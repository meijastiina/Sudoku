package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;

public class SudokuVerifier {

	public int verify(String candidateSolution) {	
		int retVal=0;
		int[] intArray=new int[81];
		int[][] intSudokuArray = new int[9][9];
		int[] intRowArray=new int[9];
		int[] intColArray=new int[9];
		int[][] intSubGridArray=new int[9][9];
		int i = 0;
		int intRowCounter = 0;
		int k = 0;
		int intColCounter = 0;
	
		int strLength = candidateSolution.length();
		  if(strLength != 81) {
			  retVal=-5;
		  } else {
			  for(i=0;i<81 && retVal==0;i++) {
				  //create sudoku array
				  if (!Character.isDigit(candidateSolution.charAt(i))) {
					  retVal=-1;
					  break;
				  }
				  int cur = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
				  if(cur<0){
					  retVal=-1;
					  break;
				  }
				  intArray[i] = cur;
				  if(intColCounter==8){
				  } else {
					//check for repetitions on a row
					  if(existsInArray(intRowArray, cur)){
							  retVal=-3;
							  break;
					  }
					  intRowArray[intColCounter] = cur;
				  }
				  if(intRowCounter>0) {
					  //check for repetitions on a col
					  for(int z=0;z<intRowCounter;z++){
						  if(intSudokuArray[z][intColCounter]==cur){
							  retVal=-4;
							  break;
						  }
					  }
				  }

				  intSudokuArray[intRowCounter][intColCounter] = cur;
				  intColCounter++;
				  if(intColCounter==9 || intColCounter==0){
					  intColCounter=0;
					  intRowArray = new int[9];
					  intColArray[intRowCounter] = cur;
					  intRowCounter++;
				  }
			  }
			  if(retVal == 0) {
				  retVal = checkSudokuStatus(intSudokuArray);
			  }
		  } 
		  
		  
		return retVal;
	}
	private int checkSudokuStatus(int[][] grid) {
	    for (int i = 0; i < 9; i++) {

	        int[] row = new int[9];
	        int[] square = new int[9];
	        int[] column = grid[i].clone();

	        for (int j = 0; j < 9; j ++) {
	            row[j] = grid[j][i];
	            square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
	        }
	        if (!(validate(square))){
	        	return -2;
	        }else if (!validate(row)){
	        	return -3;
	        } else if (!validate(column)){
	        	return -4;
	        }
	    }
	    return 0;
	}

	private boolean validate(int[] check) {
	    int i = 0;
	    Arrays.sort(check);
	    for (int number : check) {
	        if (number != ++i)
	            return false;
	    }
	    return true;
	}
	private boolean existsInArray(int[] array, int val){
		int i = 0;
		boolean retVal = false;
		for(i=0;i<array.length;i++){
			  if(array[i]==val){
				  retVal=true;
				  break;
			  }
		}
		return retVal;
	}
}

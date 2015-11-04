package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TestSudokuVerifier {
	SudokuVerifier sudokuVerifier;
	@Before
	public void setup(){
		this.sudokuVerifier = new SudokuVerifier();
	}
	@Test
	public void testCheckForStringTooShort() {
		int expectedVal = -5;
		int actualVal = this.sudokuVerifier.verify("12");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForStringTooLong() {
		int expectedVal = -5;
		int actualVal = this.sudokuVerifier.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752932");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForNegativeValues() {
		int expectedVal = -1;
		int actualVal = this.sudokuVerifier.verify("-47369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForRepetitiveValuesOnSubGrid() {
		int expectedVal = -2;
		int actualVal = this.sudokuVerifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForRepetitiveValuesOnRow() {
		int expectedVal = -3;
		int actualVal = this.sudokuVerifier.verify("447369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForRepetitiveValuesOnCol() {
		int expectedVal = -4;
		int actualVal = this.sudokuVerifier.verify("417369825432158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(expectedVal, actualVal);
	}
	@Test
	public void testCheckForValidString() {
		int expectedVal = 0;
		int actualVal = this.sudokuVerifier.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals(expectedVal, actualVal);
	}

}

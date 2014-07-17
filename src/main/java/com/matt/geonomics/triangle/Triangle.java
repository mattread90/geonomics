package com.matt.geonomics.triangle;

import java.util.ArrayList;

public class Triangle {
	
	ArrayList<int[]> rows;
	
	public Triangle() {
		rows = new ArrayList<>();
	}
	
	public void addRow(int[] row) {
		rows.add(row);
	}
	
	public void convertElementsToMinimalPathValues() {
		for (int rowNumber = numberOfRows() - 2; rowNumber > -1; rowNumber--) {
			for (int columnNumber = 0; columnNumber < rowNumber + 1; columnNumber++) {
				calculateAndSetMinimalPathValueForElement(rowNumber, columnNumber);
			}
		}
	}
	
	private int numberOfRows() {
		return rows.size();
	}
	
	private void calculateAndSetMinimalPathValueForElement(int rowNumber, int columnNumber) {
		int currentVal = getElement(rowNumber, columnNumber);
		int leftChild = getElement(rowNumber + 1, columnNumber);
		int rightChild = getElement(rowNumber + 1, columnNumber + 1);
		setElement(rowNumber, columnNumber, currentVal + (leftChild < rightChild ? leftChild : rightChild));
	}
	
	private int getElement(int rowNumber, int columnNumber) {
		return rows.get(rowNumber)[columnNumber];
	}
	
	private void setElement(int rowNumber, int columnNumber, int valueToSet) {
		rows.get(rowNumber)[columnNumber] = valueToSet;
	}
	
	public String generateMinimalPathOutput() {
		int nextColumnIndex = 0;
		StringBuilder s = new StringBuilder();
		s.append("Minimal path is: ");
		for (int rowNumber = 0; rowNumber < numberOfRows() - 1; rowNumber++) {
			if (pathGoesRight(nextColumnIndex, rowNumber)) {
				s.append(getElement(rowNumber, nextColumnIndex) - getElement(rowNumber + 1, ++nextColumnIndex) + " + ");
			} else {
				s.append(getElement(rowNumber, nextColumnIndex) - getElement(rowNumber + 1, nextColumnIndex) + " + ");
			}	
		}
		s.append(getElement(numberOfRows() - 1, nextColumnIndex));
		s.append(" = " + getElement(0,0));
		return s.toString();
	}

	private boolean pathGoesRight(int nextColumnIndex, int rowNumber) {
		return getElement(rowNumber + 1, nextColumnIndex) > getElement(rowNumber + 1, nextColumnIndex + 1);
	}
	
}

package com.matt.geonomics.parser;

public class UnrecognisedElementFormatException extends TriangleParserException {
	
	private int rowNumber, columnNumber;
	String element;
	
	public UnrecognisedElementFormatException(int rowNumber, int columnNumber, String elementValue) {
		super();
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.element = elementValue;
	}
	
	public String getMessage() {
		return 	"Incorrect format for element " + columnNumber + " on row " + rowNumber + ".\n" +
				"\"" + element + "\" cannot be converted to an integer.";
	}
	
}

package com.matt.geonomics.parser;

public class IncorrectNumberOfRowElementsException extends TriangleParserException {
	
	private int expectedNumberOfElements, foundNumberOfElements;
	
	public IncorrectNumberOfRowElementsException(int expectedNumberOfElements, int foundNumberOfElements) {
		super();
		this.expectedNumberOfElements = expectedNumberOfElements;
		this.foundNumberOfElements = foundNumberOfElements;
	}
	
	public String getMessage() {
		return 	"Incorrect number of elements for row " + expectedNumberOfElements + ".\n" +
				"Was expecting " + expectedNumberOfElements + " elements, but found " + foundNumberOfElements + ".";
	}

}
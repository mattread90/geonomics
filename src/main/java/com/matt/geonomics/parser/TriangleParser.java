package com.matt.geonomics.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.matt.geonomics.triangle.*;

public class TriangleParser {
	
	private BufferedReader reader;
	private int rowNumber = 0;
	private int columnNumber;
	private String currentLine;
		
	public TriangleParser(InputStream in) {
		this.reader = new BufferedReader(new InputStreamReader(in));
	}
	
	public Triangle parseInput() throws TriangleParserException, IOException {
		Triangle triangle = new Triangle();
		while ((currentLine = reader.readLine()) != null) {
			String[] splitLine = splitLineByWhiteSpace();
			validateNumberOfElements(splitLine);
			int[] rowToAdd = convertSplitLine(splitLine);
			triangle.addRow(rowToAdd);
			rowNumber++;
		}
		reader.close();
		return triangle;
	}
	
	private String[] splitLineByWhiteSpace() {
		return currentLine.trim().split("[\\s]+");
	}
	
	private void validateNumberOfElements(String[] splitLine) throws IncorrectNumberOfRowElementsException {
		if (splitLine.length != rowNumber + 1) {
			throw new IncorrectNumberOfRowElementsException(rowNumber + 1, splitLine.length);
		}
	}
	
	private int[] convertSplitLine(String[] splitLine) throws UnrecognisedElementFormatException {
		int[] convertedLine = new int[splitLine.length];
		for (columnNumber = 0; columnNumber < splitLine.length; columnNumber++) {
			convertedLine[columnNumber] = convertElement(splitLine[columnNumber]);
		}
		return convertedLine;
	}
	
	private int convertElement(String element) throws UnrecognisedElementFormatException {
		int convertedElement;
		try {
			convertedElement = Integer.parseInt(element); 
		} catch (NumberFormatException e) {
			throw new UnrecognisedElementFormatException(rowNumber + 1, columnNumber + 1, element);
		}
		return convertedElement;
	}
	
}

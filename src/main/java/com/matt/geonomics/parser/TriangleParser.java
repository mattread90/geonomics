package com.matt.geonomics.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.matt.geonomics.triangle.*;

public class TriangleParser {
	
	private BufferedReader reader;
		
	public TriangleParser(InputStream in) {
		this.reader = new BufferedReader(new InputStreamReader(in));
	}
	
	public Triangle parseInput() {
		Triangle triangle = new Triangle();
		String currentLine;
		int rowNumber = 0;
		
		try {
			while ((currentLine = reader.readLine()) != null) {
				rowNumber++;
				ArrayList<Node> rowToAdd = new ArrayList<>();
				String[] splitLine = currentLine.split("[\\s]+");
				if (splitLine.length != rowNumber) {
					System.out.println("Incorrect number of elements for row " + rowNumber + ".");
					System.out.println("Was expecting " + rowNumber + " elements, but found " + splitLine.length + ".");
					System.exit(0);
				}
				for (int i = 0; i < splitLine.length; i++) {
					try {
						int newValue = Integer.parseInt(splitLine[i]);
						Node n = new Node(newValue);
						rowToAdd.add(n);
					} catch (NumberFormatException e) {
						System.out.println("Incorrect format for element " + i + " on row " + rowNumber + ".");
						System.out.println("\"" + splitLine[i] + "\" cannot be converted to an integer.");
						System.exit(0);
					}
				}
				triangle.insertRow(rowToAdd);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		return triangle;
	}
	
}

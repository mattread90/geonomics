package com.matt.geonomics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.matt.geonomics.parser.TriangleParser;
import com.matt.geonomics.path.Path;
import com.matt.geonomics.triangle.Node;
import com.matt.geonomics.triangle.Triangle;

public class Main {
	
	public static void main (String[] args) {
		ArrayList<ArrayList<ArrayList<Integer>>> triangle = new ArrayList<>();
		
		String currentLine;
		int rowNumber = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while ((currentLine = reader.readLine()) != null) {
				rowNumber++;
				ArrayList<ArrayList<Integer>> rowToAdd = new ArrayList<>();
				String[] splitLine = currentLine.split("[\\s]+");
				if (splitLine.length != rowNumber) {
					System.out.println("Incorrect number of elements for row " + rowNumber + ".");
					System.out.println("Was expecting " + rowNumber + " elements, but found " + splitLine.length + ".");
					System.exit(0);
				}
				for (int i = 0; i < splitLine.length; i++) {
					try {
						int newValue = Integer.parseInt(splitLine[i]);
						ArrayList<Integer> newValuePair = new ArrayList<>();
						newValuePair.add(newValue);
						newValuePair.add(newValue);
						rowToAdd.add(newValuePair);
					} catch (NumberFormatException e) {
						System.out.println("Incorrect format for element " + (i+1) + " on row " + rowNumber + ".");
						System.out.println("\"" + splitLine[i] + "\" cannot be converted to an integer.");
						System.exit(0);
					}
				}
				triangle.add(rowToAdd);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int currentVal, leftChild, rightChild;
		for (int rowNum = triangle.size() - 2; rowNum > -1; rowNum--) {
			for (int colNum = 0; colNum < triangle.get(rowNum).size(); colNum++) {
				currentVal = triangle.get(rowNum).get(colNum).get(0);
				leftChild = triangle.get(rowNum + 1).get(colNum).get(1);
				rightChild = triangle.get(rowNum + 1).get(colNum + 1).get(1);
				triangle.get(rowNum).get(colNum).set(1, currentVal + (leftChild < rightChild ? leftChild : rightChild));
			}
		}
		
		int nextColumnIndex = 0;
		int rowNum;
		StringBuilder s = new StringBuilder();
		s.append("Minimal path is: ");
		for (rowNum = 0; rowNum < triangle.size() - 2; rowNum++) {
			s.append(triangle.get(rowNum).get(nextColumnIndex).get(0) + " + ");
			if (triangle.get(rowNum + 1).get(nextColumnIndex).get(1) > triangle.get(rowNum + 1).get(nextColumnIndex + 1).get(1)) {
				nextColumnIndex++;
			}
		}
		s.append(triangle.get(rowNum).get(nextColumnIndex).get(0) + " + ");
		if (triangle.get(rowNum + 1).get(nextColumnIndex).get(0) > triangle.get(rowNum + 1).get(nextColumnIndex + 1).get(0)) {
			nextColumnIndex++;
		}
		s.append(triangle.get(++rowNum).get(nextColumnIndex).get(0));
		s.append(" = " + triangle.get(0).get(0).get(1));
		
		System.out.println(s.toString());
		
	}

}

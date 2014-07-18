package com.matt.geonomics;

import java.io.IOException;

import com.matt.geonomics.parser.TriangleParser;
import com.matt.geonomics.parser.TriangleParserException;
import com.matt.geonomics.triangle.Triangle;

public class MinTrianglePath {

	public static void main(String[] args) {
		TriangleParser parser = new TriangleParser(System.in);

		Triangle triangle = null;
		try {
			triangle = parser.parseInput();
		} catch (TriangleParserException e) {
			System.out.print(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

		triangle.convertElementsToMinimalPathValues();
		System.out.println(triangle.generateMinimalPathOutput());
	}

}

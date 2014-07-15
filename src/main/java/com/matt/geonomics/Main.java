package com.matt.geonomics;

import com.matt.geonomics.parser.TriangleParser;
import com.matt.geonomics.path.Path;
import com.matt.geonomics.triangle.Triangle;

public class Main {
	
	public static void main (String[] args) {
		TriangleParser parser = new TriangleParser(System.in);
		Triangle triangle = parser.parseInput();
		Path minimalPath = triangle.findMinimalPath();
		System.out.println(triangle.traversePathAndPrint(minimalPath));
	}

}

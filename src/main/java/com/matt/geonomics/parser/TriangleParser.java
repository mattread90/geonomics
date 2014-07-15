package com.matt.geonomics.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.matt.geonomics.triangle.*;

public class TriangleParser {
	
	private StreamTokenizer tokenizer;
	private String currentLine;
	private int rowNumber = 0;
	private int columnNumber = 0;
	
	private static final Pattern TRIANGLE_ELEMENT_MATCHER = Pattern.compile("[\\s]*([-]?[\\d]+)");
	
	public TriangleParser() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StreamTokenizer(reader);
		tokenizer.parseNumbers();
		tokenizer.eolIsSignificant(true);
		
	}
	
	public Triangle parseInput() {
		Triangle triangle = new Triangle();
		try {
			ArrayList<Node> nextRow;
			do {
				do {
					
				} while (tokenizer.ttype != StreamTokenizer.TT_EOL);
				
			} while (tokenizer.ttype != StreamTokenizer.TT_EOF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return triangle;
	}
	
}

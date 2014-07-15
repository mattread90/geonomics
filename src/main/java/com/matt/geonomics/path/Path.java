package com.matt.geonomics.path;

import java.util.LinkedList;
import java.util.List;

public class Path {

	private List<Direction> directions = new LinkedList<>();
	private int total;
	
	public Path(int value) {
		this.total = value;
	}
	
	public int getTotal() {
		return total;
	}
	
	public List<Direction> getDirections() {
		return directions;
	}
	
	public void appendLeft(int value) {
		append(value, Direction.LEFT);
	}
	
	public void appendRight(int value) {
		append(value, Direction.RIGHT);
	}
	
	public void append(int value, Direction direction) {
		directions.add(0, direction);
		this.total += value;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Path with total " + total + ":\n");
		for (int i = 0; i < directions.size(); i++) {
			s.append(directions.get(i) + " ");
		}
		return s.toString();
	}
	
}

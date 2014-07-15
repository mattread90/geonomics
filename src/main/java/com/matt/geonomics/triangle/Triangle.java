package com.matt.geonomics.triangle;

import java.util.List;

import com.matt.geonomics.path.*;

public class Triangle {
	
	private Node rootNode;
	
	public Triangle () {
		this.rootNode = null;
	}
	
	public Triangle (Node rootNode) {
		this.rootNode = rootNode;
	}

	public void insertRow(List<Node> row) {
		Node node = this.rootNode;
		
		if (node == null) {
			this.rootNode = row.get(0);
		} else {
			// traverse to the left-most node from bottom row
			while (node.hasLeftChild()) {
				node = node.getLeftChild();
			}
			
			// append first node to the left of the current node
			Node nodeToAdd = row.get(0);
			node.setLeftChild(nodeToAdd);
			
			// for each of the nodes to add (apart from the first and last),
			// append it to the right of the node we are currently at, then
			// traverse to the next node to the right, and add the node to the
			// left of it.
			for (int i = 1; i < row.size() - 1; i++) {
				nodeToAdd = row.get(i);
				node.setRightChild(nodeToAdd);
				node = node.getRightParent().getRightChild();
				node.setLeftChild(nodeToAdd);
			}
			
			// add the final node to the right of the node we end up on (the right-most node)
			nodeToAdd = row.get(row.size() - 1);
			node.setRightChild(nodeToAdd);
		}
	}
	
	public Path findMinimalPath() {
		if (rootNode.hasLeftChild()) {
			Triangle leftTriangle = new Triangle(rootNode.getLeftChild());
			Triangle rightTriangle = new Triangle(rootNode.getRightChild());
			Path leftPath = leftTriangle.findMinimalPath();
			Path rightPath = rightTriangle.findMinimalPath();
			if (leftPath.getTotal() < rightPath.getTotal()) {
				leftPath.appendLeft(rootNode.getValue());
				return leftPath;
			} else {
				rightPath.appendRight(rootNode.getValue());
				return rightPath;
			}
		} else {
			return new Path(rootNode.getValue());
		}
	}
	
	public String traversePathAndPrint(Path path) {
		StringBuilder sb = new StringBuilder();
		List<Direction> directions = path.getDirections();
		Node currentNode = rootNode;
		sb.append("Minimal path is: " + currentNode.getValue());
		for (int i = 0; i < directions.size(); i++) {
			switch (directions.get(i)) {
			case LEFT:
				currentNode = currentNode.getLeftChild();
				break;
			case RIGHT:
				currentNode = currentNode.getRightChild();
				break;
			}
			sb.append(" + " + currentNode.getValue());
		}
		sb.append(" = " + path.getTotal());
		return sb.toString();
	}

}

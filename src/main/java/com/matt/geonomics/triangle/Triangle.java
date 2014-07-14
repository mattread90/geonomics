package com.matt.geonomics.triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	private Node rootNode;
	
	public Triangle () {
		this.rootNode = null;
	}

	public void insertRow(List<Node> row) {
		Node node = rootNode;
		
		if (rootNode == null) {
			rootNode = row.get(0);
		}
		
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

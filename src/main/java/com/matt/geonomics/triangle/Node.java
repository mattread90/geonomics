package com.matt.geonomics.triangle;

public class Node {
	
	private int value;
	private Node leftChild;
	private Node rightChild;
	private Node leftParent;
	private Node rightParent;
	
	public Node(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.leftParent = null;
		this.rightParent = null;
	}

	
	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
		leftChild.rightParent = this;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
		rightChild.leftParent = this;
	}

	public Node getLeftParent() {
		return leftParent;
	}

	public Node getRightParent() {
		return rightParent;
	}

	int getValue() {
		return value;
	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}

}

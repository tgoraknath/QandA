package com.gogo.bst;

public class SubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSubTree(Node root, Node child) {
		if(child == null) {
			return true;
		}
		if(root == null) {
			return false;
		}
		if(root == child) { 
			return true;
		}
		return isSubTree(root.left, child) || isSubTree(root.right, child);
	}
}

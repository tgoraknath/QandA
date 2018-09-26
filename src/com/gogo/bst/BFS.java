package com.gogo.bst;

import java.util.Stack;

public class BFS {

	public static void main(String[] args) {
		int[] values = {1,20,10,30,34,16,9,8, 3, 6};
		Node root = new Node();
		root.value = values[0];
		preOrder(createPreOrderBST(root, values));
		System.out.println(root.value + " ");
		zigZag(root);
	}
	private static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.value + " ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	public static Node createPreOrderBST(Node root,int[] values) {
		Node p;
		Node next = null;
		boolean flag = false;
		for(int i = 1 ; i < values.length; i++) {
			p = root;
			next = new Node();
			next.value = values[i];
			flag = true;
			while(flag) {
				if(next.value <= root.value) {
					if(p.left == null) {
						p.left = next;
						flag = false;
					}else {
						p = p.left;
					}
				} else {
					if(p.right == null) {
						p.right = next;
						flag = false;
					}else {
						p = p.right;
					}
				}
				
			}
		}
		return root;
	}
	
	public static Node deleteNode(Node root, int val) {
		if(root == null) {
			return null;
		}
		int n_val = root.value;
		if(val < n_val) {//less than root node
			root.left = deleteNode(root.left, val);
			
		}else if(val > n_val) {//greater than root node
			root.right = deleteNode(root.right, val);
		} else {
			if(root.left == null || root.right == null) {
				return root.left == null?root.right:root.left;
			}else {//node has 2 leafs
				Node successor = inOrderSuccessor(root);
				root.value = successor.value;
				root.right = deleteNode(root.right, successor.value);
			}	return root;
		}
		//we will visit
		return null;
	}
	public static Node inOrderSuccessor(Node node) {
		if(node == null) {
			return null;
		}
		Node successor = node.right;
		while(successor.left != null) {
			successor = successor.left;
		}
		return successor;		
	}
	private static void zigZag(Node root) {
		//root: {1,20,10,30,34,16,9,8, 3, 6}
		//output: 1,20,10,30,34,16,9,8,6,3
		//s1 - l-->r
		Stack<Node> s1 = new Stack<>();
		//s1 - r-->l
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node node = s1.pop();
			System.out.print(node.value+ " ");
			if(node.left != null)
				s2.push(node.left);
			if(node.right != null)
				s2.push(node.right);
			while(!s2.isEmpty()) {
				node = s2.pop();
				System.out.print(node.value+ " ");
				if(node.right != null)
					s1.push(node.right);
				if(node.left != null)
					s1.push(node.left);
			}
			
		}
		
	}

}

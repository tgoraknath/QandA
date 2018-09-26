package com.gogo.arrays;

import java.util.*;

public class HRQ8 {

	public static void main(String[] args) {

	}
	
	public static String SExpression(String s){
		HashSet<String> set = new HashSet<>();
		boolean[][] graph = new boolean [26][26];
		HashSet<Character> nodes = new HashSet<Character>();
		//construct graph and check error E2: duplicate edges
		boolean E2 = false;
		for(int i=1;i<s.length();i+=6){
			int x = s.charAt(i)-'A', y = s.charAt(i+2)-'A';
			if(graph[x][y]) //duplicate edge
				E2 = true;
			graph[x][y] = true;
			nodes.add(s.charAt(i));
			nodes.add(s.charAt(i+2));
		}
		//check error E1: more than 2 children
		boolean E1 = false;
		for(int i=0;i<26;i++){
			int count = 0; //number of child
			for(int j=0;j<26;j++){
				if(graph[i][j])
					count++;
			}
			if(count>2)
				return "E1";
		}
		if(E2) return "E2"; //return E2 after checking E1
		
		//check E3: cycle present and E4: multiple roots
		int numOfRoots = 0;
		char root =' ';
		char node;
		Iterator<Character> chars = nodes.iterator();
		while(chars.hasNext()) {
			node = chars.next();
			for(int i=0;i<26;i++) {
				if(graph[i][node - 'A']) {
					break;
				}
				if(i == 25) {
					numOfRoots++;
					root = node;
					boolean[] visited = new boolean[26];
					if(isCycle(node, graph, visited)) {
						return "E3";
					}
				}
			}
			
		}
		if(numOfRoots==0) return "E3"; //if no root, must be a cycle
		if(numOfRoots>1) return "E4"; //if more than one roots
		if(root==' ') return "E5"; //if no edge in input string, invalid input error
		return getExpressionHelper(root, graph);
		
	}
	//true means there is a cycle, false means no cycle
	private static boolean isCycle(char node, boolean[][] graph, boolean[] visited){
		if(visited[node-'A']) //node has already been visited, must has a cycle
			return true;
		visited[node-'A'] = true;
		for(int i=0;i<26;i++){
			if(graph[node-'A'][i]){
				if(isCycle((char)(i+'A'), graph, visited))
					return true;
			}
		}
		return false;
	}
	
	//Recursive DFS to get the expression/construct the tree
	private static String getExpressionHelper(char root, boolean[][] graph){
		String left = "", right = ""; //if no children, left and right should be empty
		for(int i=0;i<26;i++){
			if(graph[root-'A'][i]){
				left = getExpressionHelper((char)(i+'A'), graph);
				for(int j=i+1;j<26;j++){
					if(graph[root-'A'][j]){
						right = getExpressionHelper((char)(j+'A') ,graph);
						break;
					}
				}
				break;
			}
		}
		return "("+root+left+right+")";
	}

}

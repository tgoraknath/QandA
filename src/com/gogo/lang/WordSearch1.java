package com.gogo.lang;

public class WordSearch1 {
	private static char[][] chars = { 
			{ 'g', 'o', 'r', 'a', 'k' },
			{ 'a', 'G', 'n', 'K', 'n' }, 
			{ 'h', 'w', 'O', 'A', 'a' },
			{ 'o', 'r', 'n', 'R', 't' }, 
			{ 'a', 'b', 'r', 'i', 'h' } };
	public static void main(String[] args) {
		
		boolean expectedTrue = search("gGORh");
		System.out.println("Expected true for string 'gGORh' search : and actual value is : "+expectedTrue);
		expectedTrue = search("gorak");
		System.out.println("Expected true for string 'gorak' search : and actual value is : "+expectedTrue);
		expectedTrue = search("hROGg");
		System.out.println("Expected true for string 'hROGg' search : and actual value is : "+expectedTrue);
		expectedTrue = search("KnAth");
		System.out.println("Expected true for string 'KnAth' search : and actual value is : "+expectedTrue);
		expectedTrue = search("arOKk");
		System.out.println("Expected true for string 'arOKk' search : and actual value is : "+expectedTrue);
		//it requires additional logic in search api to ensure algorithm works for all permutation and combinations..
		expectedTrue = search("KanOA");
		System.out.println("Expected true for string 'KanOA' search : and actual value is : "+expectedTrue);
		expectedTrue = search("Kanath");
		System.out.println("Expected true for string 'KanoA' search : and actual value is : "+expectedTrue);	
	}

	private static boolean search(String string) {
		char[] searchStr = string.toCharArray();
		for(int i = 0; i< chars[0].length ;i++) {
			for(int j = 0; j< chars[1].length ;j++) {
				if(dfs(searchStr, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean dfs(char[] word, int i, int j, int ind) {
		if(ind == word.length) {
		 return true;	
		}
		if(i < 0 || j < 0 || i >= chars[0].length || j >= chars[1].length
				|| ind >= word.length || chars[i][j] != word[ind]) {
			return false;
		}
		//char chatAt = word[ind];
		word[ind] ^= 256;
		boolean flag = dfs(word, i, j+1, ind+1 ) || dfs(word, i, j-1, ind+1 ) || dfs(word, i+1, j, ind+1 ) || dfs(word, i-1, j, ind+1);
		word[ind] ^= 256;
		return flag;
	}

}

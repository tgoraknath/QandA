package com.gogo.arrays;

public class HrQ4 {
	
	public static void main(String[] args) {
		
		int[] ret = getMinimumDifference(new String[] {"drngbjuuhmwqwxrinxccsqxkp"}, new String[] {"wygwcdbtriwaesjsobrntzaqbe"});
		for(int i : ret) {
		System.out.println(i);
		}
	}
	

    /*
     * Complete the function below.
     */
    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] retCnt = new int[a.length];
        for(int i = 0; i< a.length; i++) {
           compute(a[i], b[i], i, retCnt); 
        }    
        return retCnt;
    }
   
    static void compute(String str1, String str2, int index, int[] retCnts) {
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
           retCnts[index] = -1; 
           return;
        }
        if(str1.equals(str2)) {
           retCnts[index] = 0;  
           return;
        }
        int count = 0;
        // store the count of character
        int char_count[] = new int[26];
 
        // iterate though the first String and update 
        // count
        for (int i = 0; i < str1.length(); i++) {
            char_count[str1.charAt(i) - 'a']++;      
        }
        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < str2.length(); i++) {
            if (char_count[str2.charAt(i) - 'a']-- <= 0)
                count++;          
        }      
        retCnts[index] = count;  
    }


}

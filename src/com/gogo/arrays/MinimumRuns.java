package com.gogo.arrays;
import java.util.*;

class MinimumRuns {
    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY m
     */
    public static int minimumMoves(List<Integer> a, List<Integer> b)
    	{
        int retCnt = 0;
        for(int i = 0 ; i < a.size(); i++) {
        	retCnt = compute(a.get(i).toString(), b.get(i).toString(), retCnt);
        }
        return retCnt;
    	}

	private static int compute(String str1, String str2, int retCnt) {
		return compute(str1, str2, retCnt, 0);
	}

	private static int compute(String str1, String str2, int retCnt, int index) {
		if(index == str1.length()) {
			return retCnt;
		}
		int c = Integer.valueOf(String.valueOf(str1.charAt(index)));
		int c1 = Integer.valueOf(String.valueOf(str2.charAt(index)));
		if(c > c1) {
			retCnt += c - c1;
		}else if(c < c1) {
			retCnt += c1 - c;
		}
		return compute(str1, str2, retCnt, index+1);
	}
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1234, 4321);
		List<Integer> b = Arrays.asList(2345, 3214);
		int min = minimumMoves(a, b);
		System.out.println("Expected 10, actual is "+ min);
	}
    
}


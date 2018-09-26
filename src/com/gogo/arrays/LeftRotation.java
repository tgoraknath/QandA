package com.gogo.arrays;

import java.io.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        if(a == null || a.length == 0 || a.length == 1) {
            return a;
       }
        int len = a.length;
        boolean[] visited = new boolean[len];
        int counter = 0;
        int count = 0;
        while(counter + count < len) {
            count = leftRotation(a, d, visited, counter, a[counter], 0);
            counter++;
        }
        return a;
    }
    static int leftRotation(int[] array, int by, boolean[] visited, int pos, int val, int count)      {
        if(visited[pos]) {
            return count;
        }
        int tbp = pos - by;
        int l = array.length;      
        if(tbp < 0) {
            tbp = l + tbp;    
        }
        int tbv = array[tbp];
        array[tbp] = val;
        visited[pos] = true;
       return leftRotation(array, by, visited, tbp, tbv, count+1); 
       // left move by 4
       //12345 - 11345, 1 2 | 11245 2 3 | 11235 3 4 | 
       //77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77
       
       //41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51
       //
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) throws IOException {
    	 int[] input = new int[]{41,73,89,7,10,1,59,58,84,77,77,97,58,1,86,58,26,10,86,51};
     int[] output = rotLeft(input, 10); 
     for(int i : output) {
    	  System.out.print(i+",");
     }
    }
}
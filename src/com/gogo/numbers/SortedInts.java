package com.gogo.numbers;

import java.util.Arrays;

public class SortedInts {
	public static int removeDuplicates(int[] array) {
	    if (array == null || array.length == 0)
	        return 0;
	    int n = array.length;
	    int index = 1;
	    for (int i = 1; i < n; i++) {
	        if (array[i] != array[i-1]) {
	        		array[index] = array[i];
	        		System.out.println(Arrays.toString(array));
	            index++;
	        }
	    }
	    int[] array1= Arrays.copyOf(array, index);
	    System.out.println(Arrays.toString(array1));
	    System.out.println(array1 == array);
	    return index;
	}
	
	public static void main(String[] args) {
		System.out.println("expected 4 ::"+ removeDuplicates(new int[] {1,1,2,2,3,4,4}));
	}
	
	public static void parallelSort(int[] array) {
		Arrays.parallelSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(i);
		}
	}
}


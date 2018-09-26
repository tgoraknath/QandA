package com.gogo.arrays;
import java.util.*;
public class Triangle {
    /*
     * Complete the 'getType' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY abc as parameter.
     */
    public static List<String> getType(List<String> abc) {
    	List<String> retList = new ArrayList<>();
    	  String[] args = null;
    	  for(String str : abc) {
    	     args =  str.split(" ");
    	    	 retList.add(determine(args));
    	  }
    	  return retList;
    }

	public static String determine(String... sides) {
		int side1 = Integer.valueOf(sides[0]);
		int side2 = Integer.valueOf(sides[1]);
		int side3 = Integer.valueOf(sides[2]);
		String retVal = "None of these";
		Set<Integer> unique = new HashSet<>();
		unique.add(side1);
		unique.add(side2);
		//here if the size is 1, that means
		if(unique.size() == 1 && (2 * side1) > side3) {
			retVal = "Isosceles";
		}
		unique.add(side3);
		if(unique.size() == 1) {
			retVal = "Equilateral";
		} else if(unique.size() == 2) {
			int temp = (side3 != side2) ? side2 : side1;
			if((2 * side3) > temp) {
				retVal = "Isosceles";
			}
		} else {
			retVal = "None of these";
		}
		int temp = 0;
		int total = 0;
		if (unique.size() == 2) {
			temp = (side1 == side2) ? side3 : (side1 == side3) ? side2 : side1;
			if (temp == side1) {
				total = side2 + side3;
			} else if (temp == side2) {
				total = side1 + side3;
			} else {
				total = side1 + side2;
			}
			if (total > temp) {
				retVal = "Isosceles";
			}
		} else if (unique.size() == 1) {
			retVal = "Equilateral";
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("36 36 30", "47 8 60", "46 96 90", "86 86 86");
		System.out.println(getType(list));
	}
}

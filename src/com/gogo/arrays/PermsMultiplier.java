package com.gogo.arrays;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * [1,2,3,4] -- [24,12,8,6] 
 */

class PermsMultiplier {
  public static void main(String[] args) {
    int[] numbers = new int[]{1,2,3,4};
    List<Integer> list = new ArrayList<>();
    list.remove(0);
    int[] retValues = new int[numbers.length];
    int previous = 1;
    for (int i = 0; i < numbers.length; i++) {
    	  previous = i != 0 ? previous * numbers[i-1] : previous;
    	  retValues[i] = rightSideMultiply(numbers, i+1, previous);
      System.out.println(retValues[i]);
      //initial = 1;
    }
    System.out.println(retValues);
  }
  
  /*public static int leftSideMultiply(int[] args, int index, int val) {
    if(index < 0) {
      return val;
    }
    val *= args[index];
    return val * leftSideMultiply(args, index - 1, val * args[index]);
  
  }*/
  
  public static int rightSideMultiply(int[] args, int index, int val) {
    if(index >= args.length) {
      return val;
    }
    return rightSideMultiply(args, index + 1, val * args[index]);
  }
}


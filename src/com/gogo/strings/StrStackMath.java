package com.gogo.strings;

import java.util.Stack;

public class StrStackMath {
	
	public static void main(String[] args) {
		int sum = calWithStacks("{3,{}{1,2}{{3,4},{2,3}}}");
		System.out.println("Expected FourtyFive :" +sum);
	}
	public static int calWithStacks(String str) {
		Stack<Character> opCloseStack = new Stack<>();
		Stack<Integer> intStack = new Stack<>();
		int sum = 0;
		char[] strChars = str.toCharArray();
		for(char c : strChars) {
			if(c == ',') {
				continue;
			}
			if(c == '{') {
				opCloseStack.push(c)	;
				intStack.push(null);
			} else if(c == '}') {
				//get the size of opCloseStack
				//perform pop.
				//pop element in intStack, multiply with size and add upto the sum 
				//pop until we reach null.
				int size = opCloseStack.size();
				Integer element = intStack.pop();
				while(element != null) {
					sum += size*element;
					element = intStack.pop();
				}
				opCloseStack.pop();
			} else {
				intStack.push(Integer.valueOf(""+c));
			}
		}
		return sum;
	}

}

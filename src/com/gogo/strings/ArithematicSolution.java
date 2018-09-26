package com.gogo.strings;

import java.util.*;

/**
 * Given strings (char sequence) like “3 + 5 * 9” (with or without spaces),
 * write an algorithm to solve arithmetical operations.
 * Considerations: Only additions and multiplications allowed.
 * Multiplication has precedence over addition.
 * It is always a valid expression.
 *
 */
class ArithematicSolution {
  public static void main(String[] args) {
    // Prepare sample input data

    // Test method

    // Print results
    
    //1 * 9 + 3 * 2
    //step 1: convert the string to no-spaces.
    //1*9+3*2 == 9 + 6
    //1*9+3* 
    //can I stack(..)
    //stack 1 - 1
    //get next element + pop stack - apply math and hold the result for future
    //if its + hold in the stack -2. 
    // 
    int result = cal("3 + 5 * 9");
    System.out.println("Expected: 48, actual is: "+ result);
    result = cal("4 * 3 + 5 * 9");
    System.out.println("Expected: 57, actual is: "+ result);

  }
  
  public static int cal(String str) {
    String localStr = str.replaceAll(" ", "");
    Stack<String> stack1 = new Stack<>();
    //Stack stack2 = new Stack();
    Character c = null;
    String operand1 = "";
    String operand2 = "";
    Operators operator = null;
    int result = 0;
    for(int i = 0 ; i < localStr.length(); i++) {
      c = localStr.charAt(i);
     operator = Operators.get(c);
     if(operator == null) {
       operand1 +=c.toString();
     } else if (operator == Operators.PLUS) {
       stack1.push(operand1);
       //stack2.push(operator);
       operand1 = "";
     } else {
       //how to get second operand
       operand2 = findOp2(localStr.substring(i+1, localStr.length()));
       result += Integer.valueOf(operand1) * Integer.valueOf(operand2);
       operand1 = "";
     }
   }
   while(!stack1.isEmpty()) {
     result += Integer.valueOf(stack1.pop());
   } 
    return result;
  }   
  
  public static String findOp2(String str) {
      String retValu = "";
      Character c = null;
      Operators operator = null;
      for(int i = 0; i < str.length();i++) {
        c = str.charAt(i);
        operator = Operators.get(c);
        if(operator == null) {
          retValu +=c.toString();
        }
      
      }
      return retValu;          
    }
}
enum Operators {
  PLUS('+'), MULTIPLY('*');
 private static Map<Character, Operators> MAP = null;
  static {
    MAP = new HashMap<>();
    for(Operators o : Operators.values()) {
      MAP.put(o.op, o) ;
    }
  }
 private char op;
 Operators(char op) {
   this.op = op;
 } 
  
  public static Operators get(char c) {
    return MAP.get(c);  
}

}


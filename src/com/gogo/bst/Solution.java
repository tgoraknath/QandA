package com.gogo.bst;

import java.util.*;

/*
 * Hi Aakash - below solution works, kindly go through it and see if you find any edge case to cover.
 * With in 5 sec -> any user can do 2 only requests 
 * From your main method -> simulate users calling the ratelimiter method
 * Users= A,B .... n
 *
 * sec 0 - A - pass
 * sec 1
 * sec 2
 * sec 3 - A - pass
 * sec 4 - A - fail 
 * sec 5 
 * sec 6 - A - pass
 * sec 7 - A - fail
 * 
 * new request versus existing request.
 * last visited timeStamp
 * nbrOfRequests
 * 
 * https://coderpad.io/EZG49RXY#
 */

public class Solution {
  private static int MAX_TIME_5_SEC = 5 * 1000;
  private static Map<String, User> usersMap = null;
  static {
    usersMap = new HashMap<>();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = null;
    boolean flag = true;
    while(flag) {
      name = sc.next();
      if("exit".equalsIgnoreCase(name)) {
        flag = false;
      } else {
          perform(name);
      }
    }
    sc.close();
  }

  private static void perform(String name) {
    long currentTime = System.currentTimeMillis();
    long previousTime = 0l;
    User user = usersMap.get(name);
    if (user == null) {
      System.out.println("PASS - new user");
      user = new Solution.User(name, currentTime, 1);
      usersMap.put(name, user);
    } else {
      int hits = user.getAllowedHits();
      previousTime = user.lastVisited;
      long diff = currentTime - previousTime;
      if (diff > MAX_TIME_5_SEC) {
        user.allowedHits = 1;
        user.lastVisited = currentTime;  
      } 
      if (user.allowedHits++ > 2) {
        System.out.println("FAIL because of hits : "+hits + " and time difference: "+diff);
      } else {
          System.out.println("PASS with time difference: "+ diff);
      }
    }
  }

  static class User {
    private String name;
    private long lastVisited;
    private int allowedHits;

    User() {
    }

    public User(String name, long lastVisited, int allowedHits) {
      this.name = name;
      this.allowedHits = allowedHits;
      this.lastVisited = lastVisited;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public long getLastVisited() {
      return lastVisited;
    }

    public void setLastVisited(long lastVisited) {
      this.lastVisited = lastVisited;
    }

    public int getAllowedHits() {
      return allowedHits;
    }

    public void setAllowedHits(int allowedHits) {
      this.allowedHits = allowedHits;
    }

  }
}



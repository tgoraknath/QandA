package com.gogo.arrays;
import java.util.*;
import java.util.Map.Entry;

public class Employees {
	private Map<String, Integer> salariesMap = null;
	//employee id as key and manager id as value
	private Map<String, String> empToMngrMap = null;
	public Employees() {
		salariesMap = new HashMap<>();
		empToMngrMap = new HashMap<>();
	}
    public List<Integer> sortedListOfSalaries(List<String[]> workers) {
    	   Employee emp = null;
    	   int salary = 0;
    	   for(String[] fields : workers) {
    		   emp = new Employee(fields);
    		   salary = emp.salary;
    		   if(emp.isMngr()) {
    			 String[] reporties =  emp.reporties; 
    			 for(String reportee : reporties) {
    				if(salariesMap.containsKey(reportee)) {
    					salary += salariesMap.get(reportee);
    				}else {
    					empToMngrMap.put(reportee, emp.id);
    				}
    			 }
    		   } else {
    			   String mngr = empToMngrMap.get(emp.id);
    			   if(mngr != null) {
    				 Integer mngrSal = salariesMap.get(mngr);
    				 mngrSal += emp.salary;
    				 salariesMap.put(mngr, mngrSal);
    				 empToMngrMap.remove(emp.id);
    			   }
    		   }
    		   salariesMap.put(emp.id, salary);
    	   }
    	   for(Entry<String, String> entry : empToMngrMap.entrySet()) {
    		   String reportee = entry.getKey();
    		   String mngr = entry.getValue();
    		   Integer mngrSal = salariesMap.get(mngr);
		   mngrSal += salariesMap.get(reportee);
		   salariesMap.put(mngr, mngrSal);
    		   
    	   }
    	   List<Integer> ans = new ArrayList<>();
           ans.addAll(salariesMap.values());
           Collections.sort(ans);
           return ans;
    }
    
    public static void main(String[] args) {
	    	test_down();//stack
	    	test_up();//queue
	    	test_upAndDown();//stack + queue
	    	test_downAndUp();//stack + queue
	    	test_downsAndUps();//zig zag
    	
    }
	private static void test_down() {
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,4 X".split(" "));
	    	list.add("4 Manager Christopher 1,5 X".split(" "));
	    	list.add("5 FTE Mary 100000 X".split(" "));
	    	System.out.println("Expected: [50K, 75K, 100K, 175K, 225K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	
	private static void test_up() {
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,1 X".split(" "));
	    	list.add("4 FTE Mary 100000 X".split(" "));
	    	list.add("5 Manager Christopher 1,4 X".split(" "));
	    	System.out.println("Expected: [50K, 75K, 100K, 125K, 175K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	
	private static void test_upAndDown() {
		//up and down are not mngrs
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,4 X".split(" "));
	    	list.add("4 FTE Mary 100000 X".split(" "));
	    	list.add("5 Manager Christopher 1,3 X".split(" "));
	    	System.out.println("Expected: [50K, 75K, 100K, 150K, 225K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	private static void test_downAndUp() {
		//up and down are not mngrs
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,5 X".split(" "));
	    	list.add("4 FTE Mary 100000 X".split(" "));
	    	list.add("5 Manager Christopher 1,4,6 X".split(" "));
	    	list.add("6 FTE SIX 10000 X".split(" "));
	    	System.out.println("Expected: [10K, 50K, 75K, 100K, 185K, 235K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	
	private static void test_downsAndUps() {
		//ups and downs with or without mngrs reporting
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,5 X".split(" "));//50K + 175K
	    	list.add("4 FTE Mary 100000 X".split(" "));
	    	list.add("5 Manager Christopher 1,6 X".split(" "));//75K+100K
	    	list.add("6 Manager SIX 4 X".split(" "));
	    	System.out.println("Expected: [50K, 75K, 100K, 100K, 175K, 225K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	
	private static void test_downsAndUps_2() {
		//ups and downs with or without mngrs reporting - Cyclic..
		List<String[]> list = new ArrayList<>();
	    	list.add("1 FTE George 75000 X".split(" "));
	    	list.add("2 FTE Stephan 50000 X".split(" "));
	    	list.add("3 Manager Veronica 2,5 X".split(" "));//50K + 175K
	    	list.add("4 FTE Mary 100000 X".split(" "));
	    	list.add("5 Manager Christopher 1,6 X".split(" "));//75K+100K
	    	list.add("6 Manager SIX 3 X".split(" "));
	    	System.out.println("Expected: [50K, 75K, 100K, 100K, 175K, 225K]" + "-Actual: "+
	    						new Employees().sortedListOfSalaries(list));
		
	}
	
}

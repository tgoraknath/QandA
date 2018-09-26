package com.gogo.arrays;

public class Employee {
	String id;
	String name;
	String empType;
	Integer salary = 0;
	String[] reporties = null;
	int nbrOfWeeks = 1;
	private boolean mngr;
	String mngrId;
	/**
	 * My Manager is XYZ versus A,B,C.. are my reporties.
	 * @param fields
	 */
	public Employee(String... fields) {
		id = fields[0];
		empType = fields[1];
		name = fields[2];
		if("Contractor".equalsIgnoreCase(empType)) {
			salary = Integer.valueOf(fields[3]) * Integer.valueOf(fields[4]);
		} else if("FTE".equalsIgnoreCase(empType)) {
			salary = Integer.valueOf(fields[3]);
		} else {
			mngr = true;
			//TODO - fields[3] can be null
			reporties = fields[3].split(",");
		}
	}
	public boolean isMngr() {
		return mngr;
	}
	public void addSalary(Integer sal) {
		salary += sal;
	}
	public Integer getSalary() {
       return salary;
	}

}

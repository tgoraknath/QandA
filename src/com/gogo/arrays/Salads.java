package com.gogo.arrays;
import java.util.*;

public class Salads {

	/*
	 * You have a salad bar with n ingredients. Build a program that prints out all
	 * possible salads I can create out of those.
	 * 
	 * Example: Given ["Carrots", "Lettuce", "Tomato", "lemon"]
	 * 
	 * Print or return:
	 * [["Lettuce"],["Tomato"],["Carrot"],["Tomato, "Carrots"],["Letuce,
	 * "Carrots"],["Tomato, "Letuce"], ["Tomato, "Letuce", "Carrots"]].
	 */
	/**
	 * if n is lenght of array, then print n! combinations
	 * 
	 * unique items in any order
	 * 
	 * C, T, L, CT|TC, CTL|TCL|LTC|LCT|.., CL|LC, TL
	 * 
	 * 1
	 * 
	 * at each element, see if there is past calculated arrays, if yes then repeat
	 * it with new or current element, perform this until end of the array
	 * 
	 */

	public void printCombinations(List<String> args) {
		List<List<String>> results = new ArrayList<>();
		// C, T, L, CT|TC, CTL|TCL|LTC|LCT|.., CL|LC, TL
		for (String s : args) {
			if (!results.isEmpty()) {
				// for each array in results, iterate and construct new array with size+1, copy
				// existing array into new and add s to the end.
				compute(s, results);
			}
			List<String> newIngds = new ArrayList<>();
			newIngds.add(s);
			results.add(newIngds);
		}

	}

	private void compute(String ingrediant, List<List<String>> salads) {
		List<String> newIngdts = null;
		List<List<String>> results = new ArrayList<>();
		for (List<String> igdnts : salads) {
			newIngdts = new ArrayList<>();
			newIngdts.addAll(igdnts);
			newIngdts.add(ingrediant);
			results.add(newIngdts);
		}
		salads.addAll(results);
	}
}









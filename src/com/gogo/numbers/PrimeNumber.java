package com.gogo.numbers;

import java.util.List;
import java.util.stream.IntStream;
import java.util.Arrays;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("101 is prime? "+isPrime(101));
		System.out.println("115 is prime? "+isPrime(115));
		System.out.println("is 2 prime? "+isPrime(2));
		printPrimes(15);
	}
	public static boolean isPrime(int num) {
		boolean flag = true;
		for(int i = 2; i <= Math.sqrt(num);i++) {
			if(num%i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void printPrimes(int num) {
		int[] primes = new int[num+1];
		//lets assume all values in array are prime
		primes[0] = 1;
		primes[1] = 1;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(primes[i] == 0) {
				for(int j = i; j * i <=num; j++) {
					primes[j*i] = 1;
				}
			}
		}
		/*
		Arrays.asList(primes) 
		      .stream()
			  .filter(i -> i == 0) -- compile time error bcz of asList(primes)
			  .forEach(System.out::println);
	   */
		for (int i = 0; i < primes.length; i++) {
			if(primes[i] == 0) {
				System.out.println(i);
			}
			
		}
	}
	public static void j8PrintPrime(int num) {
		
	}

}

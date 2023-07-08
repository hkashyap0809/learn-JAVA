package com.learnjava.functionalprogramming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12,9,13,7,11,32,15,4,6,2,4,12,15);
//		printAllNumbersInListFunctional(numbers);
		
		//print odd
//		printEvenNumbersInListFunctional(numbers);
		List<String> courses = List.of( "Spring", "Spring Boot", "API", "Microservices", "AWS", "Azure", "Docker", "Kubernetes");
//		printOddNumbersInListFunctional(numbers);
		//printCoursesInListFunctional(courses);
		
		
		
		//map
//		printSquaresOfEvenNumbersInListFunctional(numbers);
//		printCubes(numbers);
		
		printNumberOfCharacters(courses);
		
		
	}
	
	private static void print(int number) {
		System.out.println(number);
	}
	

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		//in funcitonal prog we focus on what to do
		//first convert the list of numbers to stream of numbers
//		sream is a sequence of elements
		//What to do
		//once i have the stream of numbers what to do with that numbers passing the method reference
		
		//method reference
//		numbers.stream().forEach(FP01Functional::print); //method reference
		
		//much simpler
		numbers.stream().forEach(System.out::println);

	}
	private static boolean isEven(int number) {
		return number%2==0;
	}
	
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		
		
//		numbers.stream()
//		//add filter
//		.filter(FP01Functional::isEven)
//		.forEach(System.out::println);
		//seems complex as we have to create a function to check for even and then pass it
		//this can be solved with lambda expression
		//lambda expression simpler way of defining a method
		
		
		//lambda
//		number -> number % 2 == 0
		
//		in functional programming we are focusing on what to do filter and print
		//convert the uumber into stream and then what to do using lambda expression
//		stream- seq of elemenets
		//with lambda expression we are defiining the complete logic in the expression
		
		numbers
		.stream()
		.filter(number -> number%2==0)
		.forEach(System.out::println); //Method Reference

	}
	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers
		.stream()
		.filter( number -> number%2 != 0)
		.forEach(System.out::println);
	}
	
	private static void printCoursesInListFunctional(List<String> courses) {
		
		//all courses
//		courses
//		.stream()
//		.forEach(System.out::println);
		
		
		//contains srpring
		courses
		.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
		
		//atleast 4 letters
//		courses
//		.stream()
//		.filter( course -> course.length()>3)
//		.forEach(System.out::println);
	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers
		.stream()
		.filter(number -> number%2 == 0)
		.map( number -> number*number )
		.forEach(System.out::println);
	}
	
	private static void printCubes(List<Integer> numbers) {
		numbers
		.stream()
		.filter(number -> number%2 == 1 )
		.map(number -> number*number*number)
		.forEach(System.out::println);
	}
	
	private static void printNumberOfCharacters(List<String> courses) {
		
		courses
		.stream()
		.map(course -> course+" "+course.length())
		.forEach(System.out::println);
	}

}

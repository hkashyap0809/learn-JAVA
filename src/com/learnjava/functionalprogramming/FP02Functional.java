package com.learnjava.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		int sum = addListFunctional(numbers);
//		System.out.println(sum);
//		0 12
//		12 9
//		21 13
//		34 4
//		38 6
//		44 2
//		46 4
//		50 12
//		62 15
//		77
//		System.out.println(sumOfSquaresFunctional(numbers));
//		System.out.println(sumOfCubeFunctional(numbers));
//		System.out.println(sumOfOddNumbersFunctional(numbers));
		
		List<Integer> doubleNumbers = doubleList(numbers);
		
		List<Integer> evenNumbers = evenList(numbers);
		
		List<String> courses = List.of( "Spring", "Spring Boot", "API", "Microservices", "AWS", "Azure", "Docker", "Kubernetes");
		List<Integer> courseLength = courseLength(courses);
		System.out.println(courseLength);

//intermediate and terminal stream operations
		
//		intermediate stream operations
		//sort, distinct,  map, filter all returns a stream - > intermediate stream operations 
		
		
//		forEach, collect reduce ( 1 element ) -> terminal operation ( return some specific type other than a stream )
	}

	private static List<Integer> courseLength(List<String> courses) {
		return courses
				.stream()
				.map( str -> str.length())
				.collect(Collectors.toList());
	}

	private static List<Integer> evenList(List<Integer> numbers) {
		return numbers
				.stream()
				.filter( num -> num % 2 == 0)
				.collect(Collectors.toList());
			
	}

	private static List<Integer> doubleList(List<Integer> numbers) {
		
		return numbers
		.stream()
		.map( num -> num * 2)
		.collect(Collectors.toList());
		
	}

	private static int sum(int aggregate, int nextNumber) {
		System.out.println(aggregate+" "+nextNumber);
		return aggregate+nextNumber;
	}
	private static int addListFunctional(List<Integer> numbers) {
		
		/*
		return numbers
		//stream of numbers and convert it to one result , this is called reduce
		.stream()
		//combine them into one result
		//start with 0 and combine them, given two numbers we want to add them up
		//0 and (a,b) -> a+b
		//FP02Functional::sum
		//reduce(initialValue, method reference(accumulation function) )
		.reduce(0, FP02Functional::sum);
		
		*/
		
		
		
		//we can also use lambda function
		return numbers
		.stream()
//		.reduce(0, (x,y)->x+y);
		.reduce(0, Integer::sum);
	}
	private static int sumSquare(int a, int b) {
		
		return a + b*b;
	}

	private static int sumOfSquaresFunctional(List<Integer> numbers) {
		/*
		return numbers
				.stream()
				.reduce(0, FP02Functional::sumSquare);
//				.reduce(0,(x,y)-> x + y*y);
 */
		
		return numbers
				.stream()
				.map(x -> x*x)
				.reduce(0, Integer::sum);
	}
	private static int sumOfCubeFunctional(List<Integer> numbers) {
//		return numbers
//				.stream()
//				.reduce(0, (x,y) -> x + y*y*y );
		
		
		return numbers
				.stream()
				.map( x-> x*x*x)
				.reduce(0, Integer::sum);
	}
	private static int sumOfOddNumbersFunctional(List<Integer> numbers) {
		return numbers
				.stream()
				.filter( number -> number % 2 == 1)
				.reduce(0, (x,y)->x+y);
	}
}

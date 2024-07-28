package com.mayer.java.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		// Testing interface default method (sqrt in Formula interface)
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		double calc = formula.calculate(100);
		System.out.println(calc);

		// Testing lambda expressions
		List<String> names = Arrays.asList("andre", "gislaine", "chewie", "sheke");
		Collections.sort(names, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		System.out.println(names);

		Collections.sort(names, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println(names);

		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		System.out.println(names);

		Collections.sort(names, (a, b) -> a.compareTo(b)); // in my opinion this is the best one! :)
		System.out.println(names);

		// now testing Converter Functional Interface Using a lambda expressions
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted); // SHOULD Print: 123

		// Using an anonymous class
		Converter<String, Integer> converter2 = new Converter<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};
		Integer converted2 = converter2.convert("456");
		System.out.println(converted2); // SHOULD Print: 456

		// predicates
		Predicate predicate = (s) -> ((String) s).length() > 0;
		predicate.test("foo"); 

		Predicate nonNull = Objects::nonNull;
		nonNull.test(null);
		
		Predicate isNull = Objects::isNull;
		isNull.test(null);
		
		Predicate<String> isEmpty = String::isEmpty;
		isEmpty.test("");
		
		Predicate isNotEmpty = isEmpty.negate();
		isNotEmpty.test("notEmpty");
		
		//function apply
		
		Function<String, Integer> toInteger = Integer::valueOf;
        Integer result = toInteger.apply("987");
        System.out.println(result);
        
        //suppliers
        Supplier stringSupplier = String::new; 
        System.out.println(stringSupplier.get());
        
        Consumer greeter = (p) -> System.out.println("Hello, " + p); 
        greeter.accept("Anakin Skywalker");
        
        
        // test stream filter
        List<String> stringCollection = new ArrayList<>(); 
        stringCollection.add("ddd2"); 
        stringCollection.add("aaa2"); 
        stringCollection.add("bbb1"); 
        stringCollection.add("aaa1"); 
        stringCollection.add("bbb3"); 
        stringCollection.add("ccc"); 
        stringCollection.add("bbb2"); 
        stringCollection.add("ddd1");
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

	}

}

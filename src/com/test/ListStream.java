package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"1", "2", "3", "4", "5", "6"});
		
		List<Integer> evenList = list.stream()
			.map(s -> Integer.valueOf(s))
			.filter(i -> i % 2 == 0)
			
			.collect(Collectors.toList());
		
		System.out.println(evenList);
	}

}

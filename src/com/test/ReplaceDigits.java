package com.test;

public class ReplaceDigits {

	public static void main(String[] args) {
		int number = 103006;
		String s = String.valueOf(number);
		s = s.replaceAll("0", "5");
		System.out.println(Integer.parseInt(s));
	}

}

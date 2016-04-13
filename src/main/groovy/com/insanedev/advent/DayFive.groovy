package com.insanedev.advent

import java.util.regex.Matcher;
import java.util.regex.Pattern

class DayFive {
	static Pattern bad = ~/.*(ab|cd|pq|xy).*/
	static Pattern doubles
	
	static {
		String doublePattern = ('a'..'z').collect { "$it$it" }.join("|")
		doubles = ~/.*($doublePattern).*/
	}

	public static boolean isNice(String input) {
		if (bad.matcher(input).matches()) {
			return false
		}
		
		String vowelsOnly = input.replaceAll("[^aeiou]", "")
		if (vowelsOnly.length() >= 3 && doubles.matcher(input).matches()) {
			return true
		}

		return false
	}
	
	public static int niceCount(String input) {
		int count = 0
		input.eachLine {
			if (isNice(it)) {
				count++
			}
		}
		
		return count
	}

}

package com.insanedev.advent

class DayOne {
	static def getFloor(String input) {
		int floor = 0;
		Integer firstBasement = null;
		
		for (int i; i < input.size(); i++) {
			char current = input.charAt(i)
			if (current == '(') {
				floor++
			} else if (current == ')') {
				floor--
			}
			
			if (floor == -1 && firstBasement == null) {
				firstBasement = i + 1;
			}
		}
		
		return [floor: floor, firstBasement: firstBasement]
	}
}

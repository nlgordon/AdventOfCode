package com.insanedev.advent.daythree

class DayThree {
	static def deliver(String input, int workers) {
		HouseMap map = new HouseMap()
		
		List<Location> locations = []
		for (int i = 0; i < workers; i++) {
			locations << new Location()
		}
		for (int i = 0; i < input.size(); i++) {
			Location current = locations[i %  workers]
			String curStep = input.charAt(i)
			if (curStep == '^') {
				current.y++
			} else if (curStep == 'v') {
				current.y--
			} else if (curStep == '>') {
				current.x++
			} else if (curStep == '<') {
				current.x--
			} else {
				throw new IllegalArgumentException("Invalid direction: $curStep")
			}
			map.getAt(current.x, current.y)
		}
		
		return [count: map.count]
	}

	static class Location {
		int x = 0
		int y = 0
	}
}

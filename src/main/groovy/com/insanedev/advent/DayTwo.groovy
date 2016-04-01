package com.insanedev.advent

class DayTwo {
	static def calcWrappingNeeds(String input) {
		int totalPaper = 0
		int totalRibbon = 0
		List<Present> presents = []
		input.eachLine {
			String spec = it.trim()
			if (spec.size() > 0) {
				presents << new Present(spec)
			}
		}
		
		presents.each {
			totalPaper += it.coverage
			totalRibbon  += it.ribbon
		}
		
		return [paper: totalPaper, ribbon: totalRibbon]
	}
}

class Present {
	int length = 0
	int width = 0
	int height = 0
	
	Present (String spec) {
		String[] parts = spec.split('x')
		length = Integer.parseInt(parts[0])
		width = Integer.parseInt(parts[1])
		height = Integer.parseInt(parts[2])
	}
	
	int getCoverage() {
		List sides = []
		sides << length * width * 2
		sides << length * height * 2
		sides << width * height * 2
		
		sides << sides.min() / 2
		
		return sides.sum()
	}
	
	int getRibbon() {
		List sides = [length, width, height].sort()
		
		int wrap = sides[0] * 2 + sides[1] * 2
		int bow = length * width * height
		
		return wrap + bow
	}
}

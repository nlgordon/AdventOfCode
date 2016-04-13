package com.insanedev.advent

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DaySix {
	static final Integer MAX = 999
	Map<Integer, Map<Integer, Integer>> lights
	Closure turnOn = { Integer cur -> return 1 }
	Closure turnOff = { Integer cur -> return 0 }
	Closure toggle = { Integer cur -> cur ? 0 : 1 }
	static final Pattern commandParser = ~/(turn on|toggle|turn off) (\d*),(\d*) through (\d*),(\d*).*/
	
	public DaySix() {
		lights = [:]
		(0..MAX).each { int x ->
			lights[x] = [:]
			(0..MAX).each { int y ->
				lights[x][y] = 0
			}
		}
	}
	
	public initPart2() {
		this.turnOn = { Integer cur -> cur + 1 }
		this.turnOff = { Integer cur -> cur - 1 < 0 ? 0 : cur - 1 }
		this.toggle = { Integer cur -> cur + 2 }
	}

	public runInstruction(String instruction) {
		Matcher command = commandParser.matcher(instruction)
		if (!command.matches()) {
			throw new IllegalArgumentException("Unable to parse: '$instruction'")
		}
		int startX = Integer.parseInt(command[0][2])
		int startY = Integer.parseInt(command[0][3])
		int endX = Integer.parseInt(command[0][4])
		int endY = Integer.parseInt(command[0][5])
		this."${command[0][1]}"(startX, startY, endX, endY)
	}
	
	public 'turn on'(int startX, int startY, int endX, int endY) {
		doOperation(startX, startY, endX, endY, turnOn)
	}
	
	public 'turn off'(int startX, int startY, int endX, int endY) {
		doOperation(startX, startY, endX, endY, turnOff)
	}
	
	public toggle(int startX, int startY, int endX, int endY) {
		doOperation(startX, startY, endX, endY, toggle)
	}
	
	public doOperation(int startX, int startY, int endX, int endY, Closure operation) {
		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {
				lights[x][y] = operation(lights[x][y])
			}
		}
	}
	
	public int countOn() {
		int count = 0
		for (int x = 0; x <= MAX; x++) {
			for (int y = 0; y <= MAX; y++) {
				count += lights[x][y]
			}
		}
		
		return count
	}
	
	public boolean getState(int x, int y) {
		return lights[x][y]
	}
}

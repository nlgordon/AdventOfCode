package com.insanedev.advent

import groovy.util.logging.Slf4j

import org.junit.Before
import org.junit.Test

@Slf4j
class DaySixTest {
	
	DaySix lights
	
	@Before
	void beforeTest() {
		lights = new DaySix()
	}

	@Test
	void testTurnOn() {
		lights.'turn on'(0, 0, 0, 0)
		assert lights.countOn() == 1
	}

	@Test
	void testTurnOnCommand() {
		lights.runInstruction("turn on 0,0 through 1,1")
		assert lights.countOn() == 4
	}

	@Test
	void testTurnOffCommand() {
		lights.runInstruction("turn on 0,0 through 1,1")
		assert lights.countOn() == 4
		lights.runInstruction("turn off 0,0 through 1,1")
		assert lights.countOn() == 0
	}

	@Test
	void testToggleCommand() {
		lights.runInstruction("turn on 0,0 through 1,1")
		lights.runInstruction("toggle 0,0 through 2,2")
		assert lights.countOn() == 5
	}
	
	@Test
	void runPartOne() {
		String input = new File("src/main/resources/daysix.txt").text
		
		input.eachLine {
			lights.runInstruction(it)
		}
		
		int count = lights.countOn()
		
		log.info("Lighs On: ${count}")
		
		assert count == 543903
	}
	
	@Test
	void runPartTwo() {
		String input = new File("src/main/resources/daysix.txt").text
		lights.initPart2();
		
		input.eachLine {
			lights.runInstruction(it)
		}
		
		log.info("Lighs On: ${lights.countOn()}")
	}
	
	@Test
	void runPartTwoTestToggle() {
		lights.initPart2();
		int count = 0
		
		lights.runInstruction("toggle 0,0 through 999,999")

		count = lights.countOn()
		assert count == 2000000
	}
	
	@Test
	void runPartTwoTestTurnOn() {
		lights.initPart2();
		int count = 0
		
		lights.runInstruction("turn on 0,0 through 999,999")

		count = lights.countOn()
		assert count == 1000000
	}
	
	@Test
	void runPartTwoTestTurnOff() {
		lights.initPart2();
		int count = 0
		
		lights.runInstruction("turn off 0,0 through 999,999")

		count = lights.countOn()
		assert count == 0 
	}
}

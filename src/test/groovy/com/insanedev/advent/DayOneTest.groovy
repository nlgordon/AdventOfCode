package com.insanedev.advent

import org.junit.Test

import groovy.util.logging.Slf4j

@Slf4j
class DayOneTest {
	
	@Test
	void testIncrement() {
		String input = "("
		def ret = DayOne.getFloor(input)
		
		assert ret['floor'] == 1
	}

	@Test
	void testDecrement() {
		String input = ")"
		def ret = DayOne.getFloor(input)
		
		assert ret['floor'] == -1
	}
	
	@Test
	void testFirstBasement() {
		String input = "()))"
		def ret = DayOne.getFloor(input)
		
		assert ret['floor'] == -2
		assert ret['firstBasement'] == 3
	}
	
	@Test
	void testFullInput() {
		String input = new File("src/main/resources/dayone.txt").text
		
		def ret = DayOne.getFloor(input)
		
		log.info("Floor: ${ret['floor']} First Basement: ${ret['firstBasement']}")
	}
}

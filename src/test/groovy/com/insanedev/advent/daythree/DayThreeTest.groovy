package com.insanedev.advent.daythree

import groovy.util.logging.Slf4j

import org.junit.Test

@Slf4j
class DayThreeTest {
	
	@Test
	void testDirections() {
		def ret = DayThree.deliver("^>v<^>v<", 1)
		assert ret['count'] == 4
	}
	
	@Test
	void testFinalRunWithOne() {
		String input = new File("src/main/resources/daythree.txt").text
		
		def ret = DayThree.deliver(input, 1)
		
		log.info("Houses: ${ret['count']}")
	}
	
	@Test
	void testFinalRunWithTwo() {
		String input = new File("src/main/resources/daythree.txt").text
		
		def ret = DayThree.deliver(input, 2)
		
		log.info("Houses: ${ret['count']}")
	}
}

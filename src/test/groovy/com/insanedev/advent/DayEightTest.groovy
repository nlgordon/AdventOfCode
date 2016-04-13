package com.insanedev.advent

import groovy.util.logging.Slf4j

import org.junit.Test

@Slf4j
class DayEightTest {
	@Test
	void testSimple() {
		List<DayEight> strings = []
		strings << new DayEight("\"\"")
		strings << new DayEight("\"abc\"")
		strings << new DayEight("\"aaa\\\"aaa\"")
		strings << new DayEight("\"\\x27\"")
		
		Integer codeLength = 0
		Integer memoryLength = 0
		
		strings.each {
			log.info("Length of: '${it.rawData}' ${it.codeLength}:${it.stringLength}")
			codeLength += it.codeLength
			memoryLength += it.stringLength
		}
		
		log.info("Code Length: $codeLength")
		log.info("Memory Length: $memoryLength")
		
		assert codeLength == 23
		assert memoryLength == 11
	}

	@Test
	void testReplacements() {
		DayEight test = new DayEight(/"aaa"aaa\\aaa\xfa"/)
		assert test.parsed == /aaa"aaa\aaa_/
	}
	
	@Test
	void testPartOne() {
		String input = new File("src/main/resources/dayeight.txt").text
		List<DayEight> strings = []
		int codeLength = 0
		int memoryLength = 0

		input.eachLine {
			DayEight item = new DayEight(it)
			codeLength += item.codeLength
			memoryLength += item.stringLength
			log.info(item.toString())
		}
		
		log.info("Diff between code and memory: ${codeLength - memoryLength}")
	}

}

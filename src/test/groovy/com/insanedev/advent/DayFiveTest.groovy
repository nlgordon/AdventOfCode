package com.insanedev.advent

import org.junit.Test

import groovy.util.logging.Slf4j;

@Slf4j
class DayFiveTest {
	@Test
	void testNaughty() {
		List<String> naughtyOptions = ['ab', 'cd', 'pq', 'xy']
		naughtyOptions.each {
			assert DayFive.isNice(it) == false
		}
	}
	
	@Test
	void testVowels() {
		assert DayFive.isNice("a") == false
		assert DayFive.isNice("ae") == false
		assert DayFive.isNice("aeibb") == true
		assert DayFive.isNice("aeioubb") == true
	}
	
	@Test
	void testDoubles() {
		assert DayFive.isNice("aaa") == true
		assert DayFive.isNice("baace") == true
		assert DayFive.isNice("baba") == false
	}
	
	@Test
	void testExamples() {
		assert DayFive.isNice("haegwjzuvuyypxyu") == false
		assert DayFive.isNice("jchzalrnumimnmhp") == false
		assert DayFive.isNice("ugknbfddgicrmopn") == true
		assert DayFive.isNice("aaa") == true
		assert DayFive.isNice("dvszwmarrgswjxmb") == false
	}
	
	@Test
	void partOne() {
		String input = new File("src/main/resources/dayfive.txt").text
		
		int count = DayFive.niceCount(input)
		
		log.info("Nice count: $count")
	}

}

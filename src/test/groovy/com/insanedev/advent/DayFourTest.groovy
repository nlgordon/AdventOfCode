package com.insanedev.advent

import groovy.util.logging.Slf4j

import org.junit.Ignore;
import org.junit.Test

@Slf4j
class DayFourTest {
	String key = "yzbqklnj"
	// String key = "abcdef"
	
	@Test
	void testMatch() {
		assert DayFour.matches("00000abc123", ~/^00000.*/) == true
	}
	
	@Test
	void testKnownHash() {
		String hash = DayFour.computeHash("abcdef609043")
		
		log.info("Hash: $hash")
	}
	
	@Test
	void runKnownPartOne() {
		String startsWith = "00000"
		int count = DayFour.findHash("abcdef", startsWith)
		log.info("Found Hash: $count for abcdef")
	}

	@Test
	void runPartOne() {
		String startsWith = "00000"
		int count = DayFour.findHash(key, startsWith)

		log.info("Found Hash: $count for $key")
	}

	@Test
	void runPartTwo() {
		String startsWith = "000000"
		int count = DayFour.findHash(key, startsWith)

		log.info("Found Hash: $count for $key")
	}
}

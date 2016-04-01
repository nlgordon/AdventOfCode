package com.insanedev.advent

import org.junit.Test
import com.insanedev.advent.Present

import groovy.util.logging.Slf4j;

@Slf4j
class DayTwoTest {

	@Test
	void testPresentParse() {
		Present present = new Present("1x2x3")
		
		assert present.length == 1
		assert present.width == 2
		assert present.height == 3
	}
	
	@Test
	void testPresentCoverage() {
		Present present = new Present("2x3x4")
		
		assert present.coverage == 58
	}
	
	@Test
	void testRunningTotal() {
		String input = """
2x3x4
1x1x10
"""
		def ret = DayTwo.calcWrappingNeeds(input)
		
		assert ret['paper'] == 58 + 43
	}
	
	@Test
	void testFinalRun() {
		String input = new File("src/main/resources/daytwo.txt").text
		
		def ret = DayTwo.calcWrappingNeeds(input)
		
		log.info("Wrapping Needs: ${ret['paper']} Ribbon Needs: ${ret['ribbon']}")
	}
	
	@Test
	void testRibbon() {
		Present present = new Present("2x3x4")
		
		assert present.ribbon == 34	

		present = new Present("1x1x10")
		
		assert present.ribbon == 14	
	}
}

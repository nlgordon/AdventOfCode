package com.insanedev.advent.daythree

import groovy.util.logging.Slf4j;

@Slf4j
class HouseMap {
	Map<Integer, Map<Integer, House>> map = [:]
	int count = 0
	
	public HouseMap() {
		getAt(0, 0)
	}
	
	House getAt(int x, int y) {
		if (!map[x]) {
			map[x] = [:]
		}
		if (!map[x][y]) {
			// log.debug("Creating at: $x, $y")
			map[x][y] = new House(this, x, y)
			count++
		}
		
		House ret = map[x][y]
		ret.deliveryCount++
		return ret
	}
}

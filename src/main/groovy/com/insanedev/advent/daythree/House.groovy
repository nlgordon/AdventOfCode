package com.insanedev.advent.daythree

import groovy.util.logging.Slf4j

@Slf4j
class House {
	Integer deliveryCount = 0
	final HouseMap map
	final int x
	final int y
	
	public House(HouseMap map, int x, int y) {
		this.map = map
		this.x = x
		this.y = y
	}
}

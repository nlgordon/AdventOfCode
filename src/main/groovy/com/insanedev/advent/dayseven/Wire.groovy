package com.insanedev.advent.dayseven

import java.util.regex.Matcher

class Wire {
	String name
	String source

	Integer value = null
	
	Wire(String name, String source) {
		if (source == null) {
			throw new IllegalArgumentException("Source can not be null for wire: $name")
		}
		
		if (source.isInteger()) {
			this.value = Integer.valueOf(source)
		} else {
			this.source = source
		}

		this.name = name
	}
	
	Integer getSignal(Circuit circuit) {
		if (value != null) {
			return value
		}
		
		return circuit.getSignal(source)
	}
}

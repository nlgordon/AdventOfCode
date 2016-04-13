package com.insanedev.advent.dayseven

import java.util.regex.Matcher

class AndGate extends TwoOperandGate {
	
	public AndGate(String dest, String left, String right) {
		super(dest, left, right)
	}

	Integer getOutput(Circuit circuit) {
		return circuit.getSignal(inputA) & circuit.getSignal(inputB)
	}
}

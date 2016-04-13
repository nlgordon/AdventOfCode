package com.insanedev.advent.dayseven

class OrGate extends TwoOperandGate {
	
	public OrGate(String dest, String left, String right) {
		super(dest, left, right)
	}

	Integer getOutput(Circuit circuit) {
		return circuit.getSignal(inputA) | circuit.getSignal(inputB)
	}
}

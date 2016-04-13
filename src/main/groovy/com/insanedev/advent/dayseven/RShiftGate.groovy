package com.insanedev.advent.dayseven

class RShiftGate extends TwoOperandGate {

	public RShiftGate(String dest, String left, String right) {
		super(dest, left, right)
	}

	@Override
	public Integer getOutput(Circuit circuit) {
		return circuit.getSignal(inputA) >> Integer.valueOf(inputB)
	}

}

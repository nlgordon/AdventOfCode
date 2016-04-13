package com.insanedev.advent.dayseven

class LShiftGate extends TwoOperandGate {
	
	public LShiftGate(String dest, String left, String right) {
		super(dest, left, right)
	}

	@Override
	public Integer getOutput(Circuit circuit) {
		return circuit.getSignal(inputA) << Integer.valueOf(inputB)
	}

}

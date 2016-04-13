package com.insanedev.advent.dayseven

abstract class TwoOperandGate extends Gate {
	String inputA
	String inputB

	public TwoOperandGate(String dest, String left, String right) {
		super(dest)
		this.inputA = left
		this.inputB = right
	}
}

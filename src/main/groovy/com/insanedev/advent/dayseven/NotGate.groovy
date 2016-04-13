package com.insanedev.advent.dayseven

class NotGate extends Gate {
	
	String left
	
	public NotGate(String dest, String left) {
		super(dest)
		this.left = left
	}

	@Override
	public Integer getOutput(Circuit circuit) {
		return ~circuit.getSignal(left);
	}

}

package com.insanedev.advent.dayseven

abstract class Gate {
	
	String dest
	
	public Gate(String dest) {
		this.dest = dest
	}

	abstract Integer getOutput(Circuit circuit)
}

package com.insanedev.advent.dayseven

import groovy.util.logging.Slf4j

import java.util.regex.Matcher

@Slf4j
class Circuit {
	// Map of initial wire values
	Map<String, Wire> wires = [:]
	
	// Map of gates by output wire
	Map<String, Gate> gates = [:]
	
	Map<String, Integer> signals = [:]
	
	Integer getSignal(String wire) {
		if (wire == null) {
			throw new IllegalArgumentException("Wire can not be null")
		}
		
		log.info("Getting signal for $wire")

		Integer ret = null
		
		if (signals[wire] != null) {
			log.info("Found cached value: ${signals[wire]}")
			return signals[wire]
		}
		if (wire =~ /^\d+$/) {
			ret = Integer.valueOf(wire)
		}

		if (gates[wire]) {
			ret = gates[wire].getOutput(this)
		} else if (wires[wire]) {
			ret = wires[wire].getSignal(this)
		}
		
		if (ret == null) {
			throw new IllegalArgumentException("Unable to get signal for $wire")
		}
		
		if (ret < 0) {
			ret += 65536
		}
		
		signals[wire] = ret
		
		return ret
	}
	
	void setWireValue(String wire, Integer value) {
		wires[wire].value = value
	}
	
	void resetCache() {
		signals = [:]
	}
	
	void processInstruction(String instruction) {
		if (!instruction.trim()) {
			return
		}
		Matcher overall = (instruction =~ /(.*) -> (.*)/)
		
		String source = overall[0][1]
		String dest = overall[0][2]

		if (source =~ /^([^ ]*)$/) {
			Wire wire = new Wire(dest, source)
			wires[wire.name] = wire
		} else if (source =~ /^NOT (.*)$/) {
			Matcher matcher = (source =~ /^NOT (.*)/)
			Gate gate = new NotGate(dest, matcher[0][1])
			gates[dest] = gate
		} else {
			// This is a gate
			Gate gate
			Matcher matcher = (source =~ /(.*) (AND|OR|LSHIFT|RSHIFT) (.*)/)
			if (matcher.matches()) {
				String left = matcher[0][1]
				String right = matcher[0][3]
				String command = matcher[0][2]
				switch (command) {
					case "AND":
						gate = new AndGate(dest, left, right)
						break;
					case "OR":
						gate = new OrGate(dest, left, right)
						break;
					case "LSHIFT":
						gate = new LShiftGate(dest, left, right)
						break;
					case "RSHIFT":
						gate = new RShiftGate(dest, left, right)
						break;
					case "NOT":
						gate = new NotGate(dest, left)
						break;
					default:
						throw new IllegalArgumentException("Invalid command: $command")
				}
				gates[dest] = gate
			}
		}
	}
}

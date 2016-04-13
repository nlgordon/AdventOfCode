package com.insanedev.advent.dayseven

import org.junit.Test;

import groovy.util.logging.Slf4j;

@Slf4j
class DaySevenTest {
	@Test
	void testAndGateInstruction() {
		Circuit circuit = new Circuit();
		circuit.processInstruction("1 AND 3 -> x")
		
		assert circuit.gates['x'] != null
		assert circuit.gates['x'] instanceof AndGate
		
		AndGate gate = circuit.gates['x']
		assert gate.inputA == '1'
		assert gate.inputB == '3'
		
		assert circuit.getSignal('x') == 1
	}

	@Test
	void testNotGateInstruction() {
		Circuit circuit = new Circuit();
		circuit.processInstruction("NOT 1 -> x")
		
		assert circuit.gates['x'] != null
		assert circuit.gates['x'] instanceof NotGate
		
		NotGate gate = circuit.gates['x']
		assert gate.left == '1'
		
		assert circuit.getSignal('x') == -2
	}

	@Test
	void testWireInstruction() {
		Circuit circuit = new Circuit();
		circuit.processInstruction("2 -> a")
		
		assert circuit.wires['a'] != null
		assert circuit.wires['a'] instanceof Wire
	}

	@Test
	void testGateGetSignal() {
		Circuit circuit = new Circuit();
		circuit.processInstruction("1 AND 3 -> x")
		
		assert circuit.getSignal('x') == 1
	}

	@Test
	void testGateGetSignalFromWire() {
		Circuit circuit = new Circuit();
		circuit.processInstruction("1 -> a")
		circuit.processInstruction("3 -> b")
		circuit.processInstruction("a AND b -> x")
		
		assert circuit.getSignal('x') == 1
	}
	
	@Test
	void testPartOne() {
		String input = new File("src/main/resources/dayseven.txt").text
		
		Circuit circuit = new Circuit();

		input.eachLine {
			circuit.processInstruction(it)
		}
		
		log.info("Part One Signal on a: ${circuit.getSignal('a')}")
	}
	
	@Test
	void testPartTwo() {
		String input = new File("src/main/resources/dayseven.txt").text
		
		Circuit circuit = new Circuit();

		input.eachLine {
			circuit.processInstruction(it)
		}
		
		Integer val = circuit.getSignal('a')
		circuit.setWireValue('b', val)
		circuit.resetCache()
		
		log.info("Part Two Signal on a: ${circuit.getSignal('a')}")
	}
	
	@Test
	void testSimple() {
		Circuit circuit = new Circuit();
		String instructions = """
123 -> x
456 -> y
x AND y -> d
x OR y -> e
x LSHIFT 2 -> f
y RSHIFT 2 -> g
NOT x -> h
NOT y -> i
""".eachLine {
			circuit.processInstruction(it)
		}
		
		assert circuit.getSignal("d") == 72
		assert circuit.getSignal("e") == 507
		assert circuit.getSignal("f") == 492
		assert circuit.getSignal("g") == 114
		assert circuit.getSignal("h") == 65412
		assert circuit.getSignal("i") == 65079
		assert circuit.getSignal("x") == 123
		assert circuit.getSignal("y") == 456
	}
}

package com.insanedev.advent

class DayEight {
	String rawData
	Integer codeLength
	Integer stringLength
	String parsed
	
	public DayEight(String data) {
		this.rawData = data
		this.codeLength = rawData.length()
		
		parsed = this.rawData
		parsed = parsed.replaceAll('^\"', "") 
		parsed = parsed.replaceAll('\"$', "") 
		parsed = parsed.replaceAll('\"', "\"")
		// parsed = parsed.replaceAll('\\\\', "\\")
		parsed = parsed.replaceAll("\\\\x[0-9a-f]{2}", "_")
		this.stringLength = parsed.length()
	}
	
	public String toString() {
		return "$rawData:$parsed $codeLength:$stringLength"
	}
}

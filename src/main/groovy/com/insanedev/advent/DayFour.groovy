package com.insanedev.advent

import groovy.util.logging.Slf4j

import java.security.MessageDigest
import java.util.regex.Pattern

@Slf4j
class DayFour {
	public static def findHash(String key, String startsWith) {
		Pattern searchPattern = ~/^$startsWith.*/

		for (int i = 0; i < 10000000; i++) {
			String hash = computeHash("$key$i")

			if (matches(hash, searchPattern)) {
				return i
			}
		}
		
		throw new UnsupportedOperationException("Hit max count")
	}
	
	public static String computeHash(String hashMessage) {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(hashMessage.getBytes());
		BigInteger hashNum = new BigInteger(1, md5.digest());
		return hashNum.toString(16).padLeft(32, "0");
	}
	
	public static boolean matches(String hash, Pattern searchPattern) {
		if (searchPattern.matcher(hash).matches()) {
			return true
		}

		return false
	}

}

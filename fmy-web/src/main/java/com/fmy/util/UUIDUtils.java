package com.fmy.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class UUIDUtils {
	
	public static String getUUID(){
		return StringUtils.remove(UUID.randomUUID().toString(), "-");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getUUID());
	}

}

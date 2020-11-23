package com.test.psk.common.util;

import com.google.gson.Gson;

public class Common {

	public static String makeJsonData(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);

	}
}

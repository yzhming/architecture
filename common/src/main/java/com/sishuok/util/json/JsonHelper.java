package com.sishuok.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	private JsonHelper() {
	}

	public static Object object2str(Object obj) {
		String retStr = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retStr;
	}

	public static Object str2Object(String str, Class cls) {
		Object retObj = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			retObj = mapper.readValue(str, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retObj;
	}

}

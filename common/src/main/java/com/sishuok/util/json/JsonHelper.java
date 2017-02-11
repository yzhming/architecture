package com.sishuok.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	private JsonHelper(){}
	
	public static String object2str(Object obj){
		String retStr="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retStr;
	}
}

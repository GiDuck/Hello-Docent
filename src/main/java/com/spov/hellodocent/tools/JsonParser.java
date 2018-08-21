package com.spov.hellodocent.tools;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


//Json을 파싱하기 위한 싱글톤 클래스
public class JsonParser {

	private static JsonParser jsonParser = new JsonParser();
	private Gson gson;

	public JsonParser() {

		gson = new GsonBuilder().create();

	}

	public static JsonParser newInstance() {

		if (jsonParser == null) {

			jsonParser = new JsonParser();
			
			return jsonParser;
			
		} else {

			return jsonParser;
		}

	}

	public <T> Object jsonToObject(String jsonStr, Type type) throws Exception {

		Object object = gson.fromJson(jsonStr, (Type) type);

		return object;
	}

	public String ObjectToJson(Object object) throws Exception {

		String jsonStr = gson.toJson(object);

		return jsonStr;
	}

}

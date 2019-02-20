package data_types;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;

public class JsonValueTest2 {
	
	public JsonValueTest2() {
		
		JsonArray array = Json.createArrayBuilder()
			.add(JsonValue.NULL)
			.add(JsonValue.FALSE)
			.add(JsonValue.TRUE)
			.add(JsonValue.EMPTY_JSON_ARRAY)
			.add(JsonValue.EMPTY_JSON_OBJECT)
			.add(Json.createValue("StringVal"))
			.add("JustString")
			.build();
		
		System.out.println(array);
		
	}
	
	
	public static void main(String[] args) {
		new JsonValueTest2();
	}
}

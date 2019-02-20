package streams;

import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;

//-JsonObject extends Map<String, JsonValue> it can not use stream() directly
// but we can use it for map.values() and map.keySet() (Strings, they need conversion to JsonValue to collect)

public class ToStreamObjectFronJsonObject {

	public ToStreamObjectFronJsonObject() {
		
		JsonObject jo = Json.createObjectBuilder().add("first", 1).add("second", 2).build();
		System.out.println("JsonObject:\t" + jo);
		
		JsonObject collected = jo.entrySet()
				.stream()
				.collect(JsonCollectors.toJsonObject());
		System.out.println("JO collected:\t" + collected);
		
		JsonObject collected2 = jo.entrySet()
				.stream()
				.filter( e -> e.getKey().startsWith("fi"))		//These are Java Strings (Map<String, JsonValue>)
				.collect(JsonCollectors.toJsonObject());
		System.out.println("JO filtered:\t" + collected2);
		
		
		System.out.println("\n");
		Map<String, JsonValue> map = jo;
		
		System.out.println("JA from keys:\t" + map.keySet().stream().map(e -> Json.createValue(e)).collect(JsonCollectors.toJsonArray()));
		System.out.println("JA from vals:\t" + map.values().stream().collect(JsonCollectors.toJsonArray()));
		
	}

	public static void main(String[] args) {
		new ToStreamObjectFronJsonObject();
	}
}

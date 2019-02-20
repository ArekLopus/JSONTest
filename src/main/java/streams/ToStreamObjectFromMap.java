package streams;

import static javax.json.Json.createValue;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;

//-JsonObject extends Map<String, JsonValue>
//-First we need to convert map to JsonObject-like map

public class ToStreamObjectFromMap {

	public ToStreamObjectFromMap() {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("first", 1);
		map.put("second", 2);
		
		
		Map<String, JsonValue> collectedToJsonLikeMap = map.entrySet()
			.stream()
			.collect(Collectors.toMap(Map.Entry::getKey, v -> createValue(v.getValue())));
			//.collect(Collectors.toMap(k -> ((Map.Entry<String, Integer>)k).getKey().toString() , v -> createValue(v.getValue())));
		System.out.println(collectedToJsonLikeMap);
		
		
		JsonObject collected = collectedToJsonLikeMap.entrySet().stream().collect(JsonCollectors.toJsonObject());
		System.out.println(collected);
		
	}

	public static void main(String[] args) {
		new ToStreamObjectFromMap();
	}
}

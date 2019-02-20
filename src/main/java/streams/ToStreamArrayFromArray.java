package streams;

import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;

//-JsonArray extends List<JsonValue>
//-We need to map an array to JsonValues.

public class ToStreamArrayFromArray {

	public ToStreamArrayFromArray() {
		
		String[] array = {"One", "Two"};
		
		JsonArray collected = Arrays.stream(array)
			.map(e -> Json.createValue(e))
			.collect(JsonCollectors.toJsonArray());
		
		System.out.println(collected);
		
		List<String> list = Arrays.asList(array);
		JsonArray collected2 = list.stream()
			.map(e -> Json.createValue(e))
			.collect(JsonCollectors.toJsonArray());
		
		System.out.println(collected2);
		
	}

	public static void main(String[] args) {
		new ToStreamArrayFromArray();
	}
}

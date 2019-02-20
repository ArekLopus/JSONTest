package streams;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;

//-JsonArray extends List<JsonValue> so it can use stream()

public class ToStreamArrayFromJsonArray {

	public ToStreamArrayFromJsonArray() {
		
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").build();
		System.out.println("JsonArray:\t" + ja);
		System.out.println("Item's class:\t" + ja.stream().findFirst().get().getClass());
		
		JsonArray collected = ja
				.stream()
				.filter( e -> e.toString().startsWith("\"O"))	//These are JsonStrings! -> "One", "Two"	
				.collect(JsonCollectors.toJsonArray());
		System.out.println("\nJA Filtered:\t" + collected);
		
		List<JsonValue> list = ja;
		System.out.println("JA from List:\t" + list.stream().collect(JsonCollectors.toJsonArray()));
		
		
	}

	public static void main(String[] args) {
		new ToStreamArrayFromJsonArray();
	}
}

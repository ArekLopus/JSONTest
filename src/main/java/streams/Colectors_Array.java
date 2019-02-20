package streams;

import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonCollectors;

//-JsonCollectors.toJsonArray() - collects filtered objects to an array.

public class Colectors_Array {

	public Colectors_Array() {
		
		JsonArray ja = null;
		
		try(JsonReader reader = Json.createReader(getClass().getResourceAsStream("/people.json"))) {
			ja = reader.readArray();
		} catch (Exception e) {
			ja = Json.createArrayBuilder().add("There was an error").add(""+e.getMessage()).build();
		}
		//System.out.println(ja);
		
		Stream<JsonObject> filter = ja.getValuesAs(JsonObject.class).stream().filter(x -> "F".equals(x.getString("gender")));
		System.out.println("Filtered:");
		filter.forEach(System.out::println);
		
		
		Stream<JsonObject> filtered = ja.getValuesAs(JsonObject.class).stream().filter(x -> "F".equals(x.getString("gender")));
		JsonArray collected = filtered.collect(JsonCollectors.toJsonArray());
		
		System.out.println("\nCollected:\n" + collected);
		
	}

	public static void main(String[] args) {
		new Colectors_Array();
	}
}

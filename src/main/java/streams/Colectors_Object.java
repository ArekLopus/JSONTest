package streams;

import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonCollectors;

//	JsonCollectors.toJsonObject
//-Constructs a Collector that accumulates the input JsonValueelements into a JsonObject.
// The name/value pairs of the JsonObject are computed by applying the provided mapping functions.
//-Parameters: keyMapper a mapping function to produce names. valueMapper a mapping function to produce values
//		JsonCollectors.toJsonObject(Function<JsonValue, String> keyMapper, Function<JsonValue, JsonValue> valueMapper)

//Simply:
//We convert items in current stream into a NEW object that has k,v created by mapping functions from items.

//-The first argument of JsonCollectors.toJsonObject() is the key of the new document that in this case is the name,
// and the second argument is the value which is the phone number.

public class Colectors_Object {

	public Colectors_Object() {
		
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
		JsonObject collected = filtered.collect(
			JsonCollectors.toJsonObject(										//Makes new object from values below:
				e -> e.asJsonObject().getString("name"),						//key - takes name from filtered objects 
				e -> e.asJsonObject().getJsonObject("phones").get("mobile")		//val - takes mobile from filtered objects 
			)
		);
		
		System.out.println("\nCollected:\n" + collected);
		
	}

	public static void main(String[] args) {
		new Colectors_Object();
	}
}

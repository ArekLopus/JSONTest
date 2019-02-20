package streams.examples;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonCollectors;

public class StreamToObject {

	public StreamToObject() {
		
		JsonArray ja = null;
		
		try(JsonReader reader = Json.createReader(getClass().getResourceAsStream("/people.json"))) {
			ja = reader.readArray();
		} catch (Exception e) {
			ja = Json.createArrayBuilder().add("There was an error").add(""+e.getMessage()).build();
		}
		
		System.out.println(ja);
		
		JsonObject result = ja.getValuesAs(JsonObject.class).stream()
				.filter(x -> "F".equals(x.getString("gender")))
				.collect(
					JsonCollectors.toJsonObject(
						k -> k.asJsonObject().getString("name"),
						v -> v.asJsonObject().getJsonObject("phones").get("mobile")
					)
				);
		
		System.out.println("Collected: " + result);
		
	}

	public static void main(String[] args) {
		new StreamToObject();
	}
}

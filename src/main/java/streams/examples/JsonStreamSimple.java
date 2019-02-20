package streams.examples;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.stream.JsonCollectors;

public class JsonStreamSimple {
	
	public JsonStreamSimple() {
		
		// {"langs":["Java","Net","C++","Scala","Python"]}
		JsonArray langs = Json.createArrayBuilder().add("Java").add("JavaScript").add("C++").add("Scala").add("Python").build();
		JsonObject jo = Json.createObjectBuilder().add("langs", langs).build();
		
		System.out.println(jo);
		
		JsonArray collected1 = jo.getJsonArray("langs").stream()
			.filter( js -> ((JsonString) js).getString().startsWith("Java") )
			.collect(JsonCollectors.toJsonArray());
		
		System.out.println("Collected: " + collected1);
		
	}
	
	
	public static void main(String[] args) {
		new JsonStreamSimple();
	}
}

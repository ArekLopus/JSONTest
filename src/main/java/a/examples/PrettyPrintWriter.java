package a.examples;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;

public class PrettyPrintWriter {

	public PrettyPrintWriter() {
		
		JsonObject jsonObject = Json.createObjectBuilder()
				.add("student",Json.createObjectBuilder()
				    .add("id", "123456")
				    .add("name", "John Doe")
				    .add("weight", 78.6)
				    .add("contact",Json.createArrayBuilder()
				        .add(Json.createObjectBuilder()
				            .add("address","Main st 1232"))
				        .add(Json.createObjectBuilder()
				            .add("phone","555-761-320")))
				    .add("gender","M")
				 ).build();
		
		
		StringWriter sw = new StringWriter();
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);	// Pretty printing feature is added.
		
		try (JsonWriter writer = Json.createWriterFactory(config).createWriter(sw)) {
		   writer.writeObject(jsonObject);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		System.out.println(sw.toString());
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PrettyPrintWriter();
	}

}

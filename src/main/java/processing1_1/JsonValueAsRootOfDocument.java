package processing1_1;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.JsonWriter;

//-JSON-Processing API 1.0 was based on RFC 4627.
//-JSON-Processing API 1.1 has been updated to RFC 7159.
//-The root of a JSON document might contain a simple value instead of only JSON objects or JSON arrays.
//-For this reason javax.java.Json, javax.java.JsonReader and javax.java.JsonWriter has been updated with following methods:
//	Json class:
//	public static JsonString | JsonNumber  createValue(String | int | long | double | BigInteger | BigDecimal value)
//
//	JsonReader:
//	default JsonValue readValue()
//
//	JsonWriter:
//	default void write(JsonValue value)

public class JsonValueAsRootOfDocument {

	public JsonValueAsRootOfDocument() {
		
		JsonString val = Json.createValue("One");
		
		StringWriter sw = new StringWriter();
		try(JsonWriter writer = Json.createWriter(sw)) {
			writer.write(val);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.println(sw.toString());
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new JsonValueAsRootOfDocument();
	}

}

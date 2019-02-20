package pointer1_1.examples;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonReader;

@SuppressWarnings("unused")
public class JsonPointerGFMonitoring {
	
	public JsonPointerGFMonitoring() {
		
		JsonObject jo = Json.createObjectBuilder().build();
		
		try(JsonReader reader = Json.createReader(getClass().getResourceAsStream("test.json"))) {
			jo = reader.readObject();
		} catch (Exception e) {
			jo = Json.createObjectBuilder().add("error","There was an error").build();
		}
		
		System.out.println("Reading: " + jo);
		
		JsonPointer pointer1 = Json.createPointer("/extraProperties/entity/corenumthreads");
		JsonPointer pointer2 = Json.createPointer("/exit_code");
		JsonPointer pointer3 = Json.createPointer("/extraProperties/entity/corenumthreads/count");
		
		System.out.println(pointer1.getValue(jo));
		System.out.println(pointer2.getValue(jo));
		System.out.println(pointer3.getValue(jo));
		
	}
	
	
	public static void main(String[] args) {
		new JsonPointerGFMonitoring();
	}
}

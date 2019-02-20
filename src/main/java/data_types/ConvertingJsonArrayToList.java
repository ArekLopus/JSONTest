package data_types;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;

//-JsonArray extends JsonStructure, List<JsonValue>

public class ConvertingJsonArrayToList {
	
	public ConvertingJsonArrayToList() {
		
		JsonArray ja = Json.createArrayBuilder().add(1).add(2).build();
		
		List<JsonValue> list = ja;
		
		System.out.println("Class: " + list.getClass().getName());
		System.out.println("List: " + list);
				
	}
	
	public static void main(String... args) {
		new ConvertingJsonArrayToList();
		
	}
	
}

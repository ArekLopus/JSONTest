package data_types;

import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

//-JsonObject extends JsonStructure, Map<String, JsonValue>

public class ConvertingJsonObjectToMap {
	
	public ConvertingJsonObjectToMap() {
		
		//Nie mogą być 2 takie same nazwy (jak 2 nazwy atrybutów w obiekcie?) 
		JsonObject jo = Json.createObjectBuilder().add("John", "Doe").add("John1", "Rambo").build();
				
		Map<String, JsonValue> map = jo;
				
		System.out.println("Class: "+map.getClass().getName());
		System.out.println("Keys: "+map.keySet());
		System.out.println("Vals: "+map.values());
				
	}
	
	public static void main(String... args) {
		new ConvertingJsonObjectToMap();
		
	}
	
}

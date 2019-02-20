package data_types;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class CreatingObjectAndArray {

	public CreatingObjectAndArray() {
		
		//JsonArray from scratch
		JsonArray ja1 = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println(ja1);
		
		
		//JsonArray from Collection (1.1)
		List<String> list = Arrays.asList("One" , "Two", "Three");
		JsonArray ja2 = Json.createArrayBuilder(list).build();
		System.out.println(ja2);
		
		
		//JsonObject from scratch
		JsonObject jo1 = Json.createObjectBuilder().add("array", ja1).build();
		System.out.println(jo1);
		
		JsonObject jo2 = Json.createObjectBuilder().add("object", jo1).build();
		System.out.println(jo2);
		
		//JsonObject from Map (1.1)
		Map<String, Object> map = new TreeMap<>();
		map.put("name", "John");
		map.put("surname", "Doe");
		JsonObject jo3 = Json.createObjectBuilder(map).build();
		System.out.println(jo3);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new CreatingObjectAndArray();
	}

}

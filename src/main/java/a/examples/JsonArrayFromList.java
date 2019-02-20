package a.examples;

import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;

public class JsonArrayFromList {

	public JsonArrayFromList() {
		
		JsonArray jsonStringArray = Arrays.asList("One", "Two").
                stream().
                map(Json::createValue).
                collect(JsonCollectors.toJsonArray());
        
        System.out.println(jsonStringArray);
	}

	public static void main(String[] args) {
		new JsonArrayFromList();

	}

}

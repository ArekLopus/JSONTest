package data_types;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;

//-An array is an ordered collection of values separated by a comma (,) within brackets ([]).
//-The following text gives an example of a JSON array, which contains a list of students with their score in alphabetical order.
//	[  {"name":"Amanda","score"=12.9}  ,  {"name":"Paolo","score"=14}  ,  {"name":"Zambo","score"=12.3}  ]

public class JsonArrayTest {
	
	public JsonArrayTest() {
		
		JsonArray arr = Json.createArrayBuilder().add("abc").add("def").build();
		
		System.out.println(arr);
		
		System.out.println("\narr instanceof JsonValue -> "+(arr instanceof JsonValue));
		System.out.println("arr instanceof JsonArray -> "+(arr instanceof JsonArray));
		System.out.println("arr instanceof JsonObject -> "+(arr instanceof JsonObject));
		System.out.println("arr instanceof JsonNumber -> "+(arr instanceof JsonNumber));
		
	}
	
	
	public static void main(String[] args) {
		new JsonArrayTest();
	}
}

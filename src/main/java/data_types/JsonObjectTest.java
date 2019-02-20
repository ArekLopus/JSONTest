package data_types;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;

//-An object is an unordered set of name:value pairs within braces ( {} ).
// After each name, there is a colon (:) and the name-value pairs are separated by a comma (,).
//-The name is string type while the type of the value can be string, object and so on.
//-The following text gives an example of a JSON object, which contains some information about a student:
//	{  "name":"Malinda"  ,  "gender":"F"  ,  "birthday":"14/03/1976"  ,  "weight":78.5  }

public class JsonObjectTest {
	
	public JsonObjectTest() {
		
		JsonObject jo = Json.createObjectBuilder().add("key1", "value1").add("key2", "value2").build();
		
		System.out.println(jo);
		
		
		System.out.println("\njo instanceof JsonValue -> "+(jo instanceof JsonValue));
		System.out.println("jo instanceof JsonArray -> "+(jo instanceof JsonArray));
		System.out.println("jo instanceof JsonObject -> "+(jo instanceof JsonObject));
		System.out.println("jo instanceof JsonNumber -> "+(jo instanceof JsonNumber));
		
	}
	
	
	public static void main(String[] args) {
		new JsonObjectTest();
	}
}

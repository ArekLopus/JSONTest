package pointer1_1;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonValue;

//-If you want to point to name field, you should use syntax:
//		/author/name

public class JsonPointerObject {

	public JsonPointerObject() {
		
		//{"author":{"name":"Duke"}}
		JsonObject jo = Json.createObjectBuilder().add("author", Json.createObjectBuilder().add("name", "Duke")).build();
		System.out.println(jo);
		
		JsonPointer pointer = Json.createPointer("/author/name");
		JsonValue name = pointer.getValue(jo);
		System.out.println(name);
		
		
		JsonPointer pointer2 = Json.createPointer("/author");
		JsonValue name2 = pointer2.getValue(jo);
		System.out.println(name2);
		
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new JsonPointerObject();
	}

}

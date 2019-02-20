package pointer1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonValue;

//-In case of arrays, use an integer to point to an element of the array and it is 0 based. For example:
//		/books/0

public class JsonPointerArray {

	public JsonPointerArray() {
		
		//["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		//{"counter":["One","Two","Three"]}
		JsonObject jo = Json.createObjectBuilder().add("counter", Json.createArrayBuilder(ja)).build();
		System.out.println(ja);
		System.out.println(jo);
		
		JsonPointer pointer1 = Json.createPointer("/0");
		JsonValue first = pointer1.getValue(ja);
		System.out.println(first);
		
		JsonPointer pointer2 = Json.createPointer("/counter/1");
		JsonValue second = pointer2.getValue(jo);
		System.out.println(second);
		
		JsonPointer pointer3 = Json.createPointer("");
		JsonValue all = pointer3.getValue(ja);
		System.out.println(all);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new JsonPointerArray();
	}

}

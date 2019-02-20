package pointer1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPointer;

//-JsonPointer - add(), containsValue(), getValue(), remove(), replace()
//-JsonArray, JsonObjects are immutable - operations add, replace, remove are creating new objects.

public class JsonPointerTransformations {
	
	public JsonPointerTransformations() {
		
		//["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println(ja);
		
		JsonPointer pointer1 = Json.createPointer("/0");
		System.out.println("Pointer '/0' -> " + pointer1.getValue(ja));
		
		
		JsonArray newJa1 = pointer1.add(ja, Json.createValue("Zero"));		//Adds BEFORE the pointer
		System.out.println("\nAdded:\t\t" + newJa1);

		JsonArray newJa2 = pointer1.replace(ja, Json.createValue("1"));
		System.out.println("Replaced:\t" + newJa2);
		
		JsonArray newJa3 = pointer1.remove(ja);
		System.out.println("Removed:\t" + newJa3);
		
	}
	
	
	public static void main(String[] args) {
		new JsonPointerTransformations();
	}
}

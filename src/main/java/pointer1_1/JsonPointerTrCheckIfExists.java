package pointer1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPointer;

//-JsonPointer - add(), containsValue(), getValue(), remove(), replace()
//-JsonArray, JsonObjects are immutable - operations add, replace, remove are creating new objects.

public class JsonPointerTrCheckIfExists {
	
	public JsonPointerTrCheckIfExists() {
		
		//["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		
		JsonPointer pointer1 = Json.createPointer("/0");
		boolean containsValue = pointer1.containsValue(ja);
		System.out.println("Pointer '/0' exists? -> " + containsValue);
		
		JsonPointer pointer2 = Json.createPointer("/3");
		System.out.println("Pointer '/3' exists? -> " + pointer2.containsValue(ja));
	}
	
	
	public static void main(String[] args) {
		new JsonPointerTrCheckIfExists();
	}
}

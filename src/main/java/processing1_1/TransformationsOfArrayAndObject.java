package processing1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

//-In JSON-Processing API 1.0, JsonObject and JsonArray are immutable objects. Once created, it can’t be modified.
//-So if you want to change a JSON element you should manually copy each of the properties of the JSON object
// into JsonObjectBuilder/JsonArrayBuilder and then modify the object.

//-With JSON-Processing API 1.1, these objects are still immutable, but a JsonObjectBuilder/JsonArrayBuilder can be created
// from a given JsonObject/JsonArray so the copy of the properties are done automatically.

//JsonArray target = Json.createArrayBuilder().add(…).build();
//JsonArrayBuilder builder = Json.createArrayBuilder(target);	// Create a builder initialized with the target values
//JsonArray result = builder.add(99, "john")					// Operations on the array
//                          .set(100, 1234)
//                          .remove(3)
//                          .build();

public class TransformationsOfArrayAndObject {

	public TransformationsOfArrayAndObject() {
		
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		
		JsonArrayBuilder builder = Json.createArrayBuilder(ja);
		builder.add(Json.createValue("Four"));
		builder.set(1, "TwoTwo");
		//builder.set(10, "TwoTwo");	 java.lang.IndexOutOfBoundsException: Index: 10, Size: 4
		builder.remove(0);
		JsonArray newJa = builder.build();
		
		System.out.println(newJa);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new TransformationsOfArrayAndObject();
	}

}

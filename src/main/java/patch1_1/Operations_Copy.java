package patch1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

//-JsonPatch - add(), copy(), move(), remove(), replace(), test()

public class Operations_Copy {

	public Operations_Copy() {

		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println("Array:\t\t" + ja);
		
		JsonArray patched = Json.createPatchBuilder()
				.copy("/3", "/0")	// destination, source
				.build()
				.apply(ja);
		
		System.out.println("Patched:\t" + patched);
		
		
		JsonObject jo = Json.createObjectBuilder().add("name", "John").add("surname", "Doe").add("age", 42).build();
		System.out.println("\nObject:\t\t" + jo);
		
		JsonObject patchedOjb = Json.createPatchBuilder()
				.copy("/surname", "/name")		// destination, source
				.build()
				.apply(jo);
		
		System.out.println("Patched:\t" + patchedOjb);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new Operations_Copy();
	}

}

package patch1_1;

import javax.json.Json;
import javax.json.JsonArray;

//-The test operation determines if the specified value is set in the JSON document.
//-If the test fails the patch operations ceases, otherwise it goes ahead and completes the remaining operations.

//-JsonPatch - add(), copy(), move(), remove(), replace(), test()

public class Operations_Test {

	public Operations_Test() {

		// ["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println("Array:\t\t" + ja);
		
		JsonArray patched = Json.createPatchBuilder()
				.test("/0", "One")
				.replace("/0", "1")
				.build()
				.apply(ja);
		
		System.out.println("Patched:\t" + patched);
		
		
		JsonArray failed = Json.createPatchBuilder()
				.test("/0", "1")
				.replace("/0", "1")
				.build()
				.apply(ja);
				
		System.out.println("\nFailed:\n" + failed);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new Operations_Test();
	}

}

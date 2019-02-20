package patch1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPatch;

//-JsonPatch - add(), copy(), move(), remove(), replace(), test()

public class CreatePatchWithBuilder {

	public CreatePatchWithBuilder() {

		// ["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println("Array:\t\t\t" + ja);

		JsonPatch patch = Json.createPatchBuilder()
				.add("/0", "Zero")
				.replace("/1", "1")
				.remove("/3")
				.build();
		System.out.println("Patch operations:\t" + patch);
		
		JsonArray patched = patch.apply(ja);
		System.out.println("Patched:\t\t" + patched);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new CreatePatchWithBuilder();
	}

}

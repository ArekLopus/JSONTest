package patch1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPatch;

//-JsonPatch - add(), copy(), move(), remove(), replace(), test()
//[
//	{"op":"add","path":"/0","value":"Zero"},
//	{"op":"replace","path":"/1","value":"1"},
//	{"op":"remove","path":"/3"}
//]
public class CreatePatchWithArray {

	public CreatePatchWithArray() {

		// ["One","Two","Three"]
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").add("Three").build();
		System.out.println("Array:\t\t\t" + ja);
		
		JsonArray ja2 = Json.createArrayBuilder()
				.add(Json.createObjectBuilder().add("op", "add").add("path", "/0").add("value", "Zero"))
				.add(Json.createObjectBuilder().add("op", "replace").add("path", "/1").add("value", "1"))
				.add(Json.createObjectBuilder().add("op", "remove").add("path", "/3"))
				.build();
		
		JsonPatch patch = Json.createPatch(ja2);
		System.out.println("Patch operations:\t" + patch);
		
		JsonArray patched = patch.apply(ja);
		System.out.println("Patched:\t\t" + patched);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new CreatePatchWithArray();
	}

}

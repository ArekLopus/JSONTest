package patch_merge1_1;

import javax.json.Json;
import javax.json.JsonMergePatch;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class MergePatchObject {

	public MergePatchObject() {

		JsonObject jo = Json.createObjectBuilder().add("a", "b").build();
		System.out.println("Object:\t\t" + jo);
		
		JsonObject jo2 = Json.createObjectBuilder().add("c", "d").build();
		JsonMergePatch patch = Json.createMergePatch(jo2);
		System.out.println("Patch:\t\t" + patch.toJsonValue());
		
		JsonValue patched = patch.apply(jo);
		System.out.println("Patched:\t" + patched);
		
		
		JsonMergePatch diff1 = Json.createMergeDiff(jo, patched);	//Difference between original and patched
		JsonMergePatch diff2 = Json.createMergeDiff(patched, jo);	//Difference between patched and original
		System.out.println("Diff 1:\t" + diff1.toJsonValue());
		System.out.println("Diff 2:\t" + diff2.toJsonValue());
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MergePatchObject();
	}

}

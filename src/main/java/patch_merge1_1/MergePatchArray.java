package patch_merge1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonMergePatch;
import javax.json.JsonValue;

//	https://erosb.github.io/post/json-patch-vs-merge-patch/
//-Arrays cannot be manipulated by merge patches.
// If you want to add an element to an array, or mutate any of its elements then you have to include the entire array
// in the merge patch document, even if the actually changed parts is minimal.

public class MergePatchArray {

	public MergePatchArray() {
		
		JsonArray ja = Json.createArrayBuilder().add("One").add("Two").build();
		System.out.println("Array:\t\t" + ja);
		
		JsonArray ja2 = Json.createArrayBuilder().add("Three").add("Four").build();
		JsonMergePatch patch = Json.createMergePatch(ja2);
		System.out.println("Patch:\t\t" + patch.toJsonValue());
		
		JsonValue patched = patch.apply(ja);
		System.out.println("Patched:\t" + patched);
		
		
		JsonMergePatch diff1 = Json.createMergeDiff(ja, patched);	//Difference between original and patched
		JsonMergePatch diff2 = Json.createMergeDiff(patched, ja);	//Difference between patched and original
		System.out.println("Diff 1:\t" + diff1.toJsonValue());
		System.out.println("Diff 2:\t" + diff2.toJsonValue());
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MergePatchArray();
	}

}

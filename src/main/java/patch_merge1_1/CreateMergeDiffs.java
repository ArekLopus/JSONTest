package patch_merge1_1;

import javax.json.Json;
import javax.json.JsonMergePatch;
import javax.json.JsonObject;

//-1st parameter is what we have. 2nd is what we want to achive, result is the difference

public class CreateMergeDiffs {

	public CreateMergeDiffs() {

		JsonObject jo = Json.createObjectBuilder().add("a", "b").build();
		System.out.println("Object1:\t" + jo);
		
		JsonObject jo2 = Json.createObjectBuilder().add("a", "b").add("b", "c").build();
		System.out.println("Object2:\t" + jo2);
		
		
		JsonMergePatch diff1 = Json.createMergeDiff(jo, jo2);	//Difference between original and patched
		JsonMergePatch diff2 = Json.createMergeDiff(jo2, jo);	//Difference between patched and original
		
		System.out.println("Diff 1:\t" + diff1.toJsonValue());
		System.out.println("Diff 2:\t" + diff2.toJsonValue());
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new CreateMergeDiffs();
	}

}

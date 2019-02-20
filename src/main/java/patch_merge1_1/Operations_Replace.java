package patch_merge1_1;

import javax.json.Json;
import javax.json.JsonMergePatch;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Operations_Replace {

	public Operations_Replace() {

		JsonObject jo = Json.createObjectBuilder().add("a", "b").build();
		System.out.println("Object:\t\t" + jo);
		
		JsonObject jo2 = Json.createObjectBuilder().add("a", "c").build();
		JsonMergePatch patch = Json.createMergePatch(jo2);
		System.out.println("Patch:\t\t" + patch.toJsonValue());
		
		JsonValue patched = patch.apply(jo);
		System.out.println("Patched:\t" + patched);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new Operations_Replace();
	}

}

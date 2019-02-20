package binding;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.User;

public class MappingsBasic_Simple {

	public MappingsBasic_Simple() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		String json = jsonb.toJson(new User("John","Doe"));
		System.out.println(json);
		
		User fromJson = jsonb.fromJson(json, User.class);
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MappingsBasic_Simple();
	}

}

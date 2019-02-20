package binding;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.UserEnum;

public class MappingEnum {

	public MappingEnum() {
		
		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(UserEnum.DEFAULT_USER);
		
		System.out.println(json);
		
		
		UserEnum fromJson = jsonb.fromJson(json, UserEnum.class);
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MappingEnum();
	}
	
	
	enum Counter {
		ONE,
		TWO,
		THREE
	}
}

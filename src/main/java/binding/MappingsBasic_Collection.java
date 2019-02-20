package binding;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.User;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MappingsBasic_Collection {

	
	public MappingsBasic_Collection() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		List users = new ArrayList();
		users.add(new User("John", "Doe"));
		users.add(new User("Jane", "Do"));

		String usersJson = jsonb.toJson(users);
		System.out.println(usersJson);
		

		List<User> fromJson = jsonb.fromJson(usersJson, ArrayList.class);
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MappingsBasic_Collection();
	}

}

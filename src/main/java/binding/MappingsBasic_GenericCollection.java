package binding;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.User;

public class MappingsBasic_GenericCollection {

	public MappingsBasic_GenericCollection() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		List<User> users = new ArrayList<>();
		users.add(new User("John", "Doe"));
		users.add(new User("Jane", "Do"));

		String usersJson = jsonb.toJson(users);
		System.out.println(usersJson);
		
		@SuppressWarnings("serial")
		List<User> fromJson = jsonb.fromJson(usersJson, new ArrayList<User>(){}.getClass().getGenericSuperclass());
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new MappingsBasic_GenericCollection();
	}

}

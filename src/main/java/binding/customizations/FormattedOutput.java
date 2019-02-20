package binding.customizations;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;

public class FormattedOutput {

	public FormattedOutput() {
		
		// Create custom configuration with formatted output
		JsonbConfig config = new JsonbConfig()
		    .withFormatting(true);

		Jsonb jsonb = JsonbBuilder.create(config);

		List<User> users = new ArrayList<>();
		users.add(new User("John", "Doe"));
		users.add(new User("Jane", "Do"));

		String usersJson = jsonb.toJson(users);
		System.out.println(usersJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new FormattedOutput();
	}

}

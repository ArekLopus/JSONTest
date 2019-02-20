package a.examples;

import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.User;

public class UserToJsonMethodTest {

	public UserToJsonMethodTest() {
		
		User u = User.DEFAULT_USER;
		
		JsonObject json = u.toJson();
		System.out.println(json);
		
		Jsonb jsonb = JsonbBuilder.newBuilder().build();
		User fromJson = jsonb.fromJson(json.toString(), User.class);
		
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new UserToJsonMethodTest();
	}

}

package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;
import binding.helper.UserNullableProps;

//	Null handling
//-By default JSON-B doesn’t serialize fields with null values. This may be a not desired behaviour.
//-There are three different ways to change default null handling.

//-On a class or package level using @JsonbNillable annotation
//	@JsonbNillable
//	public class Person {}

//-On individual properties using @JsonbProperty(nillable=true):
//	public class Person {
//	    @JsonbProperty(nillable=true)
//	    private String name;
//	}

//-Globally using withNullValues() of JsonbConfig class
//	JsonbConfig nillableConfig = new JsonbConfig()	// Create custom configuration
//	    .withNullValues(true);
//	Jsonb jsonb = JsonbBuilder.create(nillableConfig);	// Create Jsonb with custom configuration

public class NullsHandling {

	public NullsHandling() {
		
		User user = new User(null, null, null);
		
		Jsonb jsonb = JsonbBuilder.create();
		String userNoNullHandling = jsonb.toJson(user);
		System.out.println("User Without Null Handling:\t\t" + userNoNullHandling);
		
		
		String userWithNullHandlingAnnotations = jsonb.toJson(UserNullableProps.DEFAULT_NULL_USER);
		System.out.println("User With Null Handling Annotations:\t" + userWithNullHandlingAnnotations);
		
		
		JsonbConfig config = new JsonbConfig()
			.withNullValues(true);
		jsonb = JsonbBuilder.create(config);
		
		String userWithNullHandling = jsonb.toJson(user);
		System.out.println("User With Null Handling Config:\t\t" + userWithNullHandling);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new NullsHandling();
	}

}

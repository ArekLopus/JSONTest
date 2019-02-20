package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.UserCustomConstructor;

//	Custom Constructor instantiation
//-By default, public default no-arguments constructor is required for deserialization.
// In many scenarios this requirement is too strict. 
//-@JsonbCreator can be used to annotate a custom constructor with parameters
// or a static factory method used to create a class instance.

//-@JsonbProperty on the constructor parameter is required for proper parameter substitution.
//	@JsonbCreator
//	public UserCustomConstructor(@JsonbProperty(value="firstName") String firstName,
//		@JsonbProperty(value="lastName") String lastName, @JsonbProperty(value="dateOfBirth") LocalDate dateOfBirth)

//	Without customization
//Exception in thread "main" javax.json.bind.JsonbException:
//Can't create instance of a class: class binding.helper.UserCustomInstantation, No default constructor found.

public class CustomConstructorInstantation {

	public CustomConstructorInstantation() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		String json = "{\"dateOfBirth\":\"1989-02-11\",\"firstName\":\"John\",\"lastName\":\"Doe\"}";
		System.out.println(json);
		
		
		UserCustomConstructor fromJson = jsonb.fromJson(json, UserCustomConstructor.class);
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new CustomConstructorInstantation();
	}

}

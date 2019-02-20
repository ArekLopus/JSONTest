package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import binding.helper.UserTransient;

//	Ignoring properties
//-Class properties annotated with @JsonbTransient are ignored by JSON Binding engine. 
//-The behavior is different depending on where @JsonbTransient annotation is placed.
// • On field - Property is ignored during serialization and deserialization.
// • On getter - Property is ignored during serialization only.
// • On setter - Property is ignored during deserialization only.

public class PropertiesTransient {

	public PropertiesTransient() {
		
		Jsonb jsonb = JsonbBuilder.create(); 
		
		//{"dateOfBirth":"1989-02-11","firstName":"John","lastName":"Doe"}
		String jsonAny = jsonb.toJson(UserTransient.DEFAULT_USER);
		System.out.println("No transient dateOfBirth property:\t" + jsonAny);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PropertiesTransient();
	}

}

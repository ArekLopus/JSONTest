package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;

import binding.helper.User;

//	Properties order
//-To customize the order of serialized properties, JSON Binding provides PropertyOrderStrategy class.
//-The supported strategies are:
// • LEXICOGRAPHICAL (A-Z)
// • ANY (order is undefined, in the most cases it will an order in which properties appear in the class)
// • REVERSE (Z-A)

//-Default order strategy is LEXICOGRAPHICAL.
//-Order strategy can be applied globally using withPropertyOrderStrategy() of JsonbConfig class
//-Or using @JsonbPropertyOrder annotation on class.	!!!Doesnt work here!!!

//JsonbConfig config = new JsonbConfig()
//    .withPropertyOrderStrategy(PropertyOrderStrategy.ANY);
//Jsonb jsonb = JsonbBuilder.create(config);
//
//@JsonbPropertyOrder(PropertyOrderStrategy.ANY)
//public class Person {
//    private String name;
//    private String profession;
//}

public class PropertiesOrder {

	public PropertiesOrder() {
		
		Jsonb jsonb = JsonbBuilder.create();		//Default: PropertyOrderStrategy.LEXICOGRAPHICAL 
		
		String jsonLex = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("LEXICOGRAPHICAL:\t" + jsonLex);
		
		
		JsonbConfig config = new JsonbConfig()
				.withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE);
		jsonb = JsonbBuilder.create(config);
				
		String jsonRev = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("REVERSE:\t\t" + jsonRev);
		
		
		config = new JsonbConfig()
			.withPropertyOrderStrategy(PropertyOrderStrategy.ANY);
		jsonb = JsonbBuilder.create(config);
			
		String jsonAny = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("ANY:\t\t\t" + jsonAny);
		

		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PropertiesOrder();
	}

}

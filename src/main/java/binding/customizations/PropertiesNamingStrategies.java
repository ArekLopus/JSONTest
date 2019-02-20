package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

import binding.helper.User;

//	Naming Strategies
//-Naming strategy is used to change a default way of constructing property names.
//-Supported naming strategies are:
// • IDENTITY (myMixedCaseProperty)
// • LOWER_CASE_WITH_DASHES (my-mixed-case-property)
// • LOWER_CASE_WITH_UNDERSCORES (my_mixed_case_property)
// • UPPER_CAMEL_CASE (MyMixedCaseProperty)
// • UPPER_CAMEL_CASE_WITH_SPACES (My Mixed Case Property)
// • CASE_INSENSITIVE (mYmIxEdCaSePrOpErTy)
// • Or your custom implementation of JsonbNamingStrategy interface

//-IDENTITY strategy is the default one.
//-It can be applied using with withPropertyNamingStrategy() of JsonbConfig class.

public class PropertiesNamingStrategies {

	public PropertiesNamingStrategies() {
		
		JsonbConfig config = new JsonbConfig()
			.withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
		Jsonb jsonb = JsonbBuilder.create(config);
		
		String json = jsonb.toJson(User.DEFAULT_USER);
		System.out.println(json);
		
		User fromJson = jsonb.fromJson(json, User.class);
		System.out.println(fromJson);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PropertiesNamingStrategies();
	}

}

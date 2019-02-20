package binding;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;

//setProperty(String name, Object value)				Set the particular configuration property to a new value.
//withAdapters(JsonbAdapter... adapters)				Property used to specify custom mapping adapters.
//withBinaryDataStrategy(String binaryDataStrategy)		Property used to specify custom binary data strategy.
//withDateFormat(String dateFormat, Locale locale)		Property used to specify custom date format.
//withDeserializers(JsonbDeserializer... deserializers)	Property used to specify custom deserializers.
//withEncoding(String encoding)							The binding operations will default to this property for encoding of JSON data.
//withFormatting(Boolean formatted)						Property used to specify whether or not the serialized JSON data is formatted with linefeeds and indentation.
//withLocale(Locale locale)								Property used to specify custom locale.
//withNullValues(Boolean serializeNullValues)			Property used to specify whether null values should be serialized to JSON document or skipped.
//withPropertyNamingStrategy(String prNamingStrategy)	Property used to specify custom naming strategy.
//withPropertyNamingStrategy(PropertyNamingStrategy pns)	Property used to specify custom naming strategy.
//withPropertyOrderStrategy(String propertyOrderStrategy)	Property used to specify property order strategy.
//withPropertyVisibilityStrategy(PropertyVisibilityStrategy pvs)	Property used to specify custom property visibility strategy.
//withSerializers(JsonbSerializer... serializers)		Property used to specify custom serializers.
//withStrictIJSON(Boolean enabled)						Property used to specify whether strict I-JSON serialization compliance should be enforced.


public class ConfigJsonb_withMethods {

	public ConfigJsonb_withMethods() {
		
		// Create custom configuration with formatted output
		JsonbConfig config = new JsonbConfig()
				
		    .withFormatting(true);

		// Create Jsonb with custom configuration
		Jsonb jsonb = JsonbBuilder.create(config);

		List<User> users = new ArrayList<>();
		users.add(new User("John", "Doe"));
		users.add(new User("Jane", "Dowson"));

		String usersJson = jsonb.toJson(users);
		System.out.println(usersJson);
		
		
		@SuppressWarnings("serial")
		List<User> fromJson = jsonb.fromJson(usersJson, new ArrayList<User>(){}.getClass().getGenericSuperclass());
		System.out.println(fromJson);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new ConfigJsonb_withMethods();
	}

}

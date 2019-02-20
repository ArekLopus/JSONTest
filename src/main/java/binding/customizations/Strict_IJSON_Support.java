package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;

//	Strict I-JSON support	https://tools.ietf.org/html/draft-ietf-json-i-json-06
//-I-JSON (”Internet JSON”) is a restricted profile of JSON. JSON-B fully supports I-JSON by default with three exceptions:
//	 • JSON Binding does not restrict the serialization of top-level JSON texts that are neither objects nor arrays.
//	   The restriction should happen at application level.
//	 • JSON Binding does not serialize binary data with base64url encoding.
//	 • JSON Binding does not enforce additional restrictions on dates/times/duration.

//-Full support mode can be switched on like it’s shown below:
//	JsonbConfig config = new JsonbConfig()
//	    .withStrictIJSON(true);
//	Jsonb jsonb = JsonbBuilder.create(config);

public class Strict_IJSON_Support {

	public Strict_IJSON_Support() {
		
		
		byte[] bytes = "Abracadabra".getBytes();
		
		Jsonb jsonb = JsonbBuilder.create();			//default - BYTE encoding
		
		String json = jsonb.toJson(bytes);
		System.out.println("Default BYTE encoding:\t" + json);
		
		
		String json1 = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("No Strict I-JSON:\t" + json1);
		
		
		JsonbConfig config = new JsonbConfig()
			    .withStrictIJSON(true);
		jsonb = JsonbBuilder.create(config);
		
		
		String json2 = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("With Strict I-JSON:\t" + json2);
		
		
		//Exception in thread "main" javax.json.bind.JsonbException: Cannot marshal single value because I-Json is enabled!
		//It is RECOMMENDED that binary data is encoded in a string value in base64url
		try {
			String json3 = jsonb.toJson(bytes);
			System.out.println(json3);
			
			byte[] fromJson3 = jsonb.fromJson(json3, byte[].class);
			System.out.println(new String(fromJson3));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new Strict_IJSON_Support();
	}

}

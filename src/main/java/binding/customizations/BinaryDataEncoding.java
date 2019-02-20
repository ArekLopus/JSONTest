package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.BinaryDataStrategy;

//	Binary Encoding
//-JSON-B supports mapping of binary data. By default it uses BYTE encoding.
//-It can be easily customized using BinaryDataStrategy class which provides support for the most common binary data encodings:
// • BYTE
// • BASE_64
// • BASE_64_URL

public class BinaryDataEncoding {

	public BinaryDataEncoding() {
		
		byte[] bytes = "Abracadabra-ęóąśłżń".getBytes();
		
		Jsonb jsonb = JsonbBuilder.create();			//default - BYTE encoding
		
		String json = jsonb.toJson(bytes);
		System.out.println(json);
		
		byte[] fromJson = jsonb.fromJson(json, byte[].class);
		System.out.println(new String(fromJson));
		
		
		JsonbConfig config = new JsonbConfig()
			    .withBinaryDataStrategy(BinaryDataStrategy.BASE_64);
		jsonb = JsonbBuilder.create(config);
		
		String json2 = jsonb.toJson(bytes);
		System.out.println(json2);
		
		byte[] fromJson2 = jsonb.fromJson(json2, byte[].class);
		System.out.println(new String(fromJson2));
		
		
		config = new JsonbConfig()
			    .withBinaryDataStrategy(BinaryDataStrategy.BASE_64_URL);
		jsonb = JsonbBuilder.create(config);
		
		String json3 = jsonb.toJson(bytes);
		System.out.println(json3);
		
		byte[] fromJson3 = jsonb.fromJson(json3, byte[].class);
		System.out.println(new String(fromJson3));
		
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new BinaryDataEncoding();
	}

}

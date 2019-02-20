package binding.customizations;

import java.io.IOException;
import java.io.StringWriter;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.JsonbException;

import binding.helper.User;

//https://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html

public class CharacterEncodings {

	public CharacterEncodings() throws JsonbException, IOException {
		
		StringWriter sw = new StringWriter();
		
		JsonbConfig config = new JsonbConfig()
			.withFormatting(true)
		    .withEncoding("Cp1250");
		Jsonb jsonb = JsonbBuilder.create(config);
		
		jsonb.toJson(new User("Głąbek", "Bżączyśkewić"), sw);
		System.out.println(sw);
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) throws JsonbException, IOException {
		new CharacterEncodings();
	}

}

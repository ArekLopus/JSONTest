package binding.customizations;

import java.io.IOException;
import java.util.Locale;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.JsonbException;

import binding.helper.UserLocale;

//https://www.oracle.com/technetwork/java/javase/java8locales-2095355.html
//http://www.oracle.com/us/technologies/java/locale-140624.html

public class Locales {
	
	public Locales() throws JsonbException, IOException {
		
		JsonbConfig config = new JsonbConfig()
		    .withLocale(new Locale("pl_PL"));
		Jsonb jsonb = JsonbBuilder.create(config);
		
		String json = jsonb.toJson(UserLocale.DEFAULT_USER);
		System.out.println(json);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) throws JsonbException, IOException {
		new Locales();
	}

}

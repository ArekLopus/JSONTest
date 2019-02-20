package api_streaming;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class JsonStreamParserGetEmail {
	
	public JsonStreamParserGetEmail() throws FileNotFoundException {
		
		JsonParser parser = Json.createParser(new FileReader("JsonGenerator.json"));
		
		String email = null;
		JsonParser.Event event = null;
		
		while (parser.hasNext()) {
			event = parser.next();
				
			if(event.equals(JsonParser.Event.KEY_NAME) && parser.getString().equals("email") ) {
				parser.next();
				email = parser.getString();
			}
		}
		System.out.println("Email: " + email);
	}
	
	
	public static void main(String[] args) throws Exception {
		new JsonStreamParserGetEmail();
	}
}

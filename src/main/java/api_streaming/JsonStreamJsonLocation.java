package api_streaming;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;

//-Provides the location information of a JSON event in an input source.
//-The JsonLocation information can be used to identify incorrect JSON
// or can be used by higher frameworks to know about the processing location.
//-All the information provided by a JsonLocation is optional. For example, a provider may only report line numbers.
// Also, there may not be any location information for an input source. For example, if a JsonParser is created
// using JsonArray input source, all the methods in this class return -1.

public class JsonStreamJsonLocation {
	
	public JsonStreamJsonLocation() throws FileNotFoundException {
		
		JsonParser parser = Json.createParser(new FileReader("JsonGenerator.json"));
		JsonParser parser2 = Json.createParser(new FileReader("JsonGenerator.json"));
		
		String email = null;
		JsonParser.Event event = null;
		
		parser2.next();
		System.out.println(parser2.getObject());
		
		while (parser.hasNext()) {
			event = parser.next();
			
			if(event.equals(JsonParser.Event.KEY_NAME) && parser.getString().equals("email") ) {
				parser.next();
				email = parser.getString();
				
				JsonLocation location = parser.getLocation();
				System.out.println("Location: " + location);
				
			}
		}
		System.out.println("Email: " + email);
	}
	
	
	public static void main(String[] args) throws Exception {
		new JsonStreamJsonLocation();
	}
}

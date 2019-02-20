package api_streaming;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class JsonStreamParserTest {
	
	public JsonStreamParserTest() throws FileNotFoundException {
		
		JsonParser parser = Json.createParser(new FileReader("JsonGenerator.json"));
		
		while (parser.hasNext()) {
		   JsonParser.Event event = parser.next();
		   switch(event) {
		      case START_ARRAY:
		      case END_ARRAY:
		      case START_OBJECT:
		      case END_OBJECT:
		      case VALUE_FALSE:
		      case VALUE_NULL:
		      case VALUE_TRUE:
		         System.out.println(event.toString());
		         break;
		      case KEY_NAME:
		         System.out.print(event.toString() + " " + parser.getString() + " - ");
		         break;
		      case VALUE_STRING:
		      case VALUE_NUMBER:
		         System.out.println(event.toString() + " " + parser.getString());
		         break;
		   }
		}		
	}
	
	
	public static void main(String[] args) throws Exception {
		new JsonStreamParserTest();
	}
}

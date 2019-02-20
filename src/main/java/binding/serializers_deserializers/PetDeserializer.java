package binding.serializers_deserializers;

import java.lang.reflect.Type;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

//KEY_NAME  START_OBJECT  KEY_NAME  VALUE_NUMBER  KEY_NAME  VALUE_TRUE  KEY_NAME  VALUE_STRING  KEY_NAME  VALUE_TRUE  END_OBJECT  END_OBJECT

//	deserialize()
//-Deserialize JSON stream into instance of provided class using javax.json.stream.JsonParser.
//-JsonParser cursor have to be at KEY_NAME before START_OBJECT / START_ARRAY, or at START_OBJECT / START_ARRAY to call this method.
//-After deserialization is complete JsonParser will be at END_OBJECT / END_ARRAY for deserialized JSON structure. 

//-If method is called for the same type, which is deserializer bound to, deserializer recursion is suppressed.
// Otherwise deserializers are reentrant during deserialization process started by this method

//Deserializer DOESNT WORK! 
public class PetDeserializer implements JsonbDeserializer<Pet> {

	@Override
	public Pet deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Type type) {
	    
		Pet pet = null;
	
	    while (jsonParser.hasNext()) {
	    	
	    	JsonParser.Event event = jsonParser.next();
	        
	    	if (event == JsonParser.Event.KEY_NAME) {
	            String className = jsonParser.getString();
	            jsonParser.next();
	            try {
	                pet = deserializationContext.deserialize(Class.forName(className).asSubclass(Pet.class), jsonParser);
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            }
	        }
	    	
	    }
	    return pet;
	}
	
}



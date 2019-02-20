package binding.serializers_deserializers;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class PetSerializer implements JsonbSerializer<Pet> {
    
	public void serialize(Pet pet, JsonGenerator jsonGenerator, SerializationContext serializationContext) {
        
		if (pet != null) {
            jsonGenerator.writeStartObject();
            serializationContext.serialize(pet.getClass().getName(), pet, jsonGenerator);
            jsonGenerator.writeEnd();
        } else {
            serializationContext.serialize(null, jsonGenerator);
        }
		
    }
}
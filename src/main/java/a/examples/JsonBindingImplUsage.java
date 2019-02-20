package a.examples;

import java.io.StringReader;
import java.lang.reflect.Type;

import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonParser;

import org.eclipse.yasson.internal.JsonBindingBuilder;
import org.eclipse.yasson.internal.JsonbContext;
import org.eclipse.yasson.internal.JsonbRiParser;
import org.eclipse.yasson.internal.Unmarshaller;

import binding.helper.User;

//JsonBinding implemetation - org.eclipse.yasson.internal.JsonBinding
public class JsonBindingImplUsage {

	private final JsonbContext jsonbContext;

	public JsonBindingImplUsage() {
		
		JsonBindingBuilder builder = (JsonBindingBuilder) JsonbBuilder.newBuilder();
		Jsonb jsonb = builder.build();
		System.out.println(jsonb.getClass());
		
        this.jsonbContext = new JsonbContext(builder.getConfig(), builder.getProvider().orElseGet(JsonProvider::provider));
		
        
		User u = User.DEFAULT_USER;
		JsonObject json = u.toJson();
				
		JsonParser parser = new JsonbRiParser(jsonbContext.getJsonProvider().createParser(new StringReader(json.toString())));
		Unmarshaller unmarshaller = new Unmarshaller(jsonbContext);
		User deserialized = deserialize(User.class, parser, unmarshaller);
		
		System.out.println(deserialized);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new JsonBindingImplUsage();
	}
	
	private <T> T deserialize(final Type type, final JsonParser parser, final Unmarshaller unmarshaller) {
        return unmarshaller.deserialize(type, parser);
    }
	
//	public <T> T fromJson(String str, Class<T> type) throws JsonbException {
//        final JsonParser parser = new JsonbRiParser(jsonbContext.getJsonProvider().createParser(new StringReader(str)));
//        final Unmarshaller unmarshaller = new Unmarshaller(jsonbContext);
//        return deserialize(type, parser, unmarshaller);
//    }
	
}

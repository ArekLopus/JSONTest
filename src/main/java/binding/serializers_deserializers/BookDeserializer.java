package binding.serializers_deserializers;

import java.lang.reflect.Type;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

public class BookDeserializer implements JsonbDeserializer<Book> {

	@Override
	public Book deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		
		Book book = new Book();
		String fn = "", ln = "";
		
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next();
			if (event == JsonParser.Event.KEY_NAME) {

				String keyName = parser.getString();
				if (keyName.equals("id")) {
					book.setId(ctx.deserialize(String.class, parser));
				} else if (keyName.equals("title")) {
					book.setTitle(ctx.deserialize(String.class, parser));
				} else if (keyName.equals("firstName")) {
					fn = (ctx.deserialize(String.class, parser));
				} else if (keyName.equals("lastName")) {
					ln = (ctx.deserialize(String.class, parser));
				}
				
			}
		}
		book.setAuthor(fn + " " + ln); 
		return book;
	}
}
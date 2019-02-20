package binding.serializers_deserializers;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class BookSerializer implements JsonbSerializer<Book> {

	@Override
	public void serialize(Book book, JsonGenerator generator, SerializationContext serializationContext) {
		
//		if (book != null) {
//            serializationContext.serialize(book.getClass().getName(), book, generator);
//        } else {
//            serializationContext.serialize(null, generator);
//        }
		
		generator.writeStartObject();
			//generator.write("id", "QWE‑123‑RTS");
			generator.write("id", book.getId());
			generator.write("title", book.getTitle());
			generator.write("firstName", book.getAuthor().split(" ")[0]);
			generator.write("lastName", book.getAuthor().split(" ")[1]);
		generator.writeEnd();
	}
}
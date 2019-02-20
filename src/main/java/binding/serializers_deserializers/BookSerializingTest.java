package binding.serializers_deserializers;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

//	

public class BookSerializingTest {

	public BookSerializingTest() {
		
		JsonbConfig config = new JsonbConfig()
			.withDeserializers(new BookDeserializer())
			.withSerializers(new BookSerializer());
		
		Jsonb jsonb = JsonbBuilder.create(config);
		
		Book book = new Book("123", "Return To Reality", "John Downson");
		
		String json = jsonb.toJson(book, Book.class);
		System.out.println(json);
		
		
		Book fromJson = jsonb.fromJson(json, Book.class);
		System.out.println(fromJson);
		
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new BookSerializingTest();
	}

}

package streams;

import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

//-array.stream() -> returns JsonValues -> Stream<JsonValue> values = ja.stream();
//		array.stream().filter(x -> "F".equals(x.asJsonObject().getString("gender")))
//		The method getString(String) is undefined for the type JsonValue

//-You need to get an array as a list of objects here:
//		ja.getValuesAs(JsonObject.class).stream().filter(x -> "MF".equals(x.getString("gender")))
// or convert each element to an object (x.asJsonObject())
//		ja.stream().filter(x -> "M".equals(x.asJsonObject().getString("gender")))


//JsonArray.getValuesAs(Class) - returns a list view of the specified type for the array.

public class StreamReturnsJsonValues {

	public StreamReturnsJsonValues() {
		
		JsonArray ja = null;
		
		try(JsonReader reader = Json.createReader(getClass().getResourceAsStream("/people.json"))) {
			ja = reader.readArray();
		} catch (Exception e) {
			ja = Json.createArrayBuilder().add("There was an error").add(""+e.getMessage()).build();
		}
		
		System.out.println(ja);
		
		
		Stream<JsonObject> objects = ja.getValuesAs(JsonObject.class).stream();
		Stream<JsonValue> values = ja.stream();
		
		objects.filter(x -> "M".equals(x.getString("gender"))).forEach(System.out::println);
		values.filter(x -> "M".equals(x.asJsonObject().getString("gender"))).forEach(System.out::println);		
		
	}

	public static void main(String[] args) {
		new StreamReturnsJsonValues();
	}
}

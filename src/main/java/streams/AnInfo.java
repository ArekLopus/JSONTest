package streams;

//-JsonArray extends List<JsonValue> so it can use stream()
//-JsonObject extends Map<String, JsonValue>, we can use map.entrySet() (Set<Map.Entry<X,Y>>) or map.values() and map.keySet()

//-The minimum requirement for Java EE 8 is going to be Java 8.
//-Since a JsonObject is a Map and JsonArray is a list,
// JSON-Processing API takes advantage of Java’s stream operations using Lambda expressions.

//-The only element that has been developed is a Collector that returns JsonArray or JsonObject instead of List or Map.

public class AnInfo {}
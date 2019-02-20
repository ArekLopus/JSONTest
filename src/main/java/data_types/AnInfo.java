package data_types;

//-JsonArray is represented as a List.
//-JsonObject is represented as a Map.

//-The object model API consists of 13 interfaces, one class, one enum class and one exception, packaged in javax.json.
//-JsonArrayBuilder and JsonObjectBuilder to build JSON arrays and JSON objects respectively from scratch; JsonArray to access the ordered values of a JSON array as a list and JsonObject to access the values of a JSON object as a Map 
//-JsonBuilderFactory to create JsonObjectBuilder or JsonArrayBuilder instances.
//-JsonReader to read JSON from an input source and JsonReaderFactory to create JsonReader instances.
//-JsonWriter to write JSON to an output source, and JsonWriterFactory to create JsonWriter instances.


//Interface				Description
//JsonReader			-Reads a JSON object or an array structure from an input source.
//JsonReaderFactory		-Factory to create JsonReader instances.
//JsonWriter			-Writes a JSON object or array structure to an output source.
//JsonWriterFactory		-Factory to create JsonWriter instances.

//JsonBuilderFactory	-Factory to create JsonObjectBuilder and JsonArrayBuilder instances.
//JsonArrayBuilder		-A builder for creating JsonArray models from scratch, and for modifying a existing JsonArray.
//JsonObjectBuilder		-A builder for creating JsonObject models from scratch.

//JsonStructure			-Super type for the two structured types in JSON (objects and arrays).
//JsonObject			-JsonObject class represents an immutable JSON object value
//		 				 (an unordered collection of zero or more name/value pairs).
//JsonArray				-JsonArray represents an immutable JSON array (an ordered sequence of zero or more values).
//JsonString			-An immutable JSON string value.
//JsonNumber			-An immutable JSON number value.
//JsonValue				-JsonValue represents an immutable JSON value.


//Class					Description
//Json					-Factory class for creating JSON processing objects.


//Enum					Description
//JsonValue.ValueType	-Indicates the type of a JsonValue object.


public class AnInfo {}

package api_object_model;

//		The Object Model API
//-The object model API is for JSON as DOM API is for XML. This means that it represents a JSON document
// as a tree structure in memory before giving the possibility to navigate in or query the document. 
//-This API provides the most flexible way to parse a JSON document by giving a random access to any data it contains.
//-But in return, it requires more memory. That is why it is not suitable for large documents.

//-The object model API consists of thirteen interfaces, one class, one enum class and one exception, packaged in javax.json.
//-JsonArrayBuilder and JsonObjectBuilder to build JSON arrays and JSON objects respectively from scratch;
// JsonArray to access the ordered values of a JSON array as a list and JsonObject to access the values of a JSON object as a Map 
//-JsonBuilderFactory to create JsonObjectBuilder or JsonArrayBuilder instances.
//-JsonReader to read JSON from an input source and JsonReaderFactory to create JsonReader instances.
//-JsonWriter to write JSON to an output source, and JsonWriterFactory to create JsonWriter instances.

//-The following code demonstrates how to create an object model from scratch and access data within it.
//	sonObject objModel = Json.createObjectBuilder()
//    .add("student",Json.createObjectBuilder()
//    .add("id", "854963")
//    .add("name", "Louis Poyer")
//    .add("weight", 78.6)
//    .add("contact",Json.createArrayBuilder()
//        .add(Json.createObjectBuilder()
//            .add("address","Rue 632"))
//         .add(Json.createObjectBuilder()
//            .add("phone","985-761-0")))
//    ).add("gender","M")
//    .build();
//
//	JsonObject student = objModel.getJsonObject("student");
//	String name = student.getString("name");
//	JsonArray contact = student.getJsonArray("contact");
//	String address = contact.getJsonObject(0).getString("address");
//	String phone = contact.getJsonObject(1).getString("phone"));


//-The JsonObject can also be created from an input source (InputStream or Reader) using the interface javax.json.JsonReader.
//-JsonReader provides methods to read: readArray(), readObject(), readValue(). 
//-JsonReader also provides the general read() method to read any javax.json.JsonStructure subtype (JsonObject and JsonArray).
// Using the JsonStructure.getValueType() method returns the ValueType (ARRAY, OBJECT, STRING, NUMBER, TRUE, FALSE, NULL) and then
// you can read the value. The toString() method on JsonStructure returns the JSON representation of the object model.

//-JsonObject and JsonArray can be written to an output source (OutputStream or Writer) using the class javax.json.JsonWriter. 
//-The builder method Json.createWriter() can create a JsonWriter for different outputs.

public class Info {}

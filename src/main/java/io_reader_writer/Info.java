package io_reader_writer;

//-The JsonObject can also be created from an input source (InputStream or Reader) using the interface javax.json.JsonReader.
//-JsonReader provides methods to read: readArray(), readObject(), readValue(). 
//-JsonReader also provides the general read() method to read any javax.json.JsonStructure subtype (JsonObject and JsonArray).
// Using the JsonStructure.getValueType() method returns the ValueType (ARRAY, OBJECT, STRING, NUMBER, TRUE, FALSE, NULL) and then
// you can read the value. The toString() method on JsonStructure returns the JSON representation of the object model.

//-JsonObject and JsonArray can be written to an output source (OutputStream or Writer) using the class javax.json.JsonWriter. 
//-The builder method Json.createWriter() can create a JsonWriter for different outputs.

public class Info {}
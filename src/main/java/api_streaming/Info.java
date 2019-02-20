package api_streaming;

//		The streaming API
//-It's recommended to use the streaming API to parse large JSON files because, unlike the object model API,
// it does not require loading the whole file before processing. This ensures good memory management.

//-The streaming API is for JSON as StAX API is for XML. In other words, the streaming API is an event-based JSON parsing.
//-It parses a JSON file sequentially and fires an event whenever a it encounters a new tag in the stream
// (new value String, new start of objet, end of objet, new start of an array …).

//-The streaming API consists of five interfaces, one enum class, and two exceptions, contained in the javax.json.stream package.
//-JsonParser interface contains methods for step-by-step read-only access to JSON data.
//-JsonGenerator interface, which provides methods to generate (write out) JSON step-by-step.
//-Instances of these interfaces can be created respectively with Json.createParser() / Json.createParserFactory()
// and Json.createGenerator() /  Json.createGeneratorFactory().
//-JsonParser.Event enum class  contains all events triggered by the streaming API.


//		Generating JSON
//-The JSON builder APIs allow you to build a JSON tree structure in memory. The JsonParser parses a JSON object via streaming,
// the javax.json.stream.JsonGenerator allows the writing of JSON to a stream by writing one event at a time.

//-Familiarity with object and array contexts is needed when generating JSON. 
// JSON name/value pairs can be written to an object, whereas JSON values can be written to an array.
//-While the writeStartObject() writes a JSON start object character ( { ),
// the writeStartArray() writes a JSON start array character ( [ ).
//-Each opened context must be terminated using the writeEnd().
//-After writing the end of the current context, the parent context becomes the new current context.
//-The writeStartObject() is used to start a new child object context and the writeStartArray() starts a new child array context.
// Both methods can be used only in an array context or when a context is not yet started and both can only be called
// when no context is started. A context is started when one of these methods are used.
//-write() writes a JSON name/value pair in the current object context or to write a value in current array context.
//-flush() method can be used to write any buffered output to the underlying stream.
//-close() closes the generator and frees any associated resources.


//		Parsing JSON
//-In order to perform some tasks, a JSON object must be searched to find only the content that is useful for the current task.
//-Utilizing a JSON parser can make jobs such as these easier, as a parser is able to break the object down into pieces
// so that each different name/value pair or attribute can be examined as needed to locate the desired result.

//-The Json class contains a static factory method, createParser(), that accepts a bevy of input, and returns an iterable JsonParser.
//-Table lists the different possible input types that are accepted via the createParser().
//	Input Type 		Method Call
//	InputStream 	createParser(InputStream in)
//	JsonArray 		createParser(JsonArray arr)
//	JsonObject 		createParser(JsonObject obj)
//	Reader 			createParser(Reader reader)

//-Once a JsonParser has been created, it can be made into an Iterator of Event objects.
//-Each Event correlates to a different structure within the JSON object. 
//-When the JSON object is created, a START_OBJECT event occurs, adding a name\value pair that will trigger both
// a KEY_NAME and VALUE_STRING event. These events can be utilized to obtain the desired information from a JSON object.
//-In a real-life apps, a condition would test each iteration to find a particular event, and then perform some processing.
//-Table lists the different JSON events, along with a description of when each occurs.
//	Event 		Occurrence
//	START_OBJECT 	start of an object
//	END_OBJECT 		end of an object
//	START_ARRAY 	start of an array
//	END_ARRAY 		end of an array
//	KEY_NAME 		name of a key
//	VALUE_STRING 	value of a name\value pair in String format
//	VALUE_NUMBER 	value of a name\value pair in numeric format
//	VALUE_TRUE 		value of a name\value pair in Boolean format
//	VALUE_FALSE 	value of a name\value pair in Boolean format
//	VALUE_NULL 		value of a name\value pair as NULL

//-Obtain a JSON object that you would like to parse, and then parse it using the javax.json.Json createParser utility.
//-In the following example, a JSON file is read from disk, and then parsed to determine the hierarchy of events within.
//-Each of the events is printed to the server log as the JSON is being parsed. 


public class Info {}

package pointer1_1;

//	JsonPointer
//-This interface represents an immutable implementation of a JSON Pointer as defined by RFC 6901.
//-A JSON Pointer, when applied to a target JsonValue, defines a reference location in the target.
//-An empty JSON Pointer string defines a reference to the target itself.
//-If the JSON Pointer string is non-empty, it must be a sequence of '/' prefixed tokens, and the target must be a JsonArray or JsonObject. 
//-If the target is a JsonArray, the pointer defines a reference to an array element, and the last token specifies the index.
//-If the target is a JsonObject, the pointer defines a reference to a name/value pair, and the last token specifies the name.
//-The getValue() returns the referenced value. Methods add(), replace(), and remove() execute operations specified in RFC 6902.
// JsonArray, JsonObjects are immutable - operations add, replace, remove are creating new objects.


//-Apart from modifying existing code, JSON-Processing API 1.1 also adds an implementation of JSON Pointer (RFC 6901).
//-JSON Pointer defines a string syntax for identifying a specific value inside a JSON document.
//-It is important to notice that a JSON Pointer expression must be an absolute path or an exception is thrown.
//-Given document:
//{
//"author":  {
//  "name":"Duke"
// }
//}
//-If you want to point to name field, you should use next syntax:
//		/author/name
//-In case of arrays, you can use an integer to point to an element of the array and it is 0 based. For example:
//		/books/0

//-To get a JSON Pointer in JSON-Processing API, you need to use the new JsonPointer class:
//	JsonStructure author = reader.read();
//	JsonPointer p = new JsonPointer("/author/name");
//	JsonValue name = p.getValue(author);

//-JSON-Processing API 1.1 also offers some operations that are not described in RFC but might prove useful too.
// These operations are conceived to apply modifications to the elements pointed by the expression:
//	add(JsonStructure, JsonValue)
//	replace(JsonStructure, JsonValue)
//	remove(JsonStructure)
//-For example, to change the author of previous JSON document you could do:
//	JsonStructure author = reader.read();
//	 
//	JsonPointer p = new JsonPointer("/author/name");
//	JsonStructure newAuthor = p.replace(author, Json.createValue(“NewDuke“));
//And in the same way for adding and removing operations.

public class AnInfo {}

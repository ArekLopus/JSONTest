package patch1_1;

import org.glassfish.json.JsonMergePatchImpl;
import org.glassfish.json.JsonPatchImpl;

//-JSON Patch is a RFC specification that standardise the update operation.
//-JSON Patch is a JSON document that contains a sequence of modifications, which they are executed all of them or none of them.
//-It has an HTTP Method which is PATCH and application/json-patch+json media type is used to identify such documents.
//-The sequence of modifications that JSON Patch support are test, remove, add, replace, move and copy.

//-A JSON Patch document is composed by an array.
// op field is used to set the operation to apply.
// path is a JSON Pointer expression that points to the element which must receive the operation,
// and in the case of adding or replacing, you need to set the value you want to set.
//	[
//	   {"op":"replace", "path":"/brewery/key", “value”:"GBrewery"},
//	   {"op":"remove", "path": "/title"}
//	]


//-JSON Patch expresses a sequence of operations to apply against a target JSON document.
//-The operations are formatted in JSON-Pointer notation and can perform: add, copy, move, remove, replace and test operations.

//-The JsonPatchBuilder interface is the gateway into this API and is created from the static method Json.createPatchBuilder().
//-A JSON Pointer expression is passed to one of the operation methods and applied to a JSON document.

public class AnInfo {
	JsonMergePatchImpl a;	//diff impl
	JsonPatchImpl b;		//diffObject, diffArray
}
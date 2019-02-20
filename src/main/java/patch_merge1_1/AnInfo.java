package patch_merge1_1;

import org.glassfish.json.JsonMergePatchImpl;
import org.glassfish.json.JsonPatchImpl;

//	JSON Merge Patch
//-Differences between two structures do add, replace, or remove values.

//	https://erosb.github.io/post/json-patch-vs-merge-patch/
//-Arrays cannot be manipulated by merge patches. 
//-If you want to add an element to an array, or mutate any of its elements then you have to include the entire array
// in the merge patch document, even if the actually changed parts is minimal.

//	Json.createMergeDiff(JsonValue source, JsonValue target)
//-1st parameter is what we have. 2nd is what we want to achive, result is the difference


//Resulting values of the combination of target and patch
//	TARGET						PATCH								MERGE RESULT
//	{"a":"b"}					{"a":"c"}							{"a":"c"}
//	{"a":"b"}					{"b":"c"}							{"a":"b" , "b":"c"}
//	{"a":"b"}					{"a":null}							{}
//	{"a":"b" , "b":"c"}			{"a":null}							{"b":"c"}
//	{"a":["b"]}					{"a":"c"}							{"a":"c"}
//	{"a":"c"}					{"a":["b"]}							{"a":["b"]}
//	{"a": {"b": "c"}}			{"a": { "b": "d" , "c": null} }		{"a": { "b": "d"} }
//	{"a": [{"b":"c"}] }			{"a": [1]}							{"a": [1]}



public class AnInfo {
	JsonMergePatchImpl a;	//diff impl
	JsonPatchImpl b;		//diffObject, diffArray
}

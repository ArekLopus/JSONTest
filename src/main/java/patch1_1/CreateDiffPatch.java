package patch1_1;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPatch;

//-JSON-Processing API 1.1 implements one extra operation which is not specified in the RFC.
// This operation is calculates the difference between two JSON documents.
//-You can understand as the reverse operation of JSON Patch. 
//-Given two JSON documents it returns the JSON Patch document that should be applied to go from document A to document B.
//-For example:
//	JsonPatch diff = Json.createDiff(beer, newBeer2);
//Returns a JSON Path document:
//	[
//	  {"op":"replace", "path":"/brewery/key", “value”:"GBrewery"},
//	  {"op":"remove", "path": "/title"}
//	]

//-1st parameter is what we have. 2nd is what we want to achive, result is the difference

public class CreateDiffPatch {
	
	public CreateDiffPatch() {
		
		JsonArray langs5 = Json.createArrayBuilder().add("Java").add("JavaScript").add("C++").add("Scala").add("Python").build();
		JsonArray langs2 = Json.createArrayBuilder().add("Java").add("JavaScript").build();
		
		JsonPatch createDiff = Json.createDiff(langs2,  langs5);
		System.out.println("Adding:\t\t" + createDiff);
		
		JsonPatch createDiff2 = Json.createDiff(langs5,  langs2);
		System.out.println("Removing:\t" + createDiff2);
		
	}
	
	
	public static void main(String[] args) {
		new CreateDiffPatch();
	}
}

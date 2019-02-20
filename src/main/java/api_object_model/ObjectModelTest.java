package api_object_model;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;

public class ObjectModelTest {

	public ObjectModelTest() {
		
		JsonObject objModel = Json.createObjectBuilder()
			.add("student",Json.createObjectBuilder()
			    .add("id", "123456")
			    .add("name", "John Doe")
			    .add("weight", 78.6)
			    .add("contact",Json.createArrayBuilder()
			        .add(Json.createObjectBuilder()
			            .add("address","Main st 1232"))
			        .add(Json.createObjectBuilder()
			            .add("phone","555-761-320")))
			    .add("gender","M")
			 ).build();
		
		System.out.println(objModel);
		
		JsonObject student = objModel.getJsonObject("student");
		JsonArray contacts = student.getJsonArray("contact");
		String address = contacts.getJsonObject(0).getString("address");
		String phone = contacts.getJsonObject(1).getString("phone");
		JsonString gender = student.getJsonString("gender");
		
		
		System.out.println(student);
		System.out.println(contacts);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(gender);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new ObjectModelTest();
	}

}

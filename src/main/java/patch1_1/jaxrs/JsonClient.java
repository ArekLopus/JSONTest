package patch1_1.jaxrs;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JsonClient {

	public JsonClient() {
		
		JsonArray patched = Json.createPatchBuilder().add("/0", "Zero").build().toJsonArray();
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/JSONTest/res/patch/json");
		Response resp = target
				.request()
				.build("POST", Entity.entity(patched, MediaType.APPLICATION_JSON))
				.invoke();
		
		System.out.println(resp);
		System.out.println(resp.readEntity(String.class));
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new JsonClient();
	}

}

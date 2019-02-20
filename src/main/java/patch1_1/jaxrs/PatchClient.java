package patch1_1.jaxrs;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

public class PatchClient {

	public PatchClient() {
		
		//JsonPatch patch = Json.createPatchBuilder().add("/0", "Zero").build();
		JsonArray patch = Json.createPatchBuilder().add("/0", "Zero").build().toJsonArray();
		System.out.println("Patch operation:\t" + patch);
		System.out.println("Patch class:\t\t" + patch.getClass());
		System.out.println("MediaType:\t\t" + MediaType.APPLICATION_JSON_PATCH_JSON);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/JSONTest/res/patch/array");
		Response resp = target
				.request()
				.build("PATCH", Entity.entity(patch, MediaType.APPLICATION_JSON_PATCH_JSON))
				//.build("PATCH", Entity.json(patch))
				.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true)
				.invoke();
		
		System.out.println("Response:\t\t" + resp);
		System.out.println("Entity:\t\t\t" + resp.readEntity(String.class));
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PatchClient();
	}

}

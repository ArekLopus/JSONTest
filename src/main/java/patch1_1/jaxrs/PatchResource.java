package patch1_1.jaxrs;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPatch;
import javax.ws.rs.Consumes;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("patch")
public class PatchResource {
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
	public Response updateJson(JsonPatch patch){
		return Response.accepted("Got Json Patch: " + patch).build();
	}
	
	
	@Path("array")
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
	public Response updateJsonArray(JsonArray array){
		JsonPatch patch = Json.createPatch(array);
		return Response.accepted("Got Json Patch as Array: " + patch).build();
	}
	
	
	@Path("json")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postJson(JsonArray patch){
		return Response.accepted("Got Json array: " + patch).build();
	}
}

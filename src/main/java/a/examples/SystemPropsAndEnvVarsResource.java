package a.examples;

import static javax.json.Json.createValue;

import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("props")
public class SystemPropsAndEnvVarsResource {

	@GET
	@Path("system")
	public JsonObject systemProperties() {

		Properties properties = System.getProperties();
		Map<String, JsonValue> map = properties
				.entrySet()
				.stream()
				.collect(Collectors.toMap(k -> k.toString(), v -> createValue(v.getValue().toString())));
		return map.entrySet().stream().collect(JsonCollectors.toJsonObject());
	}

	@GET
	@Path("/env")
	public JsonObject environmentVariables() {
		
		Map<String, JsonValue> environment = System.getenv()
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, v -> createValue(v.getValue())));
		
		return environment.entrySet().stream().collect(JsonCollectors.toJsonObject());
	}

}
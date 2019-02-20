package a.examples;

import static javax.json.Json.createValue;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonCollectors;
import javax.json.stream.JsonGenerator;

//-JsonObject extends Map<String, JsonValue>
//-First we need to convert map to JsonObject-like map

public class SystemPropsAndEnvVars {
	
	public SystemPropsAndEnvVars() {
		
		prettyPrint(systemProperties());
		//prettyPrint(environmentVariables());
	}
	
	public static void main(String[] args) {
		new SystemPropsAndEnvVars();
	}
	
	
	private void prettyPrint(JsonStructure str) {
		StringWriter sw = new StringWriter();
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);	// Pretty printing feature is added.
		
		try (JsonWriter writer = Json.createWriterFactory(config).createWriter(sw)) {
		   writer.write(str);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		
		System.out.println(sw.toString());
	}
	
	
	public JsonObject systemProperties() {

		Properties properties = System.getProperties();
		Map<String, JsonValue> map = properties
				.entrySet()
				.stream()
				//.filter( e -> e.getKey().toString().startsWith("java") )
				.collect(Collectors.toMap(k -> k.toString(), v -> createValue(v.getValue().toString())));
		
		return map.entrySet().stream().collect(JsonCollectors.toJsonObject());
	}
	
	
	public JsonObject environmentVariables() {
		
		Map<String, JsonValue> environment = System.getenv()
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, v -> createValue(v.getValue())));
		
		return environment.entrySet().stream().collect(JsonCollectors.toJsonObject());
	}

}
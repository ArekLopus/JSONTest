package io_reader_writer;

import java.io.StringReader;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class JsonReaderWriterString {
	
	public JsonReaderWriterString() {
		
		JsonArray ja = null;
		
		StringReader sr = new StringReader("[\"One\",\"Two\"]");
		
		try(JsonReader reader = Json.createReader(sr)) {
			ja = reader.readArray();
		} catch (Exception e) {
			ja = Json.createArrayBuilder().add("There was an error").build();
		}
		
		System.out.println("JsonArray read: " + ja);
		
		
		StringWriter sw = new StringWriter();
		try(JsonWriter writer = Json.createWriter(sw)) {
			writer.writeArray(ja);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.println("JsonArray written: " + sw.toString());
	}
	
	
	public static void main(String[] args) {
		new JsonReaderWriterString();
	}
}

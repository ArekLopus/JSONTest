package io_reader_writer;

import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class JsonReaderWriterFIle {
	
	public JsonReaderWriterFIle() {
		
		JsonArray ja = null;
		
		try(JsonReader reader = Json.createReader(getClass().getResourceAsStream("Array.json"))) {
			ja = reader.readArray();
		} catch (Exception e) {
			ja = Json.createArrayBuilder().add("There was an error").build();
		}
		
		System.out.println("Reading: " + ja);
		
		try(JsonWriter writer = Json.createWriter(new PrintWriter("ArrayWritten.json"))) {		//PROJ_NAME/ArrayWriten.json
		//try(JsonWriter writer = Json.createWriter(new PrintWriter(getClass().getResource(".").getPath()+ "ArrayWriten.json"))) {
			writer.writeArray(ja);																//./ArrayWriten.json
			//throw new RuntimeException("blah");
		} catch (Exception e) {
			//writer.writeArray(Json.createArrayBuilder().add("There was an error").build());	//Cant be used here
			ja = Json.createArrayBuilder().add("There was an error").build();
		}
		
		System.out.println("Writing: " + ja);
	}
	
	
	public static void main(String[] args) {
		new JsonReaderWriterFIle();
	}
}

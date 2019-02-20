package data_types;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;

//-A JsonValue is one of the following: an object (JsonObject), an array (JsonArray), a number (JsonNumber),
// a string (JsonString), true (JsonValue.TRUE), false (JsonValue.FALSE), or null (JsonValue.NULL).

public class JsonValueTest {
	
	public JsonValueTest() {
		
		JsonString stringVal = Json.createValue("StringVal");
		JsonNumber bigDecVal = Json.createValue(BigDecimal.ONE);
		JsonNumber bigIntVal = Json.createValue(BigInteger.TEN);
		JsonNumber longVal = Json.createValue(100L);
		JsonNumber floatVal = Json.createValue(100.0F);
		JsonNumber doubleVal = Json.createValue(100.0);
		JsonValue nullValue = JsonValue.NULL;
		JsonValue falseValue = JsonValue.FALSE;
		JsonValue trueVal = JsonValue.TRUE;
		JsonValue arrayVal = JsonValue.EMPTY_JSON_ARRAY;
		JsonValue objVal = JsonValue.EMPTY_JSON_OBJECT;
		
		System.out.println(stringVal);
		System.out.println(bigDecVal);
		System.out.println(bigIntVal);
		System.out.println(longVal);
		System.out.println(floatVal);
		System.out.println(doubleVal);
		System.out.println(nullValue);
		System.out.println(falseValue);
		System.out.println(trueVal);
		System.out.println(arrayVal);
		System.out.println(objVal);
		
		
		
		System.out.println("\nlongVal instanceof JsonValue -> "+(longVal instanceof JsonValue));
		System.out.println("longVal instanceof JsonArray -> "+(longVal instanceof JsonArray));
		System.out.println("longVal instanceof JsonObject -> "+(longVal instanceof JsonObject));
		System.out.println("longVal instanceof JsonNumber -> "+(longVal instanceof JsonNumber));
		
	}
	
	
	public static void main(String[] args) {
		new JsonValueTest();
	}
}

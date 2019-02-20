package pointer1_1;

import javax.json.Json;

//https://tools.ietf.org/html/rfc6901
//-Because the characters '~' (%x7E) and '/' (%x2F) have special meanings in JSON Pointer,
// '~' needs to be encoded as '~0' and '/' needs to be encoded as '~1' when these characters appear in a reference token.

public class DecodePointer {
	
	public DecodePointer() {
		
		System.out.println("String to encode -> 'aa/bb~cc'");
		
		String encodedPointer = Json.encodePointer("aa/bb~cc");
		System.out.println("Encoded:\t" + encodedPointer);
		
		String decodedPointer = Json.decodePointer(encodedPointer);
		System.out.println("Dencoded:\t" + decodedPointer);
		
		
	}
	
	
	public static void main(String[] args) {
		new DecodePointer();
	}
}

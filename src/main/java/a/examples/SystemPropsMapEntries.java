package a.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SystemPropsMapEntries {
	
	public SystemPropsMapEntries() {
		
		Map<String, String> m = new HashMap<>();
		m.put("one", "1");
		m.put("two", "2");
		
		Set<Entry<String, String>> entrySet = m.entrySet();
		System.out.println(entrySet);
		
		System.out.println(entrySet.iterator().next().getClass());

	}
	
	public static void main(String[] args) {
		new SystemPropsMapEntries();
	}
	
}
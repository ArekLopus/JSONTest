package binding;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

import binding.helper.User;

//fromJson(InputStream stream, Class<T> type)	//or  Type runtimeType for all methods
//fromJson(Reader reader, Class<T> type)
//fromJson(String str, Class<T> type)

//toJson(Object object)
//toJson(Object object, OutputStream stream)
//toJson(Object object, Type runtimeType)
//toJson(Object object, Type runtimeType, OutputStream stream)
//toJson(Object object, Type runtimeType, Writer writer)
//toJson(Object object, Writer writer)

public class JsonbTest {

	public JsonbTest() throws JsonbException, FileNotFoundException {
		
		Jsonb jsonb = JsonbBuilder.create();

		List<User> users = new ArrayList<>();
		users.add(new User("John", "Doe"));
		users.add(new User("Jane", "Dowson"));
		
		StringWriter sw = new StringWriter();
		
		String usersJson = jsonb.toJson(users);
		jsonb.toJson(users, sw);
		jsonb.toJson(users, new PrintWriter("d:/ccc/users1.txt"));
		jsonb.toJson(users, new FileOutputStream("d:/ccc/users2.txt"));
		
		System.out.println("String:\t\t" + usersJson);
		System.out.println("StringWriter:\t" + sw);
		
		User[] fromJson1 = jsonb.fromJson(sw.toString(), User[].class);
		List<User> fromJson2 = jsonb.fromJson(sw.toString(), new ArrayList<User>(){static final long serialVersionUID = 1L;}.getClass().getGenericSuperclass());
		User[] fromJson3 = jsonb.fromJson(new FileReader("d:/ccc/users1.txt"), User[].class);
		
		System.out.println("\nString to Array:\t" + Arrays.toString(fromJson1));
		System.out.println("String to List<User>:\t" + fromJson2);
		System.out.println("FileReader:\t\t" + Arrays.toString(fromJson3));
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) throws JsonbException, FileNotFoundException {
		new JsonbTest();
	}

}

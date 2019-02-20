package binding.adapters;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;

//	Adapters
//-In some cases it may be difficult to serialize / deserialize a class the desired way.
// Sometimes it’s not possible to put custom annotations on the source code because you don’t have access to it
// or they don’t solve the problem. In this case adapters is another option to try.

//-Adapter is a class implementing javax.json.bind.adapter.JsonbAdapter interface.
//-It has a custom code to convert the “unmappable” type (Original) into another one (Adapted)
// that is serialized/deserialized the desired way. It’s sililar how type adapters in JAXB work.

public class AdapterTest {

	public AdapterTest() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		String userDefault = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("User with default serializer:\t" + userDefault);
		
		
		JsonbConfig config = new JsonbConfig()
		    .withAdapters(new UserAdapter());
		jsonb = JsonbBuilder.create(config);
		
		String userAdapter = jsonb.toJson(User.DEFAULT_USER);
		System.out.println("User with Adapter serializer:\t" + userAdapter);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new AdapterTest();
	}

}

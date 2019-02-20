package binding.serializers_deserializers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

//

public class PetSerializingTest {

	public PetSerializingTest() {
		
		List<Carrier<Pet>> carriers = new ArrayList<>();
		carriers.add(new Carrier<>(Carrier.TYPE.BAG, new Cat("Harris", 10, true, true)));
		carriers.add(new Carrier<>(Carrier.TYPE.CRATE, new Dog("Falco", 4, false, false)));
		Type carrierListType = new ArrayList<Carrier<Pet>>() {
			private static final long serialVersionUID = 1L;
		}.getClass().getGenericSuperclass();

		JsonbConfig config = new JsonbConfig()
		        .withFormatting(true)
		        .withSerializers(new PetSerializer())
		        .withDeserializers(new PetDeserializer());

		Jsonb jsonb = JsonbBuilder.create(config);

		String json = jsonb.toJson(carriers, carrierListType);
		System.out.println(json);
		
		//Deserializer DOESNT WORK! 
		System.out.println("Deserializing: ");
		List<Carrier<Pet>> list = jsonb.fromJson(json, carrierListType);
		System.out.println("List " + list.size());
		System.out.println("List " + list);

		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PetSerializingTest();
	}

}

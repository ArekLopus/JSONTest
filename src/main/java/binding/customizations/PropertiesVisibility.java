package binding.customizations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;

import binding.helper.UserVisibility;

//	Properties Visibility

public class PropertiesVisibility {

	public PropertiesVisibility() {
		
		JsonbConfig config = new JsonbConfig()
			    .withPropertyVisibilityStrategy(noneVisible);
		Jsonb jsonb = JsonbBuilder.create(config);
		
		String jsonNoneVisible = jsonb.toJson(UserVisibility.getDefaultUser());
		System.out.println("None visible:\t\t" + jsonNoneVisible);
		
		
		config = new JsonbConfig()
			    .withPropertyVisibilityStrategy(allVisible);
		jsonb = JsonbBuilder.create(config);
		
		String jsonAllVisible = jsonb.toJson(UserVisibility.getDefaultUser());
		System.out.println("All visible:\t\t" + jsonAllVisible);
		
		
		config = new JsonbConfig()
			    .withPropertyVisibilityStrategy(privateVisible);
		jsonb = JsonbBuilder.create(config);
		
		String jsonPrivateVisible = jsonb.toJson(UserVisibility.getDefaultUser());
		System.out.println("Only private visible:\t" + jsonPrivateVisible);
		
		
		config = new JsonbConfig()
			    .withPropertyVisibilityStrategy(startsWithFirstVisible);
		jsonb = JsonbBuilder.create(config);
		
		String jsonStartsWithFirst = jsonb.toJson(UserVisibility.getDefaultUser());
		System.out.println("Starts with 'first':\t" + jsonStartsWithFirst);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new PropertiesVisibility();
	}
	
	PropertyVisibilityStrategy noneVisible = new PropertyVisibilityStrategy() {
		
		@Override
		public boolean isVisible(Method method) {
			return true;
		}
		
		@Override
		public boolean isVisible(Field field) {
			return false;
		}
	};
	
	PropertyVisibilityStrategy allVisible = new PropertyVisibilityStrategy() {
		
		@Override
		public boolean isVisible(Method method) {
			return true;
		}
		
		@Override
		public boolean isVisible(Field field) {
			return true;
		}
	};
	
	PropertyVisibilityStrategy privateVisible = new PropertyVisibilityStrategy() {
		
		@Override
		public boolean isVisible(Method method) {
			return true;
		}
		
		@Override
		public boolean isVisible(Field field) {
			return Modifier.isPrivate(field.getModifiers());
		}
	};
	
	PropertyVisibilityStrategy startsWithFirstVisible = new PropertyVisibilityStrategy() {
		
		@Override
		public boolean isVisible(Method method) {
			return true;
		}
		
		@Override
		public boolean isVisible(Field field) {
			if (field.getName().startsWith("first") == true) {
				return true;
			} else {
				return false;
			}
		}
	};
}

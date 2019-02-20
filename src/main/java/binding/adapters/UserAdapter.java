package binding.adapters;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

import binding.helper.User;

public class UserAdapter implements JsonbAdapter<User, JsonObject> {
    
	@Override
    public JsonObject adaptToJson(User u) throws Exception {
        return Json.createObjectBuilder()
            .add("name", u.getFirstName())
            .add("surname", u.getLastName())
            .build();
    }

    @Override
    public User adaptFromJson(JsonObject adapted) throws Exception {
        User u = new User();
        u.setFirstName(adapted.getString("name"));
        u.setLastName(adapted.getString("surname"));
        u.setDateOfBirth(null);
        return u;
    }
}
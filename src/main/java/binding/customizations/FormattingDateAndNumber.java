package binding.customizations;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import binding.helper.User;
import binding.helper.UserFormatDateAndNumber;

//	Formatting Date / Number 
//-By default JSON-B uses ISO formats to serialize date and number fields. Sometimes it’s required to override these settings.
//-It can be done using @JsonbDateFormat and @JsonbNumberFormat annotations on fields:
//	    @JsonbDateFormat("dd.MM.yyyy")
//	    private Date birthDate;
	
//	    @JsonbNumberFormat("#0.00")
//	    public BigDecimal salary;

//or globally using withDateFormat() of JsonbConfig class:
//	JsonbConfig config = new JsonbConfig()
//	    .withDateFormat("dd.MM.yyyy", null);
//	Jsonb jsonb = JsonbBuilder.create(config);
public class FormattingDateAndNumber {

	public FormattingDateAndNumber() {
		
		Jsonb jsonb = JsonbBuilder.create();
		
		String json = jsonb.toJson(UserFormatDateAndNumber.DEFAULT_USER);
		System.out.println(json);
		
		UserFormatDateAndNumber fromJson = jsonb.fromJson(json, UserFormatDateAndNumber.class);
		System.out.println(fromJson);
		
		
		JsonbConfig config = new JsonbConfig()
				.withDateFormat("-+= dd-MM-yyyy =+-", null);
		jsonb = JsonbBuilder.create(config);
		
		String jsonDate = jsonb.toJson(User.DEFAULT_USER);
		System.out.println(jsonDate);
		
		
		System.out.println("\n--- Done ---");
	}

	public static void main(String[] args) {
		new FormattingDateAndNumber();
	}

}

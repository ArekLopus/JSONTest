package binding;

//		Customized mapping
//-Your mappings can be customized in many different ways. You can use JSON-B annotations for compile time customizations
// and JsonbConfig class for runtime customizations.

//-The sample below shows how to create JSON-B engine with custom configuration:
//	JsonbConfig config = new JsonbConfig();	// Create custom configuration
//	Jsonb jsonb = JsonbBuilder.create(config);	// Create Jsonb with custom configuration

//	Formatted output
//	JsonbConfig config = new JsonbConfig()
//		.withFormatting(true);	// Create custom config with formatted output
//	Jsonb jsonb = JsonbBuilder.create(config);
//	String result = jsonb.toJson(pojo);

//	Changing property names
//-By default, JSON property name is the same as Java property name. A common use case is serializing properties using
// different names. This can be achieved using @JsonbProperty annotation on fields or globally using JsonbNamingStrategy.

//	@JsonbProperty annotation
//-@JsonbProperty is used to change name of one particular property. It can be placed
// • on field - will affect serialization and deserialization
// • on getter - will affect serialization only
// • on setter - will affect deserialization only
//	    @JsonbProperty("person-name")
//	    private String name;

//	Naming Strategies
//-Naming strategy is used to change a default way of constructing property names.
//-IDENTITY strategy is the default one.
//-Supported naming strategies are:
// • IDENTITY (myMixedCaseProperty)
// • LOWER_CASE_WITH_DASHES (my-mixed-case-property)
// • LOWER_CASE_WITH_UNDERSCORES (my_mixed_case_property)
// • UPPER_CAMEL_CASE (MyMixedCaseProperty)
// • UPPER_CAMEL_CASE_WITH_SPACES (My Mixed Case Property)
// • CASE_INSENSITIVE (mYmIxEdCaSePrOpErTy)
// • Or your custom implementation of JsonbNamingStrategy interface
//-It can be applied using with withPropertyNamingStrategy() of JsonbConfig class:
//	JsonbConfig config = new JsonbConfig()
//	    .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
//	Jsonb jsonb = JsonbBuilder.create(config);

//	Properties order
//-To customize the order of serialized properties, JSON Binding provides PropertyOrderStrategy class.
//-Default order strategy is LEXICOGRAPHICAL.
//-The supported strategies are:
// • LEXICOGRAPHICAL (A-Z)
// • ANY (order is undefined, in the most cases it will an order in which properties appear in the class)
// • REVERSE (Z-A)
//-Order strategy can be applied globally using withPropertyOrderStrategy() of JsonbConfig class:
//	JsonbConfig config = new JsonbConfig()
//	    .withPropertyOrderStrategy(PropertyOrderStrategy.ANY);
//	Jsonb jsonb = JsonbBuilder.create(config);
// or using @JsonbPropertyOrder annotation on class:
//	@JsonbPropertyOrder(PropertyOrderStrategy.ANY)
//	public class Person {}

//	Ignoring properties (@JsonbTransient)
//-Class properties annotated with @JsonbTransient are ignored by JSON Binding engine. 
//-The behavior is different depending on where @JsonbTransient annotation is placed.
// • On field - Property is ignored during serialization and deserialization.
// • On getter - Property is ignored during serialization only.
// • On setter - Property is ignored during deserialization only.

//	Null handling
//-By default JSON-B doesn’t serialize fields with null values. This may be a not desired behaviour.
//-There are three different ways to change default null handling.
//-On a class or package level using @JsonbNillable annotation
//	@JsonbNillable
//	public class Person {}
//-On individual properties using @JsonbProperty(nillable=true):
//	public class Person {
//	    @JsonbProperty(nillable=true)
//	    private String name;
//	}
//-Globally using withNullValues() of JsonbConfig class
//	JsonbConfig nillableConfig = new JsonbConfig()
//	    .withNullValues(true);
//	Jsonb jsonb = JsonbBuilder.create(nillableConfig);

//	Custom Constructor instantiation
//-By default, public default no-arg constructor is required for deserialization. In many scenarios this requirement is too strict. 
//-@JsonbCreator can be used to annotate a custom constructor with parameters or a static factory method used to create a class instance.
//-@JsonbProperty on the constructor parameter is required for proper parameter substitution.
//-The sample below shows how @JsonbCreator annotation can be used on a custom constructor.
//	public class Person {
//	    @JsonbCreator
//	    public Person(@JsonbProperty("name") String name) {
//	        this.name = name;
//	    }
//	}

//	Date / Number Formats
//-By default JSON-B uses ISO formats to serialize date and number fields. Sometimes it’s required to override these settings.
//-It can be done using @JsonbDateFormat and @JsonbNumberFormat annotations on fields:
//	    @JsonbDateFormat("dd.MM.yyyy")
//	    private Date birthDate;
	
//	    @JsonbNumberFormat("#0.00")
//	    public BigDecimal salary;
// or globally using withDateFormat() of JsonbConfig class:
//	JsonbConfig config = new JsonbConfig()	// Create custom configuration
//	    .withDateFormat("dd.MM.yyyy", null);
//	Jsonb jsonb = JsonbBuilder.create(config);	// Create Jsonb with custom configuration

//Binary Encoding
//-JSON-B supports mapping of binary data. By default it uses BYTE encoding.
//-It can be easily customized using BinaryDataStrategy class which provides support for the most common binary data encodings:
// • BYTE
// • BASE_64
// • BASE_64_URL
//-The sample below shows a creation of Jsonb engine with BASE_64_URL encoding:
//	JsonbConfig config = new JsonbConfig()
//	    .withBinaryDataStrategy(BinaryDataStrategy.BASE_64);
//	Jsonb jsonb = JsonbBuilder.create(config);	// Create Jsonb with custom configuration
//	byte[] bytes = "Abracadabra".getBytes();
//	String json = jsonb.toJson(bytes);		//"QWJyYWNhZGFicmE=" -> BASE_64
											//[65,98,114,97,99,97,100,97,98,114,97] -> BYTE
//	Customizing character encoding
//-The binding operations will use the encoding type specified by this property for encoding JSON data. Listing shows an example.
//	JsonbConfig jsonbConfig = new JsonbConfig().withEncoding("UTF-32");
//-Valid character encoding are defined in RFC 7159 Section 8.

//	Customizing a default locale
//-The locale can be set as shown in Listing.
//	JsonbConfig jsonbConfig = new JsonbConfig()
//	  .withLocale(Locale.CANADA);


//	Customizing field visibility
//-By default, only public fields and getter/setter methods are used for serialization and deserialization,
// but you may customize access to be more or less restrictive.
//-Field visibility strategy is defined in a custom implementation of the PropertyVisibilityStrategy interface,
// where two overloaded methods—isVisible(Field) and isVisibile(Method)—control access to the respective field or method values.
//-Listing shows an example implementation.
//	PropertyVisibilityStrategy vis = new PropertyVisibilityStrategy() {
//	  @Override
//	  public boolean isVisible(Field field) {
//	      return Modifier.isProtected(field.getModifiers());
//	  }
//
//	  @Override
//	  public boolean isVisible(Method method) {
//	      return !method.getName().contains("AlternativeTitle");
//	  }
//	};

//	Adapters
//-In some cases it may be difficult to serialize/deserialize a class the desired way. Sometimes it’s not possible to put
// custom annotations on the source code because you don’t have access to it or they don’t solve the problem.
// In this case adapters is another option to try.
//-Adapter is a class implementing javax.json.bind.adapter.JsonbAdapter interface.
// It has a custom code to convert the “unmappable” type (Original) into another one (Adapted) that is serialized/deserialized
// the desired way. It’s sililar how type adapters in JAXB work.
//	public class CustomerAdapter implements JsonbAdapter<Customer, JsonObject> {
//	    @Override
//	    public JsonObject adaptToJson(Customer c) throws Exception {
//	        return Json.createObjectBuilder()
//	           .add("id", c.getId())
//	           .add("name", c.getName())
//	           .build();
//	    }
//
//	    @Override
//	    public Customer adaptFromJson(JsonObject adapted) throws Exception {
//	        Customer c = new Customer();
//	        c.setId(adapted.getInt("id"));
//	        c.setName(adapted.getString("name"));
//	        return c;
//	    }
//	}

//	Serializers/Deserializers
//-Sometimes adapters mechanism is not enough and low level access to JSONP parser/generator is needed.
//-From the spec:
// • Serializer is a class implementing javax.json.bind.serializers.JsonbSerializer interface. It is used to serialize the type
//   it’s registered on (Original). On serializing of Original type JSONB calls JsonbSerializer::serialize method.
//   This method has to contain a custom code to serialize Original type using provided JsonpGenerator.
// • Deserializer is a class implementing javax.json.bind.serializers.JsonbDeserializer interface. It is used to deserialize
//   the type it’s registered on (Original). On deserialization of Original type JSONB calls JsonbDeserializer::deserialize().
//   This method has to contain a custom code to deserialize Original type using provided JsonpParser.

//	Strict I-JSON support
//-I-JSON (”Internet JSON”) is a restricted profile of JSON. JSON-B fully supports I-JSON by default with three exceptions:
// • JSON Binding does not restrict the serialization of top-level JSON texts that are neither objects nor arrays.
//   The restriction should happen at application level.
// • JSON Binding does not serialize binary data with base64url encoding.
// • JSON Binding does not enforce additional restrictions on dates/times/duration.
//-Full support mode can be switched on like it’s shown below:
//	JsonbConfig config = new JsonbConfig()
//	    .withStrictIJSON(true);
//	Jsonb jsonb = JsonbBuilder.create(config);

public class AnInfo_Customization {}

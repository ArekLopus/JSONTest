package binding;

//		JSON Binding
//-JSON-B gives an API to marshall and unmarshal Java objects to/from JSON.
//-It comes from the best practices of existing JSON binders like Gson, Jackson or Johnzon.
//-It makes heavy use of annotations to mark classes and fields with mapping semantics
// and provides the extensibility that is so often needed when dealing with complex data structures.

//-Out of the box, it provides default mappings for serialization and deserialization that meet reasonable expectations.
// The default customizations are overridable with two customization methodologies:
//	 • compile time annotations and
//	 • a runtime configuration builder.
//-For advanced customizations, the API provides adapters and serializers/deserializers
// for times when the runtime builder and mapping annotations are not sufficient.

//-The JSON-B API provides two entry point interfaces: Jsonb and JsonbBuilder. 
//-The Jsonb interface provides the serialization and deserialization functionality via the methods toJson() and fromJson()
//-The JsonbBuilder interface provides the client an access point to a Jsonb instance.
// It builds the instance based on a set of optional configs.

//	Annotation Method
//-Using the annotations, it’s possible to customize the default behavior by annotating fields, JavaBean methods, and classes.
//	@JsonbNillable
//	@JsonbPropertyOrder(PropertyOrderStrategy.REVERSE)
//	public class Book {
//	    @JsonbProperty("cost")
//	    @JsonbNumberFormat("#0.00")
//	    private Float price;
//	}
//-You could specify the number format with the @JsonbNumberFormat and change the name of a field with the @JsonbProperty.

//	Runtime Configuration
//-Alternatively, you could choose to handle customization with the runtime configuration builder, by configuration an instance
// of JsonbConfig and passing it to the create method of the Jsonb builder, as shown in this code snippet.
//	JsonbConfig jsonbConfig = new JsonbConfig()
//	    .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES)
//	    .withNullValues(true)
//	    .withFormatting(true);
//	Jsonb jsonb = JsonbBuilder.create(jsonbConfig);


//	JSON-B’s default settings
//-For convenience, a Jsonb instance comes pre-configured with defaults reflecting accepted standards.

//-Below is an overview of JSON-B’s default strategies and mappings. 
// • Property naming strategy determines how a class’s field will be represented in serialized JSON. 
//   By default, a JSON property name takes on the exact same name as the field in the class that it serializes.
// • Property visibility strategy determines how fields are accessed and the importance given to access modifiers on fields
//   and bean methods. During both serialization and deserialization, JSON-B’s default behavior is to access only public fields
//   and public accessor and mutator methods. If no public method or fields exist, the property is ignored.
// • Property order strategy specifies the order in which properties appear in output JSON. JSON-B’s default order is lexicographic.
// • Binary data strategy encodes binary data, using a byte array by default.
// • Null value strategy specifies that object fields with a null value are ignored and null values in collections are preserved.
//   Null values in JSON properties set the corresponding object field value as null.

//-Three additional defaults are important to know about:
// • JSON-B respects the I-JSON profile, with three exceptions: JSON-B does not restrict the serialization of top-level JSON to
//   non-object or array text; it does not serialize binary data with  base64url encoding; and it does not enforce additional
//   restrictions on time-based props. It is also possible to switch-on strict compliance with I-JSON via a customization option.
// • JSON-B’s date format and locale setting will depend on your machine setting.
// • JSON data is presented without line feeds or indentations, and is encoded using UTF-8.


//	Type handling with JSON-B
//-The Java API for JSON Binding is RFC 7159-compatible for serialization and deserialization and supports all Java types
// and primitives. We’ll explore and use many of the following principles and techniques in this series:

// • Basic types: These include all primitives and their associated wrapper classes, Number and String:
//   -During serialization, the toString() method is called on the instance field to produce a String value.
//   -Fields of type Number are the exception, because Number uses the doubleValue() method to produce a primitive.
//   -Primitives values are left untouched.
//   -On deserialization, the appropriate parseXXX() method is called to perform conversion to the needed basic type.

// • Java SE types: These refer to the range of Optional classes (such as OptionalInt), the BigInteger and BigDecimal classes,
//   and the URI and URL classes.
//   -Optional values are converted to Strings by retrieving their internal type and following the object’s convention for
//    transformation to a String or primitive. (An example would be calling intValue() on an instance of Integer.)
//   -Empty optionals are treated as null values and are dealt with according to the customization setting for handling nulls.
//   -The deserialization process takes advantage of the type’s construction methods that accept a  String parameter.
//    An example would be new BigDecimal("1234").

// • Date types: JSON-B supports all the standard Java date types including Calendar, TimeZone, and the  java.time.* package.
//   The format used during serialization is ISO_DATE, ISO_DATE_TIME, and  ISO_INSTANT/LOCAL_*/ZONED_*/OFFSET_*.
//   The API specification (section 3.5) has a detailed breakdown of the format used with each date type.

// • Arrays and collection types: It is possible to serialize and deserialize single and multidimensional arrays of all
//   supported Java types and primitives. Null value elements are represented as null values in the resulting JSON or Java array.

// • JSON processing types: All JSON processing types are supported for serialization and deserialization.

// • Java classes: To be serializable, a Java class is expected to have a no-argument public or  protected constructor,
//   or to explicitly specify a method to use for custom object construction. Some rules to note: A constraint is not required for
//   serialization: JSON-B can deserialize public, protected, and protected static classes.
//   Anonymous classes are not supported: serializing an anonymous class produces JSON objects. Other than those related to
//   the Java basic, Java SE,  Date/Time and Collection/Map types already mentioned, interfaces are not supported
//   during deserialization. The runtime type is used for serialization.


//Mapping a collection
//-JSON-B supports collections and generic collections handling. For proper deserialization the runtime type of resulting
//object needs to be passed to JSON-B during deserialization. It can be done a way shown below.
//	jsonb.fromJson(result, ArrayList.class);
//	dogs = jsonb.fromJson(result, new ArrayList<Dog>(){}.getClass().getGenericSuperclass());	//a generic collection


public class AnInfo_Basics {}

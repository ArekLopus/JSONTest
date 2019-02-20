package binding.helper;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;

@JsonbNillable
public class UserNullableProps {
	
	private String firstName;
	private String lastName;
	
	@JsonbProperty(nillable=true)
	private LocalDate dateOfBirth;
	
	public static UserNullableProps DEFAULT_USER = new UserNullableProps("John", "Doe", LocalDate.of(1989, 2, 11));
	public static UserNullableProps DEFAULT_NULL_USER = new UserNullableProps(null, null, null);
	
	public UserNullableProps() {}
	
	public UserNullableProps(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserNullableProps(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}

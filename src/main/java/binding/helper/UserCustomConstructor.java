package binding.helper;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class UserCustomConstructor {
	
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public static UserCustomConstructor DEFAULT_USER = new UserCustomConstructor("John", "Doe", LocalDate.of(1989, 2, 11));
	
	public UserCustomConstructor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@JsonbCreator
	public UserCustomConstructor(@JsonbProperty(value="firstName") String firstName,
			@JsonbProperty(value="lastName") String lastName, @JsonbProperty(value="dateOfBirth") LocalDate dateOfBirth) {
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

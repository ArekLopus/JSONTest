package binding.helper;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbTransient;

public class UserTransient {
	
	private String firstName;
	private String lastName;
	
	@JsonbTransient
	private LocalDate dateOfBirth;
	
	public static UserTransient DEFAULT_USER = new UserTransient("John", "Doe", LocalDate.of(1989, 2, 11));
	
	public UserTransient() {}
	
	public UserTransient(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserTransient(String firstName, String lastName, LocalDate dateOfBirth) {
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

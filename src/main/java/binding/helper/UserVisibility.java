package binding.helper;

import java.time.LocalDate;

public class UserVisibility {
	
	private String firstName;
	private String lastName;
	protected LocalDate dateOfBirth;
	
	public static UserVisibility getDefaultUser() {
		
		UserVisibility user = new UserVisibility();
		user.firstName = "John";
		user.lastName = "Doe";
		user.dateOfBirth = LocalDate.of(1989, 2, 11);
		
		return user;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}

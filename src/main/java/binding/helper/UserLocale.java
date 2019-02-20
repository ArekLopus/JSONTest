package binding.helper;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.json.bind.annotation.JsonbNumberFormat;

public class UserLocale {
	
	private Date dateOfBirth;
	
	@JsonbNumberFormat("###,###.00")
    private BigDecimal payment;
    
	public static UserLocale DEFAULT_USER = new UserLocale(Date.from(Instant.parse("1989-11-23T10:15:30.00Z")), new BigDecimal("12500000.326"));
	
	public UserLocale() {}

	public UserLocale(Date dateOfBirth, BigDecimal payment) {
		this.dateOfBirth = dateOfBirth;
		this.payment = payment;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "UserFormatDateAndNumber [dateOfBirth=" + dateOfBirth + ", payment=" + payment + "]";
	}
	
}

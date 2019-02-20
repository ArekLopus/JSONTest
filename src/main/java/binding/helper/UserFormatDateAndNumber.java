package binding.helper;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;

public class UserFormatDateAndNumber {
	
	@JsonbDateFormat("yyyy*MM*dd")
	private LocalDate dateOfBirth;
	
    //@JsonbNumberFormat("#0.00")
    @JsonbNumberFormat("###,###.00")
    private BigDecimal payment;
	
	public static UserFormatDateAndNumber DEFAULT_USER = new UserFormatDateAndNumber(LocalDate.of(1989, 2, 11), new BigDecimal("12500000.326"));
	
	public UserFormatDateAndNumber() {}

	public UserFormatDateAndNumber(LocalDate dateOfBirth, BigDecimal payment) {
		this.dateOfBirth = dateOfBirth;
		this.payment = payment;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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

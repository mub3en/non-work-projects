package packages;

import java.text.NumberFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


enum PaymentType{
	CreditCard, BankTransfer, Mail,AmazonRewardsVisa
}

public class Payment {
	private PaymentType paymentType;
	private String accountNumber;
	private String bankOrIssuer;
	private double paymentAmount;
	private Date paymentDate;
	
	//date formatting
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy"); 
	//currency formatting
	NumberFormat paymentFormatter = NumberFormat.getCurrencyInstance();
	
	public Payment(PaymentType paymentType, String accountNumber, String bankOrIssuer, double paymentAmount, NumberFormat paymentFormatter) {
		this.paymentType = paymentType;
		this.accountNumber = accountNumber;
		this.bankOrIssuer = bankOrIssuer;
		this.paymentAmount = paymentAmount;
		this.paymentDate = Calendar.getInstance().getTime();
		this.paymentFormatter = paymentFormatter;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankOrIssuer() {
		return bankOrIssuer;
	}
	public void setBankOrIssuer(String bankOrIssuer) {
		this.bankOrIssuer = bankOrIssuer;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
//	public String getPaymentDate() {
//		return paymentDate;
//	}
//	public void setPaymentDate(String paymentDate) {
//		this.paymentDate = paymentDate;
//	}
	
	public String getPartialAccountNumber() {
		return this.accountNumber.substring(this.accountNumber.length() - 4);
	}
	
	
	public String getFormattedPaymentDate() {
//		Date sd = null;
//		try {
//			sd = sdf.parse(this.paymentDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String formattedSD = sdf.format(sd);
		return sdf.format(this.paymentDate);
	}
	
	public String getFormattedPaymentAmount() {
		return paymentFormatter.format(this.paymentAmount);
	}
	
	
}

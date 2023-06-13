package packages;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Order {
	private String orderNumber;
	private Date orderDate; //DATE
	private ArrayList<OrderItem> orderItems;
	private double itemsSubtotal;
	private double shippingHandling;
	private double tax;
	private double grandTotal;
	private Customer customer;
	private Shipment shipment;
	private Payment payment;
	
	//date formatting
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy"); 
	//currency formatting
	NumberFormat paymentFormatter = NumberFormat.getCurrencyInstance();
	
	public Order(String orderNumber, double itemsSubtotal, double shippingHandling, 
			double tax, double grandTotal, Customer customer, Shipment shipment, Payment payment) {
		this.orderNumber = orderNumber;
		this.orderDate =  Calendar.getInstance().getTime();
		this.orderItems = new ArrayList<OrderItem>();
		this.itemsSubtotal = itemsSubtotal;
		this.shippingHandling = shippingHandling;
		this.tax = tax;
		this.grandTotal = grandTotal;
		this.customer = customer;
		this.shipment = shipment;
		this.payment = payment;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public double getItemsSubtotal() {
		return itemsSubtotal;
	}
	public void setItemsSubtotal(double itemsSubtotal) {
		this.itemsSubtotal = itemsSubtotal;
	}
	public double getShippingHandling() {
		return shippingHandling;
	}
	public void setShippingHandling(double shippingHandling) {
		this.shippingHandling = shippingHandling;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
		
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getFormattedOrderDate() {
		return sdf.format(this.orderDate);
	}
	
	//	+getShippingHandlingFormatted(): String
	public String getShippingHandlingFormatted() {
		return paymentFormatter.format(this.shippingHandling);
	}

	//	+getFormattedItemsSubtotal():String
	public String getFormattedItemsSubtotal() {
		//add Sub total at the end if needs be.
		return paymentFormatter.format(this.itemsSubtotal);
	}
	
//	+getFormattedEstimatedTaxes(): String
	public String getFormattedEstimatedTaxes() {
		return paymentFormatter.format(this.tax);
	}
//	+getFormattedGrandTotal(): String
	public String getFormattedGrandTotal() {
		return paymentFormatter.format(this.grandTotal);
	}
	
	
	
	
	
}

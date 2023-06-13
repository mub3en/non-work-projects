package packages;

//Invoice
//-order: Order
//-invoiceNumber: String

public class Invoice {
	private Order order;
	private String invoiceNumber;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	

}

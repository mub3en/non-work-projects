package packages;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collection;

public class AmazonOrderDetails {
	
//	private Collection<Product> inventory;
	ArrayList<Product> products;
	ArrayList<Order> orders;
	
	public AmazonOrderDetails() {
		this.products = new ArrayList<>();
		this.orders = new ArrayList<>();
	}
	
	public void addProducts(Product[] p) {
		this.products.addAll(Arrays.asList(p));
	}
	
//	public void addProduct(String productId, String productDescription, String soldBy, double price, Condition condition) {
//		this.products.add(new Product( productId, productDescription, soldBy, price, condition));
//	}
	
//  Order order = od.createOrder(products); // Create your order
//	public Order createOrder(ArrayList<Product> products) {
//		return null;
//	}
	
	public Order createOrder(Product[] p) {
		OrderItem oi = new OrderItem();
		return null;
	}
	
	
	
	public void createShipment(Order order) {
		order.getShipment();
	}
	
	

//    od.createShipment(order); // Ship your order
//    od.createPayment(order); // Create a payment record
//    od.printOrderDetails(order); // Print 
//    od.printInvoice(order);
	
	

}

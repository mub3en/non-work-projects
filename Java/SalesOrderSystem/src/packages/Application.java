package packages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

	public static void main(String[] args){
	
		Product p1 = new Product("978-0307977205","The Pirate's Coin: A Sixty-Eight Rooms Adventure (The Sixty-Eight Rooms Adventures",
				"Amazon.com Services LLC", 7.99 , Condition.New);
		Product p2 = new Product("978-0062377029","Pax","Amazon.com Services LLC", 5.89 , Condition.New);
		Product p3 = new Product("978-0547577319","A Long Walk to Water: Based on a True Story","Amazon.com Services LLC", 5.29 , Condition.New);
		Product p4 = new Product("978-03079296175","The River (A Hatchet Adventure)","Amazon.com Services LLC", 8.49 , Condition.New);
		Product p5 = new Product("978-0307929600","Brian's Return (A Hatchet Adventure) ", "Amazon.com Services LLC", 7.19 , Condition.New);
		
		ArrayList<Product> products = new ArrayList<>();
//		products.addAll(Arrays.asList(p1,p2,p3,p4,p5));
		Product[] products_array = {p1,p2,p3,p4,p5};
	
		AmazonOrderDetails od = new AmazonOrderDetails();  // Name of main class driver
		od.addProducts(products_array);
		System.out.println(products.toString());
		
		for (Product p : products_array) {
			System.out.println(p.getProductDescription());
		}
//		
//		products.stream()
//			.forEach(f ->f.ge);

//	    od.addProduct("978-0307977205","The Pirate's Coin: A Sixty-Eight Rooms Adventure (The Sixty-Eight Rooms Adventures",
//				"Amazon.com Services LLC", 7.99 , Condition.New);
//	    od.addProduct("978-0062377029","Pax","Amazon.com Services LLC", 5.89 , Condition.New);
//	    od.addProduct("978-0547577319","A Long Walk to Water: Based on a True Story","Amazon.com Services LLC", 5.29 , Condition.New);
//	    od.addProduct("978-03079296175","The River (A Hatchet Adventure)","Amazon.com Services LLC", 8.49 , Condition.New);
//	    od.addProduct("978-0307929600","Brian's Return (A Hatchet Adventure) ", "Amazon.com Services LLC", 7.19 , Condition.New);
//	    
//	    
//	    od.addProducts(products); // Create your product data here  //	    od.addProducts(products.add(p1)); // Create your product data here
//	    
//	    
//	    
//	    products.stream()
//	    	.map(Product::getProductDescription)
//	    	.forEach(System.out::println);
	    
//	    System.out.println(products.toString());
	    
//	    Order order = od.createOrder(products); // Create your order
//	    od.createShipment(order); // Ship your order
////	    od.createPayment(order); // Create a payment record
////	    od.printOrderDetails(order); // Print 
////	    od.printInvoice(order);
	    
	    
	    
		
		

	}

}

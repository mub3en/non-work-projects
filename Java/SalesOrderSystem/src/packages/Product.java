package packages;

//Product
//-productId: String
//- productDescription : String
//- soldBy: Description
//-price: double
//-conidition: Condition

enum Condition{
	New, Used, Reconditioned
}

public class Product {
	private String productId;
	private String productDescription;
	private String soldBy; //Description
	private double price;
	private Condition conidition;
	
	public Product() {
		this.productId = "Default Value";
		this.productDescription = "Default Value";
		this.soldBy = "Default Value";
		this.price = 0.00;
		this.conidition = Condition.valueOf(null);
	}

	public Product(String productId, String productDescription, String soldBy, double price, Condition conidition) {
//		super();
		this.productId = productId;
		this.productDescription = productDescription;
		this.soldBy = soldBy;
		this.price = price;
		this.conidition = conidition;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getSoldBy() {
		return soldBy;
	}
	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Condition getConidition() {
		return conidition;
	}
	public void setConidition(Condition conidition) {
		this.conidition = conidition;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDescription=" + productDescription + ", soldBy=" + soldBy
				+ ", price=" + price + ", conidition=" + conidition + "]";
	}
}

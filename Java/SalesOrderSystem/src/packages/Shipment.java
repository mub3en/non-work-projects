package packages;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

enum ShipmentStatus {
	InProcess, Shipped, Delivered
}

enum ShipmentSpeed {
	OneDay, TwoDay, Mail
}

public class Shipment {
	
	private String shipmentId;
	private String carrier;
	private ShipmentStatus shipmentStatus;
	private String trackingId;
	private Date shippedDate; //make it a date
	private Date deliveryDate;//make it a date
	private ShipmentSpeed shipmentSpeed;
	

	public Shipment(String shipmentId, String carrier, ShipmentStatus shipmentStatus, String trackingId, ShipmentSpeed shipmentSpeed) {
		this.shipmentId = shipmentId;
		this.carrier = carrier;
		this.shipmentStatus = shipmentStatus;
		this.trackingId = trackingId;
		this.shippedDate = Calendar.getInstance().getTime();
		this.deliveryDate = Calendar.getInstance().getTime();
		this.shipmentSpeed = shipmentSpeed;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");  
	
	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public ShipmentSpeed getShipmentSpeed() {
		return shipmentSpeed;
	}

	public void setShipmentSpeed(ShipmentSpeed shipmentSpeed) {
		this.shipmentSpeed = shipmentSpeed;
	}
	
	public String getFormattedShipmentDate(){
		return sdf.format(this.shippedDate);
		
	}
	
	public String getFormattedDeliveryDate() {
		return sdf.format(this.deliveryDate);
	}
	

}

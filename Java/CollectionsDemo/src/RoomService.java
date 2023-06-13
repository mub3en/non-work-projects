//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RoomService {

	// 1. Declare a Collection to store Room Inventory
	private Collection<Room> inventory;

	public RoomService() {
		
	// 2. Initialize Collection and assign it to the Room Inventory
		this.inventory = new LinkedHashSet<>();
		

	}
	
	public void applyDiscount(final double discount) {
		
		//Reduces the rate of each room by the provided discount
		this.inventory
			.forEach(e -> e.setRate(e.getRate() * (1-discount)));
	
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
		
		//Returns a new collection of rooms that meet or exceed the provided capacity
//		for (Room room : this.inventory) {
//			if(room.getCapacity() == requiredCapacity) {
//				return this.inventory;
//			}else {
//				return null;
//			}
//		}
//		
//		return this.inventory;
		
//		Collection<Room> matches = new HashSet<>();
//
//		for (Room room : inventory) {
//			if(room.getCapacity() >= requiredCapacity ) {
//				matches = inventory;
//			}
//		}
//		
//		return matches;
		
		return this.inventory.stream()
					.filter(f -> f.getCapacity() >= requiredCapacity)
					.collect(Collectors.toList());
		
	}
	
	public Collection<Room> getRoomByRateAndType(final double rate, final String type){
		
//		Collection<Room> copy = new HashSet<>();
	
		//Returns a new collection of rooms with a rate below the provided rate and that match the provided type
		
//		for (Room room : inventory) {
//			if(room.getRate() < rate && room.getType().equals(type)) {
//				copy = inventory;
//			}
//		}
//		
//		return copy;
		
		return this.inventory.stream()
					.filter(f -> f.getRate() < rate)
					.filter(f -> f.getType().equals(type))
					.collect(Collectors.toList());
		
	}
	
	public boolean hasRoom(Room room) {
		
		// 1. Returns a boolean that indicates if the Room Inventory contains a Room.
			
			return this.inventory.contains(room);
	}
	
	public Room[] asArray() {
		
	// 2. Returns all Rooms as an Array of Rooms in the **order** they were Added.
		
		return this.inventory.toArray(new Room[0]); 
	}
	
	public Collection<Room> getByType(String type){

	/*
	   3. Return a new Collection of Rooms where Room#type matches the provided String.
		  The original Room Inventory collection MUST NOT BE MODIFIED.
	*/

		Collection<Room> copy = new HashSet<>(this.inventory);
		copy.removeIf(r -> !r.getType().equals(type));
		return copy;
		
	}

	public Collection<Room> getInventory(){
		
	// 3. Return the Room Inventory
		
		return new HashSet<>(this.inventory);
	}
	
	public void createRoom(String name, String type, int capacity, double rate) {
	
	// 4. Add a new Room to the Room Inventory using the provided parameters
//		Room r = new Room(name, type, capacity, rate);
//		Collection<Room> c = new ArrayList<>();
//		c.add(r);
		this.inventory.add(new Room(name, type, capacity, rate));

	}

	public void createRooms(Room[] rooms) {
	
	// 5. Add the Rooms provided in the Array to the Room Inventory
		this.inventory.addAll(Arrays.asList(rooms));

	}
	
	public void removeRoom(Room room) {
		
	// 6. Remove the provided Room from the Room Inventory
		this.inventory.remove(room);

	}

}
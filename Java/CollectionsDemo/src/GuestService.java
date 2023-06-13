import java.util.ArrayList;
import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
		
//		guests.stream()
//			.filter(f -> f.setPreferredRooms(List.of(f.getFirstName())))
//			.collect(Collectors.toList());
		
		
		return guests.stream()
					.filter(f -> f.getPreferredRooms().indexOf(room) == 0)
					.collect(Collectors.toList());

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
//		List<Guest> tempcheckinList = new ArrayList<>(100);
//		
//		if(guest.isLoyaltyProgramMember() == true)
//			this.checkinList.add(guest);
//		else
//			tempcheckinList.add(guest);
//		
//		for (Guest guest2 : tempcheckinList) {
//			this.checkinList.add(guest2);
//		}
			
		if (guest.isLoyaltyProgramMember() && !this.checkinList.isEmpty()) {
				
				int i = 0;
				for (; i < this.checkinList.size(); i++) {
					
					if (this.checkinList.get(i).isLoyaltyProgramMember()) {
						continue;
					}
					
					break;
					
				}
				
				this.checkinList.add(i, guest);
				
			} else {
				this.checkinList.add(guest);
			}
				
	
		}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		
		int pos1 =this.checkinList.indexOf(guest1);
		int pos2 =this.checkinList.indexOf(guest2);
		
//		if(this.checkinList.containsAll(List.of(guest1, guest2))) {
		if(pos1 != -1 && pos2 != -1) {
			this.checkinList.set(pos1, guest2);
			this.checkinList.set(pos2, guest1);
		}

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
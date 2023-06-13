package datastructures.dccc.edu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FlightOps {

    LinkedList<Flight> flts = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    private void printFlights()
    {
        // Print out flights
        //  Add your code here
    	System.out.println();
    	if(!flts.isEmpty()) {
    		for (Flight flight : flts) {
				System.out.println(flight + "\n");
			}
    	}
    	System.out.println();
    }

    private void removeCancelledFlights() {
        Stack removeStack = new Stack();

        //  Remove flights with cancellation statuses,  use stack to avoid concurrency problem with for-next
        for (Flight flt: flts)
        {
            if (flt.operationStatus == Flight.OperationStatus.CancelDueCrash
                    || flt.operationStatus == Flight.OperationStatus.CancelDueDrunkPilot
                    || flt.operationStatus == Flight.OperationStatus.CancelDueMaintenance
                    || flt.operationStatus == Flight.OperationStatus.CancelDuePassengerDisturbance
                    || flt.operationStatus == Flight.OperationStatus.NavigationError
                    || flt.operationStatus == Flight.OperationStatus.CancelNoPlane) {
                removeStack.push(flt);
            }
        }
        while (!removeStack.isEmpty()) {
            flts.remove(removeStack.pop());
        }
    }


    //  Change statuses from default Scheduled to a random status.  Some statuses make sense only for Arrival or Departure so
    //  FlightType is checked before setting
    private void changeStatuses() {
        for (Flight flt : flts) {
            Flight.OperationStatus status = (Flight.OperationStatus) Flight.OperationStatus.getRandomStatus();
            if (flt.flightType == Flight.FlightType.Arrival) {
                if (status == Flight.OperationStatus.CancelDueCrash || status == Flight.OperationStatus.NavigationError  || status == Flight.OperationStatus.Scheduled || status == Flight.OperationStatus.Queued) {
                    flt.setOperationStatus(status);
                }
                //  if status doesn't make sense, don't set it
            } else if ((flt.flightType == Flight.FlightType.Arrival && status == Flight.OperationStatus.CancelDueMaintenance)
                    || (flt.flightType == Flight.FlightType.Departure && status == Flight.OperationStatus.NavigationError)) {
                continue;
            } else {
                flt.setOperationStatus(status);
            }
        }
    }

    // Move flights with Queued status to end of LinkedList
    private void moveQueuedFlights() {
        Stack moveStack = new Stack();
        for (Flight flt : flts) {

            // Use a stack to move items to be removed
            // Items can't be removed from within for-next because loop will hit a concurrency exception

            if (flt.operationStatus == Flight.OperationStatus.Queued) {
                moveStack.push(flt);
            }
        }
        //  Now we use the stack to move the items to end
        while (!moveStack.isEmpty()) {
            // Save this item before removing
            Flight flight = (Flight) moveStack.peek();
            // Now remove it
            flts.remove(moveStack.pop());
            //  Add your code here
            //  add flight to bottom of LinkedList -- see addLast() method
            flts.addLast(flight);

        }
    }

    private void presidentAndCroniesJumpTheQueue() {
        //  President and his cronies jump the line
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm");
        try {
            Date date1 = sdf.parse("10/15/20 07:30");
            Date date2 = sdf.parse("10/15/20 07:30");
            Date date3 = sdf.parse("10/15/20 07:30");
            Flight vipFlight1 = new Flight("Vip001", "AF-01", "CDG", date1, Flight.FlightType.Departure);
            Flight vipFlight2 = new Flight("Vip002", "AF-01", "CDG", date2, Flight.FlightType.Departure);
            Flight vipFlight3 = new Flight("Vip003", "AF-01", "CDG", date3, Flight.FlightType.Arrival);

            //  Add your code here to add the above three flights to the top of the LinkedList  -- See addFirst() method
            //  Add your code here to add the above three flights to the top of the LinkedList  -- See addFirst() method
            
            flts.addAll(0, List.of(vipFlight1, vipFlight2, vipFlight3));
            
        }
        catch (ParseException e)
        {
            System.out.println("Date Parse Exception");
        }
    }

    public void doSimuluation(String filePath) {
        flts = initializeFlightList(filePath);
        String menuItem = "";
        
        
		System.out.println("~~~Welcome to the FLight Operations~~~\n");
		
		do{
			System.out.println("Enter number \n1- Display Flights(c)\n2- Search Flights(r)\n\n3- Quit (q):");
			menuItem = scanner.nextLine();
			switch (menuItem) {
			case "d":
			case "1":
				subMenu(menuItem );
				break;
			case "s":
			case "2":
				System.out.println("Search Flights coming soon...");
				break;
			case "q":
			case "3":
				System.out.println("Flight manager has been closed. Good bye!!!");
				scanner.close();
				return;
			default:
				System.out.println("\nNOT A VALID OPTION.\n");
				break;
			}
		}while(true);
    }

    public static void main(String[] args) {
        FlightOps fltOPs = new FlightOps();
        String filePath = "./resources/Flights.csv";
        fltOPs.doSimuluation(filePath);
    }
    
    public void subMenu(String menuItem ) {
    	do{
			System.out.println("Enter number \n1- ChangeStatus(c)\n2- RemoveCancelFlights(r)\n"
					+ "3- CroniesJumping(j)\n4- MoveQueuedFlights(m)\n5- ShowAllFlights(a)\n6- Go back to main menu(q):");
			menuItem = scanner.nextLine();
			switch (menuItem) {
			case "c":
			case "1":
				changeStatuses();
		        System.out.println("Changed statuses");
		        printFlights();
				break;
			case "r":
			case "2":
				System.out.println("Remove cancelled flights");
		        removeCancelledFlights();
		        printFlights();
				break;
			case "j":
			case "3":
				presidentAndCroniesJumpTheQueue();
				System.out.println("Cronies jump queue");
				printFlights();
				break;
			case "m":
			case "4":
				moveQueuedFlights();
		        System.out.println("Moved queued flights");
		        printFlights();
				break;
			case "a":
			case "5":
				changeStatuses();
		        System.out.println("Changed statuses");
		        printFlights();
		        System.out.println("Remove cancelled flights");
		        removeCancelledFlights();
		        printFlights();
		        presidentAndCroniesJumpTheQueue();
				System.out.println("Cronies jump queue");
				printFlights();
				moveQueuedFlights();
		        System.out.println("Moved queued flights");
		        printFlights();
				break;
			case "q":
			case "6":
				System.out.println("Exiting out of dispaly menu.\n");
				return;
			default:
				System.out.println("\nNOT A VALID OPTION.\n");
				break;
			}
		}while(true);
    }

    public LinkedList initializeFlightList(String filePath) {
        // Load flights from external file
        ReadCSVWithScanner csvReader = new ReadCSVWithScanner();
        LinkedList fltList = csvReader.getFlightListFromCSV(filePath);
        return fltList;
    }

}

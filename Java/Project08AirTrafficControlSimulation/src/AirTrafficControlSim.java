import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AirTrafficControlSim {

	public static final int MIN_FLIGHT_SPACING = 10;
	public int timeInterval;
	public int flightNumberCounterArrival = 1;
	public int flightNumberCounterDeparture = 1;
	public int flightSpacingCount;
	public int numberOfDivertedArrivals = 0;
	public int numberOfDeniedDepartures = 0;
	public int numberOfArrivals;
	public int numberOfDepartures;
	public int departureQueueEmpty;
	public int arrivalQueueEmpty;

	ArrayDeque<Flight> arrivalQueue = new ArrayDeque<>();
	ArrayDeque<Flight> departureQueue = new ArrayDeque<>();

	ArrayList<Flight> arrivalStatistics = new ArrayList<>();
	ArrayList<Flight> departureStatistics = new ArrayList<>();

	public int getPoissonRandom(double mean) {
//		Random r = new Random(System.currentTimeMillis());
	    Random r = new Random(System.nanoTime());
		double L = Math.exp(-mean);
		int x = 0;
		double p = 1.0;
		do {
			p = p * r.nextDouble();
			x++;
		} while (p > L);
		return x - 1;
	}

	// Arrivals
	public void processArrival(double meanArrivalFreq) {
		int count = 0;
		flightSpacingCount++;
		timeInterval++;
		if ((count = getPoissonRandom(meanArrivalFreq)) > 0)
			addToArrivalQueue(count);
		if (flightSpacingCount >= MIN_FLIGHT_SPACING) {
			if (arrivalQueue.size() > 0) {
				removeFromArrivalQueue();
				flightSpacingCount = 0;
			}
		}
	}

	public void addToArrivalQueue(int count) {
		for (int i = 0; i < count; i++) {
			Flight arrivalFlight = new Flight("AA" + flightNumberCounterArrival++, FlightType.Arrival);
			if (arrivalQueue.size() < 5) {
				arrivalFlight.setMinuteInQueue(timeInterval);
				arrivalQueue.add(arrivalFlight);
			} else {
				this.numberOfDivertedArrivals++;
				System.out.println("Arrival queue full. Flight " + arrivalFlight + " rerouted at: " + timeInterval / 60
						+ ":" + String.format("%02d", timeInterval % 60));
			}
		}
	}

	public void removeFromArrivalQueue() {
		if (arrivalQueue.size() > 0) {
			Flight arrivalFlight = arrivalQueue.removeFirst();
			arrivalFlight.setMinuteOutQueue(timeInterval);
			arrivalStatistics.add(arrivalFlight);
			arrivalStatistics.add(arrivalFlight);
			System.out.println("Flight " + arrivalFlight + " arrived at: " + timeInterval / 60 + ":"
					+ String.format("%02d", timeInterval % 60));
			numberOfArrivals++;
		}
	}

	// Departure
	public void processDeparture(double meanDepartureFreq) {
		int count = 0;
		flightSpacingCount++;
		timeInterval++;
		if ((count = getPoissonRandom(meanDepartureFreq)) > 0)
			addToDepartureQueue(count);
		if (flightSpacingCount >= MIN_FLIGHT_SPACING) {
			if (departureQueue.size() > 0 && arrivalQueue.size() == 0) {
				removeFromDepartureQueue();
				flightSpacingCount = 0;
			}
		}

	}

	public void addToDepartureQueue(int count) {
		for (int i = 0; i < count; i++) {
			Flight departureFlight = new Flight("UA" + flightNumberCounterDeparture++, FlightType.Departure);
			if (departureQueue.size() < 5) {
				departureFlight.setMinuteInQueue(timeInterval);
				departureQueue.add(departureFlight);
			} else {
				this.numberOfDeniedDepartures++;
				System.out.println("Departure queue full. Flight " + departureFlight + " departure delayed due air traffic control at: "
						+ timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60));
			}
		}
	}

	public void removeFromDepartureQueue() {
		if (departureQueue.size() > 0) {
			Flight departureFlight = departureQueue.removeFirst(); // remove top item from queue
			departureFlight.setMinuteOutQueue(timeInterval); // set time flight leaves the queue
			departureStatistics.add(departureFlight); // Save flight in departureStatistics queue.
			System.out.println("Flight " + departureFlight + " departed at: " + timeInterval / 60 + ":"
					+ String.format("%02d", timeInterval % 60));
			numberOfDepartures++;
		}
	}

	public void printSimSummaryStatistics() {
		int ttlDepartureTimeQueue =0;
		int ttlArrivalTimeQueue =0;
		double avgDepartureTimeQueue = 0.0;
		double avgArrivalTimeQueue = 0.0;
		int totalFlights = numberOfArrivals + numberOfDepartures;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("\n*********************************************************");
		System.out.println("Automated Air Traffic Control Simulator Summary Statistics");
		System.out.println("**********************************************************\n");
		System.out.println("Time period Simulated: " + timeInterval / 60 + ":" + String.format("%02d", timeInterval % 60) + " hours");
		System.out.println("Number of arrivals: " + numberOfArrivals);
		System.out.println("Number of departures: " + numberOfDepartures);
		System.out.println("Total number of flights operated: " + totalFlights);
		if(numberOfArrivals > 0)
			System.out.println("Average number of arrivals per hour: " + String.format("%.2f", (double)(numberOfArrivals / (timeInterval / 60.0))));
		else
			System.out.println("Average can't be calculated, since number of arrivals are zero. ");
		if(numberOfDepartures > 0)
			System.out.println("Average number of departures per hour: " + String.format("%.2f", (double)(numberOfDepartures / (timeInterval / 60.0))));
		else
			System.out.println("Average can't be calculated, since number of departures are zero. ");
		System.out.println("Arrivals remaining in the queue: " + arrivalQueue.size());
		System.out.println("Departures remaining in the queue: " + departureQueue.size());
		System.out.println("Number of diverted arrivals: " + this.numberOfDivertedArrivals);
		System.out.println("Number of diverted departures: " + this.numberOfDeniedDepartures);
		
		
		for(Flight flt : arrivalStatistics) {
			ttlArrivalTimeQueue =  ttlArrivalTimeQueue + flt.timeInQueue();
		}
		
		if(arrivalStatistics.size() > 0) {
			avgArrivalTimeQueue = ttlArrivalTimeQueue/arrivalStatistics.size();
		}
		
		for(Flight flt : departureStatistics) {
			ttlDepartureTimeQueue =  ttlDepartureTimeQueue + flt.timeInQueue();
		}
		
		if(departureStatistics.size() > 0) {
			avgDepartureTimeQueue = ttlDepartureTimeQueue/departureStatistics.size();
		}
		
		int emptyQueueInstances = arrivalQueueEmpty + departureQueueEmpty;
		double pctIdle = (double) emptyQueueInstances/timeInterval * 100.00;
		System.out.println("Percent time idle runaway: " + df.format(pctIdle) + "%");
		System.out.println("Average arrival time in queue: " + df.format(avgArrivalTimeQueue) + " minutes");
		System.out.println("Average departure time in queue: " + df.format(avgDepartureTimeQueue) + " minutes");
	}
	
	
	public static void main(String[] args) {

		AirTrafficControlSim sim = new AirTrafficControlSim();
		Scanner scanner = new Scanner(System.in);

		double meanArrivalFreq = 0.0;
		double meanDepartureFreq = 0.0;

		System.out.println("Enter mean departure frequency (0.0 < df > 1.0): ");
		if (scanner.hasNextDouble()) 
			meanDepartureFreq = scanner.nextDouble();
			
		System.out.println("Enter mean arrival frequency   0.0 < af > 1.0): ");
		if (scanner.hasNextDouble())
			meanArrivalFreq = scanner.nextDouble();
		

		// Each i in the loop represents a minute, 720 x 2 = 1440 minutes in 24 hours
		if (meanDepartureFreq + meanArrivalFreq <= 1.0) {
			for (int i = 0; i < 720; i++) {
				sim.processArrival(meanArrivalFreq);
				sim.processDeparture(meanDepartureFreq);
				
				if(sim.arrivalQueue.size() == 0)
					sim.arrivalQueueEmpty++;
				
				if(sim.departureQueue.size() ==0)
					sim.departureQueueEmpty++;
			}
		} else {
			System.out
					.println("ERROR: Your sum adds up to more than 1.0, that means the probability is more than 100%.");
		}
		
		sim.printSimSummaryStatistics(); 

		
	    
		scanner.close();
	}

}
enum FlightType {
	Arrival, Departure
};

class Flight {
	String flightNumber;
	FlightType flightType;
	int minuteInQueue;
	int minuteOutQueue;
	
	//Empty constructor
//	public Flight() {
//		
//	}
	// constructor
	public Flight(String flightNumber, FlightType flightType) {
		this.flightNumber = flightNumber;
		this.flightType = flightType;
	}

	public String toString() {
		return flightType + ": " + flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}
	
	 public void setFlightType(String type) {
        switch(type) {
            case "Arrival":
                flightType = FlightType.Arrival;
                break;
            case "Departure":
                flightType = FlightType.Departure;
                break;
        }
    }

	public FlightType getFlightType() {
		return this.flightType;
	}

	// "minute" that flight entered the queue
	public void setMinuteInQueue(int minute) {
		this.minuteInQueue = minute;
	}

	// "minute" that flight exits the queue
	// difference is time in queue
	public void setMinuteOutQueue(int minute) {
		this.minuteOutQueue = minute;
	}

	public int timeInQueue() {
		return minuteOutQueue - minuteInQueue;
	}
}
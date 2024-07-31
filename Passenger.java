
public class Passenger {
	String passengerID;
	String ticketClass;
	int ticketNumber;
	static int ticketCounter = 0;
	
	Passenger(String cl){
		setTicketNumber();
		setTicketClass(cl);
		setPassengerID();
	}

	public void setTicketNumber() {
		ticketCounter++; 
		ticketNumber= ticketCounter;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	public void setTicketClass(String tClass) {
		ticketClass=tClass;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	
	public void setPassengerID() {
		passengerID="PID_"+ticketClass+" "+ticketNumber;
	}
	public String getPassengerID() {
		return passengerID;
	}
	
	public String toString() {
		return String.format("%S",passengerID);
	}
}

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Flight {
	String flightName;
	int seats;
	int seatsSold;
	Random randy;
	LinkedList<Passenger>passBooked = new LinkedList<Passenger>();
	PriorityQueue<Passenger> boardingQueue = new PriorityQueue<Passenger>(new PassengerComparator());
	
	Flight(String fName, int seed){
		setFlightName(fName);
		randy = new Random(seed);
		setSeats();
	}
	
	public void setFlightName(String name) {
		flightName = name;
	}
	
	public void setSeats() {
		seats = randy.nextInt(75,151);
	}
	public void sellSeats() {
		seatsSold = (seats/2)+randy.nextInt(0,1+seats/2);
		for(int i=0;i<seatsSold;i++) {
			int num = randy.nextInt(0,5);
			if(num==0) {
				passBooked.add(new FirstClassPassenger());
			}else{
				passBooked.add(new CoachPassenger());
			}
		}
	}
	public void lineUpCall() {
		Iterator<Passenger> passIter = passBooked.iterator();
		while(passIter.hasNext()) {
			boardingQueue.add(passIter.next());
		}
	}
	public void boarding(PrintWriter outWriter) {
		outWriter.printf("The boarding order for Flight %S with %d seats and %d seats sold is:",flightName,seats,seatsSold);
		int len = boardingQueue.size();
		for(int i =0;i<len;i++) {
			Passenger passAt = boardingQueue.remove();
			if(i%3==0) {
				outWriter.printf("\n");
			}
			outWriter.printf("%-18S",passAt.getPassengerID());
		}
		
		
	}
}

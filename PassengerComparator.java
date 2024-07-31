import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>{

	@Override
	public int compare(Passenger p1, Passenger p2) {
		if(p1.getTicketClass()=="First"&&p2.getTicketClass()=="Coach") {
			return -1;
		}else if(p1.getTicketClass()=="Coach"&&p2.getTicketClass()=="First"){
			return 1;
		}
		else
			return p1.getTicketNumber()-p2.getTicketNumber();
	}

}

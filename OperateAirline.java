import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OperateAirline {

	public static void main(String[] args) throws IOException {
		ArrayList<Flight>flightList = new ArrayList<Flight>();
		Scanner input = new Scanner(System.in);
		for(int i =0;i<3;i++) {
			System.out.printf("Please enter the Flight Name:%n");			
			String name1=input.nextLine();
			System.out.printf("Please enter an integer seed from 1 to 50:%n");
			int seed1 = Integer.parseInt(input.nextLine());
			Flight flight = new Flight(name1,seed1);
			flightList.add(flight);
		}	

		System.out.printf("Please enter the name of the output file:");
		String outputFile = input.next();
		PrintWriter outputWriter = new PrintWriter(outputFile);
		for(Flight f:flightList) {
			f.sellSeats();
			f.lineUpCall();
			f.boarding(outputWriter);
			outputWriter.printf("%n%n%n");
		}
		outputWriter.close();
		input.close();

	}

}

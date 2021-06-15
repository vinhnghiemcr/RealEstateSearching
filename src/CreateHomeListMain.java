import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class CreateHomeListMain
{
	public static void main(String[] args)
	{
		//*** these lines print to a file and shows where to put listing files
		// PrintWriter outStream = TextFileIO.createTextWrite("out.txt");
		// outStream.println("hi");
		// System.out.println("hi");
		// outStream.close();
		RealEstateAgent myAgent = new RealEstateAgent();
		Scanner scan = new Scanner(System.in);
		System.out.println("I am a Real Estate Agent. I can create a list of homes for sale.");
		System.out.println("Would you like to create a list?");
		System.out.println("Enter yes or no.");
		String choice = scan.nextLine();
		
		while(choice.equalsIgnoreCase("yes"))
		{
			String theHomeList = myAgent.listingsChosen();
			System.out.println(theHomeList);
			System.out.println("Would you like to create a new list");
			System.out.println("Enter yes or no.");
			choice = scan.nextLine();
		}// while
		System.out.println("Thank you for creating lists.");
		scan.close();
	}
}




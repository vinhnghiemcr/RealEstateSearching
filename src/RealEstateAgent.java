import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class RealEstateAgent //*** this is the largest class
{
	//*** ArrayLists that I used.
	private ArrayList<Agency> agencyArray = new ArrayList<Agency>();	
	private ArrayList<RealEstateListing> listingsFromOneAgency = new ArrayList<RealEstateListing>();
	private ArrayList<RealEstateListing> finalArrayListOfRealEstateListings = new ArrayList<RealEstateListing>();
	private String answerSoFar = "";
	private Agency century21 = null;
	private Agency reMax = null;
	private Agency mcEnearney = null;
	private Agency longAndFoster = null;

	Scanner scan = new Scanner(System.in);

	public RealEstateAgent()
	{	
		//Create real-estate companies here.  
		//Give them a name and pass in their text file. 
		//Here is the code.
		reMax = new Agency("ReMax","ReMax.txt");
		mcEnearney = new Agency("McEnearney", "McEnearney.txt");
		longAndFoster = new Agency ("Long & Foster", "LongAndFoster.txt");
		century21 = new Agency("Century 21","Century21.txt");
	}

	public ArrayList<RealEstateListing> age(int ageRange, ArrayList<Agency> agencyArray){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (Agency agency : agencyArray){	
			ArrayList<RealEstateListing> temp = agency.age(ageRange);
			for (RealEstateListing other : temp){
				ans.add(other);
			}
		}
		return ans;
	}


	private void getAgenciesForTheExhibition() {
		printAgencyList();

		String choice = scan.nextLine();
		Scanner scanLine = new Scanner(choice);
		

		while(scanLine.hasNextInt()){
			int company = scanLine.nextInt();
			
			switch(company){
			case 1: agencyArray.add(century21); break;
			case 2: agencyArray.add(reMax); break;
			case 3: agencyArray.add(mcEnearney); break;
			case 4: agencyArray.add(longAndFoster); break;
			default: break;
			}
		}
		scanLine.close();
	}



	private static void printAgencyList(){
		System.out.println("For this list of homes which real-estate agencies");
		System.out.println("would you like the home listings drawn from?");
		System.out.println("Please enter their numbers on one line");
		System.out.println("1) Century 21");
		System.out.println("2) ReMax");
		System.out.println("3) McEnearney");
		System.out.println("4) Long & Foster");
	}
}


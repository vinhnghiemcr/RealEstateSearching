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
	
	private int pickHomeCriterion() {
		printHomeCriterion();
		int ans = scan.nextInt();
		scan.nextLine();
		return ans;
	}

	private void printHomeCriterion() {
		System.out.println("Please choose a home criteria");
		System.out.println("and enter its number.");
		System.out.println("1) Style");
		System.out.println("2) Number Of Bedrooms");
		System.out.println("3) Number Of Bathrooms");
		System.out.println("4) Lot Size");
		System.out.println("5) Age");
		System.out.println("6) Price");
		System.out.println("7) Distance From Work");
		System.out.println("8) Jurisdiction");
	}
	
	public ArrayList<RealEstateListing> style(int styleType, ArrayList<Agency> agencyArray){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		String homeType = "";
		switch(styleType){
		case 1: homeType = "Rambler"; break;
		case 2: homeType = "Condominium"; break;
		case 3: homeType = "Colonial"; break;
		case 4: homeType = "Georgian"; break;
		case 5: homeType = "Townhouse"; break;
		case 6: homeType = "Split Level"; break;
		case 7: homeType = "Cape Cod"; break;
		default: break;
		}

		for (Agency agency : agencyArray){
			//agency.toString();
			ArrayList<RealEstateListing> temp = agency.style(homeType);
			for (RealEstateListing other : temp){
				ans.add(other);
			}

		}
		return ans;
		//*** ask each agency to give a list that satisfies the requested style.
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


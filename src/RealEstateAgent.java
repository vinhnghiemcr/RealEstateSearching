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
	
	public String listingsChosen(){
		getAgenciesForTheExhibition();
		int homeCriterion = pickHomeCriterion();
		
		switch (homeCriterion)
		{
		case 1:// Style
			int style = getStyle();
			finalArrayListOfRealEstateListings = style(style, agencyArray);
			break;
		case 2://number of bedrooms
			double numberOfBed = getNumberOfBedroom();
			finalArrayListOfRealEstateListings = bedroom(numberOfBed, agencyArray);
			break;
		case 3: //number of bathrooms
			double numberOfBath = getNumberOfBathroom();
			finalArrayListOfRealEstateListings = bathroom(numberOfBath, agencyArray);
			break;
		case 4: //number of lot size
			double numberOfLotSize = getNumberOfLotSize();
			finalArrayListOfRealEstateListings = bathroom(numberOfLotSize, agencyArray);
			break;
		case 5: //age
			int ageRange = getAge();
			finalArrayListOfRealEstateListings = age(ageRange, agencyArray);
			break;
		case 6: // price
			int priceRange = getPriceRange();
			finalArrayListOfRealEstateListings = price(priceRange, agencyArray);
			break;
		case 7: //Distance from work
			int distanceRange = getDistanceRange();
			finalArrayListOfRealEstateListings = distance(distanceRange, agencyArray);
			break;
		case 8: //Jurisdiction
			int jurisdiction = getJurisdiction();
			finalArrayListOfRealEstateListings = jurisdiction(jurisdiction, agencyArray);
			break;
		default:
			System.out.println("bad topic Selection choice " + homeCriterion);
			System.exit(0);
		}
		String ans = "";
		
		int i =1;
		for (RealEstateListing other : finalArrayListOfRealEstateListings){
			System.out.print(i + ") ");
			System.out.println(other.toString() );
			i++;
		}
		return ans;
	}
	
	private int getDistanceRange() {
		System.out.println("Please choose the distance and enter its number.");
		System.out.println("1) under 5");
		System.out.println("2) 5 to 10");
		System.out.println("3) 10 to 15");
		System.out.println("4) over 15");
		int distanceRange = scan.nextInt();
		scan.nextLine();
		return distanceRange;
	}
	
	private int getJurisdiction() {
		System.out.println("Please choice a jurisdiction");
		System.out.println("and enter its number.");
		System.out.println("1) District of Columbia");
		System.out.println("2) Arlington");
		System.out.println("3) Alexandria");
		System.out.println("4) Falls Church");
		System.out.println("5) Fairfax");
		
		int jurisdiction = scan.nextInt();
		scan.nextLine();
		return jurisdiction;
	}
	
	private int getPriceRange() {
		System.out.println("Please choose the price and enter its number.");
		System.out.println("1) under 100 thousand");
		System.out.println("2) 100 thousand to 150 thousand");
		System.out.println("3) 150 thousand to 200 thousand");
		System.out.println("4) 200 thousand to 300 thousand");
		System.out.println("5) 300 thousand to 400 thousand");
		System.out.println("6) over 400 thousand");
		int priceRange = scan.nextInt();
		scan.nextLine();
		return priceRange;
	}

	private int getAge() {
		System.out.println("Enter the age range of the house:");
		System.out.println("1) 1 to 5 years old.");
		System.out.println("2) 6 to 10 years old.");
		System.out.println("3) 11 to 15 years old.");
		System.out.println("4) Greater than 15 years old.");
		int ageRange = scan.nextInt();
		scan.nextLine();
		return ageRange;
	}
	private double getNumberOfLotSize() {
		System.out.println("Please enter a number of lot size:");
		double numberOfLotSize = scan.nextDouble();
		return numberOfLotSize;
	}
	private double getNumberOfBathroom() {
		System.out.println("Please choice a number of bathroom between 1 to 4:");
		double numberOfBathroom = scan.nextDouble();
		return numberOfBathroom;
	}
	private double getNumberOfBedroom() {
		System.out.println("Please choice a number of bedrooms between 1 to 4:");
		double numberOfBedroom = scan.nextDouble();
		return numberOfBedroom;
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


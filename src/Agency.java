import java.util.ArrayList;
import java.util.Scanner;
public class Agency
{
	private String agency;
	private ArrayList<RealEstateListing> realEstateListingArray = new ArrayList<RealEstateListing>();

	public Agency(String agency, String agencyFile){
		//***	Constructor reads its file into an ArrayList
		//*** Here is the code to read a file
		this.agency = agency; 
		Scanner scanAgencyFile = TextFileIO.createTextRead(agencyFile);
		readFile(scanAgencyFile);
		scanAgencyFile.close();
	}
	
	public void readFile(Scanner read)
	{	int numberOfListing = read.nextInt();
	for (int i = 1; i <= numberOfListing; i++){
		RealEstateListing other = new RealEstateListing();
		other.readRealEstateListing(read);
		realEstateListingArray.add(other);
		}		
	}
	
	public ArrayList<RealEstateListing> jurisdiction(String location){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (int i = 0; i < 20; i++){
			if (this.realEstateListingArray.get(i).getStyle().equalsIgnoreCase(location)){
				ans.add(this.realEstateListingArray.get(i));
			}
		}
		return  ans;
	}	
	public ArrayList<RealEstateListing> distance(int distanceRange){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		switch (distanceRange){
		case 1: 
			for (int i = 0; i < 20; i++){
				if (this.realEstateListingArray.get(i).getDistance() < 5)			
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 2:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getDistance() >= 5) &&(this.realEstateListingArray.get(i).getDistance() < 10))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 3: 
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getDistance() >= 10) &&(this.realEstateListingArray.get(i).getDistance() < 15))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
	
		case 4: 
			for (int i = 0; i < 20; i++){
				if (this.realEstateListingArray.get(i).getDistance() >= 15)			
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		default: break;
		}
		return ans;
	}

	public String toString(){
		String ans = "";
		for (RealEstateListing other : realEstateListingArray){
			ans = other.toString();
		}
		return ans;
	}

}


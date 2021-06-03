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
	
	public ArrayList<RealEstateListing> price(int priceRange){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		switch (priceRange){
		case 1: 
			for (int i = 0; i < 20; i++){
				if (this.realEstateListingArray.get(i).getPrice() < 100)			
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 2:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getPrice() >= 100) &&(this.realEstateListingArray.get(i).getPrice() < 150))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 3: 
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getPrice() >= 150) &&(this.realEstateListingArray.get(i).getPrice() < 200))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 4:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getPrice() >= 200)&&(this.realEstateListingArray.get(i).getPrice() < 300))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 5:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getPrice() >= 300)&&(this.realEstateListingArray.get(i).getPrice() < 400))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 6: 
			for (int i = 0; i < 20; i++){
				if (this.realEstateListingArray.get(i).getPrice() >= 400)			
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		default: break;
		}
		return ans;
	}
	public ArrayList<RealEstateListing> age(int ageRange){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		switch (ageRange){
		case 1: 
			for (int i = 0; i < 20; i++){
				if (this.realEstateListingArray.get(i).getAge() <= 5)			
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 2:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getAge() > 5) &&(this.realEstateListingArray.get(i).getAge() <= 10))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 3: 
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getAge() > 10) &&(this.realEstateListingArray.get(i).getAge() <= 15))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		case 4:
			for (int i = 0; i < 20; i++){
				if ((this.realEstateListingArray.get(i).getAge() >= 15))				
					ans.add(this.realEstateListingArray.get(i));
			}
			break;
		default: break;
		}
		return ans;
	}
	public ArrayList<RealEstateListing> lotSize(double numberOfLotSize){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (int i = 0; i < 20; i++){
			if (this.realEstateListingArray.get(i).getLotSize() == numberOfLotSize){				
				ans.add(this.realEstateListingArray.get(i));	
			}
		}
		return ans;
	}
	public ArrayList<RealEstateListing> bedroom(double numberOfBedroom){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (int i = 0; i < 20; i++){
			if (this.realEstateListingArray.get(i).getNumberOfBed() == numberOfBedroom){				
				ans.add(this.realEstateListingArray.get(i));	
			}
		}
		return ans;
	}
	public ArrayList<RealEstateListing> bathroom(double numberOfBathroom){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (int i = 0; i < 20; i++){
			if (this.realEstateListingArray.get(i).getNumberOfBath() == numberOfBathroom){				
				ans.add(this.realEstateListingArray.get(i));	
			}
		}
		return ans;
	}	
	public ArrayList<RealEstateListing> style(String desiredStyle){
		ArrayList<RealEstateListing> ans = new ArrayList<RealEstateListing>();
		for (int i = 0; i < 20; i++){
			//System.out.println(this.realEstateListingArray.get(i).getStyle());
			//System.out.println(desiredStyle);
			if (this.realEstateListingArray.get(i).getStyle().equalsIgnoreCase(desiredStyle)){

				ans.add(this.realEstateListingArray.get(i));	
				//System.out.println(realEstateListingArray.get(i));
			}
		}
		return  ans;
	}	
	
	public String toString(){
		String ans = "";
		for (RealEstateListing other : realEstateListingArray){
			ans = other.toString();
		}
		return ans;
	}

}


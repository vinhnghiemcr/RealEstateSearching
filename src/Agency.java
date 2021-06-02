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
		

	public String toString(){
		String ans = "";
		for (RealEstateListing other : realEstateListingArray){
			ans = other.toString();
		}
		return ans;
	}

}


import java.util.Scanner;

public class RealEstateListing{
	//variables hold value of the style, jurisdiction, age, number of bed, number of bathroom, lot size in square acre, price and distance to downtown
	private String style, jurisdiction;
	private int age ;
	private double numberOfBed, numberOfBath, lotSize, price, distance;
       
	//readRealEstateListing() takes a scanner object as a parameter
	//It will read values from the scanner object and assign them to the corresponding variables
	public void readRealEstateListing(Scanner read)
	{	read.nextLine();
		read.nextLine();
		style = read.nextLine();
		
		numberOfBed = read.nextDouble();
		numberOfBath = read.nextDouble();
		lotSize = read.nextDouble();
		age = read.nextInt();
		price = read.nextDouble();
		distance = read.nextDouble();
		jurisdiction = read.next();
				
	}
	
	//Print out the RealEstateListing object
	public String toString()
	{	String format = "%-20s%-25s%-20s%-20s%n";
	System.out.printf(format,"Style: " + style, "Bedrooms: "+ numberOfBed, "Bathrooms: "+ numberOfBath, "Lot Size: "+ lotSize + " Square acre");
	System.out.printf(format, "Age: " + age, "Price: $" + (price*1000), "Distance: "+ distance, "Jurisdiction: " + jurisdiction );
	System.out.println("");
		return "" ;
	}

	public String getStyle() {
		return this.style;
	}
	public String getJurisdiction(){
		return this.jurisdiction;
	}
	public int getAge(){
		return this.age;
	}
	public double getNumberOfBed(){
		return this.numberOfBed;
	}
	public double getNumberOfBath(){
		return this.numberOfBath;
	}
	public double getLotSize(){
		return this.lotSize;
	}
	public double getPrice(){
		return this.price;
	}
	public double getDistance(){
		return this.distance;
	}
}
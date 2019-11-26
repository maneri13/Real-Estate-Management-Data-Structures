
/**
 * @author Hashsham Maneri
 * The House class is a child of the RealEstate class and has an additional Boolean property:
 * hasLawn = indicates whether a house a lawn or not.
 * Since the hasLawn property is not currently used,
 * The class also has 2 constructors with & without the hasLawn property
 */
public class House extends RealEstate{
	private boolean hasLawn;		

	public House( int noOfBedroom, int noOfBathroom, int pricePerMonth, boolean hasLawn, int id) {
		super(noOfBedroom, noOfBathroom, pricePerMonth);
		this.setId(id);
		this.hasLawn = hasLawn;
	}
	
	public House( int noOfBedroom, int noOfBathroom, int pricePerMonth, int id) {
		super(noOfBedroom, noOfBathroom, pricePerMonth);
		this.setId(id);
	}

	public boolean isHasLawn() {
		return hasLawn;
	}

	
	public String toString() {
		return String.valueOf("ID: " + getId() + " ") + String.valueOf("No of Room(s): " + getNoOfBedroom() + " "
				+ String.valueOf("No of Bathroom(s): " + getNoOfBathroom() + " ")
				+ String.valueOf("Monthly Payment: " + getPricePerMonth() + "\n "));
	}

}

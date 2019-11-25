
/**
 * @author Hashsham Maneri
 * The House class is a child of the RealEstate class and has an additional properties:
 * Boolean lift = indicates whether an apartment has a lift or not.
 * Int buildingFloors = indicates the total number of floors in apartment building
 * Int appartmentFloor = indicates the floor on which the apartment is located.
 */


public class Apartment extends RealEstate {
	private boolean lift;
	private int buildingFloors, apartmentFloor;

	public Apartment(int noOfBedroom, int noOfBathroom, int pricePerMonth, boolean isLift, int floors,
			int apartmentFloor, int id) {
		super(noOfBedroom, noOfBathroom, pricePerMonth);
		this.lift = isLift;
		this.buildingFloors = floors;
		this.apartmentFloor = apartmentFloor;
		setId(id);
	}

	public boolean lift() {
		return lift;
	}


	public int getFloors() {
		return buildingFloors;
	}


	public String toString() {
		return String.valueOf("ID: " + getId() + " ") + String.valueOf("No of Room(s): " + getNoOfBedroom() + " "
				+ String.valueOf("No of Bathroom(s): " + getNoOfBathroom() + " ")
				+ String.valueOf("Building Floors: " + buildingFloors + " ")
				+ String.valueOf("Appartment Floor: " + apartmentFloor + "  ")
				+ String.valueOf("Monthly Payment: " + getPricePerMonth() + "\n "));
	}
}

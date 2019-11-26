
/**
 * @author Hashsham Maneri An abstract class which contains all properties
 *         common to different types of Real Estate such as Houses and
 *         Appartments.
 */
public abstract class RealEstate implements Comparable {
	private int noOfBedroom; // All properties are private for encapsulation
	private int noOfBathroom;
	private int pricePerMonth;
	private int id;

	public RealEstate(int noOfBedroom, int noOfBathroom, int pricePerMonth) {

		this.noOfBedroom = noOfBedroom;
		this.noOfBathroom = noOfBathroom;
		this.pricePerMonth = pricePerMonth;
	}

	public int compareTo(Object o) {
		RealEstate r2 = (RealEstate) o;
		return ((Comparable) pricePerMonth).compareTo(r2.pricePerMonth);
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public int getNoOfBedroom() {
		return noOfBedroom;
	}

	public void setNoOfBedroom(int noOfBedroom) {
		this.noOfBedroom = noOfBedroom;
	}

	public int getNoOfBathroom() {
		return noOfBathroom;
	}

	public void setNoOfBathroom(int noOfBathroom) {
		this.noOfBathroom = noOfBathroom;
	}

	public float getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(int pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

}

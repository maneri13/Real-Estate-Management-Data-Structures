
/**
 * @author Hashsham Maneri
 * 
 */
public class RealEstateManagementSystem implements IManagementSystem {
	private LinkedList realEstates = new LinkedList();
	private LinkedList clients = new LinkedList();
	private PriorityQueue visits = new PriorityQueue();
	private int realEstateId = 0;
	private int clientId = 0;

	@Override
	public int addNewHouse(int bedrooms, int bathrooms, int price) {
		realEstates.addFirst(new House(bedrooms, bathrooms, price, realEstateId++));
		return realEstateId;
	}

	@Override
	public int addNewApartment(int bedrooms, int bathrooms, int price, boolean lift, int apartmentFloor,
			int buildingFloors) {
		realEstates.addFirst(
				new Apartment(bedrooms, bathrooms, price, lift, buildingFloors, apartmentFloor, realEstateId++));
		return realEstateId;
	}

	@Override
	public int addRegularClient(String name, String emailAddress) {
		clients.addFirst(new Client(name, emailAddress, clientId++));
		return Client.getId();
	}

	@Override
	public int addVIPClient(String name, String emailAddress) {
		clients.addFirst(new VipClient(name, emailAddress, clientId++));
		return Client.getId();
	}

	@Override
	public void printHouses() {

		for (int i = 0; i < realEstates.size(); i++) {
			if (((RealEstate) realEstates.get(i)) instanceof House) {
				System.out.println("Houses: " + realEstates.get(i).toString());
			}
		}
	}

	@Override
	public void printApartments() {

		for (int i = 0; i < realEstates.size(); i++) {
			if ((RealEstate) realEstates.get(i) instanceof Apartment) {
				System.out.println("Apartments: " + realEstates.get(i).toString());
			}
		}

	}

	@Override
	public void printRegularClients() {
		for (int i = 0; i < clients.size(); i++) {
			if (!(clients.get(i) instanceof VipClient)) {
				System.out.println("Regular Clients: " + clients.get(i).toString());
			}

		}

	}

	@Override
	public void printVIPClient() {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i) instanceof VipClient) {
				System.out.println("VIP Clients: " + clients.get(i).toString());
			}

		}

	}

	@Override
	public void searchOnPrice(int minPrice, int maxPrice) {
		for (int i = 0; i < realEstates.size(); i++) {
			RealEstate temp = RealEstate.class.cast(realEstates.get(i));
			if (temp.getPricePerMonth() >= minPrice && temp.getPricePerMonth() <= maxPrice) {
				System.out.println(realEstates.get(i).toString());
			}
		}

	}

	@Override
	public void searchOnBedroomsAndPrice(int minBedrooms, int maxPrice) {
		for (int i = 0; i < realEstates.size(); i++) {
			RealEstate temp = RealEstate.class.cast(realEstates.get(i));
			if (temp.getNoOfBedroom() >= minBedrooms && temp.getPricePerMonth() <= maxPrice) {
				System.out.println(realEstates.get(i).toString());
			}
		}

	}

	@Override
	public void requestVisit(int client, int property) {
		Object clientObject = clients.get(client - 1);
		if (VipClient.class.isInstance(clientObject)) {
			visits.push(new Visit(property, client), property+1000);
		} else {
			visits.push(new Visit(property, client), property+2000);
		}

	}

	@Override
	public void organizeVisits() {
		int counter = 1, id = -1;
		for (int i = visits.size() -1 ; i >= 0 ; i--) {
			Visit visit = Visit.class.cast(PriorityQueue.PriorityPair.class.cast(visits.get(i)).getElement());
			int priority = (int)PriorityQueue.PriorityPair.class.cast(visits.get(i)).getPriority();
			if (id != visit.getRealEstateId()) {
				id = visit.getRealEstateId();
				counter = 1;
			}
			else {
				counter++;
				if (counter == 5) {
					System.out.println("A visit is being arranged for realEstate ID: " + id );
					counter = 1;
					visits.pop();
					visits.pop();
					visits.pop();
					visits.pop();
					visits.pop();
				}
			}
			System.out.println(priority);
			System.out.println(counter);
		}
		
	}

}

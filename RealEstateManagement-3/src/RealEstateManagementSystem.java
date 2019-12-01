
/**
 * @author Hashsham Maneri
 * 1. Clean up code specially casting and instanceof code
 * 2. Maybe put visits structure in RealEstate class to make things simpler
 * 3. Instead of using key while pushing, find a way to use compareto method in client class(maybe boolean method to check class type)
 * 4. Check chapter 14 of practicum pdf for coding standards
 */
public class RealEstateManagementSystem implements IManagementSystem {
	//private LinkedList realEstates = new LinkedList();
	private CircularVector realEstates = new CircularVector();
	//private LinkedList clients = new LinkedList();
	private CircularVector clients = new CircularVector();
	private int realEstateId = 0;
	private int clientId = 0;

	@Override
	public int addNewHouse(int bedrooms, int bathrooms, int price) {
		realEstates.AddLast(new House(bedrooms, bedrooms, price, realEstateId++));
		return realEstateId;
	}

	@Override
	public int addNewApartment(int bedrooms, int bathrooms, int price, boolean lift, int apartmentFloor,
			int buildingFloors) {
		realEstates.AddLast(new Apartment(bedrooms, bathrooms, price, lift, buildingFloors, apartmentFloor, realEstateId++));
		return realEstateId;
	}

	@Override
	public int addRegularClient(String name, String emailAddress) {
		//clients.addFirst(new Client(name, emailAddress, clientId++));
		clients.AddLast(new Client(name, emailAddress, clientId++));
		return Client.getId();
	}

	@Override
	public int addVIPClient(String name, String emailAddress) {
		clients.AddLast(new VipClient(name, emailAddress, clientId++));
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
		RealEstate realEstate = (RealEstate)realEstates.get(property-1);		
		
		  Object clientObject = clients.get(client - 1); 
		  if (clientObject instanceof VipClient) { 
			  realEstate.visits.push(client, 2); } else
		  { realEstate.visits.push(client, 1); }
		  
			realEstate.setVisitCounter(realEstate.getVisitCounter() + 1);		 
		
		
	}

	@Override
	public void organizeVisits() {
		/*
		 * int counter = 1, id = -1; for (int i = visits.size() -1 ; i >= 0 ; i--) {
		 * Visit visit =
		 * Visit.class.cast(PriorityQueue.PriorityPair.class.cast(visits.get(i)).
		 * getElement()); int priority =
		 * (int)PriorityQueue.PriorityPair.class.cast(visits.get(i)).getPriority(); if
		 * (id != visit.getRealEstateId()) { id = visit.getRealEstateId(); counter = 1;
		 * } else { counter++; if (counter == 5) {
		 * System.out.println("A visit is being arranged for realEstate ID: " + id );
		 * counter = 1; visits.pop(); visits.pop(); visits.pop(); visits.pop();
		 * visits.pop(); } } System.out.println(priority); System.out.println(counter);
		 * }
		 */
		for (int i = 0; i < realEstates.size(); i++) {

			RealEstate realEstate = (RealEstate)realEstates.get(i);
			if (realEstate.getVisitCounter()>= 5) {
				int noOfVisits = (int)(realEstate.getVisitCounter() / 5); 
				for (int j = 0; j < noOfVisits; j++) {
					realEstate.visits.pop();
					realEstate.visits.pop();
					realEstate.visits.pop();
					realEstate.visits.pop();
					realEstate.visits.pop();
					System.out.println("A visit has been organized at RealEstate ID: " + realEstate.getId());
				}
			}
			
		}
	}

}

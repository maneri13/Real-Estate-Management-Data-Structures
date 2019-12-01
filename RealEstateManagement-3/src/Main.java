
public class Main {

	public static void main(String[] args) {
		RealEstateManagementSystem rems = new RealEstateManagementSystem();
		System.out.println(rems.addNewHouse(2, 3, 1450));
		System.out.println(rems.addNewHouse(2, 3, 1450));
		System.out.println(rems.addNewApartment(1, 1, 650, false, 1, 2));
		//rems.printHouses();
		//rems.printApartments();
		rems.addRegularClient("Hashsham", "abcd@example.com");
		rems.addVIPClient("Sample", "asd@u2.com");
		rems.addVIPClient("Sample3", "asd@u2.com");
		rems.addVIPClient("Sample3", "asd@u2.com");
		rems.addVIPClient("Sample3", "asd@u2.com");
		rems.addVIPClient("Sample3", "asd@u2.com");
		//rems.printRegularClients();
		//rems.printVIPClient();
		rems.requestVisit(1, 2);
		//rems.requestVisit(1, 1);
		rems.requestVisit(1, 2);
		rems.requestVisit(5, 2);
		rems.requestVisit(1, 2);
		rems.requestVisit(4, 2);
		rems.requestVisit(3, 2);
		rems.requestVisit(2, 2);
		//rems.requestVisit(3, 2);
		rems.requestVisit(3, 3);
		rems.organizeVisits();

	}

}

public class Client implements Comparable{

	private String name;
	private String Address;
	private static int id ;


	public Client(String name, String address, int id) {
		this.name = name;
		this.Address = address;
		this.id = id;

	}


	public static int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String toString() {

		return "ID: " + id + " Name: " + name + " Address: " + Address;
	}

	@Override
	public int compareTo(Object o) {
		Client c2 = (Client) o;
		return ((Comparable)id).compareTo(c2.id);
	}

}

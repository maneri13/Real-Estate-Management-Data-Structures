public class Visit implements Comparable<Visit> {
	private int realEstateId, clientId;

	public Visit(int realEstateId, int clientId) {
		this.realEstateId = realEstateId;
		this.clientId = clientId;
	}

	public int getRealEstateId() {
		return realEstateId;
	}


	public int getClientId() {
		return clientId;
	}


	@Override
	public int compareTo(Visit o) {
		if (this.getClientId() > o.getClientId()) {
			return 1;
		} else if (this.getClientId() < o.getClientId()) {
			return 0;
		}
		return -1;
	}
	
	public String toString() {
		return realEstateId + " " + clientId;
	}

}

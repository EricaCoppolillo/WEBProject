package model;

public class StoreAddress extends Address{

	private String address;
	
	public StoreAddress() {
		this.address = "Ritiro a mano in un qualsiasi dei nostri store";
	}
	
	@Override
	public String toString() {
		return this.address;
	}
}

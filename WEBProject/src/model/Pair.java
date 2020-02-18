package model;

public class Pair {
	
	public int idProduct;
	public int sumNumber;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getSumNumber() {
		return sumNumber;
	}
	public void setSumNumber(int sumNumber) {
		this.sumNumber = sumNumber;
	}
	public Pair(int idProduct, int sumNumber) {
		super();
		this.idProduct = idProduct;
		this.sumNumber = sumNumber;
	}
	
	
	
}

package persistence;

import java.util.ArrayList;

import model.*;
import persistence.dao.AmministratoreDao;
import persistence.dao.CategoryDao;
import persistence.dao.ProductDao;
import persistence.dao.jdbc.AmministratoreDaoJDBC;
import persistence.dao.jdbc.CategoryDaoJDBC;
import persistence.dao.jdbc.ProductDaoJDBC;

public class DBManager {
	
	private static DBManager instance;
	private static  DataSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource = new DataSource("jdbc:postgresql://manny.db.elephantsql.com:5432/ndbzhnht","ndbzhnht","orWOykJIylSTUE8z1z2yXSFfvAn1jyIH");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	private ArrayList<Utente> utenti;
	private ArrayList<Amministratore> amministratori;
	
	private DBManager() {
		utenti = new ArrayList<Utente>();
		amministratori = new ArrayList<Amministratore>();
	}
	
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		return instance;
	} 
	
	public void registraUtente(Utente u) {
		if(u!=null)
			utenti.add(u);
	}
	
	public boolean utenteRegistrato(Utente utente) {
		for(Utente u : utenti) {
			if(utente.getUsername().equals(u.getUsername()) && utente.getPassword().equals(u.getPassword()))
				return true;
		}
		return false;
	}
	
	public Amministratore getAmministratore(String id, String password) {
		return getAmministratoreDao().findAdmin(id, password);
	}
	
	public AmministratoreDao getAmministratoreDao() {
		return new AmministratoreDaoJDBC(dataSource);
		
	}

	public ProductDao getProductDao(){
		return new ProductDaoJDBC(this.dataSource);
	}

	public CategoryDao getCategoryDao(){
		return new CategoryDaoJDBC(this.dataSource);
	}

	public void stampaUtenti() {
		for(Utente u : utenti) {
			System.out.println(u.getUsername() + " " + u.getPassword());
		}
	}

	public Category getCategory(int categoryId){
		return getCategoryDao().findCategory(categoryId);
	}

	public Product getProduct(int productId){
		return getProductDao().findProduct(productId);
	}

	public ArrayList<Product> getProducts(int start, int end, int categoryId){
		return getProductDao().findProducts(start, end, categoryId);
	}

	public ArrayList<Product> getProductsByManufacturer(int start, int end, String manufacturer){
		return getProductDao().findProductsByManufacturer(start, end, manufacturer);
	}

	public ArrayList<Manufacturer> getManufacturers(){ return getProductDao().findManufacturers(); }

	public ArrayList<Product> getProductsByPriceRange(int start, int end, float lowerBound, float upperBound){
		return getProductDao().findProductsByPriceRange(start, end, lowerBound, upperBound);
	}

	public ArrayList<Review> getLastReviews(int productId){ return getProductDao().findLastReviews(productId); }

	public int getProductsCount(){ return getProductDao().findProductsNumber(); }
}

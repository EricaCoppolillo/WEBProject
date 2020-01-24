package persistence;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import model.Administrator;
import model.Category;
import model.Manufacturer;
import model.Product;
import model.Review;
import model.User;
import persistence.dao.AdministratorDao;
import persistence.dao.CartDao;
import persistence.dao.CategoryDao;
import persistence.dao.ProductDao;
import persistence.dao.ReviewDao;
import persistence.dao.UserDao;
import persistence.dao.jdbc.AdministratorDaoJDBC;
import persistence.dao.jdbc.CartDaoJDBC;
import persistence.dao.jdbc.CategoryDaoJDBC;
import persistence.dao.jdbc.ProductDaoJDBC;
import persistence.dao.jdbc.ReviewDaoJDBC;
import persistence.dao.jdbc.UserDaoJDBC;

public class DBManager {
	
	private static DBManager instance;
	private static DataSource dataSource;
	
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
	

	private DBManager() {}
	
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		return instance;
	} 
	
	public User getUser(String username) {
		return getUserDao().findUser(username);
	}
	
	public User getUserByEmail(String email) {
		return getUserDao().findUserByEmail(email);
	}
	
	public UserDao getUserDao() {
		return new UserDaoJDBC(dataSource);
	}
	
	public String getSecurityQuestion(String username) {
		return getUserDao().findSecurityQuestion(username);
	}
	
	public String getPassword(String username, String answer) {
		return getUserDao().findPassword(username, answer);
	}
	
	public void registerUser(User user) {
		getUserDao().registerUser(user);
	}
	
	public Administrator getAdministrator(String id, String password) {
		return getAdministratorDao().findAdmin(id, password);
	}
	
	public AdministratorDao getAdministratorDao() {
		return new AdministratorDaoJDBC(dataSource);
	}

	public ProductDao getProductDao(){
		return new ProductDaoJDBC(this.dataSource);
	}

	public CategoryDao getCategoryDao(){
		return new CategoryDaoJDBC(this.dataSource);
	}

	public Category getCategory(int categoryId){
		return getCategoryDao().findCategory(categoryId);
	}

	public Product getProduct(int productId){
		return getProductDao().findProduct(productId);
	}

	public ArrayList<Product> getProducts(int categoryId, int page, String manufacturer, float lowerBound,
										  float upperBound, int orderType, String keyword){
		return getProductDao().findProducts(categoryId, page, manufacturer, lowerBound, upperBound, orderType, keyword);
	}

	public int getProductsCount(int categoryId, String manufacturer, float lowerBound, float upperBound, String keyword){
		return getProductDao().findProductsNumber(categoryId, manufacturer, lowerBound, upperBound, keyword);
	}

	public ArrayList<Review> getLastReviews(int productId, int offset){
		return getProductDao().findLastReviews(productId, offset);
	}

	public ArrayList<Manufacturer> getManufacturers(int categoryId, String keyword){
		return getProductDao().findManufacturers(categoryId, keyword);
	}

	public void insertProduct(Product p){ getProductDao().saveProduct(p);}
	
	public void insertIntoCart(int idUser, int idProduct, int quantity) {
		getCartDao().insert(idUser, idProduct, quantity);
	}
	
	public void updateQuantity(int idUser, int idProduct, int quantity) {
		getCartDao().updateQuantity(idUser, idProduct, quantity);
	}

	public ArrayList<Product> getCartProducts(int idUser) {
		return getCartDao().getCartProducts(idUser);
	}
	
	public float getTotalPrice(ArrayList<Product> products) {
		float sum = 0;
		for(Product p : products) {
			sum += p.getPricePerQuantity();
		}
		return sum;
	}
	
	public void deleteCartProduct(int idUser, int idProduct) {
		getCartDao().delete(idUser, idProduct);
	}
	
	public CartDao getCartDao() {
		return new CartDaoJDBC(dataSource);
	}
	
	public ReviewDao getReviewDao() {
		return new ReviewDaoJDBC(this.dataSource);
	}
	
	public void postReview(Review r) { getReviewDao().postReview(r);}
	
	public void updateProduct(Product p){ getProductDao().updateProduct(p);}
	
	public void deleteProduct(int id) {getProductDao().deleteProduct(id);}
	
	public ArrayList<Product> getProductPurchaseForUser(int idUser) {return getProductDao().getProductPurchaseForUser(idUser);}
	public boolean purchasedProduct(int usrId, int productID) {return getProductDao().purchasedBy(usrId, productID);}
}

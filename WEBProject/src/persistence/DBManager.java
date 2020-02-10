package persistence;

import java.sql.Date;
import java.util.ArrayList;

import model.*;
import persistence.dao.*;
import persistence.dao.jdbc.*;

public class DBManager {
	
	private static DBManager instance;
	private static DataSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource = new DataSource("jdbc:postgresql://rogue.db.elephantsql.com:5432/xgnounaz","xgnounaz","qM-VMf9EWX3zTH6uPNRAZL2nBJOXX7CG");
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
	
	public User getUser(String username, String password) {
		return getUserDao().findUser(username, password);
	}
	
	public User getUserByEmail(String email) {
		return getUserDao().findUserByEmail(email);
	}
	
	public User getUserByUsername(String username) {
		return getUserDao().findUserByUsername(username);
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
	
	public int getId(String username) {
		return getUserDao().findId(username);
	}
	
	public void registerUser(User user) {
		getUserDao().registerUser(user);
	}

	public void saveGuestUser(User user) {
		getUserDao().saveUser(user);
	}
	
	public void updatePassword(String username, String newPassword) {
		getUserDao().updatePassword(username, newPassword);
	}
	
	public Administrator getAdministrator(int id, String password) {
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

	public PurchaseDao getPurchaseDao(){ return new PurchaseDaoJDBC(this.dataSource);}

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
	
	public boolean isInCart(int idUser, int idProduct) {
		return getCartDao().isInCart(idUser, idProduct);
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

	public void deleteAllCartProducts(int userId){ getCartDao().deleteAll(userId);}
	
	public void deleteCartProduct(int idUser, int idProduct) {
		getCartDao().delete(idUser, idProduct);
	}
	
	public CartDao getCartDao() {
		return new CartDaoJDBC(dataSource);
	}
	
	public ReviewDao getReviewDao() {
		return new ReviewDaoJDBC(dataSource);
	}
	
	public void postReview(Review r) { getReviewDao().postReview(r);}
	
	public CommentDao getCommentDao() {
		return new CommentDaoJDBC(dataSource);
	}
	
	public void saveComment(int idProduct, String content) {
		getCommentDao().saveComment(idProduct, content);
	}

	public ArrayList<Comment> getComments(int productId) {
		return getCommentDao().getCommentForProduct(productId);
	}
	
	private AssistanceDao getAssistanceDao() {
		return new AssistanceDaoJDBC(dataSource);
	}
	
	public void saveAssistanceQuestion(int idUser, String username, String question) {
		getAssistanceDao().saveQuestion(idUser, username, question);
	}
	
	public ArrayList<Comment> getAssistanceQuestions() {
		return getAssistanceDao().getAllQuestions();
	}
	
	public ArrayList<Comment> getUserAssistanceComments(int idUser) {
		return getAssistanceDao().getComments(idUser);
	}
	
	public void saveAssistanceAnswer(int idAdmin, int idUser, String answer) {
		getAssistanceDao().saveAnswer(idAdmin, idUser, answer);
	}
	
	public void removeUserQuestion(int idUser, String content) {
		getAssistanceDao().deleteUserQuestion(idUser, content);
	}
	
	public void deleteComments(int idUser) {
		getAssistanceDao().deleteComments(idUser);
	}
	
	public void updateProduct(Product p){ getProductDao().updateProduct(p);}
	
	public void deleteProduct(int id) {getProductDao().deleteProduct(id);}
	
	public ArrayList<Product> getProductPurchaseForUser(int idUser) {return getPurchaseDao().getProductPurchaseForUser(idUser);}
	public boolean purchasedProduct(int usrId, int productID) {return getProductDao().purchasedBy(usrId, productID);}

	public ArrayList<String> getMapCoords() {
		return getMapDao().getCoords();
	}
	
	public MapDao getMapDao() {
		return new MapDaoJDBC(dataSource);
	}

	public boolean insertPayment(float amount, String transactionCode){
		return getPurchaseDao().insertPayment(amount, transactionCode);
	}

	public boolean insertPurchase(int userId, int paymentId, String shipmentMode){
		return getPurchaseDao().insertPurchase(userId, paymentId, shipmentMode);
	}

	public Payment getPayment(String transactionCode){
		 return getPurchaseDao().findPayment(transactionCode);
	}

	public Purchase getPurchase(Payment payment){
		return getPurchaseDao().findPurchase(payment);
	}

	public boolean insertPurchaseProductAssociation(int quantity, int productId, int purchaseId){
		return getPurchaseDao().insertPurchaseProductAssociation(quantity, productId, purchaseId);
	}
	
	public boolean existsProduct(String model, String manufacturer)
	{
		return getProductDao().existsProduct(model, manufacturer);
	}
}

package persistence.dao.jdbc;

import model.*;
import persistence.DataSource;
import persistence.dao.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoJDBC implements ProductDao {

    private DataSource dataSource;
    private Connection connection;

    public ProductDaoJDBC(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Product findProduct(int productId) {
        Product product = null;

        try {
            connection = dataSource.getConnection();
            String query = "select product.id, product.model, product.manufacturer, product.price, product.specs, product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category where " +
                    "product.id = ? and product.category = category.id " +
                    "group by product.id, category.id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                Category category;
                category = new Category(result.getInt("cid"), result.getString("name"));
                product = new ProductProxy(productId, result.getString("model"), result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    @Override
    public ArrayList<Product> findProducts(int categoryId, int page, String manufacturer, float lowerBound,
                                           float upperBound, int orderType, String keyword) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            connection = dataSource.getConnection();

            String query = "select product.id as pid, product.model, product.manufacturer, product.price, product.specs, " +
                    "product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category " +
                    "where product.category = category.id ";

            if(categoryId != -1)
                query += "and category.id = ? ";

            if(!manufacturer.equals(""))
                query += "and LOWER(product.manufacturer) = ? ";

            if(!(lowerBound < 0 || upperBound < 0))
                query += "and product.price >= ? and product.price <= ? ";

            if(!keyword.equals(""))
                query += "and lower(concat(product.manufacturer, ' ', product.model)) similar to ? ";



            String orderBy;

            switch (orderType){
                case 1:
                    orderBy = "product.price ASC";
                    break;
                case 2:
                    orderBy = "product.price DESC";
                    break;
                default:
                    orderBy = "avstars DESC NULLS LAST";
                    break;
            }

            query += " group by product.id, category.id order by " + orderBy + " limit 9 offset ?";

            PreparedStatement statement = connection.prepareStatement(query);
            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

            if(!manufacturer.equals("")){
                statement.setString(parameterIndex, manufacturer.toLowerCase());
                parameterIndex++;
            }

            if(!(lowerBound < 0 || upperBound < 0)){
                statement.setFloat(parameterIndex, lowerBound);
                parameterIndex++;
                statement.setFloat(parameterIndex, upperBound);
                parameterIndex++;
            }

            if(!keyword.equals("")){
                statement.setString(parameterIndex, "%" + keyword.toLowerCase() + "%");
                parameterIndex++;
            }

            statement.setInt(parameterIndex, (page - 1) * 9);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Category category = new Category(result.getInt("cid"), result.getString("name"));
                Product product = new ProductProxy(result.getInt("pid"), result.getString("model"),
                        result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public int findProductsNumber(int categoryId, String manufacturer, float lowerBound, float upperBound,
                                  String keyword) {
        int count = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select count(*) as cp from product";

            String queryChars = " where";

            if(categoryId != -1) {
                query += queryChars + " product.category = ?";
                queryChars = " and";
            }

            if(!manufacturer.equals("")) {
                query += queryChars + " LOWER(product.manufacturer) = ?";
                queryChars = " and";
            }

            if(lowerBound > 0 && upperBound > 0) {
                query += queryChars + " and product.price >= ? and product.price <= ?";
                queryChars = " and";
            }

            if(!keyword.equals("")){
                query += queryChars + " lower(concat(product.manufacturer, ' ', product.model)) similar to ?";
                queryChars = " and";
            }


            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

            if(!manufacturer.equals("")){
                statement.setString(parameterIndex, manufacturer.toLowerCase());
                parameterIndex++;
            }

            if(lowerBound > 0 && upperBound > 0){
                statement.setFloat(parameterIndex, lowerBound);
                parameterIndex++;
                statement.setFloat(parameterIndex, upperBound);
                parameterIndex++;
            }

            if(!keyword.equals("")){
                statement.setString(parameterIndex, "%" + keyword.toLowerCase() + "%");
                parameterIndex++;
            }

            ResultSet result = statement.executeQuery();
            if(result.next()) {
                count = result.getInt("cp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    @Override
    public ArrayList<Manufacturer> findManufacturers(int categoryId, String keyword) {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            String query = "select distinct(manufacturer), count(id) as cid from product";

            String queryChars = " where";

            if(categoryId != -1) {
                query += queryChars + " product.category = ?";
                queryChars = " and";
            }

            if(!keyword.equals("")){
                query += queryChars + " lower(concat(product.manufacturer, ' ', product.model)) similar to ?";
                queryChars = " and";
            }

            query += " group by manufacturer";

            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

            if(!keyword.equals("")){
                statement.setString(parameterIndex, "%" + keyword.toLowerCase() + "%");
                parameterIndex++;
            }

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                manufacturers.add(new Manufacturer(result.getString("manufacturer"),
                        result.getInt("cid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return manufacturers;
    }

    @Override
    public ArrayList<Review> findLastReviews(int productId, int offset) {
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String query = "select * from review, \"user\" where review.product = ? and review.author = \"user\".id " +
                    "order by " +
                    "review.id desc limit 5 offset ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            statement.setInt(2, offset * 5);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Review review = new Review(result.getInt(1), result.getString("title"),
                        result.getString("body"), result.getInt("stars"), productId, result.getString("username"));
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reviews;
    }

    @Override
    public void saveProduct(Product p) {
        try {
            connection = dataSource.getConnection();
            String query = "insert into product(model,manufacturer,price,specs,description,category,image) values(?,?,?,?,?,?,?)";
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setString(1, p.getModel());
            stat.setString(2, p.getManufacturer());
            stat.setFloat(3, p.getPrice());
            stat.setString(4, p.getSpecs());
            stat.setString(5, p.getDescription());
            stat.setInt(6, p.getCategory().getId());
            stat.setString(7, p.getImagePath());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void updateProduct(Product p) {
		 try {
	            connection = dataSource.getConnection();
	            String query = "update product set model=?,manufacturer=?,price=?,specs=?,description=?,category=?,image=? where id=?";
	            PreparedStatement stat = connection.prepareStatement(query);
	            stat.setString(1, p.getModel());
	            stat.setString(2, p.getManufacturer());
	            stat.setFloat(3, p.getPrice());
	            stat.setString(4, p.getSpecs());
	            stat.setString(5, p.getDescription());
	            stat.setInt(6, p.getCategory().getId());
	            stat.setString(7, p.getImagePath());
	            stat.setInt(8, p.getId());
	            stat.executeUpdate();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}

	@Override
	public void deleteProduct(int id) {
		 try {
	            connection = dataSource.getConnection();
	            String query = "delete from product where id = ?";
	            PreparedStatement stat = connection.prepareStatement(query);
	            stat.setInt(1, id);
	            stat.executeUpdate();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	@Override
	public ArrayList<Product> getProductPurchaseForUser(int idUser) {
		ArrayList<Product>products = new ArrayList<Product>();
		 try {
	            connection = dataSource.getConnection();
	            String query = "select *\n" + 
	            		"from product,\"purchaseProducts\",purchase,user\n" + 
	            		"where product.id = \"purchaseProducts\".product and purchase.id = \"purchaseProducts\".purchase and purchase.user=? ";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, idUser);
	            ResultSet result = statement.executeQuery();
	            while (result.next()) {
	            	Product product = new ProductProxy(result.getInt(1), result.getString("model"), result.getString("manufacturer"), result.getFloat("price"), result.getString("specs"), result.getString("description"), new Category(result.getString("category")),  0, result.getString("image"));
	                product.setDate(result.getDate("date"));
	                product.setShipment(result.getString("shipment"));
	            	products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 for(int i = 0; i<100; i++)
		{
			System.out.println(products.size());
		}
		return products;
	}
	@Override
	public boolean purchasedBy(int userID, int productId) {
		boolean purchased = false;
		try {
			connection = dataSource.getConnection();
			String query = "select * from \"purchaseProducts\", purchase where purchase.id = \"purchaseProducts\".purchase and \"purchaseProducts\".product = ? and purchase.user = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, productId);
			statement.setInt(2, userID);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				purchased = true;
				break;
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		return purchased;
	}
    
    
    
}

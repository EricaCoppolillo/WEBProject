package persistence.dao.jdbc;

import model.Category;
import persistence.DataSource;
import persistence.dao.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDaoJDBC implements CategoryDao {

    private DataSource dataSource;
    private Connection connection;

    public CategoryDaoJDBC(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Category findCategory(int categoryId) {
        Category category = null;

        try {
            this.connection = this.dataSource.getConnection();
            String query = "select * from \"categoria\" where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, categoryId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                category = new Category(categoryId, result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return category;
    }

    @Override
    public ArrayList<Category> findCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            this.connection = this.dataSource.getConnection();
            String query = "select * from \"categoria\"";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                categories.add(new Category(result.getInt(0), result.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return categories;

    }
}

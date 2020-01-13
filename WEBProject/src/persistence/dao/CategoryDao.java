package persistence.dao;

import model.Category;

import java.util.ArrayList;

public interface CategoryDao {
    Category findCategory(int categoryId);
    ArrayList<Category> findCategories();
}

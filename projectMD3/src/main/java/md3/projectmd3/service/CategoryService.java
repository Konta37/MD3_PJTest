package md3.projectmd3.service;

import md3.projectmd3.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    List<Category> findByName(String name);
}

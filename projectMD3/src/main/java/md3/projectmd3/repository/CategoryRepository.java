package md3.projectmd3.repository;

import md3.projectmd3.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    List<Category> findByName(String name);
}

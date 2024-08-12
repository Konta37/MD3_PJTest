package md3.projectmd3.service.impl;

import md3.projectmd3.model.entity.Category;
import md3.projectmd3.repository.CategoryRepository;
import md3.projectmd3.repository.impl.CategoryRepositoryImpl;
import md3.projectmd3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepositoryImpl categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}

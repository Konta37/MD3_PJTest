package md3.projectmd3.repository.impl;

import md3.projectmd3.model.entity.Category;
import md3.projectmd3.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {

        Session session = sessionFactory.openSession();
        try{
            return session.createQuery("from Category",Category.class).list();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category findById(int id) {
//        Session session = sessionFactory.openSession();
//        try{
//            return session.createQuery("from Category where id = id");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Category where categoryName like :name", Category.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}

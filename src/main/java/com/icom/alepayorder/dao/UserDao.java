package com.icom.alepayorder.dao;

import com.icom.alepayorder.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public User getUserById(BigInteger id) {
//        User user = null;
//
//        try {
//            System.out.println(id);
//            Query query = entityManager.createNativeQuery("SELECT * FROM gate_schema.user WHERE id=11");
////            query.setParameter(":id", id);
//            user = (User) query.getSingleResult();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        return entityManager.find(User.class, id);
    }
}

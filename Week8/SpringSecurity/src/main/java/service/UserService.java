package service;

import model.Users;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    @Autowired
    private SessionFactory sessionFactory;

    public Users getUserByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Users where username = :username");
        query.setString("username", username);

        return (Users) query.uniqueResult();
    }
}

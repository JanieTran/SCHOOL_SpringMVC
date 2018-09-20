package service;

import model.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */
@Configuration
public class StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADD_STUDENT')")
    public void saveStudent(Student student){
        sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_GET_STUDENT')")
    public Student getStudent(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Student where id:id");
        query.setInteger("id", id);

        return (Student) query.uniqueResult();
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_GET_STUDENT')")
    public List<Student> getAllStudents(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Student");
        return query.list();
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_DEL_STUDENT')")
    public void deleteStudent(Student student){
        sessionFactory.getCurrentSession().delete(student);
    }


}

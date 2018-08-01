package clinic.service;

import clinic.entity.Lecturer;
import clinic.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import clinic.entity.School;

import java.util.List;

/**
 * Created by CoT on 10/13/17.
 */

@Transactional
public class PersonService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // New instances

    public void savePerson(Person person){
        sessionFactory.getCurrentSession().save(person);
    }

    public void saveLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().save(lecturer);
    }

    public void saveSchool(School school) {
        sessionFactory.getCurrentSession().save(school);
    }

    // Update db
    public void updateLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().update(lecturer);
    }

    // Delete instace
    public void deleteLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().delete(lecturer);
    }

    // Query
    public List<Lecturer> getAllLecturer() {
        return sessionFactory.getCurrentSession().createQuery("from Lecturer").list();
    }

    public Lecturer getLecturer(int id) {
        return (Lecturer) sessionFactory.getCurrentSession().get(Lecturer.class, id);
    }


}

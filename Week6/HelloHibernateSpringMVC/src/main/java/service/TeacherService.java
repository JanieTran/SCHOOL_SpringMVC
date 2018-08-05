package service;

import model.Teacher;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TeacherService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveTeacher(Teacher teacher) {
        sessionFactory.getCurrentSession().save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return sessionFactory.getCurrentSession().createQuery("from Teacher").list();
    }

    public List<Teacher> findTeachers(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Teacher s where s.name like :name");

        query.setString("name", "%"+name+"%");

        return query.list();
    }

    public void deleteTeacher(int id) {
        Teacher teacher = (Teacher) sessionFactory.getCurrentSession().get(Teacher.class, id);
        sessionFactory.getCurrentSession().delete(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        sessionFactory.getCurrentSession().update(teacher);
    }
    
}

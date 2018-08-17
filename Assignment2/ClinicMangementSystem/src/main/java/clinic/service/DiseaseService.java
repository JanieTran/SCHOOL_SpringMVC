package clinic.service;

import clinic.model.Disease;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DiseaseService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ====================================================================
    // CREATE
    // ====================================================================

    public void saveDisease(Disease disease) {
        sessionFactory.getCurrentSession().save(disease);
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Disease getDiseaseById(int id) {
        return (Disease) sessionFactory.getCurrentSession().get(Disease.class, id);
    }

    public List<Disease> getDiseaseByIcd(String icd) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Disease d where d.icd like :icd");
        query.setString("icd", "%" + icd + "%");

        return query.list();
    }

    public List<Disease> getAllDiseases() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Disease");
        return query.list();
    }

    public List<Disease> findDiseaseByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Disease d where d.name like :name");
        query.setString("name", "%" + name + "%");

        return query.list();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    public void updateDisease(Disease disease) {
        sessionFactory.getCurrentSession().update(disease);
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    public void deleteDisease(int id) {
        Disease disease = (Disease) sessionFactory.getCurrentSession().get(Disease.class, id);
        sessionFactory.getCurrentSession().delete(disease);
    }
}

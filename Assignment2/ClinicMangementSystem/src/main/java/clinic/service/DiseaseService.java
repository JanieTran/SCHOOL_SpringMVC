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
    private Session currentSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        currentSession = sessionFactory.getCurrentSession();
    }

    public void saveDisease(Disease disease) {
        currentSession.save(disease);
    }

    public Disease getDiseaseByIcd(String icd) {
        Query query = currentSession.createQuery("from Disease d where d.icd like :icd");
        query.setString("icd", icd);

        return (Disease) query.uniqueResult();
    }

    public List<Disease> getAllDiseases() {
        Query query = currentSession.createQuery("from Disease");
        return query.list();
    }

    public List<Disease> findDiseaseByName(String name) {
        Query query = currentSession.createQuery("from Disease d where d.name like :name");
        query.setString("name", "%" + name + "%");

        return query.list();
    }

    public void updateDisease(Disease disease) {
        currentSession.update(disease);
    }

    public void deleteDisease(String icd) {
        Disease disease = (Disease) currentSession.get(Disease.class, icd);
        currentSession.delete(disease);
    }
}

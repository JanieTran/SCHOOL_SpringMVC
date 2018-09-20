package clinic.service;

import clinic.model.PrescribedDrugs;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PrescribedDrugsService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<PrescribedDrugs> getAllPrescribedDrugs() {
        Query query = sessionFactory.getCurrentSession().createQuery("from PrescribedDrugs");
        return query.list();
    }

    public int countPrescribedDrugs() {
        String sql = "select count(drug) " +
                "from PrescribedDrugs ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return (int) query.uniqueResult();
    }
}

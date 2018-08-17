package clinic.service;

import clinic.model.Prescription;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PrescriptionService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ====================================================================
    // CREATE
    // ====================================================================

    public void savePrescription(Prescription prescription) {
        sessionFactory.getCurrentSession().save(prescription);
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Prescription getPrescriptionById(int id) {
        return (Prescription) sessionFactory.getCurrentSession().get(Prescription.class, id);
    }

    public List<Prescription> getAllPrescriptions() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription");
        return query.list();
    }

    public List<Prescription> findPrescriptionByDrug(String drugName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription where drugs like :drugName");
        query.setString("drugName", "%" + drugName + "%");

        return query.list();
    }

    public List getNumberOfDrugsPrescribed() {
        String sqlQuery = "select count(id) " +
                          "from Prescription " +
                          "group by drug";
        Query query = sessionFactory.getCurrentSession().createQuery(sqlQuery);

        return query.list();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    public void updatePrescription(Prescription prescription) {
        sessionFactory.getCurrentSession().update(prescription);
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    public void deletePrescription(int id) {
        Prescription prescription = (Prescription) sessionFactory.getCurrentSession().get(Prescription.class, id);
        sessionFactory.getCurrentSession().delete(prescription);
    }
}

package clinic.service;

import clinic.model.Visit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class VisitService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ====================================================================
    // CREATE
    // ====================================================================

    public void saveVisit(Visit visit) {
        sessionFactory.getCurrentSession().save(visit);
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Visit getVisitById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit where id:id");
        query.setInteger("id", id);

        return (Visit) query.uniqueResult();
    }

    public List<Visit> getAllVisits() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit");
        return query.list();
    }

    public List<Visit> findVisitByPatient(int patientId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit v where v.patient = :patientId");
        query.setInteger("patientId", patientId);

        return query.list();
    }

    public List<Visit> findVisitOnDate(String date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit where dateTime = :date");
        query.setString("date", date);

        return query.list();
    }

    public List<Visit> findVisitBeforeDate(String date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit where dateTime <= :date");
        query.setString("date", date);

        return query.list();
    }

    public List<Visit> findVisitAfterDate(String date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit where dateTime >= :date");
        query.setString("date", date);

        return query.list();
    }

    public List getVisitsPerDay() {
        String sqlQuery = "select count(patient) " +
                          "from Visit " +
                          "group by dateTime";
        Query query = sessionFactory.getCurrentSession().createQuery(sqlQuery);

        return query.list();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    public void updateVisit(Visit visit) {
        sessionFactory.getCurrentSession().update(visit);
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    public void deleteVisit(int id) {
        Visit visit = (Visit) sessionFactory.getCurrentSession().get(Visit.class, id);
        sessionFactory.getCurrentSession().delete(visit);
    }

}

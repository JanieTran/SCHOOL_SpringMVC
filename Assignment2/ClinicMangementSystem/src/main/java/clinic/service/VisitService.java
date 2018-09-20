package clinic.service;

import clinic.model.Disease;
import clinic.model.Patient;
import clinic.model.Prescription;
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

    public void addVisit(String body) {
        Visit visit = createVisit(body);

        saveVisit(visit);
    }

    private Visit createVisit(String body) {
        body = body.substring(1, body.length() - 1).trim();
        String[] bodyElements = body.split("\n");

        Visit visit = new Visit();

        for (String element : bodyElements) {
            element = element.replaceAll("\"", "");
            if (element.charAt(element.length() - 1) == ',')
                element = element.substring(0, element.length() - 1);

            String key = element.split(":")[0].trim();
            String val = element.split(":")[1].trim();

            switch (key) {
                case "patient":
                    Patient patient = (Patient) sessionFactory.getCurrentSession()
                            .get(Patient.class, Integer.parseInt(val));
                    visit.setPatient(patient);
                    break;

                case "disease":
                    Disease disease = (Disease) sessionFactory.getCurrentSession()
                            .get(Disease.class, Integer.parseInt(val));
                    visit.setDisease(disease);
                    break;

                case "problems":
                    visit.setProblems(new String[]{val});
                    break;

                case "prescription":
                    Prescription prescription = (Prescription) sessionFactory.getCurrentSession()
                            .get(Prescription.class, Integer.parseInt(val));
                    visit.setPrescription(prescription);
                    break;

                case "stringTime":
                    visit.setStringTime(val);
                    break;
            }
        }

        return visit;
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Visit getVisitById(int id) {
        return (Visit) sessionFactory.getCurrentSession().get(Visit.class, id);
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
        String sqlQuery = "select dateTime, count(id) " +
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

package clinic.service;

import clinic.model.Patient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PatientService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ====================================================================
    // CREATE
    // ====================================================================

    public void savePatient(Patient patient) {
        sessionFactory.getCurrentSession().save(patient);
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Patient getPatientById(int id) {
        return (Patient) sessionFactory.getCurrentSession().get(Patient.class, id);
    }

    public List<Patient> getAllPatients() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient");
        return query.list();
    }

    public List<Patient> findPatientByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.name like :name");
        query.setString("name", "%" + name + "%");

        return query.list();
    }

    public List<Patient> findPatientByBirthday(String birthday) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.birthday like :birthday");
        query.setString("birthday", "%" + birthday + "%");

        return query.list();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    public void updatePatient(Patient patient) {
        sessionFactory.getCurrentSession().update(patient);
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    public void deletePatient(int id) {
        Patient patient = (Patient) sessionFactory.getCurrentSession().get(Patient.class, id);
        sessionFactory.getCurrentSession().delete(patient);
    }
}

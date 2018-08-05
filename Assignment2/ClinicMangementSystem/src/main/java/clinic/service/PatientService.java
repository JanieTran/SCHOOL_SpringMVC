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
    private Session currentSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        currentSession = sessionFactory.getCurrentSession();
    }

    public void savePatient(Patient patient) {
        currentSession.save(patient);
    }

    public Patient getPatientById(int id) {
        Query query = currentSession.createQuery("from Patient where id:id");
        query.setInteger("id", id);

        return (Patient) query.uniqueResult();
    }

    public List<Patient> getAllPatients() {
        Query query = currentSession.createQuery("from Patient");
        return query.list();
    }

    public List<Patient> findPatientByName(String name) {
        Query query = currentSession.createQuery("from Patient p where p.name like :name");
        query.setString("name", "%" + name + "%");

        return query.list();
    }

    public void updatePatient(Patient patient) {
        currentSession.update(patient);
    }

    public void deletePatient(int id) {
        Patient patient = (Patient) currentSession.get(Patient.class, id);
        currentSession.delete(patient);
    }
}

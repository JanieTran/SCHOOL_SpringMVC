package clinic.service;

import clinic.model.Drug;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Transactional
@Service
public class DrugService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ====================================================================
    // CREATE
    // ====================================================================

    public void saveDrug(Drug drug) {
        sessionFactory.getCurrentSession().save(drug);
    }

    // ====================================================================
    // READ
    // ====================================================================

    public Drug getDrugById(int id) {
        return (Drug) sessionFactory.getCurrentSession().get(Drug.class, id);
    }

    public List<Drug> getAllDrugs() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug");
        return query.list();
    }

    public List<Drug> findDrugByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug d where d.name like :name");
        query.setString("name", "%" + name + "%");

        return query.list();
    }

    // ====================================================================
    // UPDATE
    // ====================================================================

    public void updateDrug(Drug drug) {
        sessionFactory.getCurrentSession().update(drug);
    }

    // ====================================================================
    // DELETE
    // ====================================================================

    public void deleteDrug(int id) {
        Drug drug = (Drug) sessionFactory.getCurrentSession().get(Drug.class, id);
        sessionFactory.getCurrentSession().delete(drug);
    }
}

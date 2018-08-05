package clinic.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Visit {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Patient patient;

    @Column
    private String[] problems;

    @Column
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Disease disease;

    @Column
    private Date dateTime;

    @Column
    private Prescription prescription;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================


    public Visit(Patient patient, String[] problems, Disease disease, Date dateTime, Prescription prescription) {
        this.patient = patient;
        this.problems = problems;
        this.disease = disease;
        this.dateTime = dateTime;
        this.prescription = prescription;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public String[] getProblems() {
        return problems;
    }

    public Disease getDisease() {
        return disease;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setId(int id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setProblems(String[] problems) {
        this.problems = problems;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}

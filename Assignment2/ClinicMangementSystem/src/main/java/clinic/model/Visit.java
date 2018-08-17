package clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Visit {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Patient patient;

    @Column
    private String[] problems;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private Disease disease;

    @Column
    private String dateTime;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private Prescription prescription;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Visit() {
    }

    public Visit(Patient patient, String[] problems, Disease disease, String dateTime, Prescription prescription) {
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

    public String getStringTime() {
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

    public void setStringTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}

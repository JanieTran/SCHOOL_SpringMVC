package clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class PrescribedDrugs {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Prescription prescription;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Drug drug;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public PrescribedDrugs() {
    }

    public PrescribedDrugs(Prescription prescription, Drug drug) {
        this.prescription = prescription;
        this.drug = drug;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public int getId() {
        return id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Drug getDrug() {
        return drug;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setId(int id) {
        this.id = id;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}

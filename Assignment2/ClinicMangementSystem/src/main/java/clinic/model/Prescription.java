package clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prescription {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "prescription")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private List<PrescribedDrugs> drugs;

    @Column
    private String dose;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Prescription() {
    }

    public Prescription(List<PrescribedDrugs> drugs, String dose) {
        this.drugs = drugs;
        this.dose = dose;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public int getId() {
        return id;
    }

    public List<PrescribedDrugs> getDrugs() {
        return drugs;
    }

    public String getDose() {
        return dose;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setId(int id) {
        this.id = id;
    }

    public void setDrugs(List<PrescribedDrugs> drugs) {
        this.drugs = drugs;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}

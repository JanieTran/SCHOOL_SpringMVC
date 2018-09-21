package clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Drug {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "drug")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private List<PrescribedDrugs> prescription;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Drug() {
    }

    public Drug(String name) {
        this.name = name;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PrescribedDrugs> getPrescription() {
        return prescription;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrescription(List<PrescribedDrugs> prescription) {
        this.prescription = prescription;
    }
}

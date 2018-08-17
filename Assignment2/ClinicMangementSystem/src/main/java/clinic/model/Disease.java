package clinic.model;

import javax.persistence.*;

@Entity
public class Disease {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String icd;

    @Column
    private String name;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Disease() {
    }

    public Disease(String icd, String name) {
        this.icd = icd;
        this.name = name;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public int getId() {
        return id;
    }

    public String getIcd() {
        return icd;
    }

    public String getName() {
        return name;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setId(int id) {
        this.id = id;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public void setName(String name) {
        this.name = name;
    }
}

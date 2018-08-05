package clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disease {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    private String icd;

    @Column
    private String name;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Disease(String icd, String name) {
        this.icd = icd;
        this.name = name;
    }

    // ====================================================================
    // GETTERS
    // ====================================================================

    public String getIcd() {
        return icd;
    }

    public String getName() {
        return name;
    }

    // ====================================================================
    // SETTERS
    // ====================================================================

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public void setName(String name) {
        this.name = name;
    }
}

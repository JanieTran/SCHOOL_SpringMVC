package clinic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    // ====================================================================
    // PROPERTIES
    // ====================================================================

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Date birthday;

    @Column
    private String gender;

    @Column
    private String address;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Patient(String name, Date birthday, String gender, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
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

    public Date getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

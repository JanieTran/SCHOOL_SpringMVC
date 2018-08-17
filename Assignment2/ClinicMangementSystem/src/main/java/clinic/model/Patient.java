package clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String birthday;

    @Column
    private String gender;

    @Column
    private String address;

    @OneToMany(mappedBy = "patient")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private List<Visit> visits;

    // ====================================================================
    // CONSTRUCTOR
    // ====================================================================

    public Patient() {
    }

    public Patient(String name, String birthday, String gender, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.visits = new ArrayList<>();
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

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public List<Visit> getVisits() {
        return visits;
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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

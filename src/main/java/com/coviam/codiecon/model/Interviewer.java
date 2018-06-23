package com.coviam.codiecon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "interviewer")
public class Interviewer {

    @Column(name = "name")
    String name;
    @Id
    @Column(name = "email")
    String email;
    @Column(name = "pass")
    String pass;
    @Column(name = "preference")
    String preference;

    public Interviewer(String name, String email, String pass, String preference) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}

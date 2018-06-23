package com.coviam.codiecon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "candidate")
public class Candidate {

    @Column(name = "name")
    String name;
    @Id
    @Column(name = "email")
    String email;
    @Column(name = "pass")
    String pass;
    @Column(name = "day")
    int day;
    @Column(name = "preference")
    String preference;

    public Candidate(String name, String email, String pass, int day, String preference) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.day = day;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}

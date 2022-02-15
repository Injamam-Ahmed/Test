package com.injamam.test.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "testdata")
@Component
public class Testtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;

    @Override
    public String toString() {
        return "Testtable [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    public Testtable() {
    }

    public Testtable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

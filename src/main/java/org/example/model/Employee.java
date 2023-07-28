package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "hibernate_clase")
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    public Employee(long l, String juan, String elDeveloper) {
        this.id=l;
        this.description=juan;
        this.name=elDeveloper;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

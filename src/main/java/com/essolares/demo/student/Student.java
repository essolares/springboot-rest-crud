package com.essolares.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private long id;
    private String name;
    @Transient  //NON PERSISTED IN DATABASE
    private Integer age;
    private LocalDate birth;
    private String email;

    public Student(long id, String name, LocalDate birth, String email) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }
    
    public Student(String name, LocalDate birth, String email) {
        this.name = name;
        this.birth = birth;
        this.email = email;
    }
    public Student() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", birth=" + birth + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    
}

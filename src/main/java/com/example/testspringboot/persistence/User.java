package com.example.testspringboot.persistence;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    
    private Long id;
    private String name;
    private String lastName;
    
    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}





// import javax.persistence.Table;


// public class Objective {

//     @Id
//     @GeneratedValue

//     private String description;

//     private String submittedBy;

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(final String title) {
//         this.title = title;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(final String description) {
//         this.description = description;
//     }

//     public String getSubmittedBy() {
//         return submittedBy;
//     }

//     public void setSubmittedBy(final String submittedBy) {
//         this.submittedBy = submittedBy;
//     }
// }
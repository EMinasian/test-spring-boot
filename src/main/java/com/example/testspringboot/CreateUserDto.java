package com.example.testspringboot;

public class CreateUserDto {

    private String name;
    private String lastName;

    public CreateUserDto() {
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

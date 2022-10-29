package io.softwarecrafter.annotation.sample;


import io.bytesbiter.annotation.library.BuilderProperty;
import io.bytesbiter.annotation.library.CreationDate;

@CreationDate
public class Person {

    String firstName;

    String lastName;

    int age;

    public String getFirstName() {
        return firstName;
    }

    @BuilderProperty
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @BuilderProperty
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    @BuilderProperty
    public void setAge(int age) {
        this.age = age;
    }
}

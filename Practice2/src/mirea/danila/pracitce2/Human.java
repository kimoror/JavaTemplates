package mirea.danila.pracitce2;

import java.util.Date;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int weight;

    public Human(int age,
                 String firstName,
                 String lastName,
                 Date birthDate,
                 int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthDate() {
        return birthDate.getDay() + "/" + birthDate.getMonth() + "/" + birthDate.getYear();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }


    public char getLastWordOfName() {
        return firstName.charAt(firstName.length() - 1);
    }

    public int agePlusThree() {
        age += 3;
        return age;
    }
}

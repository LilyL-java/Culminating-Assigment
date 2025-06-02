package game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 342619939
 */
public class Animal {
    private String lastName;
    private String firstName;
    private Date date;
    private static int totalPlayers = 0;
    
    public Animal(String lastName, String firstName, Date date) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        totalPlayers++;
    }
    public Animal() {
        this.lastName = "Null";
        this.firstName = "Null";
        this.date = new Date();
        totalPlayers++;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public Date getDOB() {
        return date;
    }
    public void setDOB(Date date) {
        this.date = date;
    }
    public static int getTotalPlayers() {
        return totalPlayers;
    }
    public String makeSound() {
        return "*Animal sound*";
    }
}

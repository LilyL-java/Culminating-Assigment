/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
public class Pig extends Animal {

    public Pig(String lastName, String firstName, Date date) {
        super(lastName, firstName, date);
    }
    public Pig() {
        super();
    }
    @Override
    public String makeSound() {
        return "Oink oink!";
    }
}

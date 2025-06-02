/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
public class Rat extends Animal {
    
    public Rat(String lastName, String firstName, Date date) {
        super(lastName, firstName, date);
    }
    public Rat() {
        super();
    }
    @Override
    public String makeSound() {
        return "Squeak squeak!";
    }
}

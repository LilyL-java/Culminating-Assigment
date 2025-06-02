/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
public class Rabbit extends Animal {
    
    public Rabbit(String lastName, String firstName, Date date) {
        super(lastName, firstName, date);
    }
    public Rabbit() {
        super();
    }
    @Override
    public String makeSound() {
        return "Squeak squeak!";
    }
}

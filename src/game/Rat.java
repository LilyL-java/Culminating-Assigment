/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Rat extends Animal {
    /**
     * This constructor makes a Rat object using the provided information
     * @param p
     * @param x
     * @param y
     * @param lastName
     * @param firstName
     * @param date
     * @param imagePath 
     */
    public Rat(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        super(p, x, y, lastName, firstName, date, imagePath);
    }
    /**
     * This constructor makes a default Rat object using the Animal constructor
     */
    public Rat() {
        super();
    }
    /**
     * This method allows the Rat object to make a sound (overridden)
     * @return Returns rat sound
     */
    @Override
    public String makeSound() {
        return "Squeak squeak!";
    }
}

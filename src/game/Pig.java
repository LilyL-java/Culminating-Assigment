/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author 342619939
 */
//Imported packages
import processing.core.PApplet;
import processing.core.PImage;

public class Pig extends Animal {
    /**
     * This constructor makes a Sheep object using the provided information
     * @param p
     * @param x
     * @param y
     * @param lastName
     * @param firstName
     * @param date
     * @param imagePath 
     */
    public Pig(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        super(p, x, y, lastName, firstName, date, imagePath);
    }
    /**
     * This constructor makes a default Pig object using the Animal constructor
     */
    public Pig() {
        super();
    }
    /**
     * This method allows the Pig object to make a sound (overridden)
     * @return Returns pig sound
     */
    @Override
    public String makeSound() {
        return "Oink oink!";
    }
}

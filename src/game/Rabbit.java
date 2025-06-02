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

public class Rabbit extends Animal {
    
    public Rabbit(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        super(p, x, y, lastName, firstName, date, imagePath);
    }
    public Rabbit() {
        super();
    }
    @Override
    public String makeSound() {
        return "Squeak squeak!";
    }
}

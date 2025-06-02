/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import processing.core.PApplet;
/**
 *
 * @author 342619939
 */
public class GameSet extends PApplet {
    int stage = 0;
    private Animal bunny;
    public void settings(){
	   //sets the size of the window
        size (1000,600);
    }
    public void setup(){
        background(255);
        bunny = new Rabbit(this, 250, 250, "Me", "My", new Date(01,20,2005), "images/Rabbit.png");
        
    }
    public void draw(){
        if (stage == 0) {
           bunny.draw();
        }
    }


}

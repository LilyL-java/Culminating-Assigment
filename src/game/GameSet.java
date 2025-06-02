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
    //stage 0 = beginning, stage 1-2 = rat, stage 3 = bunny, stage 4-5 = sheep, stage 6 = pig
    int stage = 0;
    public static String isAnimal = "";
    boolean ratInitialized = false;
    boolean crossRiver = false;
    boolean bunnyInitialized = false;
    boolean sheepInitialized = false;
    boolean pigInitialized = false;
    private Animal bunny;
    private Animal pig;
    private Animal rat;
    private Animal sheep;
    private Animal ox;
    public void settings(){
	   //sets the size of the window
        size (1000,600);
    }
    public void setup(){
        background(255);
        textSize(20);
        bunny = new Rabbit(this, 150, 250, "Null", "Null", new Date(), "images/Rabbit.png");
        pig = new Pig(this, 350, 250, "Null", "Null", new Date(), "images/Pig.png");
        rat = new Rat(this, 550, 250, "Null", "Null", new Date(), "images/Rat.png");
        sheep = new Sheep(this, 750, 250, "Null", "Null", new Date(), "images/Sheep.png");
    }
    public void draw(){
        if (stage == 0) {
            background(255);
            fill(0);
            text("Welcome to the Great Race hosted by the Jade Emperor, choose your animal!", 20, 50);
            bunny.draw();
            pig.draw();
            rat.draw();
            sheep.draw();
//            text("E.g. Sheep,Mary,Cook,01,02,2005", 20, 80);
//            text(userInput, 20,110);
// ask for user info at end
            
        } else if (stage == 1) {
            if (!ratInitialized) {
            rat = new Rat(this, 200, 250, "Null", "Null", new Date(), "images/Rat.png");
            ratInitialized = true;
            }
            background(0, 107, 18);
            fill(0);
            text("Ride the Ox's back!", 20,50);
            ox = new Animal(this, 500, 200, "Null", "Null", new Date(), "images/Ox.png");
            ox.draw();
            if (keyPressed) {
                if (keyCode == LEFT) {
                    rat.move(-5, 0);
                } else if (keyCode == RIGHT) {
                    rat.move(5, 0);
                } else if (keyCode == UP) {
                    rat.move(0, -5);
                } else if (keyCode == DOWN) {
                    rat.move(0, 5);
                }
            }
            rat.draw();
            if (rat.isCollidingWith(ox)) {
                stage = 2;
            }
        } else if (stage == 2) {
            background(0, 103, 199);
            fill(0);
            text("Yes, I'm going to get 1st place!", 20,50);
            if (!crossRiver) {
                rat = new Rat(this, 100, 250, "Null", "Null", new Date(), "images/Rat.png");
                ox = new Animal(this, 100, 300, "Null", "Null", new Date(), "images/Ox.png");
                crossRiver = true;
            }
            rat.draw();
            ox.draw();
            rat.move(1, 0);
            ox.move(1, 0);
            if (ox.x == 1000) {
                isAnimal = "rat";
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
        }
    }
    public void mousePressed() {
        if (rat.isClicked(mouseX, mouseY)) {
            stage = 1;
        } else if (bunny.isClicked(mouseX, mouseY)) {
            stage = 3;
        } else if (sheep.isClicked(mouseX, mouseY)) {
            stage = 5;
        } else if (pig.isClicked(mouseX, mouseY)) {
            stage = 6;
        }
    }
    

//           this.noLoop();
//           this.getSurface().setVisible(false);
//           new Results().setVisible(true);
}

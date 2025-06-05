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
    //stage 0 = beginning, stage 1-2 = rat, stage 3 = bunny, stage 4-5 = sheep, stage 6-7 = pig
    int stage = 0;
    public static String isAnimal = "";
    boolean ratInitialized = false;
    boolean crossRiver = false;
    boolean bunnyInitialized = false;
    boolean sheepInitialized = false;
    boolean closeCall = false;
    boolean pigInitialized = false;
    private Animal bunny;
    private Animal pig;
    private Animal rat;
    private Animal sheep;
    private Animal ox;
    private Props rock [] = new Props [4];
    private Props logs;//
    private Animal monkey;
    private Animal rooster;
    private Props raft;
    private Props salad;
    private Props day;
    private Props night;
    private Props river;
    
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
        day = new Props(this,0,0,"images/Day.png");
        night = new Props(this,0,0,"images/Night.png");
        river = new Props(this,0,0,"images/River.png");
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
            
        } else if (stage == 1) {
            if (!ratInitialized) {
            rat = new Rat(this, 200, 250, "Null", "Null", new Date(), "images/Rat.png");
            ratInitialized = true;
            }
            background(255);
            day.draw();
            fill(255, 247, 0);
            text("Ride the Ox's back since you can't swim!", 20,50);
            text("Press E to squeak in output", 20, 80);
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
                } else if (key == 'e' || key == 'E') {
                    System.out.println(rat.makeSound());
                }
            }
            rat.draw();
            if (rat.isCollidingWith(ox)) {
                stage = 2;
            }
        } else if (stage == 2) {
            background(255);
            river.draw();
            fill(0);
            text("Yes, I can jump off and get 1st place!", 20,50);
            if (!crossRiver) {
                rat = new Rat(this, 100, 250, "Null", "Null", new Date(), "images/Rat.png");
                ox = new Animal(this, 100, 300, "Null", "Null", new Date(), "images/Ox.png");
                crossRiver = true;
            }
            rat.draw();
            ox.draw();
            rat.move(2, 0);
            ox.move(2, 0);
            if (rat.x == 1000) {
                isAnimal = "Rat";
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
        } else if (stage == 3) {
            background(0, 103, 199);
            fill(0);
            text("Click on each rock to hop across the river!", 20,50);
            text("I can see the finish line, I'll get 4th!", 20,80);
            text("Press E to squeak in output", 20,110);
            int c = 50;
            for (int i = 0; i < rock.length; i++) {
                rock[i] = new Props(this, c, 300, "images/Rock.png");
                rock[i].draw();
                c = c + 250;
            }
            if (!bunnyInitialized) {
                bunny = new Rabbit(this, 50, 250, "Null", "Null", new Date(), "images/Rabbit.png");
                bunnyInitialized = true;
            }
            if (keyPressed) {
                if (key == 'e' || key == 'E') {
                    System.out.println(bunny.makeSound());
                }
            }
            bunny.draw();
            if (!(bunny.isCollidingWith(rock[0]) || bunny.isCollidingWith(rock[1]) || bunny.isCollidingWith(rock[2]) || bunny.isCollidingWith(rock[3]))) {
                System.out.println("You fell in the water!");
                exit();
            }
            if (bunny.x >= 600) {
                isAnimal = "Rabbit";
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
        } else if (stage == 4) {
            background(255);
            day.draw();
            fill(255, 247, 0);
            text("Help the monkey and rooster find logs to make a raft!", 20,50);
            text("Press E to baa in output", 20, 80);
            logs = new Props(this, 500, 289, "images/Logs.png");
            logs.draw();
            rooster = new Animal(this, 700, 150, "Null", "Null", new Date(), "images/Rooster.png");
            rooster.draw();
            monkey = new Animal(this, 100, 350, "Null", "Null", new Date(), "images/Monkey.png");
            monkey.draw();
            if (!sheepInitialized) {
            sheep = new Sheep(this, 200, 250, "Null", "Null", new Date(), "images/Sheep.png");
            sheepInitialized = true;
            }
            if (keyPressed) {
                if (keyCode == LEFT) {
                    sheep.move(-5, 0);
                } else if (keyCode == RIGHT) {
                    sheep.move(5, 0);
                } else if (keyCode == UP) {
                    sheep.move(0, -5);
                } else if (keyCode == DOWN) {
                    sheep.move(0, 5);
                } else if (key == 'e' || key == 'E') {
                    System.out.println(sheep.makeSound());
                }
            }
            sheep.draw();
            if (sheep.isCollidingWith(logs)) {
                stage = 5;
            }
        } else if (stage == 5) {
            background(255);
            river.draw();
            fill(0);
            text("I see land, we made it in time to be 8th-10th!", 20,50);
            text("Why don't we let Sheep be 8th, Monkey be 9th, and Rooster be 10th?", 20, 80);
            if (!closeCall) {
                sheep = new Sheep(this, 150, 150, "Null", "Null", new Date(), "images/Sheep.png");
                monkey = new Animal(this, 50, 250, "Null", "Null", new Date(), "images/Monkey.png");
                rooster = new Animal(this, 250, 250, "Null", "Null", new Date(), "images/Rooster.png");
                raft = new Props(this, 1, 150, "images/Raft.png");
                closeCall = true;
            }
            raft.draw();
            sheep.draw();
            monkey.draw();
            rooster.draw();
            sheep.move(1,0);
            rooster.move(1,0);
            monkey.move(1,0);
            raft.move(1,0);
            if (raft.x == 1000) {
                isAnimal = "Sheep";
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
        } else if (stage == 6) {
            background(255);
            day.draw();
            text("I need to finish this race- Oh! Food..", 20,50);
            text("Press E to oink in output", 20, 80);
            if (!pigInitialized) {
                pig = new Pig(this, 50, 250, "Null", "Null", new Date(), "images/Pig.png");
                salad = new Props(this, 800, 250, "images/Salad.png");
                pigInitialized = true;
            }
            salad.draw();
            if (keyPressed) {
                if (keyCode == LEFT) {
                    pig.move(-5, 0);
                } else if (keyCode == RIGHT) {
                    pig.move(5, 0);
                } else if (keyCode == UP) {
                    pig.move(0, -5);
                } else if (keyCode == DOWN) {
                    pig.move(0, 5);
                } else if (key == 'e' || key == 'E') {
                    System.out.println(pig.makeSound());
                }
            }
            pig.draw();
            if (pig.isCollidingWith(salad)) {
                stage = 7;
            }
        } else if (stage == 7) {
            background(255);
            night.draw();
            pig.changePlacement(450,250);
            pig.draw();
            fill(0);
            text("And the pig fell asleep until night..", 350, 400);
            text("Luckily, it got into 12th place! (Click the pig)", 350, 430);
        }
    }
    public void mousePressed() {
        if (stage == 0) {
            if (rat.isClicked(mouseX, mouseY)) {
                stage = 1;
            } else if (bunny.isClicked(mouseX, mouseY)) {
                stage = 3;
            } else if (sheep.isClicked(mouseX, mouseY)) {
                stage = 4;
            } else if (pig.isClicked(mouseX, mouseY)) {
                stage = 6;
            }
        }
        if (stage == 7 && pig.isClicked(mouseX, mouseY)) {
            isAnimal = "Pig";
            this.noLoop();
            this.getSurface().setVisible(false);
            new Results().setVisible(true);
        }
        if (stage == 3) {
            bunny.moveTo(mouseX, mouseY);
        }
    }
}

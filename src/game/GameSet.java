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
    //stage -1 = menu, stage 0 = beginning, stage 1-2 = rat, stage 3 = bunny, stage 4-5 = sheep, stage 6-7 = pig
    //Stopwatch idea courtesy to ChatGPT (startTime, totalTime, timer)
    //Timer is counted in milliseconds
    //Initialized booleans idea courtesy to ChatGPT (bunnyInitialized,ratInitialized,crossRiver,sheepInitialized,closeCall,pigInitialized)
    private int startTime;
    //totalTime is public to transfer to results page
    public static int totalTime;
    //If timer is true, the timer is on, if false it is not on
    boolean timer = false;
    //Initialize the stage to menu
    int stage = -1;
    int count = 0;
    //Initialize the isAnimal holder, which is public so it can be transfered to results page
    public static String isAnimal = "";
    //Initialize the booleans below (This is used because whenever I change the object's location, I cannot move it afterwards so this is used to prevent that from happening)
    boolean ratInitialized = false;
    boolean crossRiver = false;
    boolean bunnyInitialized = false;
    boolean sheepInitialized = false;
    boolean closeCall = false;
    boolean pigInitialized = false;
    //Initialize the Animals and Props
    private Animal bunny;
    private Animal pig;
    private Animal rat;
    private Animal sheep;
    private Animal ox;
    private Props rock [] = new Props [4];
    private Props logs [] = new Props [3];
    private Animal monkey;
    private Animal rooster;
    private Props raft;
    private Props salad;
    //Initialize backgrounds
    private Props menu;
    private Props day;
    private Props night;
    private Props river;
    private Props gameOver;
    
    public void settings(){
	//Sets the size of the window
        size (1000,600);
    }
    
    public void setup(){
        background(255);
        textSize(20);
        //4 Animals initialized for the animal pick (stage 0)
        bunny = new Rabbit(this, 150, 250, "Null", "Null", new Date(), "images/Rabbit.png");
        pig = new Pig(this, 350, 250, "Null", "Null", new Date(), "images/Pig.png");
        rat = new Rat(this, 550, 250, "Null", "Null", new Date(), "images/Rat.png");
        sheep = new Sheep(this, 750, 250, "Null", "Null", new Date(), "images/Sheep.png");
        //Backgrounds stay in their position at (0,0)
        menu = new Props(this,0,0,"images/MainMenu.png");
        day = new Props(this,0,0,"images/Day.png");
        night = new Props(this,0,0,"images/Night.png");
        river = new Props(this,0,0,"images/River.png");
        gameOver = new Props(this,0,0,"images/GameOver.png");
    }
    
    public void draw(){
        if (stage == -1) {
            //Menu is drawn
            background(255);
            menu.draw();
        } else if (stage == 0) {
            //Timer starts at stage 0
            if (timer  == false) {
                startTime = millis();
                timer = true;
            }
            //Day background is drawn
            background(255);
            day.draw();
            fill(0);
            rect(0,0,700,100);
            fill(255);
            //Draws in the pre-positioned Animals to be clicked on
            //Added an intro and instructions
            text("Welcome to the Great Race hosted by the Jade Emperor, choose your animal!", 20, 50);
            bunny.draw();
            pig.draw();
            rat.draw();
            sheep.draw();
            //Stage 1 = rat route
        } else if (stage == 1) {
            //If this boolean is false, Rat object gets placed down at coordinates (200,250)
            if (!ratInitialized) {
            rat = new Rat(this, 200, 250, "Null", "Null", new Date(), "images/Rat.png");
            ratInitialized = true;
            }
            //Background day gets drawn (Daytime)
            background(255);
            day.draw();
            //Instructions shown to user to move to the ox and press e
            fill(0);
            rect(0,0,480,100);
            fill(255);
            text("Ride the Ox's back since you can't swim! (Arrow keys)", 20,50);
            text("Press E to squeak in output", 20, 80);
            //Ox gets drawn
            ox = new Animal(this, 500, 200, "Null", "Null", new Date(), "images/Ox.png");
            ox.draw();
            //User movement for the rat
            //Also has option to press e to use makeSound() method
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
            //Draw rat
            rat.draw();
            //If collide with Ox, then move on to next stage which is stage 2
            if (rat.isCollidingWith(ox)) {
                stage = 2;
            }
            //Cutscene after stage 1
        } else if (stage == 2) {
            //Background river is drawn (Just the river)
            background(255);
            river.draw();
            fill(0);
            rect(0,0,360,100);
            fill(255);
            //Text is shown
            text("Yes, I can jump off and get 1st place!", 20,50);
            //Use of boolean crossRiver to reposition and move the rat and ox
            if (!crossRiver) {
                rat = new Rat(this, 100, 250, "Null", "Null", new Date(), "images/Rat.png");
                ox = new Animal(this, 100, 300, "Null", "Null", new Date(), "images/Ox.png");
                crossRiver = true;
            }
            //Draws rat and ox
            rat.draw();
            ox.draw();
            //Moves rat and ox
            rat.move(2, 0);
            ox.move(2, 0);
            //If rat's x coordinate is 1000 (width of game), timer stops and saves to totalTime
            //isAnimal is set to "Rat" for the Results jFrame
            if (rat.x == 1000) {
                if (timer == true) {
                    totalTime = (millis() - startTime)/1000;
                    timer = false;
                }
                isAnimal = "Rat";
                //Stops the loop of Sketch and makes Results page visible
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
            //Rabbit route is stage 3
        } else if (stage == 3) {
            //Background is a blue colour for water
            background(0, 103, 199);
            fill(0);
            rect(0,0,370,150);
            fill(255);
            //Instruction for user is displayed to move to rabbit and press e
            text("Click on each rock to hop across the river!", 20,50);
            text("I can see the finish line, I'll get 4th!", 20,80);
            text("Press E to squeak in output", 20,110);
            //Initialize for the x coordinates of rocks
            int c = 50;
            //For loop to add position of rocks
            //Draws rocks
            for (int i = 0; i < rock.length; i++) {
                rock[i] = new Props(this, c, 300, "images/Rock.png");
                rock[i].draw();
                c = c + 250;
            }
            //Use of boolean bunnyInitialized to reposition and move the rabbit
            if (!bunnyInitialized) {
                bunny = new Rabbit(this, 50, 250, "Null", "Null", new Date(), "images/Rabbit.png");
                bunnyInitialized = true;
            }
            //Allows user to press e to use rabbit's makeSound() method
            if (keyPressed) {
                if (key == 'e' || key == 'E') {
                    System.out.println(bunny.makeSound());
                }
            }
            //Draws bunny
            bunny.draw();
            //If the bunny ever collides with any of the rock prop objects, user is redirected to stage 0734 (a game over page)
            if (!(bunny.isCollidingWith(rock[0]) || bunny.isCollidingWith(rock[1]) || bunny.isCollidingWith(rock[2]) || bunny.isCollidingWith(rock[3]))) {
                stage = 0734;
            }
            //For the bunny route, if it reaches more or equal to 600 px on the x axis, the timer will stop and totalTime is divided by 1000 since it counts in milliseconds
            if (bunny.x >= 750) {
                if (timer == true) {
                    totalTime = (millis() - startTime)/1000;
                    timer = false;
                }
                //Sets isAnimal to Rabbit for results page
                isAnimal = "Rabbit";
                //Stops looping the Sketch and makes results page visible
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
            //Sheep route is stage 4
        } else if (stage == 4) {
            //Day background is drawn and instructions are shown to user to move the sheep and press e
            background(255);
            day.draw();
            fill(0);
            rect(0,0,600,100);
            fill(255);
            text("Help the monkey and rooster find logs to make a raft! (Arrow keys)", 20,50);
            text("Press E to baa in output", 20, 80);
            //Draws a rooster image
            rooster = new Animal(this, 700, 150, "Null", "Null", new Date(), "images/Rooster.png");
            rooster.draw();
            //Draws a monkey object
            monkey = new Animal(this, 100, 350, "Null", "Null", new Date(), "images/Monkey.png");
            monkey.draw();
            //Use of boolean sheepInitialized to reposition and move the sheep as well as the logs
            if (!sheepInitialized) {
                sheep = new Sheep(this, 200, 250, "Null", "Null", new Date(), "images/Sheep.png");
                logs [0] = new Props(this, 500, 289, "images/Logs.png");
                logs [1] = new Props(this, 250, 200, "images/Logs.png");
                logs [2] = new Props(this, 863, 467, "images/Logs.png"); 
            sheepInitialized = true;
            }
            //If user clicks arrow keys, it moves the sheep and if pressed the e key, it uses makeSound() in output
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
            //Sheep and logs are drawn
            logs[0].draw();
            logs[1].draw();
            logs[2].draw();
            sheep.draw();
            //If the sheep collides with the logs props, changes the x and y coordinates of logs outside screen
            //Stage moves to 5 if all of them are outside of screen (or in another words, have been collided with)
            if (sheep.isCollidingWith(logs[0])) {
                logs[0].changePlacement(2000,2000);
            }
            if (sheep.isCollidingWith(logs[1])) {
                logs[1].changePlacement(2000,2000);
            }
            if (sheep.isCollidingWith(logs[2])) {
                logs[2].changePlacement(2000,2000);
            }
            if (logs[0].x >1000 && logs[1].x > 1000 && logs[2].x > 1000) {
                stage = 5;
            }
            //Cutscene for sheep is stage 5
        } else if (stage == 5) {
            //River background is drawn
            background(255);
            river.draw();
            fill(0);
            rect(0,0,600,100);
            //Text is given to user
            fill(255);
            text("I see land, we made it in time to be 8th-10th!", 20,50);
            text("Why don't we let Sheep be 8th, Monkey be 9th, and Rooster be 10th?", 20, 80);
            //Use of boolean closeCall to reposition and move the three animals and a new raft prop
            if (!closeCall) {
                sheep = new Sheep(this, 150, 150, "Null", "Null", new Date(), "images/Sheep.png");
                monkey = new Animal(this, 50, 250, "Null", "Null", new Date(), "images/Monkey.png");
                rooster = new Animal(this, 250, 250, "Null", "Null", new Date(), "images/Rooster.png");
                raft = new Props(this, 1, 150, "images/Raft.png");
                closeCall = true;
            }
            //Draws the animals and raft
            raft.draw();
            sheep.draw();
            monkey.draw();
            rooster.draw();
            //Moves them all to the right
            sheep.move(1,0);
            rooster.move(1,0);
            monkey.move(1,0);
            raft.move(1,0);
            //If the raft's x-axis is 1000 (screen length), timer stops and totalTime is set
            if (raft.x == 1000) {
                if (timer == true) {
                    totalTime = (millis() - startTime)/1000;
                    timer = false;
                }
                //isAnimal is set to Sheep for results page
                isAnimal = "Sheep";
                //Stops Sketch and makes results page visible
                this.noLoop();
                this.getSurface().setVisible(false);
                new Results().setVisible(true);
            }
            //Pig route is stage 6
        } else if (stage == 6) {
            //Draws day background
            background(255);
            day.draw();
            fill(0);
            rect(0,0,450,100);
            //Gives user instructions to go to the food and allows to oink in output
            fill(255);
            text("I need to finish this race- Oh! Food.. (Arrow keys)", 20,50);
            text("Press E to oink in output", 20, 80);
            //Use of boolean pigInitialized to reposition and move the pig as well as add a salad prop
            if (!pigInitialized) {
                pig = new Pig(this, 50, 250, "Null", "Null", new Date(), "images/Pig.png");
                salad = new Props(this, 800, 250, "images/Salad.png");
                pigInitialized = true;
            }
            //Draws in the salad prop (which is the food)
            salad.draw();
            //If user clicks arrow keys, it moves the pig and if pressed the e key, it uses makeSound() in output
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
            //Draws in pig object
            pig.draw();
            //If pig collides with the salad prop, it moves on to stage 7
            if (pig.isCollidingWith(salad)) {
                stage = 7;
            }
        } else if (stage == 7) {
            //Draws in the night background
            background(255);
            night.draw();
            //Uses a method to change placement (x,y coordinates) of the pig since it doesn't need moving
            pig.changePlacement(450,250);
            //Draws in pig
            pig.draw();
            fill(0);
            //Gives user instructions to click on the pig
            text("And the pig fell asleep until night..", 350, 400);
            text("Luckily, it got into 12th place! (Click the pig)", 350, 430);
        } else if (stage == 0734) {
            gameOver.draw();
        }
    }
    
    //mousedPressed method to detect if the mouse is clicked
    public void mousePressed() {
        //If stage is -1 (menu) then if menu is clicked, it moves on to stage 0 (animal selection)
        if (stage == -1) {
            if (menu.isClicked(mouseX, mouseY)) {
                stage = 0;
            }
            //If stage is 0, then another if statement
            //If any of the animal images are clicked then depending on which animal the user chooses, it redirects the scene to the appropriate stage
        } else if (stage == 0) {
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
        //If it is stage 7 (pig route) and the pig is clicked as instructed, then timer stops and totalTime is set
        if (stage == 7 && pig.isClicked(mouseX, mouseY)) {
            if (timer == true) {
                    totalTime = (millis() - startTime)/1000;
                    timer = false;
            }
            //isAnimal is set as Pig for results page
            isAnimal = "Pig";
            //Stops loop of Sketch and makes results page appear
            this.noLoop();
            this.getSurface().setVisible(false);
            new Results().setVisible(true);
        }
        //If it is stage 3 (rabbit stage), this allows user to move the rabbit on the rocks using moveTo method
        if (stage == 3) {
            bunny.moveTo(mouseX, mouseY);
        }
        //If it is stage 0734 (game over for rabbit), this allows user to click and exit the program after failing the jumps
        if (stage == 0734) {
            if (gameOver.isClicked(mouseX,mouseY)) {
                exit();
            }
        }
    }
}

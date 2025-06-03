package game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 342619939
 */
public class Animal {
    public int x, y;
    private String lastName;
    private String firstName;
    private Date date;
    private PImage image;
    private PApplet app;
    private static final int currentPlayer = 1;
    
    public Animal(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.image = app.loadImage(imagePath);
    }
    public Animal() {
        this.lastName = "Null";
        this.firstName = "Null";
        this.date = new Date();
    }
    public void move(int dx, int dy) {
      x = x + dx;
      y = y + dy;
    }
    public void draw() {
      app.image(image, x, y);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public Date getDOB() {
        return date;
    }
    public void setDOB(Date date) {
        this.date = date;
    }
    public static int getCurrentPlayer() {
        return currentPlayer;
    }
    public String makeSound() {
        return "*Animal sound*";
    }
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d < 64;
    }
    public boolean isCollidingWith(Animal other) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        int otherCenterX = other.x+(other.image.pixelWidth/2);
        int otherCenterY = other.y+(other.image.pixelHeight/2);
        float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY); 
        return d < 64;
    }
    public void moveTo(int dx, int dy) {
        x = dx - 64;
        y = dy - 84;
    }
}

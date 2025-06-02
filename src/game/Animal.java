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
    private int x, y;
    private String lastName;
    private String firstName;
    private Date date;
    private PImage image;
    private PApplet app;
    private static int totalPlayers = 0;
    
    public Animal(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.image = app.loadImage(imagePath);
        totalPlayers++;
    }
    public Animal() {
        this.lastName = "Null";
        this.firstName = "Null";
        this.date = new Date();
        totalPlayers++;
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
    public static int getTotalPlayers() {
        return totalPlayers;
    }
    public String makeSound() {
        return "*Animal sound*";
    }
}

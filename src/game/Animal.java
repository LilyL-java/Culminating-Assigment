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
    private static final int CURRENT_PLAYER = 1;
    /**
     * This constructor makes an Animal object using the provided information
     * @param p
     * @param x
     * @param y
     * @param lastName
     * @param firstName
     * @param date
     * @param imagePath 
     */
    public Animal(PApplet p, int x, int y, String lastName, String firstName, Date date, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.image = app.loadImage(imagePath);
    }
    /**
     * This constructor makes a default Animal object
     */
    public Animal() {
        this.lastName = "Null";
        this.firstName = "Null";
        this.date = new Date();
    }
    /**
     * This method allows the object to move via their coordinates plus dx and dy
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy) {
      x = x + dx;
      y = y + dy;
    }
    /**
     * This method just changes the object's placement without user movement
     * @param dx
     * @param dy 
     */
    public void changePlacement(int dx, int dy) {
        x = dx;
        y = dy;
    }
    /**
     * Draws the image of the object
     */
    public void draw() {
      app.image(image, x, y);
    }
    /**
     * This gives user's first name
     * @return Returns user's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This gives user's last name
     * @return Returns user's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * This sets user's first and last name
     * @param lastName
     * @param firstName 
     */
    public void setName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    /**
     * Returns user's date of birth
     * @return Returns user's DOB
     */
    public Date getDOB() {
        return date;
    }
    /**
     * This sets user's date of birth
     * @param date 
     */
    public void setDOB(Date date) {
        this.date = date;
    }
    /**
     * This returns the amount of current players
     * @return Returns the amount of current players online
     */
    public static int getCurrentPlayer() {
        return CURRENT_PLAYER;
    }
    /**
     * Returns object's sound
     * @return Returns sound an Animal object makes
     */
    public String makeSound() {
        return "*Animal sound*";
    }
    /**
     * This method detects whether or not user has clicked on something
     * @param mouseX
     * @param mouseY
     * @return Returns the distance between the image and the mouse needed to be classified as clicked
     */
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < 64;
    }
    /**
     * This method detects whether or not an object is colliding with another Animal object
     * @param other
     * @return Returns the distance between the image and the other image needed to be classified as collided
     */
    public boolean isCollidingWith(Animal other) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        int otherCenterX = other.x+(other.image.pixelWidth/2);
        int otherCenterY = other.y+(other.image.pixelHeight/2);
        float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY); 
        return d < 64;
    }
    /**
     * This method detects whether or not an object is colliding with a Props object
     * @param other
     * @return Returns the distance between the image and the props (different class) needed to be classified as collided
     */
    public boolean isCollidingWith(Props other) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        int otherCenterX = other.x+(other.getImage().pixelWidth/2);
        int otherCenterY = other.y+(other.getImage().pixelHeight/2);
        float d = PApplet.dist(otherCenterX, otherCenterY, centerX, centerY); 
        return d < 64;
    }
    /**
     * This method moves the object where the mouse clicks on (Rabbit scene)
     * @param dx
     * @param dy 
     */
    public void moveTo(int dx, int dy) {
        x = dx - 64;
        y = dy - 84;
    }
}

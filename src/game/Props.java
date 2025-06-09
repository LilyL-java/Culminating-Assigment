/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 342619939
 */
public class Props {
    public int x,y;
    private PImage image;
    private PApplet app;
    /**
     * This constructor a Props object using the provided information
     * @param p
     * @param x
     * @param y
     * @param imagePath 
     */
    public Props(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    /**
     * Draws the prop's image
     */
    public void draw() {
      app.image(image, x, y);
    }
    /**
     * This method returns the image
     * @return Returns prop's image
     */
    public PImage getImage() {
        return image;
    }
    /**
     * This method moves the prop according to the dx and dy plus their coordinates
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy) {
      x = x + dx;
      y = y + dy;
    }
    /**
     * This method detects whether or not user has clicked on something
     * @param mouseX
     * @param mouseY
     * @return Returns the distance between the mouse and the background image needed to be classified as collided (background images are 1000 px)
     */
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < 1000;
    }
}

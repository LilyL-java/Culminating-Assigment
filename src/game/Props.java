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
    
    public Props(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    public void draw() {
      app.image(image, x, y);
    }
    public PImage getImage() {
        return image;
    }
    public void move(int dx, int dy) {
      x = x + dx;
      y = y + dy;
    }
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < 1000;
    }
}

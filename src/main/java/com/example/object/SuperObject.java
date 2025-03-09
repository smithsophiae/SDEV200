//SuperObject class is the base for all objects that can be added like dog house or bones
package com.example.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.example.main.GamePanel;

public class SuperObject {

    // declaration
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;

    // draw method
    public void draw(Graphics2D g2, GamePanel gp) {

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

// Entity.java file sets up variables for entities like Player
package com.example.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    // int values for entities' position and speed
    public int x, y;
    public int speed;

    // img file for player and the direction player is facing
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public String direction;

    // sprite fps counter
    public int spriteCounter = 0;
    public int spriteNum = 1;

    // hitbox and boolean for collision
    public Rectangle hitBox;
    public boolean collisioinOn = false;
}

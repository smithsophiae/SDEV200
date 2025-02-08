package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public Player (GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/down3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }
    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true ||
                keyHandler.leftPressed == true || keyHandler.rightPressed == true) {
            if (keyHandler.upPressed) {
                direction = "up";
                y -= speed;
            }
            else if (keyHandler.downPressed) {
                direction = "down";
                y += speed;
            }
            else if (keyHandler.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else if (keyHandler.rightPressed) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics2D g2d) {
      //  g2d.setColor(Color.WHITE);
     //   g2d.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize); //makes white square for testing
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                else if (spriteNum == 2) {
                    image = up2;
                }
                else if (spriteNum == 3) {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                else if (spriteNum == 2) {
                    image = down2;
                }
                else if (spriteNum == 3) {
                    image = down3;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                else if (spriteNum == 2) {
                    image = left2;
                }
                else if (spriteNum == 3) {
                    image = left3;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                else if (spriteNum == 2) {
                    image = right2;
                }
                else if (spriteNum == 3) {
                    image = right3;
                }
                break;
        }
        g2d.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}

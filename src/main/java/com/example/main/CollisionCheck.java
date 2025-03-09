// CollisionCheck.java checks the four corners and make sure if the entity and fences should collide
package com.example.main;

import com.example.entity.Entity;

public class CollisionCheck {
    GamePanel gamePanel;

    // constructor
    public CollisionCheck(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    // Method to check hitbox around the player by adding tilesize to player's x,y
    // coordinate
    public void checkTile(Entity entity) {
        int entityLeftx = entity.x + entity.hitBox.x;
        int entityrightx = entity.x + entity.hitBox.x + entity.hitBox.width;
        int entitytopy = entity.y + entity.hitBox.y;
        int entitybottomy = entity.y + entity.hitBox.y + entity.hitBox.height;

        int entityleftcol = entityLeftx / gamePanel.tileSize;
        int entityrightcol = entityrightx / gamePanel.tileSize;
        int entitytoprow = entitytopy / gamePanel.tileSize;
        int entitybottomrow = entitybottomy / gamePanel.tileSize;

        int tileNum1, tileNum2;
        // Ensure to check only the direction player is moving toward
        switch (entity.direction) {
            case "up":
                entitytoprow = (entitytopy - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityleftcol][entitytoprow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityrightcol][entitytoprow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisioinOn = true;
                }
                break;
            case "down":
                entitybottomrow = (entitybottomy + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityleftcol][entitybottomrow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityrightcol][entitybottomrow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisioinOn = true;
                }
                break;
            case "left":
                entityleftcol = (entityLeftx - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityleftcol][entitytoprow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityleftcol][entitybottomrow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisioinOn = true;
                }
                break;
            case "right":
                entityrightcol = (entityrightx - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityrightcol][entitytoprow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityrightcol][entitybottomrow];
                if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisioinOn = true;
                }

        }
    }
}

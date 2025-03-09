// Tilemanager file initialize all tile files to create the map and draw/update them every frame (1/60 of a second)
//

package com.example.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import javax.imageio.ImageIO;
import com.example.main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    Tile[] mazeTile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tile = new Tile[30];
        Objects.requireNonNull(gp);
        Objects.requireNonNull(gp);
        this.mapTileNum = new int[16][12];
        this.getTileImage();
        this.loadMap("/res/maps/basic.txt");
    }

    public void loadMap(String fileName) {
        try {
            InputStream is = this.getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (true) {
                Objects.requireNonNull(this.gp);
                if (col >= 16) {
                    break;
                }

                Objects.requireNonNull(this.gp);
                if (row >= 12) {
                    break;
                }

                String line = br.readLine();

                while (true) {
                    Objects.requireNonNull(this.gp);
                    if (col >= 16) {
                        Objects.requireNonNull(this.gp);
                        if (col == 16) {
                            col = 0;
                            ++row;
                        }
                        break;
                    }

                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    this.mapTileNum[col][row] = num;
                    ++col;
                }
            }

            br.close();
        } catch (Exception var9) {
            Exception e = var9;
            e.printStackTrace();
        }

    }

    // Assigning tile images
    public void getTileImage() {
        try {
            /*
             * Grass tiles
             * 0 1 2
             * 3 4 5
             * 6 7 8
             * forms a 3x3 grass tiles with grid.
             */
            this.tile[0] = new Tile();
            this.tile[0].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (1).png"));
            this.tile[1] = new Tile();
            this.tile[1].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (2).png"));
            this.tile[2] = new Tile();
            this.tile[2].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (3).png"));
            this.tile[3] = new Tile();
            this.tile[3].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (9).png"));
            this.tile[4] = new Tile();
            this.tile[4].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (10).png"));
            this.tile[5] = new Tile();
            this.tile[5].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (11).png"));
            this.tile[6] = new Tile();
            this.tile[6].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (21).png"));
            this.tile[7] = new Tile();
            this.tile[7].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (22).png"));
            this.tile[8] = new Tile();
            this.tile[8].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/grass (23).png"));
            /*
             * fence tiles (tilenum => + 8)
             * 9,10 single
             * 11 connect down
             * 12 double no connect
             * 13 double connect left
             * 14 connect top down
             * 15 door (left)
             * 16 door (right)
             * 17 connect top
             * 18 connect right
             * 19 connect left right
             * 20 connect left
             * 21 connect down right
             * 22 connect left down right
             * 23 connect left down
             * 24 connect top down right
             * 25 connect all four
             * 26 connect left top down
             * 27 connect top right
             * 28 connect left top right
             * 29 connect left top
             */
            this.tile[9] = new Tile();
            this.tile[9].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (1).png"));
            this.tile[10] = new Tile();
            this.tile[10].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (2).png"));
            this.tile[11] = new Tile();
            this.tile[11].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (3).png"));
            this.tile[12] = new Tile();
            this.tile[12].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (4).png"));
            this.tile[13] = new Tile();
            this.tile[13].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (5).png"));
            this.tile[14] = new Tile();
            this.tile[14].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (6).png"));
            this.tile[15] = new Tile();
            this.tile[15].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (7).png"));
            this.tile[16] = new Tile();
            this.tile[16].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (8).png"));
            this.tile[17] = new Tile();
            this.tile[17].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (9).png"));
            this.tile[18] = new Tile();
            this.tile[18].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (10).png"));
            this.tile[19] = new Tile();
            this.tile[19].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (11).png"));
            this.tile[20] = new Tile();
            this.tile[20].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (12).png"));
            this.tile[21] = new Tile();
            this.tile[21].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (13).png"));
            this.tile[22] = new Tile();
            this.tile[22].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (14).png"));
            this.tile[23] = new Tile();
            this.tile[23].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (15).png"));
            this.tile[24] = new Tile();
            this.tile[24].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (16).png"));
            this.tile[25] = new Tile();
            this.tile[25].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (17).png"));
            this.tile[26] = new Tile();
            this.tile[26].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (18).png"));
            this.tile[27] = new Tile();
            this.tile[27].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (19).png"));
            this.tile[28] = new Tile();
            this.tile[28].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (20).png"));
            this.tile[29] = new Tile();
            this.tile[29].image = ImageIO.read(this.getClass().getResourceAsStream("/res/tiles/fence (21).png"));
            for (int i = 0; i < this.tile.length; i++) {
                this.tile[i].collision = true;
            }
            tile[4].collision = false;

        } catch (IOException var2) {
            IOException e = var2;
            e.printStackTrace();
        }

    }

    // Draw all image files

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            // get tilenum from maptilenum array.
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}

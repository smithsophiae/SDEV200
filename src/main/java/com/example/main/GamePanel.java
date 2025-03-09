// GamePanel sets everything happening in the gaming window
package com.example.main;

import com.example.entity.Player;
import com.example.tile.TileManager;
import com.example.object.SuperObject;
import javax.swing.*;

import javafx.application.Platform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.stage.Stage;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Screen settings
    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 actual tile size
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize; // 768 px
    public final int screenHeight = maxScreenRow * tileSize; // 576 px
    int FPS = 60;
    private Stage primaryStage;
    private boolean running = true;
    private Timer countdownTimer;
    private int timeRemaining = 60;
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionCheck collisionCheck = new CollisionCheck(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyHandler);
    public SuperObject obj[] = new SuperObject[10];

    // no arg constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public GamePanel(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    // Place items
    public void setupGame() {
        aSetter.setObject();
        startCountdownTimer();
    }

    // Timer
    private void startCountdownTimer() {
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                if (timeRemaining <= 0) {
                    countdownTimer.stop();
                    showLoseScreen();
                }
                repaint();
            }
        });
        countdownTimer.start();
    }

    // Start gamethread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // fps loop
    public void run() { // shorter fps loop.
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null && running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + FPS);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // update player to new position, sprite
    public void update() {
        player.update();

        // Check if the player reached the end
        // Define a small threshold to check if the player is close enough to the target
        int threshold = 10; // Adjust the value based on the desired proximity

        if (obj[0] != null) {

            if (Math.abs(player.x - obj[0].x) <= threshold && Math.abs(player.y - obj[0].y) <= threshold) {
                System.out.println("You Win!");
                stopGameThread();
                countdownTimer.stop();
                Platform.runLater(() -> showJavaFXWinScreen());
            }
        }

    }

    // Stop the game
    public void stopGameThread() {
        running = false;
    }

    public void showJavaFXWinScreen() {
        // // Create an instance of your existing Win class
        // Win winScreen = new Win();

        // // Call the method to create the Win screen scene and pass the primaryStage
        // Scene winScene = winScreen.createWinScreen(primaryStage);

        // // Set the scene on the primary stage (your current window) and show it
        // primaryStage.setScene(winScene);
        // primaryStage.show();
        Platform.runLater(() -> {
            Win winScreen = new Win();
            primaryStage.setScene(winScreen.createWinScreen(primaryStage));
        });
    }

    // lose screen
    public void showLoseScreen() {
        Platform.runLater(() -> {

            Lose loseScreen = new Lose();
            primaryStage.setScene(loseScreen.createLoseScreen(primaryStage));
            // primaryStage.show();
        });
    }

    // Display Map, Player, Timer on screen
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        tileManager.draw(g2d);
        for (SuperObject object : obj) {
            if (object != null) {
                object.draw(g2d, this);
            }
        }
        player.draw(g2d);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(Color.WHITE);
        String timeText = String.format("Time Left: %02d:%02d", timeRemaining / 60, timeRemaining % 60);
        g2d.drawString(timeText, 10, 30);
        g2d.dispose();
    }
}

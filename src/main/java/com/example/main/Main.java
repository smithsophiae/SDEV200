/*
 * Dog Days is a java project developed by Seungwook Aaron Kim and Sophie Smith. 
 * User will controll a dog lost in a maze hoping to find the exit. 
 * 
 */

package com.example.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title of main window
        primaryStage.setTitle("Dog Days");
        Scene title = new TitleScreen().createTitleScreen(primaryStage);
        // Sets inital load up screen to Title Screen
        primaryStage.setScene(title);
        primaryStage.show();

    }

    public static void main(String[] args) {
        // Launches javaFX application

        launch(args);
    }
}

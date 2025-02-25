import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MazeScreen {

    public Scene createMazeScreen(javafx.stage.Stage primaryStage) {
        //Custom pixel font for game
        Font pixelFont = Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 20);

        //Creating screen layout - called intermediate as it is middle filler page for now
        //Maze game will go here instead of buttons and text

        //Creates root container 
        StackPane intermediateRoot = new StackPane();
        //Vbox for layout spacing 
        VBox intermediateLayout = new VBox(20);
        //Centers elements in Vbox
        intermediateLayout.setAlignment(Pos.CENTER);

       
        //Changing root background color to black
        intermediateRoot.setStyle("-fx-background-color: black;");

        //Creating Win button - test button to show if you win maze
        Button winButton = new Button("Win");
        //Applies custom font to text 
        winButton.setFont(pixelFont); 
        //Changing font to green
        winButton.setTextFill(Color.GREEN); 
        //Styles button
        winButton.setStyle("-fx-background-color: white; -fx-padding: 10 20; -fx-background-radius: 10;");

        //Creating lose button - test button to show if you lose maze
        Button loseButton = new Button("Lose");
        //Applies custom font to text
        loseButton.setFont(pixelFont); 
        //Changing font to red
        loseButton.setTextFill(Color.RED); 
        //Styles button
        loseButton.setStyle("-fx-background-color: white; -fx-padding: 10 20; -fx-background-radius: 10;");

        //Label to show where the maze game will be presented
        Label mazeLabel = new Label("This is where the maze will be haha");
        //Applies custom font to text
        mazeLabel.setFont(pixelFont);
        //Changing font to white
        mazeLabel.setTextFill(Color.WHITE);
        //Styles label
        mazeLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10 20;");

        //Creates action when win button pressed - sends user to Win Screen
        winButton.setOnAction(event -> primaryStage.setScene(new Win().createWinScreen(primaryStage)));

        //Creates action when lose button pressed - sends user to Lose Screen
        loseButton.setOnAction(event -> primaryStage.setScene(new Lose().createLoseScreen(primaryStage)));

        //Adds buttons and label to layout
        intermediateLayout.getChildren().addAll(winButton, mazeLabel, loseButton);
        //Adds Vbox to root container
        intermediateRoot.getChildren().add(intermediateLayout);

        //Creates scene with specific dimensions based on title screen
        return new Scene(intermediateRoot, 768, 576); 
    }
}

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lose {

    //Screen dimensions
    //16x16 pixels
    final int originalTileSize = 16;
    //Enlarges tiles
    final int scale = 3; 
    //Actual tile size 48x48
    public final int tileSize = originalTileSize * scale; 
    //Number of columns
    public final int maxScreenCol = 16; 
    //Number of rows
    public final int maxScreenRow = 12; 
    //Screen width - 768 pixels
    public final int screenWidth = maxScreenCol * tileSize; 
    //Screen height - 576 pixels
    public final int screenHeight = maxScreenRow * tileSize; 

    public Scene createLoseScreen(Stage primaryStage) {
        //Custom font for game texts
        Font pixelFont = Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 20);

        //Root container for Lose Screen
        StackPane loseRoot = new StackPane();
        //Vbox added with spacing
        VBox loseLayout = new VBox(20);
        //Centers elements in Vbox 
        loseLayout.setAlignment(Pos.CENTER);
        //Adds padding to vboz
        loseLayout.setPadding(new Insets(30));

        //Adding background image to screen
        Image loseBackgroundImage = new Image("file:/C:/Users/sophi/DogDaysJavaFX/images/lose9.png");
        ImageView loseBackgroundView = new ImageView(loseBackgroundImage);
        //Sets image to 87.5 % of screen wdith 
        loseBackgroundView.setFitWidth(screenWidth * 0.875);
        //Sets image to 85 % of screen height
        loseBackgroundView.setFitHeight(screenHeight * 0.85);

        //Creating rectangle to curve image corners
        Rectangle clip = new Rectangle(screenWidth * 0.875, screenHeight * 0.85);
        //Horizontal edges curve
        clip.setArcWidth(50); 
        //Vertical edges curve
        clip.setArcHeight(50); 
        //Applies curves
        loseBackgroundView.setClip(clip); 

        //Centering background image 
        StackPane loseImageContainer = new StackPane(loseBackgroundView);
        //Adding padding to image
        loseImageContainer.setPadding(new Insets(50));

        //Creating lose screen label
        Label loseLabel = new Label("Game Over");
        //Styles font with custom style and size
        loseLabel.setFont(Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 60)); 
        //Changing font to red
        loseLabel.setTextFill(Color.RED); 

        //Creating rectangle to go under lose label
        //Sets rectangle size
        Rectangle whiteBox = new Rectangle(350, 80);  
        //Changing color to black
        whiteBox.setFill(Color.BLACK);  
        //Curves horizontal edges
        whiteBox.setArcWidth(30); 
        //Curves vertical edges
        whiteBox.setArcHeight(30);  

        ///Creating shadow for rectangle 
        DropShadow dropShadow = new DropShadow();
        //Horizontal shadow offset
        dropShadow.setOffsetX(5);  
        //Vertical shadow offset
        dropShadow.setOffsetY(5);  
        //Changing shadow color to red
        dropShadow.setColor(Color.RED);  
        //Applies shadow 
        whiteBox.setEffect(dropShadow); 

        //Creates stockpane to layer label over rectangle 
        StackPane loseTitleContainer = new StackPane();
        loseTitleContainer.getChildren().addAll(whiteBox, loseLabel);
        //Moves container up
        loseTitleContainer.setTranslateY(-140); 
        //Adds container to layout
        loseLayout.getChildren().add(loseTitleContainer);

        //Creates button to try game again
        Button tryAgainButton = new Button("Try Again");
        //Applies custom font
        tryAgainButton.setFont(pixelFont); 
        //Changing font to white
        tryAgainButton.setTextFill(Color.WHITE);
        //Button style  
        tryAgainButton.setStyle("-fx-background-color: black; -fx-padding: 10 20; -fx-background-radius: 10;");
        //Moves button down
        tryAgainButton.setTranslateY(100);

        //Creating white shadow for button
        DropShadow buttonShadow = new DropShadow();
        //Horizontal shadow offset
        buttonShadow.setOffsetX(3); 
        //Vertical shadow offset
        buttonShadow.setOffsetY(3); 
        //Changing shadow to white
        buttonShadow.setColor(Color.WHITE);
        //Applies shadow 
        tryAgainButton.setEffect(buttonShadow);  

        //Creating action when Try Again button pressed - sends user to Title screen
        tryAgainButton.setOnAction(event -> primaryStage.setScene(new TitleScreen().createTitleScreen(primaryStage)));

        //Adds button to layout
        loseLayout.getChildren().add(tryAgainButton);
        loseRoot.getChildren().addAll(loseImageContainer, loseLayout);

        //Sets background color behind image to black 
        loseRoot.setStyle("-fx-background-color: black;");

        //Returns scene with previously defined dimensions 
        return new Scene(loseRoot, screenWidth, screenHeight);
    }
}

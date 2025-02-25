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

public class Win {

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


    public Scene createWinScreen(Stage primaryStage) {
        //Custom font for text
        Font pixelFont = Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 20);

        //Root container for Win Screen
        StackPane winRoot = new StackPane();
        //Vbox for layout
        VBox winLayout = new VBox(20);
        //Centers elements in vbox
        winLayout.setAlignment(Pos.CENTER);
        //Adds padding to Vbox
        winLayout.setPadding(new Insets(30));

        //Adds background image 
        Image winBackgroundImage = new Image("file:/C:/Users/sophi/DogDaysJavaFX/images/win10.jpg");
        //Displays image
        ImageView winBackgroundView = new ImageView(winBackgroundImage);
        //Sets image weidth to 87.5 % screen width
        winBackgroundView.setFitWidth(screenWidth * 0.875); 
        //Sets image height to 85 % screen height
        winBackgroundView.setFitHeight(screenHeight * 0.85);

        //Creates a rectangle to round the image corners
        Rectangle clip = new Rectangle(screenWidth * 0.875, screenHeight * 0.85);
        //Curves corners horizontally
        clip.setArcWidth(50); 
        //Curves corners vertically 
        clip.setArcHeight(50); 
        //Applies the curves
        winBackgroundView.setClip(clip); 

        //Creates stockpane to center image
        StackPane winImageContainer = new StackPane(winBackgroundView);
        //Adds padding to image
        winImageContainer.setPadding(new Insets(50)); 

        //Label stating the player won
        Label winLabel = new Label("You Win");
        //Applies custom font and size
        winLabel.setFont(Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 60)); 
        //Changing color to green
        winLabel.setTextFill(Color.GREEN); 

        //Creates rectangle for behind text
        //Rectangle size
        Rectangle whiteBox = new Rectangle(350, 80);  
        //Changing color to black
        whiteBox.setFill(Color.BLACK); 
        //Curves horizontal edges
        whiteBox.setArcWidth(30); 
        //Cuvres vertical edges 
        whiteBox.setArcHeight(30);  

        //Creating green shadow behind rectangle 
        DropShadow dropShadow = new DropShadow();
        //Horiztonal shadow offset
        dropShadow.setOffsetX(5); 
        //Vertical shadow offset 
        dropShadow.setOffsetY(5); 
        //Changing shadow color to green
        dropShadow.setColor(Color.GREEN);  
        //Applies shadow 
        whiteBox.setEffect(dropShadow);  

        //Stockpane to layer label over rectangle 
        StackPane winTitleContainer = new StackPane();
        winTitleContainer.getChildren().addAll(whiteBox, winLabel);
        //Moves container up on screen
        winTitleContainer.setTranslateY(-160); 

        //Adds container to layout
        winLayout.getChildren().add(winTitleContainer);

        //Creates Play Again button
        Button playAgainButton = new Button("Play Again");
        //Applies custom fond to text
        playAgainButton.setFont(pixelFont); 
        //Changing font color to white
        playAgainButton.setTextFill(Color.WHITE); 
        //Styles button
        playAgainButton.setStyle("-fx-background-color: black; -fx-padding: 10 20; -fx-background-radius: 10;");
        //Moves button down
        playAgainButton.setTranslateY(110);

        //Creating white button shadow 
        DropShadow buttonShadow = new DropShadow();
        //Horizontal shadow offset
        buttonShadow.setOffsetX(3);  
        //Vertical shadow offset
        buttonShadow.setOffsetY(3);  
        //Changing shadow color to white 
        buttonShadow.setColor(Color.WHITE); 
        //Applies shadow 
        playAgainButton.setEffect(buttonShadow);  

        //Creates action when Play Again button is pressed - sends user to Title Screen
        playAgainButton.setOnAction(event -> primaryStage.setScene(new TitleScreen().createTitleScreen(primaryStage)));

        //Adds Play Again button to layout 
        winLayout.getChildren().add(playAgainButton);
        winRoot.getChildren().addAll(winImageContainer, winLayout);

        //Sets background under image to black
        winRoot.setStyle("-fx-background-color: black;");

        //Returns scene with previously defined dimensions
        return new Scene(winRoot, screenWidth, screenHeight);
    }
}

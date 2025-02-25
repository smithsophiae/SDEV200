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

public class TitleScreen {

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


    public Scene createTitleScreen(Stage primaryStage) {
        //Custom pixel font for game screen
        Font pixelFont = Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 20);

        //Title Screen layout
        StackPane titleRoot = new StackPane();
        //Vbox to vertically align screen
        VBox titleLayout = new VBox(20);
        //Center all elements 
        titleLayout.setAlignment(Pos.CENTER);
        //Padding for elements
        titleLayout.setPadding(new Insets(30));

        //Title Screen Background Image
        Image titleBackgroundImage = new Image("file:/C:/Users/sophi/DogDaysJavaFX/images/title3.jpg");
        ImageView titleBackgroundView = new ImageView(titleBackgroundImage);
        //Sets image to 97.5 % of screen width 
        titleBackgroundView.setFitWidth(screenWidth * 0.975);  
        //Sets image to 95 % of screen height 
        titleBackgroundView.setFitHeight(screenHeight * 0.95); 

        //Creates a rectangle to round the image corners
        Rectangle clip = new Rectangle(screenWidth * 0.975, screenHeight * 0.95);
        //Curves corners horizontally
        clip.setArcWidth(50);
        //Curves corners vertically 
        clip.setArcHeight(50); 
        //Applies the curves
        titleBackgroundView.setClip(clip); 

        //Creates a white hightlighting shadow behind image
        DropShadow shadow = new DropShadow();
        //Horizontal offset for shadow
        shadow.setOffsetX(10); 
        //Vertical offset for shadow
        shadow.setOffsetY(10); 
        //Changing shadow color to white
        shadow.setColor(Color.WHITE); 
        //Shadow blur radius
        shadow.setRadius(15); 
        //Applies the shadow
        titleBackgroundView.setEffect(shadow); 

        //Container to center image
        StackPane titleImageContainer = new StackPane(titleBackgroundView);
        //Padding to futher center image
        titleImageContainer.setPadding(new Insets(50)); 

        //Creates title label for game
        Label titleLabel = new Label("Dog Days");
        //Styles with custom font and size
        titleLabel.setFont(Font.loadFont("file:/C:/Users/sophi/DogDaysJavaFX/images/PixelifySans-VariableFont_wght.ttf", 60)); 
        //Changing font color to sienna
        titleLabel.setTextFill(Color.SIENNA); 

        //Creates a rectangle behind title label

        //Setting the rectangle size
        Rectangle whiteBox = new Rectangle(300, 80); 
        //Changing color to black
        whiteBox.setFill(Color.BLACK); 
        //Curves horizontal corners
        whiteBox.setArcWidth(30);
        //Curves vertical corners  
        whiteBox.setArcHeight(30); 

        //Creating a shadow for title rectangle 
        DropShadow dropShadow = new DropShadow();
        //Horizontal offset for shadow
        dropShadow.setOffsetX(5);
        //Vertical offset for shadow
        dropShadow.setOffsetY(5); 
        //Changing color to match font
        dropShadow.setColor(Color.SIENNA);  
        //Applies shadow
        whiteBox.setEffect(dropShadow); 

        //Creates Stackpane to layer title label over the rectangle
        StackPane titleContainer = new StackPane();
        titleContainer.getChildren().addAll(whiteBox, titleLabel);
        //Shifts label up 
        titleLabel.setTranslateY(-5); 

        //Adds the title container to layout
        titleLayout.getChildren().add(titleContainer);

        //Creates the Play button 
        Button playButton = new Button("Play");
        //Sets button to custom font
        playButton.setFont(pixelFont); 
        //Changes color to white
        playButton.setTextFill(Color.WHITE); 
        //Style for button
        playButton.setStyle("-fx-background-color: black; -fx-padding: 10 20; -fx-background-radius: 10;");
        //Shifts button down
        playButton.setTranslateY(50);

        //Creates white shadow for Play button
        DropShadow buttonShadow = new DropShadow();
        //Horizontal offset for shadow
        buttonShadow.setOffsetX(3);  
        //Vertical offset for shadow
        buttonShadow.setOffsetY(3); 
        //Changes color to white
        buttonShadow.setColor(Color.WHITE);  
        //Applies shadow to button
        playButton.setEffect(buttonShadow);  

        //Creates action when button pressed - sends user to Maze Game Screen
        playButton.setOnAction(event -> primaryStage.setScene(new MazeScreen().createMazeScreen(primaryStage)));

        //Adds Play button to layout
        titleLayout.getChildren().add(playButton);
        titleRoot.getChildren().addAll(titleImageContainer, titleLayout);

        //Sets background to black behind the background image
        titleRoot.setStyle("-fx-background-color: black;");

        //Returns scene with previously defined dimensions
        return new Scene(titleRoot, screenWidth, screenHeight);
    }
}

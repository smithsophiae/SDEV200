import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Title of main window 
        primaryStage.setTitle("Dog Days");

        //Sets inital load up screen to Title Screen
        primaryStage.setScene(new TitleScreen().createTitleScreen(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //Launches javaFX application
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This is the main class for market side.
 * @author Emre Karatas -22001641
 * @version v1.0 - 17.07.2021
 */
public class Main extends Application {

    @Override
    /**
     * initializor method
     */
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Spoil'nt");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("Images/logo.jpeg"));
        primaryStage.setScene(new Scene(root, 520, 400));
        primaryStage.show();
    }


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

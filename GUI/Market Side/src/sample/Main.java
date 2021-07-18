package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Spoil'nt");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("Images/logo.jpeg"));
        primaryStage.setScene(new Scene(root, 520, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

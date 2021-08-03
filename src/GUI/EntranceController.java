package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class controls the entrance of all users
 * @author Emre Karataş
 * @version v1.0 20.07.2021
 */
public class EntranceController
{
    /**
     * This method controls the entrance of the market users
     * @param event
     * @throws IOException
     */
    public void marketButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("marketLogin.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method controls the entrance of the admin users
     * @param event
     * @throws IOException
     */
    public void adminButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method controls the entrance of the customer users
     * @param event
     * @throws IOException
     */
    public void customerButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();

    }
}

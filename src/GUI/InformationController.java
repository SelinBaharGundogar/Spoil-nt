package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls information.fxml page.
 * @author Aslı Karaman
 * @version v1.0 19.07.2021
 */
public class InformationController implements Initializable
{

    // variables
    @FXML
    private ImageView informationView = new ImageView();

    /**
     * This method initializes the categorization page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File informationFile = new File("");
        Image informationImage = new Image(informationFile.toURI().toString());
        informationView.setImage(informationImage);
    }

    /**
     * This method adds action to the return back button, which returns back to the main page
     * @param event
     * @throws IOException
     */
    public void returnToMainOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method adds action to the about us button, which enables user to go to about us page
     * @param event
     * @throws IOException
     */
    public void goToAboutUsOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("aboutUs.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method adds action to the food waste button, which enables user to go to food waste page
     * @param event
     * @throws IOException
     */
    public void goToFoodWasteOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("FoodWaste.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method adds action to the climate change button, which enables user to go to climate change page
     * @param event
     * @throws IOException
     */
    public void goToClimateChangeOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("ClimateChange.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method adds action to the poverty button, which enables user to go to poverty page
     * @param event
     * @throws IOException
     */
    public void goToPovertyOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("poverty.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method adds action to the tips button, which enables user to go to tips page
     * @param event
     * @throws IOException
     */
    public void goToTipsOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("tips.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }
}

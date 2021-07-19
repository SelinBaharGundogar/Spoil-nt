package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls profile page.
 * @author Emre Karatas-22001641
 * @version v1.0 -18.07.2021
 */
public class ProfileController implements Initializable
{
    @FXML
    private ImageView profileImageView = new ImageView();

    @FXML
    private Button mainPageButton;

    @Override
    /**
     * This method initializes market photo.
     */
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File profileFile = new File("Images/market-logo.jpg");
        Image profileImage = new Image(profileFile.toURI().toString());
        profileImageView.setImage(profileImage);

    }

    /**
     * This method add action to main page button.
     * @param event
     * @throws IOException
     */
   public void mainPageButtonOnAction(ActionEvent event) throws IOException
   {
       Parent profileView = FXMLLoader.load(getClass().getResource("mainPage_Market.fxml"));
       Scene profileViewScene = new Scene(profileView);

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(profileViewScene);
       stage.show();
   }

    /**
     * This method add action to updateSetttings button.
     * @param event
     * @throws IOException
     */
   public void updateSettingsButtonOnAction(ActionEvent event) throws IOException
   {
       Parent updateView = FXMLLoader.load(getClass().getResource("Market_Info.fxml"));
       Scene updateViewScene = new Scene(updateView);

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(updateViewScene);
       stage.show();

   }
}

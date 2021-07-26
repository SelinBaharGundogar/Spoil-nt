package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls DairyProductsCategorization.fxml page.
 * @author Aslı Karaman - 21901576
 * @version v1.0 19.07.2021
 */
public class FruitsVegetablesController implements Initializable
{
    // variables


    @FXML
    public static TableView<Item> view;
    @FXML
    private ImageView categorizationView = new ImageView();
    @FXML
    private  Label categoryName;
    @FXML
    private TableColumn<Item, SimpleStringProperty> nameC;
    @FXML
    private TableColumn<Item, String> marketC;
    @FXML
    private TableColumn<Item, Date> expireDateC;
    @FXML
    private TableColumn<Item, Double> priceC;
    @FXML
    private TableColumn<Item, Comment> evaluationC;


    /**
     * This method initializes the categorization page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        File categorizationFile = new File("Images/basket.jpeg");
        Image categorizationImage = new Image(categorizationFile.toURI().toString());
        categorizationView.setImage(categorizationImage);



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
     * This method adds action to the logout button, which enables user to logout of application
     * @param event
     * @throws IOException
     */
    public  void logOutButtonOnAction(ActionEvent event) throws IOException
    {
        int n = JOptionPane.showConfirmDialog(null,"Are you sure?","LogOut",JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            Parent loginView = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene loginViewScene= new Scene(loginView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginViewScene);
            stage.show();
        }
    }

    /**
     * This method adds action to the profile button, which enables user to go profile page
     * @param event
     * @throws IOException
     */
    public void profileButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();
    }

    /**
     * This method adds action to the information button, which enables user to go information page
     * @param event
     * @throws IOException
     */
    public void goToInformationOnAction(ActionEvent event) throws IOException
    {
        Parent informationView = FXMLLoader.load(getClass().getResource("information.fxml"));
        Scene informationViewScene= new Scene(informationView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(informationViewScene);
        stage.show();
    }
}

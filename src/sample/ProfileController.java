package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls profile page.
 * @author Emre Karatas-22001641, Selin Bahar Gundogar
 * @version v1.0 -18.07.2021
 */
public class ProfileController implements Initializable
{
    @FXML
    private ImageView profileImageView = new ImageView();

    @FXML
    private Button mainPageButton;



    @FXML
    private TableView<CustomerUser> table;

    @FXML
    private TableColumn<CustomerUser, Integer> no;

    @FXML
    private TableColumn<CustomerUser, Date> date;

    @FXML
    private TableColumn<CustomerUser, Integer> count;

    @FXML
    private TableColumn<CustomerUser, String> category;

    @FXML
    private TableColumn<CustomerUser, String> name;

    @FXML
    private TableColumn<CustomerUser, String> market;

    @FXML
    private TableColumn<CustomerUser, Integer> price;

    @FXML
    private TableColumn<CustomerUser, Integer> number;

    @FXML
    private TableColumn<CustomerUser, Comment> evaluation;


    ObservableList<CustomerUser> list = FXCollections.observableArrayList();

    @Override
    /**
     * This method initializes market photo.
     */
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File profileFile = new File("Images/market-logo.jpg");
        Image profileImage = new Image(profileFile.toURI().toString());
        profileImageView.setImage(profileImage);

        profileImageView.setImage(UserContainer.activeMarketUser.getMarketImage());
        name.setText(UserContainer.activeMarketUser.getMarketName());


        /*
        date.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getDate());
        no.setCellValueFactory(new PropertyValueFactory<CustomerUser, Integer>("name"));
        count.setCellValueFactory(new PropertyValueFactory<CustomerUser, String>("name"));
        category.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getCategory());
        name.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getName());
        market.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getMarketName());
        price.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getPrice());
        number.setCellValueFactory(new PropertyValueFactory<CustomerUser, String>("name"));
        evaluation.setCellValueFactory((UserContainer.currentUser -> UserContainer.currentUser.getItem().getComment());
*/


        //ID.setCellValueFactory(new PropertyValueFactory<CustomerUser, Integer>("ID"));
        //password.setCellValueFactory(new PropertyValueFactory<CustomerUser, String>("password"));
        table.setItems(list);

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

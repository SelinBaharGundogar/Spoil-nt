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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class controls main.fxml page.
 * @author Aslı Karaman - 21901576
 * @version v1.0 19.07.2021
 */
public class CustomerMainPageController implements Initializable
{
    // variables
    static ObservableList<Item> list= FXCollections.observableArrayList();
    static String categoryString;
    @FXML
    private Button Dairy;
    @FXML
    public static TableColumn<Item, String> basketView;
    @FXML
    private Button Bakery;
    @FXML
    private Button Snacks;
    @FXML
    private Button Fruits;
    @FXML
    private Button logOutButton;
    @FXML
    private javafx.scene.control.Label idLabel;
    @FXML
    private javafx.scene.control.Label userNameLabel;
    @FXML
    private Button profileButton;
    @FXML
    private javax.swing.JOptionPane JOptionPane;
    @FXML
    private ImageView b = new ImageView();


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
     * This method initializes the main page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File mainFile = new File("Images/basket.png");
        javafx.scene.image.Image mainImage = new Image(mainFile.toURI().toString());
        b.setImage(mainImage);
        categoryString = "arda";

       // userNameLabel.setText(UserContainer.currentUser.getUsername());
        //idLabel.setText(String.valueOf(UserContainer.currentUser.getID()));

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

    public void DairyButtonOnAction(ActionEvent event) throws IOException
    {
        ObservableList<Item> dairyList = FXCollections.observableArrayList();
        categoryString = "Dairy Products";
        MarketUser marketUser = new MarketUser("","",12,"", "");
        CustomerUser customerUser = new CustomerUser("","",1,"","");
        Comment c = new Comment("", 12, 2, 12, 13, marketUser, customerUser);
        ArrayList<Comment> cList = new ArrayList<>();
        cList.add(c);
        //dairyList.add(new Item("fhg",null,  "Dairy", "lklk", 12, "k", 12, cList  ));
        list = dairyList;

        Parent profileView = FXMLLoader.load(getClass().getResource("DairyProductsCategorization.fxml"));
        Scene profileViewScene= new Scene(profileView);

        /*for (Item i: ItemContainer.getItemsList()) {
            if(i.getCategory().equals("Dairy"))
                dairyList.add(i);
        }*/

        //CategorizationController c = new CategorizationController();
        //c.categoryName.setText("Dairy Products");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();
    }

    public void MeatProductsButtonOnAction(ActionEvent event) throws IOException
    {
        //CategorizationController.categoryName.setText("Dairy Products");
        Parent profileView = FXMLLoader.load(getClass().getResource("MeatProductsCategorizationPage.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }

    public void SnacksButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("SnacksCategorizationPage.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }

    public void FruitsButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("FruitsVegetables.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }
}

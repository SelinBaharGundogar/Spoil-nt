package GUI;

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
import model.Item;
import model.MarketUser;
import model.UserContainer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls main.fxml page.
 * @author Aslı Karaman - 21901576
 * @version v1.0 19.07.2021
 */
public class MainPageController implements Initializable
{
    // variables
    @FXML
    private Button logOutButton;
    @FXML
    private Button profileButton;

    @FXML
    private TableView<MarketUser> helpfulMarket;

    @FXML
    private TableView<Item> basket;

    @FXML
    private TableView<Item> discounted;

    @FXML
    private TableView<MarketUser>helpfulMarketsList;

    @FXML
    private TableColumn<Item, String> basketOFUser;

    @FXML
    private TableColumn<Item, String> discountedMost;

    @FXML
    private TableColumn<MarketUser, String>helpfulMarkets;

    @FXML
    private javax.swing.JOptionPane JOptionPane;
    @FXML
    private ImageView basketView = new ImageView();

    private ObservableList<MarketUser> marketUserListObservableList;

    private ObservableList<Item> basketItems;

    private ObservableList<Item> discountedMostItems;

    /**
     * This method initializes the main page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File mainFile = new File("Images/basket.png");
        javafx.scene.image.Image mainImage = new Image(mainFile.toURI().toString());
        basketView.setImage(mainImage);

        System.out.println(UserContainer.activeCustomerUser.id);
    }



    public void setBasket(){

    }





    public void setItemsOnTheTable(){
        marketUserListObservableList = FXCollections.observableList((UserContainer.getMarketUsersList()));
        basketItems = FXCollections.observableList(UserContainer.activeCustomerUser.getCurrentItems());
        discountedMostItems = FXCollections.observableList(getMostExpensive());

        basketOFUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        discountedMost.setCellValueFactory(new PropertyValueFactory<>("name"));
        helpfulMarkets.setCellValueFactory(new PropertyValueFactory<>("marketName"));

        helpfulMarket.setItems(marketUserListObservableList);
        discounted.setItems(discountedMostItems);
        basket.setItems(basketItems);
    }


    public ObservableList<Item> getMostExpensive() {
        double temp = 0;
        ObservableList<Item> list = FXCollections.observableArrayList();
        ObservableList<Item> tempOne = FXCollections.observableArrayList();
        for (MarketUser marketUser : UserContainer.getMarketUsersList()) {
            for (Item a : marketUser.getItems()) {
                if (a.getPrice() > temp && a.getStatus() == 1) {
                    temp = a.getPrice();
                    tempOne.add(a);
                }
            }
        }



        for (int count = tempOne.size() - 5; count < tempOne.size(); count++) {
            for (Item a : tempOne) {
                list.add(a);
            }
        }
        return list;
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

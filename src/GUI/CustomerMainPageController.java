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
import javafx.scene.control.*;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * This class controls main.fxml page.
 * @author Aslı Karaman, Selin Bahar Gundogar
 * @version v1.0 19.07.2021
 */
public class CustomerMainPageController implements Initializable
{
    // variables
    static ObservableList<Item> list= FXCollections.observableArrayList();
    static String categoryString;
    @FXML
    private TextField searchTextField;

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
    private Label idLabel;
    @FXML
    private Label userNameLabel;
    @FXML
    private Button profileButton;
    @FXML
    private javax.swing.JOptionPane JOptionPane;
    @FXML
    private ImageView imageView = new ImageView();

    @FXML
    private TableView<Item> basket;

    @FXML
    private TableColumn<Item, String> basketOFUser;

    @FXML
    private TableColumn<Item, String> discountedMost;

    @FXML
    private TableColumn<MarketUser, String> helpfulMarkets;

    @FXML
    private TableView<Item> discounted;

    @FXML
    private TableView<MarketUser> helpfulMarketsList ;




    private ObservableList<Item> basketItems;
    private ObservableList<Item> discountedMostItems;
    private ObservableList<MarketUser> helpfulMarketListObservable;


    /**
     * This method initializes the main page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File mainFile = new File("Images/basket.png");
        javafx.scene.image.Image mainImage = new Image(mainFile.toURI().toString());
        imageView.setImage(mainImage);
        System.out.println("customer page");
        System.out.println("market list");
        System.out.println(UserContainer.getMarketUsersList());
        System.out.println("active market user");
        System.out.println(UserContainer.activeMarketUser);


        userNameLabel.setText(UserContainer.activeCustomerUser.getUserName());
        idLabel.setText(String.valueOf(UserContainer.activeCustomerUser.getID()));
        setHelpfulMarkets();
        setAll();
    }


    public void setHelpfulMarkets()
    {
        int result = 0;
        int count=0;
        for (MarketUser marketUser : UserContainer.getMarketUsersList()) {
            for (Item a : marketUser.getItems()) {
                if(a.getStatus() == -1){
                    count++;
                    result += a.getScore();
                }

            }
            if ( count != 0)
                marketUser.setAverage(result / count);
        }



        Collections.sort(UserContainer.getMarketUsersList());
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
     * This method takes the items of the user.
     * @return basket items of the user
     */
    public ObservableList<Item> geBasketItemsOfUser(){
        ObservableList<Item> list = FXCollections.observableArrayList();
        for (Item a : UserContainer.activeCustomerUser.getCurrentItems()) {
            if ( a.getStatus() == 0 ){
                list.add(a);
            }
        }
        return list;
    }


    /**
     * This method sets all of the information on the tableviews.
     */
    public void setAll(){
        helpfulMarketListObservable = FXCollections.observableList((UserContainer.getMarketUsersList()));
        basketItems = FXCollections.observableList(geBasketItemsOfUser());
        discountedMostItems = FXCollections.observableList(getMostExpensive());

        basketOFUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        discountedMost.setCellValueFactory(new PropertyValueFactory<>("name"));
        helpfulMarkets.setCellValueFactory(new PropertyValueFactory<>("marketName"));

        helpfulMarketsList.setItems(helpfulMarketListObservable);
        discounted.setItems(discountedMostItems);
        basket.setItems(basketItems);
    }

    /**
     * This method gets the most expensive items.
     * @return the most expensive items
     */
    public ObservableList<Item> getMostExpensive() {

        ObservableList<Item> list = FXCollections.observableArrayList();
        ArrayList<Item> items = new ArrayList<>();
        for (MarketUser marketUser : UserContainer.getMarketUsersList()) {
            for (Item a : marketUser.getItems()) {
                items.add(a);
            }
        }

        Collections.sort(items);
        if (items.size() >= 5)
        {
            for (int i = 0; i < 5; i++){
                list.add(i, items.get(i));
            }
        }
        else
        {
            for (int i = 0; i < items.size(); i++){
                list.add(i, items.get(i));
            }
        }

        return list;

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

    /**
     * This method opens the Dairy products categorization fxml.
     * @param event
     * @throws IOException
     */
    public void DairyButtonOnAction(ActionEvent event) throws IOException
    {
        ObservableList<Item> dairyList = FXCollections.observableArrayList();
        categoryString = "Dairy Products";

        list = dairyList;

        Parent profileView = FXMLLoader.load(getClass().getResource("DairyProductsCategorization.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();
    }

    /**
     * This method opens the meat products categorization fxml.
     * @param event
     * @throws IOException
     */
    public void MeatProductsButtonOnAction(ActionEvent event) throws IOException
    {
        Parent meatView = FXMLLoader.load(getClass().getResource("MeatProductsCategorizationPage.fxml"));
        Scene meatViewScene= new Scene(meatView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(meatViewScene);
        stage.show();

    }

    /**
     * This method opens the snacks products categorization fxml.
     * @param event
     * @throws IOException
     */
    public void SnacksButtonOnAction(ActionEvent event) throws IOException
    {
        Parent snacksView = FXMLLoader.load(getClass().getResource("SnacksCategorizationPage.fxml"));
        Scene snacksViewScene= new Scene(snacksView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(snacksViewScene);
        stage.show();

    }

    /**
     * This method opens the fruits and vegetables products categorization fxml.
     * @param event
     * @throws IOException
     */
    public void FruitsButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("FruitsVegetables.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }

    /**
     * This method directs the user to the categorization page they type
     * @param event
     * @throws IOException
     */
    public void search(ActionEvent event) throws IOException
    {
        String category = searchTextField.getText();
        if (category.equals("Dairy Products"))
        {
            Parent dairyProductsView = FXMLLoader.load(getClass().getResource("DairyProductsCategorization.fxml"));
            Scene dairyProductsViewScene= new Scene(dairyProductsView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(dairyProductsViewScene);
            stage.show();
        }
        else if (category.equals("Meat Products"))
        {
            Parent meatView = FXMLLoader.load(getClass().getResource("MeatProductsCategorizationPage.fxml"));
            Scene meatViewScene= new Scene(meatView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(meatViewScene);
            stage.show();
        }
        else if (category.equals("Snacks"))
        {
            Parent snacksView = FXMLLoader.load(getClass().getResource("SnacksCategorizationPage.fxml"));
            Scene snacksViewScene= new Scene(snacksView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(snacksViewScene);
            stage.show();
        }
        else if (category.equals("Fruits & Vegetables"))
        {
            Parent fruitsVegetablesView = FXMLLoader.load(getClass().getResource("FruitsVegetables.fxml"));
            Scene fruitsVegetablesViewScene= new Scene(fruitsVegetablesView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(fruitsVegetablesViewScene);
            stage.show();
        }

    }


}
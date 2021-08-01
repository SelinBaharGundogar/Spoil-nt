package GUI;



import javafx.beans.property.SimpleStringProperty;
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

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls DairyProductsCategorization.fxml page.
 * @author Aslı Karaman - 21901576
 * @version v1.0 19.07.2021
 */
public class MeatProductsCategorizationController implements Initializable
{
    // variables


    @FXML
    public static TableView<Item> view;
    @FXML
    private ImageView categorizationView = new ImageView();
    @FXML
    public TableView<Item> table1;
    @FXML
    private TableColumn<Item, Double> price;
    @FXML
    private TableColumn<Item, Date> date;
    @FXML
    public Label error;

    @FXML
    private TableColumn<Item, String> name;


    @FXML
    private TableView<Item> basket;

    @FXML
    private TableColumn<Item, String> basketOFUser;

    @FXML
    private TableColumn<Item, String> discountedMost;

    @FXML
    private TableView<Item> discounted;

    private ObservableList<Item> basketItems;
    private ObservableList<Item> discountedMostItems;

    @FXML
    private Button addBasket;
    @FXML
    private TableColumn<Item, String> market;
    private ObservableList<Item> itemList;
    private ObservableList<Item> itemsOfDairyProducts;

    /**
     * This method initializes the categorization page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        File categorizationFile = new File("Images/basket.jpeg");
        Image categorizationImage = new Image(categorizationFile.toURI().toString());
        categorizationView.setImage(categorizationImage);
        setItemsOnTheTable();
    }

    /**
     * This method sets item on the table
     */
    public void setItemsOnTheTable(){
        itemList = getItemOfCategories();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        market.setCellValueFactory(new PropertyValueFactory<>("market"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        table1.setItems(itemList);
    }

    /**
     * This method settings all tableviews
     */
    public void setAll()
    {

        basketItems = FXCollections.observableList(geBasketItemsOfUser());
        discountedMostItems = FXCollections.observableList(getMostExpensive());

        basketOFUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        discountedMost.setCellValueFactory(new PropertyValueFactory<>("name"));
        //productname.setCellValueFactory(new PropertyValueFactory<>("name"));
        //quantity.setCellValueFactory(new PropertyValueFactory<>("name"));
        discounted.setItems(discountedMostItems);
        basket.setItems(basketItems);
    }

    /**
     * Getting most expensive
     * @return
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

        /*double temp = 0;
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
         */
        return list;

    }

    /**
     * Gets basket items of the user
     * @return
     */
    public ObservableList<Item> geBasketItemsOfUser()
    {
        ObservableList<Item> list = FXCollections.observableArrayList();
        for (Item a : UserContainer.activeCustomerUser.getCurrentItems()) {
            if ( a.getStatus() == 0 ){
                list.add(a);
            }
        }
        return list;
    }

    /**
     * Reserves items
     * @throws IOException
     */
    public void reserve() throws IOException {
        int amountReserved;
        //needs fixing
        amountReserved = 1;
        Item item = table1.getSelectionModel().getSelectedItem();


        if ( amountReserved > item.getAmount() ){
            error.setText("You cannot buy it");
            //give error message
            //UserContainer.activeMarketUser.getItems().remove();
        }
        else if ( (item.getAmount() - amountReserved == 0)) {
            item.setStatus(-1);
            item.setAmount( Double.parseDouble(""+ (item.getAmount() - 1)));
        }
        else {
            item.setAmount( Double.parseDouble(""+ (item.getAmount() - 1)));
        }

        Item newItem = new Item( item.getName(), item.getMarket(), item.getDueDate(), item.getCategory(), item.getBrand(), item.getPrice(), item.getMeasure(), 1);
        newItem.setItemID(item.getItemID());
        newItem.setStatus(0);
        UserContainer.activeCustomerUser.addItem(newItem);
        setAll();
        setItemsOnTheTable();
    }


    /**
     * Button method
     * @throws IOException
     */
    public void buttonMethod() throws IOException {
        reserve();
    }

    /**
     * Gets items of categories
     * @return
     */
    public ObservableList getItemOfCategories(){

        ObservableList<Item> list = FXCollections.observableArrayList();
        for (MarketUser marketUser : UserContainer.getMarketUsersList() ) {
            for ( Item a : marketUser.getItems() )
            {
                if ( a.getCategory().equals("Meat Products")) {
                    list.add(a);
                }
            }
        }
        return list;
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


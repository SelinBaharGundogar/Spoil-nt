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
import javafx.stage.Stage;
import model.Item;
import model.UserContainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

/**
 * This class controls IDPage.
 * @author Emre Karatas-22001641, Selin Bahar Gundogar
 * @version v1.0-18.07.2021
 */
public class IDController implements Initializable
{
    @FXML
    private Button returnMainButton;

    @FXML
    private TextField idTextField;

    @FXML
    private Label idMessageLabel;


    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> productname;


    private ObservableList<Item> lisItemsOfCustomer;

    ObservableList<Item> itemOfTheMarketUser;

    /**
     * This method initializes the controller and sets all the items on the table
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setItemsOnTheTable();
    }

    /**
     * this method displays the item of the market user
     * @return items of the market user
     */
    public ObservableList<Item> displayedItem(){
        itemOfTheMarketUser = FXCollections.observableList(checkID());
        return itemOfTheMarketUser;
    }

    /**
     * This method sets the items of the customer user on the table
     */
    public void setItemsOnTheTable(){
        lisItemsOfCustomer = checkID();
        productname.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(lisItemsOfCustomer);
        System.out.println(" setItemsOnTheTable called");
    }

    /**
     * This method checks and search for the ID
     * @return ID if found
     */
    public int onlyCheckID( ){
        int id = 0;
        try {
            id = Integer.parseInt(idTextField.getText());
        }catch (NullPointerException a) {
            System.out.println("null");
        }catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return id;
    }

    /**
     * This method gets the items of a customer user
     * @return the list of items
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
     * This method gives a list of items of the found ID
     * @return
     */
    public ObservableList<Item> checkID(){
        System.out.println("Check id entered");
        int id = onlyCheckID();
        ObservableList<Item> list = FXCollections.observableArrayList();
        if(id == (UserContainer.activeCustomerUser.getID()))
        {
            for( Item a: UserContainer.activeCustomerUser.getCurrentItems()){
                System.out.println("for entered");
                if(a.getMarket().equals(UserContainer.activeMarketUser.getMarketName()) && a.getStatus() == 0 )
                {
                    list.add(a);
                    System.out.println("for if entered");
                }
            }
            System.out.println("if entered");
        }
        return list;
    }

    /**
     * This method creates an action for the search button
     * @param event
     */
    public void searchButtonOnAction( ActionEvent event) {
        onlyCheckID();
        setItemsOnTheTable();
        System.out.println("clicked");
    }

    /**
     * Add action to sell button.
     * @param event
     */
    public void sellButtonOnAction(ActionEvent event)
    {
        if ( idTextField.getText().isBlank())
        {
            idMessageLabel.setText("You must provide an ID!");
        }
        else
        {
            idMessageLabel.setText("Sold successfully!");
            for ( Item a : checkID() ) {
                a.setStatus(-1);
                setItemsOnTheTable();
                System.out.println("inside loop sold");
            }
            System.out.println("not blank");
            //status code implementation
        }
        System.out.println("sell button on action");
    }

    /**
     * Add action to return main page button.
     * @param event
     * @throws IOException
     */
    public void returnMainButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("MainPage_Market.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }
}

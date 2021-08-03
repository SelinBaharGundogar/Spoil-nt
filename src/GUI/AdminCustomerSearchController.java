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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CustomerUser;
import model.Item;
import model.UserContainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls the AdminCustomerSearchController fxml page
 * @author Emre Karatas, Selin Bahar Gundogar
 * @version 1 August 2021
 */
public class AdminCustomerSearchController implements Initializable
{
    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> name;



    @FXML
    private TextField idTextField;

    private ObservableList<Item> customerItems;

    /**
     * This method adds action to the return back button, which returns back to the main page
     * @param event
     * @throws IOException
     */
    public void returnToMainPage(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminMain.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }

    /**
     * This method initializes the admin customer search page
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setItems();
    }

    public ObservableList<Item> getItems(){
        ObservableList<Item> itemOfTheCustomerUser = FXCollections.observableList(checkIDOfCustomerUser());
        return itemOfTheCustomerUser;
    }

    /**
     * This button lists the past items of the customer
     * @param event
     */
    public void searchButtonOnAction(ActionEvent event)
    {
        setItems();
    }


    /**
     *  This method checks the ID of users
     * @return list of items of that user
     */
    public ObservableList<Item> checkIDOfCustomerUser(){

        ObservableList<Item> list = FXCollections.observableArrayList();
        for (CustomerUser customerUser  : UserContainer.getCustomerUsersList() ) {

            try {
                if(Integer.parseInt(idTextField.getText())== customerUser.getID())
                {
                    for( Item a: customerUser.getCurrentItems()){
                        if( a.getStatus() == 0 )
                            list.add(a);
                    }
                }
            }catch (NullPointerException a) {
                System.out.println("null");
            }catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }

        }
        return list;
    }


    /**
     * This method sets the items on the tableview.
     */
    public void setItems(){
        customerItems = getItems();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(customerItems);
    }

    /**
     * This method deletes the user that is selected
     * @param event
     */
    public void banCustomerUser(ActionEvent event)
    {
        for (CustomerUser customerUser  : UserContainer.getCustomerUsersList() )
        {

            try {
                if(Integer.parseInt(idTextField.getText())== customerUser.getID())
                {
                    System.out.println("banned");
                    UserContainer.customerUsersList.remove(customerUser);
                    setItems();
                    break;
                }
            }catch (NullPointerException a) {
                System.out.println("null");
            }catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }

        }
        System.out.println("clicked");

    }


}

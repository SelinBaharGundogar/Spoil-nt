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
import model.Item;
import model.MarketUser;
import model.UserContainer;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Admin market search controller class
 * @author Emre Karatas, Parsa Keihan
 * @version v1.0 -19.07.2021
 */
public class AdminMarketSearchController implements Initializable
{

    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> name;

    @FXML
    private TextField idTextField;

    private ObservableList<Item> marketUserItems;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setItems();
    }

    public ObservableList<Item> getItems(){
        ObservableList<Item> itemOfTheMarketUser = FXCollections.observableList(checkIDOfMarketUser());
        return itemOfTheMarketUser;
    }

    public ObservableList<Item> checkIDOfMarketUser(){

        System.out.println("inside");
        ObservableList<Item> list = FXCollections.observableArrayList();
        for (MarketUser marketUser : UserContainer.getMarketUsersList() )
        {
            try {
                if(Integer.parseInt(idTextField.getText())== marketUser.getID())
                {
                    System.out.println("inside if1");
                    for( Item a: marketUser.getAllItems()){
                        if( a.getStatus() == -1 ){
                            System.out.println("inside if2");
                            list.add(a);
                        }

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
    public void setItems(){
        marketUserItems = getItems();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(marketUserItems);
    }

    public void searchButtonOnAction(ActionEvent event)
    {
        setItems();
    }
    @FXML
    public void backToMainPage(ActionEvent event) throws IOException {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminMain.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }
    public void banMarketUser(ActionEvent event) {
        for (MarketUser marketUser : UserContainer.getMarketUsersList()) {

            try {
                if (Integer.parseInt(idTextField.getText()) == marketUser.getID()) {
                    UserContainer.marketUsersList.remove(marketUser);
                    setItems();
                    break;
                }
            } catch (NullPointerException a) {
                System.out.println("null");
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }

        }
    }

}

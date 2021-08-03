package GUI;
import java.awt.*;
import java.awt.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import java.awt.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Item;
import model.UserContainer;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * This class controls removeItem page.
 * @author Emre Karatas-22001641
 * @version v1.0-20.07.2021
 * */
public class RemoveItemController  implements Initializable{

    /**
     * This method add action to main page button.
     *
     * @param event
     * @throws IOException
     */

    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> category;

    @FXML
    private TableColumn<Item, String> productname;

    @FXML
    private TableColumn<Item, Date> expirationdate;

    ObservableList<Item> itemOfTheMarketUser;


    @FXML
    private Button anotherButton;

    private ObservableList<Item> itemList;



    @Override
    /**
     * Initializes page
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setItemsOnTheTable();
    }

    /**
     * Displays item
     * @return
     */
    public ObservableList<Item> displayedItem()
    {
        itemOfTheMarketUser = FXCollections.observableList(UserContainer.activeMarketUser.getItems());
        return itemOfTheMarketUser;
    }

    /**
     * Set items on the table
     */
    public void setItemsOnTheTable()
    {

        itemList = displayedItem();
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        productname.setCellValueFactory(new PropertyValueFactory<>("name"));
        expirationdate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        table.setItems(itemList);
    }

    /**
     * Button method on action
     */
    public void buttonMethod()
    {
        for ( Item item : displayedItem())
        {
            if ( item.equals(table.getSelectionModel().getSelectedItem()))
            {
                table.getItems().remove(item);
                item.setRemoved();
                item.setStatus(-1);
                break;
            }

        }
        setItemsOnTheTable();
    }

    /**
     * Returns to main page
     * @param event
     * @throws IOException
     */
    public void toMainPageButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("MainPage_Market.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }


}
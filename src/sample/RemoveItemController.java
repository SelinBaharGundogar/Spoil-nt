package sample;

import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * This class controls removeItem page.
 */
public class RemoveItemController
{

    /**
     * This method add action to main page button.
     * @param event
     * @throws IOException
     */

    @FXML
    private TableView<MarketUser> table;

    @FXML
    private TableColumn<MarketUser, String> category;

    @FXML
    private TableColumn<MarketUser, String> productname;

    @FXML
    private TableColumn<MarketUser, Date> expirationdate;

    @FXML
    private TableColumn<MarketUser, Integer> unitmeasure;


    @FXML
    private TableColumn<MarketUser, Integer> quantityleft;

    @FXML
    private TableColumn<MarketUser, Button> remove;


    ObservableList<MarketUser> list = FXCollections.observableArrayList();

    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this may need review as the variable name is needed and not the value of the variable
        category.setCellValueFactory((UserContainer.currentUser.getItem().getCategory()));
        //setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        productname.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getName());
        expirationdate.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getDate());
        unitmeasure.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getMeasure());
        quantityleft.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getQuantity());
        //this will change ddepending on how the data class was implemented
        list.add(UserContainer.currentUser);
        remove.setCellValueFactory(new PropertyValueFactory<MarketUser, Button>("button"));
        table.setItems(list);
    }
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

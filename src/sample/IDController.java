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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    private TableView<CustomerUser> table;

    @FXML
    private TableColumn<CustomerUser, String> productname;

    @FXML
    private TableColumn<CustomerUser, Integer> quantity;



    ObservableList<CustomerUser> list = FXCollections.observableArrayList(
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Bu sinifin tableview'ini implement etmemiz icin id search metodunun yazilmasi gerekiyor
        //ID control metodu gerekiyor

        /*/
        list.add(UserContainer.customerUsersList.getIDMathcing User()?);
        productname.setCellValueFactory(UserContainer.customerUsersList -> UserContainer.customerUsersList.getItems().getName());
        quantity.setCellValueFactory(UserContainer.customerUsersList -> UserContainer.customerUsersList.getItem().getQuantity());
        // expirationdate.setCellValueFactory(UserContainer.currentUser -> UserContainer.currentUser.getItem().getDate());
        table.setItems(list);
        */
    }




    public void searchButtonOnAction( ActionEvent event) {
        idTextField.getText();
        //data sinifinda id'ye gore aratma metodu
        //data sinifinda kategoriye gore aratma metodu
    }

//search button'a action metodu


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
            //status code implementation
        }
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

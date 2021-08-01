package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Item;
import model.ItemContainer;
import model.UserContainer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls addItem.fxml page.
 * @author Emre Karatas-22001641
 * @version v1.0 18.07.2021
 */
public class AddItemController implements Initializable
{


    @FXML
    private TextField name;
    @FXML
    private ChoiceBox<String> category;
    @FXML
    private DatePicker dateOfEx;
    @FXML
    private TextField quantity;
    @FXML
    private ChoiceBox<String> quantityBox;
    @FXML
    private TextField price;
    @FXML
    private TextField brandName;
    @FXML
    private Label addItemMessageLabel;

    private String[] quantities = { "L", "Kg"};
    private String[] categories = {"Dairy Products", "Meat Products", "Fruits & Vegetables","Snacks"};


    /**
     * Add action to add button.
     * @param event
     */
    public void addButtonOnAction(ActionEvent event)
    {

        System.out.println("arda");
        Item newItem = new Item(name.getText(), UserContainer.activeMarketUser.getMarketName(), dateOfEx.getValue(), String.valueOf(category.getValue()), brandName.getText(), Double.parseDouble( price.getText()), quantityBox.getValue(), Double.parseDouble(quantity.getText()) );
        UserContainer.activeMarketUser.addItem(newItem);
        ItemContainer.addItemsList(newItem);
        addItemMessageLabel.setText("Item added successfully!");
        System.out.println(UserContainer.activeMarketUser.getItems());
    }

    /**
     * Add action to close button, it goes back to main page.
     * @param event
     * @throws IOException
     */
    public void closeButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("MainPage_Market.fxml"));
        Scene mainViewScene = new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    @Override
    /**
     * This method initializes choice boxes.
     */
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        quantityBox.getItems().addAll(quantities);
        category.getItems().addAll(categories);
        ItemContainer c = new ItemContainer();
    }
}

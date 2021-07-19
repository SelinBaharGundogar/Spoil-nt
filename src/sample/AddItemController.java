package sample;

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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    private String[] categories = { "Fish","Milk", "Meat", "Fruits&Vegetables","Snacks"};


    /**
     * Add action to add button.
     * @param event
     */
    public void addButtonOnAction(ActionEvent event)
    {
        if ( dateOfEx.getValue() != null)
        {
            if ( dateOfEx.getValue().isBefore(LocalDate.now()))
            {
                addItemMessageLabel.setText("The date you entered should be in future!");
            }
        }
        else if (category.getItems() == null)
        {
            addItemMessageLabel.setText("Add an item to category!");
        }
        else if (name.getText().isBlank() || quantity.getText().isBlank()  || price.getText().isBlank() || brandName.getText().isBlank())
        {

            addItemMessageLabel.setText("Must fill all the details about the item!");
        }
        else if ( Double.parseDouble(price.getText()) < 0)
        {
            addItemMessageLabel.setText("Price of the item cannot be negative!");
        }
        else if ( Double.parseDouble(quantity.getText()) < 0 )
        {
            addItemMessageLabel.setText("Quantity cannot be negative!");
        }
        else
        {
            addItemMessageLabel.setText("Item added successfully!");
        }

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



    }
}

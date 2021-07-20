package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This class controls IDPage.
 * @author Emre Karatas-22001641
 * @version v1.0-18.07.2021
 */
public class IDController
{
    @FXML
    private Button returnMainButton;

    @FXML
    private TextField idTextField;

    @FXML
    private Label idMessageLabel;


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

package GUI;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.UserContainer;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Admin class controller
 * @author Emre Karatas, Parsa Keihan
 * @version v1.0 -19.07.2021
 */
public class AdminMainController implements Initializable
{
    @FXML
    private Label dateTime;

    @FXML
    private TextField nameTextField;
    @FXML
    private PasswordField password;
    @FXML
    private Label idLabel;
    @FXML
    private Label updateLabel;
    @FXML
    private Label userCountLabel;
    @FXML
    private Label marketCountLabel;

    /**
     * Logout button on action
     * @param event
     * @throws IOException
     */
    public  void logOutButtonOnAction(ActionEvent event) throws IOException
    {
        int n = JOptionPane.showConfirmDialog(null,"Are you sure?","LogOut",JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            Parent loginView = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Scene loginViewScene= new Scene(loginView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginViewScene);
            stage.show();
        }
        else
        {

        }

    }

    /**
     * Update button on action
     * @param event
     */
    public void updateButtonOnAction(ActionEvent event)
    {
        if ( !nameTextField.getText().isBlank() && !password.getText().isBlank() && password.getText().length() >= 6 )
        {
            updateLabel.setText("Updated!");
            UserContainer.activeAdminUser.setUsername(nameTextField.getText());
            UserContainer.activeAdminUser.setPassword(password.getText());
        }
        else
        {

            updateLabel.setText("Update failed!");
        }
    }

    /**
     * This button opens the market search page
     * @param event
     * @throws IOException
     */
    public void marketSearchButtonOnAction(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminMarketSearch.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }


    /**
     * This button opens the admin customer search page.
     * @param event
     * @throws IOException
     */
    public void customerSearchButtonOnAction(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminCustomerSearch.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }

    /**
     * This method initializes the methods that will be viewed by the user.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        initClock();
        nameTextField.setText(UserContainer.activeAdminUser.getUsername());
        password.setText(UserContainer.activeAdminUser.getPassword());
        idLabel.setText(UserContainer.activeAdminUser.getID() + "");
        if ( UserContainer.customerUsersList == null)
        {
            userCountLabel.setText("0");
        }
        if ( UserContainer.marketUsersList == null)
        {
            marketCountLabel.setText("0");
        }
        else
        {
            userCountLabel.setText(UserContainer.getCustomerUsersList().size()+ "");
            marketCountLabel.setText(UserContainer.getMarketUsersList().size() +"");
        }


    }

    /**
     * This method initializes the clock.
     */
    public void initClock()
    {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}

package sample;

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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Admin class controller
 * @author Emre Karatas-22001641
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
    private Label updateLabel;

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
        if ( (!nameTextField.getText().isBlank() || !password.getText().isBlank()) && password.getText().length() >= 6 )
        {
            updateLabel.setText("Updated!");
        }
        else
        {
            updateLabel.setText("Update failed!");
        }
    }

    public void marketSearchButtonOnAction(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminMarketSearch.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }

    public void customerSearchButtonOnAction(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("AdminCustomerSearch.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        initClock();
        nameTextField.setText("Özcan Öztürk");

    }

    public void initClock()
    {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}

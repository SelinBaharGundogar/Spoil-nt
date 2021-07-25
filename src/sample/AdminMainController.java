package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * Admin class controller
 * @author Emre Karatas-22001641
 * @version v1.0 -19.07.2021
 */
public class AdminMainController
{
    @FXML
    private Label maintainance;
    @FXML
    private Label notification;
    @FXML
    private TextArea notificationTextArea;
    @FXML
    private CheckBox customerCheckBox;
    @FXML
    private CheckBox marketCheckBox;
    @FXML
    private TextField name;
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
     * Maintainance button on action
     * @param event
     */
    public void maintainanceButtonOnAction(ActionEvent event)
    {
        maintainance.setText("Maintaince is running...");
    }

    public void notificationButtonOnAction(ActionEvent event)
    {
        if ( notificationTextArea.getText().isBlank())
        {
            notification.setText("Please give details about notification.");
        }
        else if ( !marketCheckBox.isSelected() && !customerCheckBox.isSelected())
        {
            notification.setText("Please select check boxes!");
        }
        else if ( marketCheckBox.isSelected() && !customerCheckBox.isSelected())
        {
            notification.setText("Notification sent to markets!");
        }
        else if ( customerCheckBox.isSelected() && !marketCheckBox.isSelected())
        {
            notification.setText("Notification sent to customers!");
        }
        else if (  customerCheckBox.isSelected() && marketCheckBox.isSelected())
        {
            notification.setText("Notification sent to both!");
        }
    }

    /**
     * Update button on action
     * @param event
     */
    public void updateButtonOnAction(ActionEvent event)
    {
        if ( (!name.getText().isBlank() || !password.getText().isBlank()) && password.getText().length() >= 6 )
        {
            updateLabel.setText("Updated!");
        }
        else
        {
            updateLabel.setText("Update failed!");
        }
    }
}

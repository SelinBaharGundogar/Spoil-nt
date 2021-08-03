package GUI;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.UserContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class controls customer settings change fxml.
 * @author Aslı Karaman, Selin Bahar Gundogar, Arda Ceylan
 * @version v1.0 19.07.2021
 */
public class CustomerSettingsChangeController implements Initializable
{

    @FXML
    private Label updateMessageLabel;
    @FXML
    private TextField nameOfCustomer;
    @FXML
    private TextField surnameOfCustomer;
    @FXML
    private TextField usernameOfCustomer;
    @FXML
    private RadioButton deactivateRadioButton;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label changePasswordLabel;
    @FXML
    private TextArea addressTextArea;



    /**
     * This method add action to back profile page button.
     */
    public void backToProfileOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("profile.fxml"));
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
        nameOfCustomer.setText(UserContainer.activeCustomerUser.getName());
        surnameOfCustomer.setText(UserContainer.activeCustomerUser.getSurname());
        usernameOfCustomer.setText(UserContainer.activeCustomerUser.getUserName());
        addressTextArea.setText(UserContainer.activeCustomerUser.getAddress());
        emailTextField.setText(UserContainer.activeCustomerUser.getEmail());
        passwordTextField.setText(UserContainer.activeCustomerUser.getPassword());

    }

    /**
     * This method add action to update button.
     * @param event
     * @throws IOException
     */
    public void updateButtonOnAction(ActionEvent event) throws IOException
    {

        if ( nameOfCustomer.getText().isBlank() && deactivateRadioButton.isSelected())
        {
            int selection = JOptionPane.showConfirmDialog(null,"Are you sure?","Deactivation Confirmation",JOptionPane.OK_CANCEL_OPTION);
            if ( selection == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Your account is deactivated successfully!");
                toLoginPage(event);
            }
        }
        else if ( nameOfCustomer.getText().isBlank())
        {
            updateMessageLabel.setText("Name cannot be blank!");
        }
        else
        {
            UserContainer.activeCustomerUser.setName(nameOfCustomer.getText());
            UserContainer.activeCustomerUser.setAddress(addressTextArea.getText());
            UserContainer.activeCustomerUser.setSurname(surnameOfCustomer.getText());
            UserContainer.activeCustomerUser.setUserName(usernameOfCustomer.getText());
            updateMessageLabel.setText("Updated successfully!");
        }
    }

    /**
     * This method add action to update password button.
     * @param event
     */
    public void updatePasswordOnAction(ActionEvent event)
    {
        if ( emailTextField.getText().isBlank() || passwordTextField.getText().isBlank())
        {
            changePasswordLabel.setText("Fill e-mail and/or password");
        }
        else
        {
            UserContainer.activeCustomerUser.setPassword(emailTextField.getText());
            changePasswordLabel.setText("Password updated successfully!");
        }

    }

    /**
     * This method connects update settings page with login page.
     * @param event
     * @throws IOException
     */
    public void toLoginPage(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginViewScene= new Scene(loginView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginViewScene);
        stage.show();
    }




}

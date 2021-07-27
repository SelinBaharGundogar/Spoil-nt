package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MarketRegisterController implements Initializable
{
    @FXML
    private Button cancelButton;

    @FXML
    private Button registerButton;

    @FXML
    private ImageView registerView = new ImageView();

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;
    @FXML
    private TextArea adressTextArea;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private Label passwordWarningLabel;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File registerFile = new File("Images/register.jpeg");
        Image registerImage = new Image(registerFile.toURI().toString());
        registerView.setImage(registerImage);
        UserContainer container = new UserContainer();
    }

    public void registerButtonOnAction(ActionEvent event)
    {
        if (nameTextField.getText().isBlank() ||  emailTextField.getText().isBlank() || adressTextArea.getText().isBlank() || passwordTextField.getText().isBlank() || confirmPasswordTextField.getText().isBlank())
        {
            registerMessageLabel.setText("Please fill all the areas!");
        }
        else if ( !passwordTextField.getText().equals(confirmPasswordTextField.getText()))
        {
            passwordWarningLabel.setText("Passwords do not match!");

        }
        else if (passwordTextField.getLength() < 6 && confirmPasswordTextField.getLength() < 6)
        {
            passwordWarningLabel.setText("Password length should at least 6.");
        }
        else
        {
            passwordWarningLabel.setText("");
            registerMessageLabel.setText("User has been registered successfully!");
            registerUser(event);
        }

    }

    /**
     * this method add action to close button.
     * @param event
     * @throws IOException
     */
    public void closeButtonOnAction(ActionEvent event) throws IOException
    {
        goToLogin(event);
    }

    public void registerUser(ActionEvent event)
    {
        MarketUser user = new MarketUser(emailTextField.getText(), passwordTextField.getText(), 0, adressTextArea.getText(),nameTextField.getText());
        //System.out.println(user.toString());
        UserContainer.marketUsersList.add(user);
        //System.out.println(UserContainer.marketUsersList.get(0));
        UserContainer.activeMarketUser = user;
        System.out.println(UserContainer.activeMarketUser);
        //System.out.println(UserContainer.marketUsersList.get(0).getID());
    }

    /**
     * This method connects register with login.
     * @param event
     * @throws IOException
     */
    public void goToLogin(ActionEvent event) throws IOException
    {
        Parent registrationView = FXMLLoader.load(getClass().getResource("marketLogin.fxml"));
        Scene registrationViewScene = new Scene(registrationView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(registrationViewScene);
        stage.show();
    }

}


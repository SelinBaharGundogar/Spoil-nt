package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CustomerUser;
import model.UserContainer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class controls login.fxml page.
 * @author Aslı Karaman
 * @version v1.0 19.07.2021
 */
public class LoginController implements Initializable
{
    // variables
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField passwordTextField;

    /**
     * This method adds action to the cancel button, which returns back to the entrance page
     * @param event
     * @throws IOException
     */
    public void cancelButtonOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("Entrance.fxml"));
        Scene mainViewScene = new Scene(mainView);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();
    }

    /**
     * This method checks whether all necessary information has entered to login
     * @param event
     * @throws IOException
     */
    public void loginButtonOnAction(ActionEvent event) throws IOException
    {
        if (!userNameTextField.getText().isBlank()  && !passwordTextField.getText().isBlank())
        {
            logIn(event);
        }
        else
        {
            loginMessageLabel.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
            loginMessageLabel.setText("Please enter username or id and password");
            loginMessageLabel.setAlignment(Pos.CENTER);
        }
    }

    /**
     * This method initializes the login page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    /**
     * checks for the password before login (validates the login)
     * @return true if it is validate
     */
    public boolean validateLogin()
    {
        for (CustomerUser i: UserContainer.customerUsersList)
        {
            try {
                if(userNameTextField.getText().equals(i.getUsername()))
                {
                    if(i.getPassword().equals(passwordTextField.getText()))
                    {
                        UserContainer.activeCustomerUser = i;
                        return true;
                    }
                }
            }catch(NumberFormatException ex){
                System.err.println("Invalid string in argumment");
            }

        }
        return false;
    }

    /**
     * This method adds action to the registration button, which enables user to go to the registration page
     * @param event
     * @throws IOException
     */
    public void goToRegistration(ActionEvent event) throws IOException
    {
        Parent registrationView = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene registrationViewScene = new Scene(registrationView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(registrationViewScene);
        stage.show();
    }

    /**
     * This method adds action to the login button, which enables user to login to the application
     * @param event
     * @throws IOException
     */
   public void logIn(ActionEvent event) throws IOException
   {
       if(validateLogin()) {
           Parent registrationView = FXMLLoader.load(getClass().getResource("main.fxml"));
           Scene registrationViewScene = new Scene(registrationView);

           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(registrationViewScene);
           stage.show();
       }
       else {
           loginMessageLabel.setAlignment(Pos.CENTER);
           loginMessageLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
           loginMessageLabel.setText("Wrong user name or password!!!");
       }
   }
}

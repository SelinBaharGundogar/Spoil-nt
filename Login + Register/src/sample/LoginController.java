package sample;

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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
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

    public void cancelButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event){
        if ((userNameTextField.getText().isBlank() == false || idTextField.getText().isBlank() == false) && passwordTextField.getText().isBlank() == false){
            //validateLogin();
        }else{
            loginMessageLabel.setText("Please enter username or id and password");
            loginMessageLabel.setAlignment(Pos.CENTER);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File loginFile = new File("LoginPageImages/logo.png");
        Image logoImage = new Image(loginFile.toURI().toString());
        logoImageView.setImage(logoImage);
    }

    /*public void validateLogin(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String verifyLogin = "";
        //42.dk

        try{

            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    //loginMessageLabel.setText("Congratulations!");
                    createAccountForm();
                }else{
                    loginMessageLabel.setText("Invalid Login! Please try again.");
                }
            }

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }*/

    public void goToRegistration(ActionEvent event) throws IOException {
        Parent registrationView = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene registrationViewScene = new Scene(registrationView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(registrationViewScene);
        stage.show();

    }

    public void createAccountForm()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 600, 467));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}

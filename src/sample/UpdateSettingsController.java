package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class controls updateSetting page.
 */
public class UpdateSettingsController implements Initializable
{
    @FXML
    private ChoiceBox<String> cityBox = new ChoiceBox();

    @FXML
    private ChoiceBox<String> districtBox = new ChoiceBox();

    @FXML
    private Label updateMessageLabel;
    @FXML
    private TextField nameOfMarket;
    @FXML
    private RadioButton deactivateRadioButton;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label changePasswordLabel;

    @FXML
    private ImageView marketImage;

    FileChooser imageChooser = new FileChooser();
    private String[] cities = {"Ankara"};
    private String[] districtsAnkara = {"Çankaya","Yenimahalle"};

    @FXML
    /**
     * This method add action to back profile page button.
     */
    private void backToProfileOnAction(ActionEvent event) throws IOException
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
        cityBox.getItems().addAll(cities);
        districtBox.getItems().addAll(districtsAnkara);

    }

    /**
     * This method add action to update button.
     * @param event
     * @throws IOException
     */
    public void updateButtonOnAction(ActionEvent event) throws IOException
    {

        if ( cityBox.getValue() == null && districtBox.getValue()== null && nameOfMarket.getText().isBlank() && deactivateRadioButton.isSelected())
        {
            int selection = JOptionPane.showConfirmDialog(null,"Are you sure?","Deactivation Confirmation",JOptionPane.OK_CANCEL_OPTION);
            if ( selection == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Your account is deactivated successfully!");
                toLoginPage(event);
            }
        }
        else if ( cityBox.getValue() == null || districtBox.getValue()== null)
        {
            updateMessageLabel.setText("Please select a district!");
        }
        else if ( nameOfMarket.getText().isBlank())
        {
            updateMessageLabel.setText("Name cannot be blank!");
        }
        else
        {
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

    /**
     * This method picks an image from computer.
     * @param event
     */
    public void ImagePicker(ActionEvent event)
    {
        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        if ( !userDirectory.canRead())
        {
            userDirectory = new File("c:/");
        }
        imageChooser.setInitialDirectory(userDirectory);
        imageChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png"));
        File image = imageChooser.showOpenDialog(null);
       try
       {
           BufferedImage bufferedImage = ImageIO.read(image);
           Image newImage = SwingFXUtils.toFXImage(bufferedImage,null);
           marketImage.setImage(newImage);

       }catch (Exception e)
       {
           System.out.println(e.getMessage());
       }
    }


}

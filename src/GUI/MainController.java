package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * This  class controls main page.
 * @author Emre Karatas-22001641
 * @version v1.0-18.07.2021
 */
public class MainController
{
    @FXML
    private Button logOutButton;

    @FXML
    private Button addItemButton;
    @FXML
    private Button idButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button removeItemButton;


    /**
     * this method add action to log out button.
     * @param event
     * @throws IOException
     */
    public  void logOutButtonOnAction(ActionEvent event) throws IOException
    {
        int n = JOptionPane.showConfirmDialog(null,"Are you sure?","LogOut",JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            Parent loginView = FXMLLoader.load(getClass().getResource("marketLogin.fxml"));
            Scene loginViewScene= new Scene(loginView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginViewScene);
            stage.show();
        }


    }

    /**
     * This method add action to profilebutton.
     * @param event
     * @throws IOException
     */
    public void profileButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("marketProfile.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }

    /**
     * This method connects main with addItem page.
     * @param event
     * @throws IOException
     */
    public void addItemButtonOnAction(ActionEvent event) throws IOException
    {
        Parent itemView = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
        Scene itemViewScene= new Scene(itemView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(itemViewScene);
        stage.show();

    }

    /**
     * This method connects main page with id page.
     * @param event
     * @throws IOException
     */
    public void idButtonOnAction(ActionEvent event) throws IOException
    {
        Parent IDView = FXMLLoader.load(getClass().getResource("IDPage.fxml"));
        Scene IDViewScene = new Scene(IDView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(IDViewScene);
        stage.show();
    }

    /**
     * This method connects main with removeItem page.
     * @param event
     * @throws IOException
     */
    public void removeItemButtonOnAction(ActionEvent event) throws IOException
    {
        Parent removeItemView = FXMLLoader.load(getClass().getResource("RemoveItem.fxml"));
        Scene removeItemV??ewScene = new Scene(removeItemView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(removeItemV??ewScene);
        stage.show();

    }



}

package sample;

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

    public  void logOutButtonOnAction(ActionEvent event) throws IOException
    {
        int n = JOptionPane.showConfirmDialog(null,"Are you sure?","LogOut",JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            Parent loginView = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene loginViewScene= new Scene(loginView);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginViewScene);
            stage.show();
        }
        else
        {

        }

    }
    public void profileButtonOnAction(ActionEvent event) throws IOException
    {
        Parent profileView = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene profileViewScene= new Scene(profileView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(profileViewScene);
        stage.show();

    }

    public void addItemButtonOnAction(ActionEvent event) throws IOException
    {
        Parent itemView = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
        Scene itemViewScene= new Scene(itemView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(itemViewScene);
        stage.show();

    }

    public void idButtonOnAction(ActionEvent event) throws IOException
    {
        Parent IDView = FXMLLoader.load(getClass().getResource("IDPage.fxml"));
        Scene IDViewScene = new Scene(IDView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(IDViewScene);
        stage.show();
    }

    public void removeItemButtonOnAction(ActionEvent event) throws IOException
    {
        Parent removeItemView = FXMLLoader.load(getClass().getResource("RemoveItem.fxml"));
        Scene removeItemVıewScene = new Scene(removeItemView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(removeItemVıewScene);
        stage.show();

    }

}

package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.CustomerUser;
import model.Item;
import model.UserContainer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls profile page.
 * @author Emre Karatas, Selin Bahar Gundogar, Arda Ceylan
 * @version v1.0 -18.07.2021
 */
public class ProfileController implements Initializable
{
    @FXML
    private ImageView marketLogo;

    @FXML
    private Label marketName;

    @FXML
    private Button mainPageButton;



    @FXML
    private TableView<Item> pastitems;


    @FXML
    private TableColumn<Item, String> categoryofpastitems;

    @FXML
    private TableColumn<Item, String> rating;

    @FXML
    private TableColumn<Item, String> productname;

    @FXML
    private TableColumn<Item, Date> date;

    @FXML
    private TableColumn<Item, Double> amount;



    private ObservableList<Item> pastItemsTable;


    @Override
    /**
     * This method initializes market photo.
     */
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        marketLogo.setImage(UserContainer.activeMarketUser.getMarketImage());
        marketName.setText(UserContainer.activeMarketUser.getMarketName());
        setPastItems();
    }


    /**
     * Getting past items
     * @return
     */
    public ObservableList<Item> getPastItems()
    {
        System.out.println("inside");
        int count = 0;
        int sum = 0;
        ObservableList<Item> itemOfTheMarketUser = FXCollections.observableArrayList();
        for (Item a : UserContainer.activeMarketUser.getAllItems()){
            System.out.println("1 for");
            for (CustomerUser b : UserContainer.getCustomerUsersList()){
                System.out.println("2 for");
                for (Item c : b.getCurrentItems()){

                    if (c.getMarket().equals(a.getMarket()) && c.getDueDate().equals(a.getDueDate()) && c.getName().equals(a.getName()) ){
                        sum += c.getScore();
                        count++;
                        System.out.println("3 for if");
                    }
                }
            }
            if (count != 0){
                a.setScore(sum / count);
                a.setAmount(count);
            }
            if (a.getStatus() == -1)
            {
                itemOfTheMarketUser.add(a);
                System.out.println("status -1");
            }
        }
        return itemOfTheMarketUser;
    }

    /**
     * Setting past items
     */
    public void setPastItems(){
        pastItemsTable = getPastItems();
        productname.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryofpastitems.setCellValueFactory(new PropertyValueFactory<>("category"));
        date.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        rating.setCellValueFactory(new PropertyValueFactory<>("score"));

        pastitems.setItems(pastItemsTable);
    }

    /**
     * This method add action to main page button.
     * @param event
     * @throws IOException
     */
   public void mainPageButtonOnAction(ActionEvent event) throws IOException
   {
       Parent profileView = FXMLLoader.load(getClass().getResource("mainPage_Market.fxml"));
       Scene profileViewScene = new Scene(profileView);

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(profileViewScene);
       stage.show();
   }

    /**
     * This method add action to updateSetttings button.
     * @param event
     * @throws IOException
     */
   public void updateSettingsButtonOnAction(ActionEvent event) throws IOException
   {
       Parent updateView = FXMLLoader.load(getClass().getResource("Market_Info.fxml"));
       Scene updateViewScene = new Scene(updateView);

       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(updateViewScene);
       stage.show();

   }
}

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Item;
import model.UserContainer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * This class controls profile.fxml page.
 * @author Aslı Karaman - 21901576
 * @version v1.0 19.07.2021
 */
public class CustomerProfileController implements Initializable
{
    // variables
    @FXML
    private Button returnToMain;
    @FXML
    private ImageView profileView = new ImageView();
    @FXML
    private Button goToComment;
    @FXML
    private Label idLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label userName;
    @FXML
    private Label email;
    @FXML
    private Label address;
    @FXML
    private TextField evaluateTextField;

    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> productname;
    @FXML
    private TableColumn<Item, String> market;

    @FXML
    private TableColumn<Item, Double> price;


    @FXML
    private TableColumn<Item, String> category;

    @FXML
    private TableColumn<Item, Date> date;

    @FXML
    private TableColumn<Item, Double> score;

    private ObservableList<Item> itemList;
    ObservableList<Item> itemOfTheMarketUser;

    /**
     * This method initializes the categorization page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File profileFile = new File("Images/profile.png");
        javafx.scene.image.Image profileImage = new Image(profileFile.toURI().toString());
        profileView.setImage(profileImage);

        idLabel.setText(UserContainer.activeCustomerUser.getID()+ "");
        userName.setText(UserContainer.activeCustomerUser.getUserName());
        usernameLabel.setText(UserContainer.activeCustomerUser.getUserName());
        name.setText(UserContainer.activeCustomerUser.getName());
        surname.setText(UserContainer.activeCustomerUser.getSurname());
        email.setText(UserContainer.activeCustomerUser.getEmail());
        address.setText(UserContainer.activeCustomerUser.getAddress());
        setItemsOnTheTable();
    }

    /**
     * This method checks all of past items of the market user
     * @return the past items
     */
    public ObservableList<Item> checkPastItems(){
        ObservableList<Item> list = FXCollections.observableArrayList();
            for( Item a : UserContainer.activeCustomerUser.getCurrentItems() ){
                if ( a.getStatus() == -1 ) {
                    list.add(a);
                }
        }
        //setItemsOnTheTable();
        return list;
    }

    /**
     * This method sets the tableviews
     */
    public void setItemsOnTheTable(){
        itemList = checkPastItems();
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        productname.setCellValueFactory(new PropertyValueFactory<>("name"));
        market.setCellValueFactory(new PropertyValueFactory<>("market"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        date.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        table.setItems(itemList);
    }

    /**
     * The user can leave a rating to the selected item.
     * @throws IOException
     */
    public void evaluate() throws IOException
    {
        checkPastItems();
        setItemsOnTheTable();
        checkPastItems();
        for ( Item item : checkPastItems())
        {
            checkPastItems();
            setItemsOnTheTable();
            checkPastItems();
            if ( item.equals(table.getSelectionModel().getSelectedItem()))
            {
                item.setScore(Double.parseDouble(evaluateTextField.getText()));
                checkPastItems();
                setItemsOnTheTable();
                checkPastItems();
                //break;
            }
            checkPastItems();
            setItemsOnTheTable();
            checkPastItems();
        }
        checkPastItems();

        setItemsOnTheTable();
        checkPastItems();
    }


    /**
     * This method adds action to the return back button, which returns back to the main page
     * @param event
     * @throws IOException
     */
    public void returnToMainOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();

    }

    /**
     * This method takes the user to the customer settings change page
     * @param event
     * @throws IOException
     */
    public void updateSettingsOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("CustomerSettingsChange.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();

    }

    /**
     * This method adds action to the "+" button, which goes to comment page
     * @param event
     * @throws IOException
     */
    public void goToCommentOnAction(ActionEvent event) throws IOException
    {
        Parent commentView = FXMLLoader.load(getClass().getResource("comment.fxml"));
        Scene commentViewScene= new Scene(commentView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(commentViewScene);
        stage.show();
    }


}

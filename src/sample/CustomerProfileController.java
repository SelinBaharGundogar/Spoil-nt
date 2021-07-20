package sample;

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
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    @FXML
    private TextField address;
    @FXML
    private Button nameEdit;
    @FXML
    private Button surnameEdit;
    @FXML
    private Button userNameEdit;
    @FXML
    private Button emailEdit;
    @FXML
    private Button numberEdit;
    @FXML
    private Button addressEdit;


    /**
     * This method initializes the categorization page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File profileFile = new File("Images/profile.png");
        javafx.scene.image.Image profileImage = new Image(profileFile.toURI().toString());
        profileView.setImage(profileImage);
    }

    /*public ObservableList<PastProducts> getPastProducts(){
        ObservableList<PastProducts> pastProducts = FXCollections.observableArrayList();
        pastProducts.add(new PastProducts(LocalDate.of(2021, Month.JULY,17), "Dairy products", "Milk", "Migros", "3 tl", 5, 4.3));
        return pastProducts;
    }*/

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

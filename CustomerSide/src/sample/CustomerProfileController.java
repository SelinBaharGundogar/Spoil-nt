package sample;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class CustomerProfileController implements Initializable
{
    /*@FXML
    private TableView<PastProducts> tableView;
    @FXML
    private TableColumn<PastProducts, Integer> rowNumberColumn;
    @FXML
    private TableColumn<PastProducts, LocalDate> dateColumn;
    @FXML
    private TableColumn<PastProducts, String> categoryColumn;
    @FXML
    private TableColumn<PastProducts, String> nameColumn;
    @FXML
    private TableColumn<PastProducts, String> marketColumn;
    @FXML
    private TableColumn<PastProducts, String> priceColumn;
    @FXML
    private TableColumn<PastProducts, Integer> numberColumn;
    @FXML
    private TableColumn<PastProducts, Double> evaluationColumn;
     */

    @FXML
    private Button returnToMain;
    @FXML
    private ImageView profileView = new ImageView();
    @FXML
    private Button goToComment;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        /*rowNumberColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, Integer>("rowNumber"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, LocalDate>("date"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, String>("category"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, String>("name"));
        marketColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, String>("market"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, String>("price"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, Integer>("number"));
        evaluationColumn.setCellValueFactory(new PropertyValueFactory<PastProducts, Double>("evaluation"));

        tableView.setItems(getPastProducts());
         */

        File profileFile = new File("Images/profile.png");
        javafx.scene.image.Image profileImage = new Image(profileFile.toURI().toString());
        profileView.setImage(profileImage);


    }

    /*public ObservableList<PastProducts> getPastProducts(){
        ObservableList<PastProducts> pastProducts = FXCollections.observableArrayList();
        pastProducts.add(new PastProducts(LocalDate.of(2021, Month.JULY,17), "Dairy products", "Milk", "Migros", "3 tl", 5, 4.3));
        return pastProducts;
    }*/

    public void returnToMainOnAction(ActionEvent event) throws IOException
    {
        Parent mainView = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainViewScene= new Scene(mainView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(mainViewScene);
        stage.show();

    }

    public void goToCommentOnAction(ActionEvent event) throws IOException
    {
        Parent commentView = FXMLLoader.load(getClass().getResource("comment.fxml"));
        Scene commentViewScene= new Scene(commentView);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(commentViewScene);
        stage.show();

    }


}

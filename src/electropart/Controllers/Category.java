package electropart.Controllers;

import java.sql.DriverManager;
import java.sql.SQLException;

import electropart.DbControl;
import electropart.TableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Category {
    private Stage stage;
    private Parent root;

    public DbControl dbc = new DbControl("./");

    @FXML
    private TextField addCat;

    public void textBarCat(ActionEvent event) {

        dbc.generateDataBase(addCat.getText());
        dbc.insertData(addCat.getText(), new TableData("10uF", 10, "normal", "NXP", "Top shelf", "https://ww1.microchip.com/downloads/aemDocuments/documents/SCBU/ProductDocuments/DataSheets/ATECC608A-CryptoAuthentication-Device-Summary-Data-Sheet-DS40001977B.pdf", "null"));
        
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void addEntry(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/resources/fxml/addEntry.fxml"));
        // stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
        stage = new Stage();

        Image logo = new Image("file:../../assets/image.png");
        stage.getIcons().add(logo);

        stage.setTitle("Add Entry");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();

        // ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}

package electropart.Controllers;

import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Category {
    private Stage stage;
    private Parent root;

    @FXML
    private TextField addCat;

    public void textBarCat(ActionEvent event) {
        String db = "jdbc:sqlite:" + addCat.getText() + ".db";
        System.out.println(db);

        try (var conn = DriverManager.getConnection(db)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
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

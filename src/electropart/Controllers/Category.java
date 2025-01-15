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
import javafx.scene.Node;

public class Category {
    private Stage stage;
    private Parent root;

    @FXML
    private TextField addCat;

    public void textBarCat(ActionEvent event) {
        String db = "jdbc:sqlite:" + addCat.getText() + ".sqlite";
        System.out.println(db);

        var sqlTable = "CREATE TABLE IF NOT EXISTS " + addCat.getText() + " ("
                + "	id INTEGER PRIMARY KEY,"
                + "	value text NOT NULL,"
                + "	quantity INTIGER NOT NULL,"
                + " footprint TEXT NOT NULL,"
                + "	manufacturer TEXT NOT NULL,"
                + "	location TEXT NOT NULL,"
                + "	pdf TEXT NOT NULL,"
                + "	timestamp DATE DEFAULT CURRENT_TIMESTAMP"
                + ");";

        var sqlInsert = "INSERT INTO " + addCat.getText()
                + "(value,quantity,footprint,manufacturer,location,pdf) VALUES(?,?,?,?,?,?)";

        try (var conn = DriverManager.getConnection(db)) {
            if (conn != null) {
                var table = conn.createStatement();
                table.execute(sqlTable);

                var dataIn = conn.prepareStatement(sqlInsert);
                dataIn.setString(1, "10uF");
                dataIn.setInt(2, 20);
                dataIn.setString(3, "normal");
                dataIn.setString(4, "SMT");
                dataIn.setString(5, "Top shelf");
                dataIn.setString(6, "website.pdf");

                dataIn.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
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

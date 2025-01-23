package electropart.Controllers;

import electropart.DbControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Category {

    public DbControl dbc = new DbControl("./");

    @FXML
    private TextField addCat;

    public void textBarCat(ActionEvent event) {

        dbc.generateDataBase(addCat.getText());

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}

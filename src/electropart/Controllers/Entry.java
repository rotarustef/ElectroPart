package electropart.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import electropart.DbControl;
import electropart.TableData;

public class Entry implements Initializable {

    @FXML
    private TextField textValue;

    @FXML
    private TextField textQuantity;

    @FXML
    private TextField textFootprint;

    @FXML
    private TextField textManufacturer;

    @FXML
    private TextField textLocation;

    @FXML
    private TextField textPdf;

    @FXML
    private ChoiceBox<String> choiceDb;

    public DbControl dbc = new DbControl("./");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceDb.getItems().addAll(dbc.getDatabese());
    }

    public void getTableData(ActionEvent event) {

        System.out.println(choiceDb.getValue());

        dbc.insertData(choiceDb.getValue(), new TableData(
        textValue.getText(),
        Integer.parseInt(textQuantity.getText()),
        textFootprint.getText(),
        textManufacturer.getText(),
        textLocation.getText(),
        textPdf.getText()
        ));

        textValue.clear();
        textQuantity.clear();
        textFootprint.clear();
        textManufacturer.clear();
        textLocation.clear();
        textPdf.clear();
    }

}

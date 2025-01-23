package electropart.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import electropart.DbControl;
import electropart.TableData;

public class Entry {

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

    public DbControl dbc = new DbControl("./");

    public void getTableData(ActionEvent event) {
        
        dbc.insertData("tr", new TableData(
            textValue.getText(), 
            Integer.parseInt(textQuantity.getText()), 
            textFootprint.getText(), 
            textManufacturer.getText(), 
            textLocation.getText(),
            textPdf.getText()
            ));
        
        }

}

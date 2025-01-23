package electropart.Controllers;

import electropart.TableData;
import electropart.DbControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class MainWindow implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public DbControl dbc = new DbControl("./");
    public ObservableList<String> names;

    @FXML
    private ListView<String> listView;

    @FXML
    private TableView<TableData> table;

    @FXML
    private TableColumn<TableData, String> idColumn;

    @FXML
    private TableColumn<TableData, String> valueColumn;

    @FXML
    private TableColumn<TableData, Integer> quantityColumn;

    @FXML
    private TableColumn<TableData, String> footprintColumn;

    @FXML
    private TableColumn<TableData, String> manufacturerColumn;

    @FXML
    private TableColumn<TableData, String> locationColumn;

    @FXML
    private TableColumn<TableData, String> pdfColumn;

    @FXML
    private TableColumn<TableData, String> timeColumn;

    private ObservableList<TableData> tableDataList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        names = FXCollections.observableArrayList(dbc.getDatabese());
        listView.setItems(names);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue<? extends String> var1, String var2, String var3) {
                String printDb = listView.getSelectionModel().getSelectedItem();

                tableDataList = FXCollections.observableArrayList();

                for(TableData tableRow: dbc.selectData(printDb)){
                    tableDataList.add(tableRow);
                }

                table.setItems(tableDataList);
            }
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("qunatity"));
        footprintColumn.setCellValueFactory(new PropertyValueFactory<>("footprint"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        pdfColumn.setCellValueFactory(new PropertyValueFactory<>("pdf"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        

    }

    public void mainWindow(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/resources/fxml/mainWindow.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addCategory(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/resources/fxml/addCategory.fxml"));
        // stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        // scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
        stage = new Stage();

        Image logo = new Image("file:../../assets/image.png");
        stage.getIcons().add(logo);

        stage.setTitle("Add Category");
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        stage.show();

        // ((Node)(event.getSource())).getScene().getWindow().hide();
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
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

        // ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void test(ActionEvent e) throws Exception {

        names = FXCollections.observableArrayList(dbc.getDatabese());
        listView.setItems(names);
    }

    public void test2(ActionEvent e, String printDb) throws Exception{
        
    }

}

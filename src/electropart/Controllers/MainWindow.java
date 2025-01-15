package electropart.Controllers;

import electropart.TableData;

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
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class MainWindow implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String dbPath = "./";
    public ObservableList<String> names;

    @FXML
    private ListView<String> listView;

    @FXML
    private TableView<TableData> table;

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
        names = FXCollections.observableArrayList(getDatabese());
        listView.setItems(names);


        // valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty());
        // quantityColumn.setCellValueFactory(cellData -> cellData.getValue().qunatityProperty().asObject());
        // footprintColumn.setCellValueFactory(cellData -> cellData.getValue().footprintProperty());
        // manufacturerColumn.setCellValueFactory(cellData -> cellData.getValue().manufacturerProperty());
        // locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        // pdfColumn.setCellValueFactory(cellData -> cellData.getValue().pdfProperty());
        // timeColumn.setCellValueFactory(cellData -> cellData.getValue().getTimestamp());

        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("qunatity"));
        footprintColumn.setCellValueFactory(new PropertyValueFactory<>("footprint"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        pdfColumn.setCellValueFactory(new PropertyValueFactory<>("pdf"));

        tableDataList = FXCollections.observableArrayList();
        tableDataList.add(new TableData("Item 1", 10, "Small", "Manufacturer A", "Location A", "file1.pdf", "2025"));


        table.setItems(tableDataList);

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

    public ArrayList<String> getDatabese() {
        File folder = new File(dbPath);
        ArrayList<String> dbCategory = new ArrayList<String>();

        for (File file : folder.listFiles()) {
            if (file.getName().contains(".sqlite")) {
                dbCategory.add(file.getName().split(".sqlite")[0]);
            }
        }

        return dbCategory;
    }

    public void test(ActionEvent e) throws Exception {

        names = FXCollections.observableArrayList(getDatabese());
        listView.setItems(names);
    }

}

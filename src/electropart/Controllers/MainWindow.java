package electropart.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainWindow {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
        stage.setScene(new Scene(root, 450, 450));
        stage.show();

        // ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}

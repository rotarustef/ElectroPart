package electropart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    static final int initHeight = 600;
    static final int initWidth = 1000;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/mainWindow.fxml"));
        Scene scene = new Scene(root);

        Image logo = new Image("file:../../assets/image.png");
        stage.getIcons().add(logo);

        stage.setTitle("ElectroPart");
        stage.setMinHeight(initHeight);
        stage.setMinWidth(initWidth);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
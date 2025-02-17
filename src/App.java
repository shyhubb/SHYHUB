import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("MAMA BANK");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("IMAGES\\07a36f8150f730182b06489a34b690e6.jpg")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // dọgfdhjdhgfgfgdọgfdhjdhgfgfg

    public static void main(String[] args) {
        launch(args);
    }
}
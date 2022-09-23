package myUtilities;

import com.example.librarymanagementsystem.StartUpPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenChanger {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public void ChangeScreen(ActionEvent event, String FXMLFILE) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUpPage.class.getResource(FXMLFILE));
        root = fxmlLoader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}

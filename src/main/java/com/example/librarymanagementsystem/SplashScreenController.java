package com.example.librarymanagementsystem;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import myUtilities.ScreenChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class SplashScreenController implements Initializable {

    public ProgressBar splash_progress;

    private Scene scene;
    private Stage stage;
    private Parent root;

    double progress;

    public Label progress_label;

    public Button enterSystem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        enterSystem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(StartUpPage.class.getResource("login-view.fxml"));
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                stage = StartUpPage.clearSplash;

                scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            }
        });


    }

}


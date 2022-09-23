package com.example.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartUpPage extends Application {
    public static Stage clearSplash;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartUpPage.class.getResource("splash-screen-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1500, 1000);
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(false);

        clearSplash = stage;

    }

    public static void main(String[] args) {
        launch();
    }
}
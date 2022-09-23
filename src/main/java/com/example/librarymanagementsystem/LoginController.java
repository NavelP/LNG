package com.example.librarymanagementsystem;

import connectivity.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import myUtilities.ScreenChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField loginusername;
    public TextField loginpassword;
    public Button loginbutton;

    public Button signupfromlogin;

    ScreenChanger sc = new ScreenChanger();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database db = new Database();
        Connection connect = db.connectDB();

        loginbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String inputedUsername = loginusername.getText();
                String inputedPassword = loginpassword.getText();
                Statement statement;
                ResultSet resultSet;

                String sql = "SELECT id FROM SignIn WHERE username = '"+ inputedUsername+"' AND password = '" + inputedPassword +"'";
                try {
                    statement = connect.createStatement();
                    resultSet = statement.executeQuery(sql);

                    if(resultSet.next()){

                        sc.ChangeScreen(actionEvent, "view-library-view.fxml");
                    }else{
                        sc.ChangeScreen(actionEvent, "sign-up-view.fxml");
                    }
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        signupfromlogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    sc.ChangeScreen(actionEvent, "sign-up-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}

package com.example.librarymanagementsystem;

import connectivity.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import myUtilities.ScreenChanger;
import myUtilities.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    public TextField usernamevalue;
    public TextField passwordvalue;
    public TextField nationalidvalue;

    public Label test;

    public Button loginfromsignup;

    ScreenChanger sc = new ScreenChanger(); //object from the ScreenChanger class that is used to change the screen

    @FXML
    public void SubmitSignInDetails(ActionEvent actionEvent) throws SQLException, IOException {
        Database db = new Database();
        Connection connect = db.connectDB();

        String username = usernamevalue.getText();
        String password = passwordvalue.getText();
        String nationalId = nationalidvalue.getText();

        if(username.isEmpty() || password.isEmpty() || nationalId.isEmpty()){
            test.setText("Cannot submit blank data");
        }else{
            User user = new User(username, password, nationalId);
            String sql = "INSERT INTO SignIn (username, password, nationalid) VALUES("+"'"+user.getUsername()+"','"+ user.getPassword() +"','" +
                    user.getNationalid() + "')";
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);

            sc.ChangeScreen(actionEvent, "login-view.fxml");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginfromsignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    sc.ChangeScreen(actionEvent, "login-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
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
import java.sql.*;
import java.util.ResourceBundle;

public class ReturnBorrowedBook implements Initializable {
    public TextField return_national_id;
    public TextField return_book_name;
    public Button return_button, return_view, return_read_books, return_boroow_books, return_return_books;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database connectionInitializer = new Database();
        Connection connect = connectionInitializer.connectDB();

        return_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String inputedNationalId = return_national_id.getText();
                String inputedBookName = return_book_name.getText();

                Statement statement;
                ResultSet resultSet;

                String sql = "SELECT id FROM BorroweredBooks WHERE borrower_nationalid = '"+
                        inputedNationalId+"' AND borrowed_bookname = '" + inputedBookName +"'";

                if(!inputedNationalId.isEmpty() && !inputedBookName.isEmpty()){
                    try {
                        statement = connect.createStatement();
                        resultSet = statement.executeQuery(sql);

                        if(resultSet.next()){

                            sql = "DELETE FROM BorroweredBooks WHERE id = '"+
                                    resultSet.next()+"'";

                            PreparedStatement ps = connect.prepareStatement(sql);
                            ps.executeUpdate();


                        }else{
                            //user did not borrow the book he is returning
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    //user tries to return empty book information
                }
            }
        });

        return_view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ScreenChanger sc = new ScreenChanger();
                try {
                    sc.ChangeScreen(actionEvent, "view-library-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return_read_books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ScreenChanger sc = new ScreenChanger();
                try {
                    sc.ChangeScreen(actionEvent, "read-book-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return_boroow_books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ScreenChanger sc = new ScreenChanger();
                try {
                    sc.ChangeScreen(actionEvent, "borrow-book-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return_return_books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ScreenChanger sc = new ScreenChanger();
                try {
                    sc.ChangeScreen(actionEvent, "return-borrowed-book-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

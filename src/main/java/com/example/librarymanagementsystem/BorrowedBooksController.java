package com.example.librarymanagementsystem;

import connectivity.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import myUtilities.ScreenChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class BorrowedBooksController implements Initializable {
    public TextField borrower_id;
    public TextField borrow_book_name;
    public DatePicker returning_date;

    public Button borrow_button, borrow_view, borrow_read_books, borrow_boroow_books, borrow_return_books;

    ScreenChanger sc = new ScreenChanger(); //object from the ScreenChanger class that is used to change the screen


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database connectionInitializer = new Database();
        Connection connect = connectionInitializer.connectDB();

        borrow_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String inputedId = borrower_id.getText();
                String inputedName = borrow_book_name.getText();
                LocalDate inputedReturningDate = returning_date.getValue();

                if(inputedId.isEmpty() || inputedName.isEmpty()){
                    ;
                }else{
                    String sql = "INSERT INTO BorroweredBooks (borrower_nationalid, borrowed_bookname, return_date) VALUES("+"'"
                            +inputedId+"','"+ inputedName +"','" + inputedReturningDate + "')";
                    Statement statement = null;
                    try {
                        statement = connect.createStatement();
                        statement.executeUpdate(sql);


                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        borrow_view.setOnAction(new EventHandler<ActionEvent>() {
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

        borrow_read_books.setOnAction(new EventHandler<ActionEvent>() {
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

        borrow_boroow_books.setOnAction(new EventHandler<ActionEvent>() {
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

        borrow_return_books.setOnAction(new EventHandler<ActionEvent>() {
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

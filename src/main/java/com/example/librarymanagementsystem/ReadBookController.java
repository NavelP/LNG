package com.example.librarymanagementsystem;

import connectivity.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import myUtilities.ScreenChanger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ReadBookController implements Initializable {
    public TextField read_book_title;

    public Button read_book_selected, return_view, return_read_books,return_boroow_books,return_return_books;

    public TextArea display_book_content;

    public Label test;


    ScreenChanger sc = new ScreenChanger();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Database connectionInitializer = new Database();
        Connection connect = connectionInitializer.connectDB();

        read_book_selected.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String book_title = read_book_title.getText();

                Statement statement;
                ResultSet resultSet;

                String sql = "SELECT book_link FROM Books WHERE book_name = '" + book_title + "'";
                try {
                    statement = connect.createStatement();
                    resultSet = statement.executeQuery(sql);

                    if (resultSet.next()) {

                        //the book was found
                        String path = resultSet.getString(1);

                        Scanner scanner = new Scanner(new File("src/main/resources/com/example/librarymanagementsystem/LibraryManagement_MiniProject_Files/Mathematics/book.txt"));

                        //printing the characters
                        int i = 0;
                        test.setText(i+"");
                        while (scanner.hasNext()) {
                            i++;
                            if (scanner.hasNextInt()) {
                                //display_book_content.appendText(scanner.nextInt() + " ");

                            } else {

                                //display_book_content.appendText(scanner.next() + " ");
                            }
                        }
                        test.setText(i+"");

                    } else {
                        //the book was not found
                        sc.ChangeScreen(actionEvent, "sign-up-view.fxml");
                    }
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
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

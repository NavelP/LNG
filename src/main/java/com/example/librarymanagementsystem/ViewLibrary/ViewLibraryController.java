package com.example.librarymanagementsystem.ViewLibrary;

import connectivity.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myUtilities.ScreenChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewLibraryController implements Initializable {
    public TableView<ViewLibraryP> view_books_table_view;

    public TableColumn<ViewLibraryP, Integer> book_id_column;
    public TableColumn<ViewLibraryP, String> book_category_column;
    public TableColumn<ViewLibraryP, String> book_name_column;
    public TableColumn<ViewLibraryP, String> book_publisher_column;


    public Button view_books_view;
    public Button borrow_book_view_lib;

    Database connectionInitializer = new Database();
    Connection connect = connectionInitializer.connectDB();

    Statement statement;
    ResultSet resultSet;

    public Button view_return_book;

    public Button view_read_book;

    public Button view_account;

    ViewLibraryP single_book = null;

    ObservableList<ViewLibraryP> books_list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();

        view_books_view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadData();
            }
        });

        borrow_book_view_lib.setOnAction(new EventHandler<ActionEvent>() {
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

        view_return_book.setOnAction(new EventHandler<ActionEvent>() {
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

        view_read_book.setOnAction(new EventHandler<ActionEvent>() {
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
    }

    private void loadData() {
        refreshTable();
       // book_id_column.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        book_category_column.setCellValueFactory(new PropertyValueFactory<>("book_category"));
        book_name_column.setCellValueFactory(new PropertyValueFactory<>("book_name"));
        book_publisher_column.setCellValueFactory(new PropertyValueFactory<>("book_publisher"));
    }

    /*method to refresh the table*/
    @FXML
    private void refreshTable(){
        books_list.clear();

        String sql = "SELECT * FROM Books";
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                if(resultSet.getInt("bookid") != 0){
                    books_list.add(new ViewLibraryP(resultSet.getInt("bookid"), resultSet.getString("book_category"),
                            resultSet.getString("book_name"), resultSet.getString("book_publisher")));
                }

                books_list.add(new ViewLibraryP(resultSet.getString("book_category"),
                        resultSet.getString("book_name"), resultSet.getString("book_publisher")));

                view_books_table_view.setItems(books_list);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            Logger.getLogger(ViewLibraryController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

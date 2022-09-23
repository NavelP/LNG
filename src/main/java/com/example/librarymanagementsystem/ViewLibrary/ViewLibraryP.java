package com.example.librarymanagementsystem.ViewLibrary;

public class ViewLibraryP {
    public int bookid;
    public String book_category, book_name, book_publisher;

    public ViewLibraryP(int bookid, String book_category, String book_name, String book_publisher) {
        this.bookid = bookid;
        this.book_category = book_category;
        this.book_name = book_name;
        this.book_publisher = book_publisher;
    }

    public ViewLibraryP(String book_category, String book_name, String book_publisher) {
        this.book_category = book_category;
        this.book_name = book_name;
        this.book_publisher = book_publisher;
    }

    public int getId() {
        return bookid;
    }

    public void setId(int id) {
        this.bookid = id;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }
}

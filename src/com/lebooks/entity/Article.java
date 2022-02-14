package com.lebooks.entity;

public class Article {
    private int book_id;
    private int category_id;
    private float book_price;
    private String  book_name;
    private String book_author;
    private String book_description;
    private String book_image;
    private int books_reserve;
    private float book_press;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public int getBooks_reserve() {
        return books_reserve;
    }

    public void setBooks_reserve(int books_reserve) {
        this.books_reserve = books_reserve;
    }

    public float getBook_press() {
        return book_press;
    }

    public void setBook_press(float book_press) {
        this.book_press = book_press;
    }
}

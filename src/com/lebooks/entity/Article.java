package com.lebooks.entity;

public class Article {
    private int book_id;
    private String  book_name;
    private String book_price;
    private String book_author;
    private String book_description;
    private String book_image;
    private int book_reserve;
    private String book_press;
    private String book_birthplace;
    private String book_type;

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public int getBook_reserve() {
        return book_reserve;
    }

    public void setBook_reserve(int book_reserve) {
        this.book_reserve = book_reserve;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public String getBook_birthplace() {
        return book_birthplace;
    }

    public void setBook_birthplace(String book_birthplace) {
        this.book_birthplace = book_birthplace;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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


}

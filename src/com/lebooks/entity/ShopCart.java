package com.lebooks.entity;

public class ShopCart {
    private int cart_id;
    private int cart_user_id;
    private int cart_book_id;
    private int cart_book_amount;
    private String cart_book_price;
    private String cart_book_name;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCart_user_id() {
        return cart_user_id;
    }

    public void setCart_user_id(int cart_user_id) {
        this.cart_user_id = cart_user_id;
    }

    public int getCart_book_id() {
        return cart_book_id;
    }

    public void setCart_book_id(int cart_book_id) {
        this.cart_book_id = cart_book_id;
    }

    public int getCart_book_amount() {
        return cart_book_amount;
    }

    public void setCart_book_amount(int cart_book_amount) {
        this.cart_book_amount = cart_book_amount;
    }

    public String getCart_book_price() {
        return cart_book_price;
    }

    public void setCart_book_price(String cart_book_price) {
        this.cart_book_price = cart_book_price;
    }

    public String getCart_book_name() {
        return cart_book_name;
    }

    public void setCart_book_name(String cart_book_name) {
        this.cart_book_name = cart_book_name;
    }
}

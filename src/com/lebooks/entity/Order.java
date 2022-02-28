package com.lebooks.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
    private int order_id;
    private String Order_name;
    private int order_amount;
    private String order_price;
    private int order_receiver_id;
    private String order_address;
    private String order_status;
    private String order_time;

    public int getOrder_id() { return order_id; }

    public void setOrder_id(int order_id) { this.order_id = order_id; }
    public String getOrder_name() {
        return Order_name;
    }

    public void setOrder_name(String order_name) {
        Order_name = order_name;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public int getOrder_receiver_id() {
        return order_receiver_id;
    }

    public void setOrder_receiver_id(int order_receiver_id) {
        this.order_receiver_id = order_receiver_id;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
}

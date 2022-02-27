package com.lebooks.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
    private String Order_name;
    private int order_amount;
    private String order_price;
    private String order_receiver;
    private String order_address;
    private String order_status;
    private String order_time;

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

    public String getOrder_receiver() {
        return order_receiver;
    }

    public void setOrder_receiver(String order_receiver) {
        this.order_receiver = order_receiver;
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

    public void setOrder_time() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        order_time = formatter.format(calendar.getTime());
        this.order_time = order_time;
    }
}

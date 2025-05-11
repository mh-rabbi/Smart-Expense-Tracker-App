package com.smartlyexpense.smartexpensetracker;

public class ExpenseModel {
    int id;
    String name, category, date;
    double amount;
    public ExpenseModel(int id, String name, double amount, String category, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
}

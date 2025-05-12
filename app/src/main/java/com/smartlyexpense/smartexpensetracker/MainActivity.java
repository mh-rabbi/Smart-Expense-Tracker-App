package com.smartlyexpense.smartexpensetracker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DBHelper dbHelper;
    ArrayList<ExpenseModel> expenseList;
    ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.expenseList);
        dbHelper = new DBHelper(this);
        expenseList = new ArrayList<>();

        loadExpenses();

        findViewById(R.id.btnAddExpense).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddExpenseActivity.class));
        });
    }
    private void loadExpenses() {
        Cursor c = dbHelper.getAllExpenses();
        while (c.moveToNext()) {
            expenseList.add(new ExpenseModel(
                    c.getInt(0),
                    c.getString(1),
                    c.getDouble(2),
                    c.getString(3),
                    c.getString(4)
            ));
        }
        adapter = new ExpenseAdapter(this, expenseList);
        listView.setAdapter(adapter);
    }
    protected void onResume() {
        super.onResume();
        expenseList.clear();
        loadExpenses();
    }
}
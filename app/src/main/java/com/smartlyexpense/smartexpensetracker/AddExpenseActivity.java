package com.smartlyexpense.smartexpensetracker;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddExpenseActivity extends AppCompatActivity {
    EditText name, amount, category, date;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_expense);
        name = findViewById(R.id.etName);
        amount = findViewById(R.id.etAmount);
        category = findViewById(R.id.etCategory);
        date = findViewById(R.id.etDate);
        db = new DBHelper(this);

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String n = name.getText().toString();
            double a = Double.parseDouble(amount.getText().toString());
            String c = category.getText().toString();
            String d = date.getText().toString();
            db.insertExpense(n, a, c, d);
            finish();
        });
    }
}
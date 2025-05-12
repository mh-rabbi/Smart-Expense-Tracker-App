package com.smartlyexpense.smartexpensetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpenseAdapter extends BaseAdapter {
    Context context;
    ArrayList<ExpenseModel> list;
    public ExpenseAdapter(Context context, ArrayList<ExpenseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_expense, parent, false);
        }
        TextView name = convertView.findViewById(R.id.txtName);
        TextView amount = convertView.findViewById(R.id.txtAmount);
        TextView cat = convertView.findViewById(R.id.txtCategory);
        TextView date = convertView.findViewById(R.id.txtDate);

        ExpenseModel e = list.get(position);
        name.setText(e.name);
        amount.setText("৳ " + e.amount);
        cat.setText(e.category);
        date.setText(e.date);

        return convertView;
    }
}

package com.example.androidfinal.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfinal.Pojo.Transaction;
import com.example.androidfinal.R;

import java.util.ArrayList;

public class CustomTransRecyclerViewAdapter extends RecyclerView.Adapter<CustomTransRecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<Transaction> transactions;
    private Context context;


    public CustomTransRecyclerViewAdapter(ArrayList<Transaction> transactions, Context context) {
        this.transactions = transactions;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Transaction transaction = transactions.get(position);
        holder.date.setText(transaction.getDate());
        holder.transName.setText(transaction.getTransactionName());
//        holder.amount.setText((int) transaction.getAmount());

    }

    @Override
    public int getItemCount() {
        if (transactions != null) {
            return transactions.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView date;
        protected TextView transName;
        protected TextView amount;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.date = itemView.findViewById(R.id.transactionDate);
            this.transName = itemView.findViewById(R.id.transactionName);
            this.amount = itemView.findViewById(R.id.transactionAmount);
        }
    }

}

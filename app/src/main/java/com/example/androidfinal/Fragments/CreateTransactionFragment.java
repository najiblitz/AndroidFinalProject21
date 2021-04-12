package com.example.androidfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Billing;
import com.example.androidfinal.Pojo.Transaction;
import com.example.androidfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreateTransactionFragment extends Fragment {

    Transaction transaction;
    public static final int UPDATE =1;

    public static final String TRANSACTION = "Transaction";
    public static final String ACTION_TYPE = "action_type";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_transaction, container, false);

        EditText date = view.findViewById(R.id.transactionDate);
        EditText name = view.findViewById(R.id.transactionName);
        EditText amount = view.findViewById(R.id.transAmount);

        Button submit = view.findViewById(R.id.submitNewTransaction);
        Button cancel = view.findViewById(R.id.cancelNewTransaction);

        transaction = new Transaction();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getContext());
                transaction.setDate(date.getText().toString());
                transaction.setTransactionName(name.getText().toString());
                transaction.setAmount(Double.parseDouble(amount.getText().toString()));


                db.addTransaction(transaction);
                db.close();

                Navigation.findNavController(view).popBackStack();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });

        return view;

    }
}
package com.example.androidfinal.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Transaction;
import com.example.androidfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreateTransactionFragment extends Fragment {

    Transaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_transaction, container, false);

        // Add Settings
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean textSize = sharedPrefs.getBoolean("textSize", false);

        EditText date = view.findViewById(R.id.transDate);
        EditText name = view.findViewById(R.id.transName);
        EditText amount = view.findViewById(R.id.transAmount);

        Button submit = view.findViewById(R.id.submitNewTransaction);
        Button cancel = view.findViewById(R.id.cancelNewTransaction);


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    transaction.setDate(date.getText().toString());
                    transaction.setTransactionName(name.getText().toString());
                    transaction.setAmount(Double.parseDouble(amount.getText().toString()));
                    Database db = new Database(getContext());


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


            // Settings


        TextView text12 = view.findViewById(R.id.textView45);
        TextView text2 = view.findViewById(R.id.textView6);
        TextView text3 = view.findViewById(R.id.textView7);

        if (textSize) {
            text12.setTextSize(32);
            text2.setTextSize(32);
            text3.setTextSize(32);
        } else {
            text12.setTextSize(25);
            text2.setTextSize(25);
            text3.setTextSize(25);

        }

        return view;
    }
}
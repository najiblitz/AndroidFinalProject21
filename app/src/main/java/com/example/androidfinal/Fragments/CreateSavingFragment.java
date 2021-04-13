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

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.R;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CreateSavingFragment extends Fragment {


    Saving saving;
    public static final int UPDATE =1;

    public static final String SAVING = "Saving";
    public static final String ACTION_TYPE = "action_type";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_saving, container, false);

        // Add Settings

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean textSize = sharedPrefs.getBoolean("textSize", false);

        EditText title = view.findViewById(R.id.transDate);
        EditText haveAmount = view.findViewById(R.id.transName);
        EditText goalAmount = view.findViewById(R.id.transAmount);

        Button submit = view.findViewById(R.id.submitNewTransaction);
        Button cancel = view.findViewById(R.id.cancelNewTransaction);

        saving = new Saving();

        // onClick to submit new Saving

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set text values

                saving.setTitle(title.getText().toString());
                saving.setHaveAmount(Double.parseDouble(haveAmount.getText().toString()));
                saving.setGoalAmount(Double.parseDouble(goalAmount.getText().toString()));

                // get context from database

                Database db = new Database(getContext());
                db.addSaving(saving);
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

        EditText text1 = view.findViewById(R.id.textView45);
        EditText text2 = view.findViewById(R.id.textView6);
        EditText text3 = view.findViewById(R.id.textView7);

        if (textSize) {
            text1.setTextSize(32);
            text2.setTextSize(32);
            text3.setTextSize(32);
        } else {
            text1.setTextSize(25);
            text2.setTextSize(25);
            text3.setTextSize(25);

        }

        return view;
    }
}
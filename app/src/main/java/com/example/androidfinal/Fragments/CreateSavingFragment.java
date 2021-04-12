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
import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.R;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CreateSavingFragment extends Fragment {


    Saving saving;
    public static final int UPDATE =1;
    public static final int CREATE =2;

    public static final String SAVING = "Saving";
    public static final String ACTION_TYPE = "action_type";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_saving, container, false);

        EditText title = view.findViewById(R.id.savingsTitleNew);

        EditText haveAmount = view.findViewById(R.id.savingsStartAmount);
        EditText goalAmount = view.findViewById(R.id.savingsGoalAmount);

        Button submit = view.findViewById(R.id.submitNewSavings);
        Button cancel = view.findViewById(R.id.cancelNewSavings);

        saving = new Saving();
        submit.setText("Add New Goal");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saving.setTitle(title.getText().toString());
                saving.setHaveAmount(Double.parseDouble(haveAmount.getText().toString()));
                saving.setGoalAmount(Double.parseDouble(goalAmount.getText().toString()));

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

        return view;
    }
}
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
public class EditSavingFragment extends Fragment {

    Saving saving;
    public static final String SAVING = "Saving";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_saving, container, false);

        saving = getArguments().getParcelable(SAVING);

        EditText haveAmount = view.findViewById(R.id.newAmountHave);
        EditText goalAmount = view.findViewById(R.id.newAmountGoal);

        Button submit = view.findViewById(R.id.submitEditSavings);
        Button cancel = view.findViewById(R.id.cancelEditSavings);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (saving != null) {
                    saving.setHaveAmount(Double.parseDouble(haveAmount.getText().toString()));
                    saving.setGoalAmount(Double.parseDouble(goalAmount.getText().toString()));
                }
                Database db = new Database(getContext());
                db.updateSaving(saving);
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
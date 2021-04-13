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

        // Add Settings

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean textSize = sharedPrefs.getBoolean("textSize", false);

        saving = getArguments().getParcelable(SAVING);

        EditText haveAmount = view.findViewById(R.id.newAmountHave);
        EditText goalAmount = view.findViewById(R.id.newAmountGoal);

        Button submit = view.findViewById(R.id.submitEditSavings);
        Button cancel = view.findViewById(R.id.cancelEditSavings);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set new values from editText

                if (saving != null) {
                    saving.setHaveAmount(Double.parseDouble(haveAmount.getText().toString()));
                    saving.setGoalAmount(Double.parseDouble(goalAmount.getText().toString()));
                }

                // update savings in database

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


        // Settings

        TextView txt1 = view.findViewById(R.id.textView45);
        TextView txt11 = view.findViewById(R.id.textView7);

        if (textSize) {
            txt1.setTextSize(32);
            txt11.setTextSize(32);
        } else {
            txt1.setTextSize(25);
            txt11.setTextSize(25);
        }

        return view;
    }
}
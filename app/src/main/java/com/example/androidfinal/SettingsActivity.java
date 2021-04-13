package com.example.androidfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.androidfinal.Pojo.Budget;
import com.example.androidfinal.Pojo.Transaction;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            // set reset OnClick for deleting both Budget & transactions values

            Preference reset = findPreference("resetMonth");
            reset.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {

                    // create Alert Dialog to ask user to confirm reset

                    new AlertDialog.Builder(getContext())
                            .setTitle("Delete")
                            .setMessage("Are you sure you want to reset?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Database db = new Database(getContext());

                                    ArrayList<Budget> budgets = db.getAllBudgets();
                                    ArrayList<Transaction> transactions = db.getAllTransactions();

                                    // delete budgets on click

                                    for (Budget budget : budgets) {
                                        db.deleteBudget(budget.getId());
                                    }

                                    // delete transactions on click

                                    for (Transaction transaction : transactions) {
                                        db.deleteTransaction(transaction.getId());
                                    }

                                    db.close();
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();
                    return false;
                    }
            });

        }
    }
}
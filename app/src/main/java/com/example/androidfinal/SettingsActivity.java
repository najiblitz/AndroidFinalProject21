package com.example.androidfinal;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

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
            Preference reset = findPreference("resetMonth");
            reset.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {

                    Database db = new Database(getContext());

                    ArrayList<Budget> budgets = db.getAllBudgets();
                    ArrayList<Transaction> transactions = db.getAllTransactions();

                    for (Budget budget : budgets) {

                        db.deleteBudget(budget.getId());
                    }

                    for (Transaction transaction : transactions) {

                        db.deleteTransaction(transaction.getId());
                    }

                    db.close();

                    return true;
                }
            });




        }
    }
}
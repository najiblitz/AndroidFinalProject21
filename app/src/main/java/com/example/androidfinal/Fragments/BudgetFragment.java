package com.example.androidfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Budget;
import com.example.androidfinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BudgetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BudgetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BudgetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BudgetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BudgetFragment newInstance(String param1, String param2) {
        BudgetFragment fragment = new BudgetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        EditText salary = view.findViewById(R.id.salary);
        EditText home = view.findViewById(R.id.homeCost);

        Button button = view.findViewById(R.id.refreshButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getContext());
                Budget budget = db.getAllBudgets().get(0);

                budget.setSalary(salary.getText().toString().equals("") ? 0: Double.parseDouble(salary.getText().toString()));

                budget.setHome(home.getText().toString().equals("") ? 0: Double.parseDouble(home.getText().toString()));


                budget.setSalary(budget.getSalary() - budget.getHome());

                salary.setText(String.format("%.2f",budget.getSalary()));

                db.updateBudget(budget);
                db.close();
            }
        });


        Database db = new Database(getContext());


        if (db.getAllBudgets().isEmpty()) {
            db.addBudget(new Budget());
        }

        Budget budget = db.getAllBudgets().get(0);
        salary.setText(budget.getSalary() + "");
        home.setText(budget.getHome() + "");



        db.close();



        return view;
    }
}
package com.example.androidfinal.Fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Budget;
import com.example.androidfinal.R;

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

        // import text ids

        EditText salary = view.findViewById(R.id.salary);
        TextView salaryUpdate = view.findViewById(R.id.salaryUpdate);
        EditText home = view.findViewById(R.id.homeCost);
        EditText electricity = view.findViewById(R.id.electricityCost);
        EditText oil = view.findViewById(R.id.oilCost);
        EditText tv = view.findViewById(R.id.tvCost);
        EditText phone = view.findViewById(R.id.phoneCost);
        EditText homeRepairs = view.findViewById(R.id.homeRepairCost);
        EditText homeOther = view.findViewById(R.id.otherHomeCost);
        EditText car  = view.findViewById(R.id.vehicleCost);
        EditText insurance = view.findViewById(R.id.carInsCost);
        EditText gas = view.findViewById(R.id.gasCost);
        EditText carRepair = view.findViewById(R.id.carRepairCost);
        EditText carOther = view.findViewById(R.id.otherCarCost);
        EditText dining = view.findViewById(R.id.diningCost);
        EditText groceries = view.findViewById(R.id.groceriesCost);
        EditText beauty = view.findViewById(R.id.beautyCost);
        EditText personal = view.findViewById(R.id.personalCost);
        EditText activities = view.findViewById(R.id.activitiesCost);
        EditText shows = view.findViewById(R.id.showsCost);
        EditText otherDaily = view.findViewById(R.id.otherDailyCost);

        Button button = view.findViewById(R.id.refreshButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database db = new Database(getContext());

                Budget budget = db.getAllBudgets().get(0);

                // set all editable text to database

                budget.setSalary(salary.getText().toString().equals("") ? 0: Double.parseDouble(salary.getText().toString()));

                budget.setHome(home.getText().toString().equals("") ? 0: Double.parseDouble(home.getText().toString()));
                budget.setElectric(electricity.getText().toString().equals("") ? 0: Double.parseDouble(electricity.getText().toString()));
                budget.setOil(oil.getText().toString().equals("") ? 0: Double.parseDouble(oil.getText().toString()));
                budget.setTv(tv.getText().toString().equals("") ? 0: Double.parseDouble(tv.getText().toString()));
                budget.setPhone(phone.getText().toString().equals("") ? 0: Double.parseDouble(phone.getText().toString()));
                budget.setHomeRepairs(homeRepairs.getText().toString().equals("") ? 0: Double.parseDouble(homeRepairs.getText().toString()));
                budget.setHomeOther(homeOther.getText().toString().equals("") ? 0: Double.parseDouble(homeOther.getText().toString()));
                budget.setCar(car.getText().toString().equals("") ? 0: Double.parseDouble(car.getText().toString()));
                budget.setInsurance(insurance.getText().toString().equals("") ? 0: Double.parseDouble(insurance.getText().toString()));
                budget.setGas(gas.getText().toString().equals("") ? 0: Double.parseDouble(gas.getText().toString()));
                budget.setCarRepairs(carRepair.getText().toString().equals("") ? 0: Double.parseDouble(carRepair.getText().toString()));
                budget.setCarOther(carOther.getText().toString().equals("") ? 0: Double.parseDouble(carOther.getText().toString()));
                budget.setDining(dining.getText().toString().equals("") ? 0: Double.parseDouble(dining.getText().toString()));
                budget.setGroceries(groceries.getText().toString().equals("") ? 0: Double.parseDouble(groceries.getText().toString()));
                budget.setBeauty(beauty.getText().toString().equals("") ? 0: Double.parseDouble(beauty.getText().toString()));
                budget.setPersonal(personal.getText().toString().equals("") ? 0: Double.parseDouble(personal.getText().toString()));
                budget.setActivities(activities.getText().toString().equals("") ? 0: Double.parseDouble(activities.getText().toString()));
                budget.setShows(shows.getText().toString().equals("") ? 0: Double.parseDouble(shows.getText().toString()));
                budget.setDailyOther(otherDaily.getText().toString().equals("") ? 0: Double.parseDouble(otherDaily.getText().toString()));

                Double newSalary = budget.getSalary() - budget.getHome() - budget.getElectric() - budget.getOil() - budget.getTv() - budget.getPhone() - budget.getHomeRepairs() - budget.getHomeOther() - budget.getCar() - budget.getInsurance() - budget.getGas() - budget.getCarRepairs() - budget.getCarOther() - budget.getDining() - budget.getGroceries() - budget.getBeauty() - budget.getPersonal() - budget.getActivities() - budget.getShows() - budget.getDailyOther() ;

                salaryUpdate.setText(String.format("%.2f",newSalary));

                // If statement to change text red/green if amount left is positive/negative
                if (newSalary < 0) {
                    salaryUpdate.setTextColor(Color.RED);
                } else {
                    salaryUpdate.setTextColor(Color.parseColor("#66CD00"));
                }

                // update budget

                db.updateBudget(budget);

                db.close();
            }
        });

        Database db = new Database(getContext());

        // if there's no values, add as new budget

        if (db.getAllBudgets().isEmpty()) {
            db.addBudget(new Budget());
        }

        Budget budget = db.getAllBudgets().get(0);
        salary.setText(budget.getSalary() + "");
        home.setText(budget.getHome() + "");
        electricity.setText(budget.getElectric() + "");
        oil.setText(budget.getOil() + "");
        tv.setText(budget.getTv() + "");
        phone.setText(budget.getPhone() + "");
        homeRepairs.setText(budget.getHomeRepairs() + "");
        homeOther.setText(budget.getHomeOther()+ "");
        car.setText(budget.getCar() + "");
        insurance.setText(budget.getInsurance() + "");
        gas.setText(budget.getGas() + "");
        carRepair.setText(budget.getCarRepairs() + "");
        carOther.setText(budget.getCarOther() + "");
        dining.setText(budget.getDining() + "");
        groceries.setText(budget.getGroceries() + "");
        beauty.setText(budget.getBeauty() + "");
        personal.setText(budget.getPersonal() + "");
        activities.setText(budget.getActivities() + "");
        shows.setText(budget.getShows() + "");
        otherDaily.setText(budget.getDailyOther() + "");


        db.close();



        TextView homeTitle = view.findViewById(R.id.textView182);
        TextView carTitle = view.findViewById(R.id.textView1822);
        TextView dailyTitle = view.findViewById(R.id.textView82);


        // Settings

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean textSize = sharedPrefs.getBoolean("textSize", false);


        if (textSize) {
            home.setTextSize(27);
            electricity.setTextSize(27);
            oil.setTextSize(27);
            tv.setTextSize(27);
            phone.setTextSize(27);
            homeRepairs.setTextSize(27);
            homeOther.setTextSize(27);
            car.setTextSize(27);
            insurance.setTextSize(27);
            gas.setTextSize(27);
            carRepair.setTextSize(27);
            carOther.setTextSize(27);
            dining.setTextSize(27);
            groceries.setTextSize(27);
            beauty.setTextSize(27);
            activities.setTextSize(27);
            shows.setTextSize(27);
            otherDaily.setTextSize(27);
            homeTitle.setTextSize(27);
            carTitle.setTextSize(27);
            dailyTitle.setTextSize(27);
        } else {
            home.setTextSize(20);
            electricity.setTextSize(20);
            oil.setTextSize(20);
            tv.setTextSize(20);
            phone.setTextSize(20);
            homeRepairs.setTextSize(20);
            homeOther.setTextSize(20);
            car.setTextSize(20);
            insurance.setTextSize(20);
            gas.setTextSize(20);
            carRepair.setTextSize(20);
            carOther.setTextSize(20);
            dining.setTextSize(20);
            groceries.setTextSize(20);
            beauty.setTextSize(20);
            activities.setTextSize(20);
            shows.setTextSize(20);
            otherDaily.setTextSize(20);
            homeTitle.setTextSize(20);
            carTitle.setTextSize(20);
            dailyTitle.setTextSize(20);
        }




        return view;
    }
}
package com.example.androidfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.R;

//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CreateSavingFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CreateSavingFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public CreateSavingFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CreateUpdateSavingFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CreateSavingFragment newInstance(String param1, String param2) {
//        CreateSavingFragment fragment = new CreateSavingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

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

        EditText haveAmount = view.findViewById(R.id.newAmountHave);
        EditText goalAmount = view.findViewById(R.id.newAmountGoal);

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

            }
        });

        return view;
    }
}
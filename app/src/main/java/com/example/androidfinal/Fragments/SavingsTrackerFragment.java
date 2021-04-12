package com.example.androidfinal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidfinal.Views.CustomRecyclerViewAdapter;
import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavingsTrackerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavingsTrackerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SavingsTrackerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavingsTrackerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SavingsTrackerFragment newInstance(String param1, String param2) {
        SavingsTrackerFragment fragment = new SavingsTrackerFragment();
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
        View view = inflater.inflate(R.layout.fragment_savings_tracker, container, false);

        Button newButton = view.findViewById(R.id.newSavingsButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle extra = new Bundle();
//                extra.putInt(CreateUpdateRecipeFragment.ACTION_TYPE, CreateUpdateRecipeFragment.CREATE);
//                Navigation.findNavController(view).navigate(R.id.createUpdateRecipeFragment, extra);
                Navigation.findNavController(view).navigate(R.id.action_nav_savings_to_createUpdateSavingFragment);
            }
        });

        Database db = new Database(getContext());

        ArrayList<Saving> savings = db.getAllSavings();
        db.close();

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(savings, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
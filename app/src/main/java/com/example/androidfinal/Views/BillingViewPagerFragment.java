package com.example.androidfinal.Views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Billing;
import com.example.androidfinal.R;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillingViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillingViewPagerFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public BillingViewPagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BillingViewPagerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BillingViewPagerFragment newInstance(String param1, String  param2, String param3) {
        BillingViewPagerFragment fragment = new BillingViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Add settings used on page

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean textSize = sharedPrefs.getBoolean("textSize", false);

        // Create View

        View view = inflater.inflate(R.layout.fragment_billing_view_pager, container, false);

        TextView name = view.findViewById(R.id.companyName);
        TextView phone = view.findViewById(R.id.companyPhone);
        TextView website = view.findViewById(R.id.companyWebsite);
        TextView click = view.findViewById(R.id.billingTxt);

        if (mParam1 != null && mParam2 != null && mParam3 != null) {

            // Set Text

            name.setText(mParam1);
            phone.setText(mParam2);
            website.setText(mParam3);

        // Settings



            if (textSize) {
                name.setTextSize(40);
                click.setTextSize(35);
                phone.setTextSize(30);
                website.setTextSize(30);
            } else {
                name.setTextSize(30);
                click.setTextSize(25);
                phone.setTextSize(20);
                website.setTextSize(20);
            }
        }


        return view;
    }

}
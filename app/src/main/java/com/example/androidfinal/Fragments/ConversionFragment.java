package com.example.androidfinal.Fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Money;
import com.example.androidfinal.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConversionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConversionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConversionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConversionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConversionFragment newInstance(String param1, String param2) {
        ConversionFragment fragment = new ConversionFragment();
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
        View view = inflater.inflate(R.layout.fragment_conversion, container, false);

        // Set Spinners to display the Currencies to choose from

        Spinner currencyFrom = view.findViewById(R.id.oldCurrency);
        Spinner currencyTo = view.findViewById(R.id.newCurrency);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currencies));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyFrom.setAdapter(adapter);
        currencyTo.setAdapter(adapter);

        TextView amountToConvert = view.findViewById(R.id.amountToConvert);
        TextView amountConverted = view.findViewById(R.id.amountConverted);


        Button button = view.findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String apiKey = "https://v6.exchangerate-api.com/v6/6c8faa9bd56e03f3481bdecd/latest/";

                RequestQueue queue = Volley.newRequestQueue(getContext());

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiKey + currencyFrom.getSelectedItem().toString(), null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Money money = new Money(Double.parseDouble(amountToConvert.getText().toString()));
                            JSONObject mainObject = response.getJSONObject("conversion_rates");

                            double amountToConvert = money.getAmountToConvert();
                            double convertedAmount = amountToConvert * mainObject.getDouble(currencyTo.getSelectedItem().toString());
                            amountConverted.setText(convertedAmount + "");

                            Database db = new Database(getContext());
                            db.addMoney(money);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(request);
            }

        });

        return view;
    }
}
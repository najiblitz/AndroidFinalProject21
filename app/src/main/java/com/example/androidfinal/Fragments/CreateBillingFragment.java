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
import com.example.androidfinal.Pojo.Billing;
import com.example.androidfinal.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CreateBillingFragment extends Fragment {

   Billing billing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_billing, container, false);


        EditText name = view.findViewById(R.id.billingName);
        EditText phone = view.findViewById(R.id.billingPhone);
        EditText web = view.findViewById(R.id.billingWebsite);

        Button submit = view.findViewById(R.id.submitNewBilling);
        Button cancel = view.findViewById(R.id.cancelNewBilling);

        billing = new Billing();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billing.setCompanyName(name.getText().toString());
                billing.setCompanyPhone(phone.getText().toString());
                billing.setCompanyWebsite(web.getText().toString());

                Database db = new Database(getContext());
                db.addBilling(billing);
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
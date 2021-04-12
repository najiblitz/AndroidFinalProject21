package com.example.androidfinal.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidfinal.Database;
import com.example.androidfinal.Pojo.Transaction;
import com.example.androidfinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransactionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransactionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransactionsFragment newInstance(String param1, String param2) {
        TransactionsFragment fragment = new TransactionsFragment();
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
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        final ListView listView = view.findViewById(R.id.listview);

        ArrayList<Transaction> transactions = new ArrayList<>();

        Database db = new Database(getContext());

         transactions = db.getAllTransactions();
         listView.setAdapter(new CustomListViewAdapter(getContext(), transactions));


        return view;

    }


    public class CustomListViewAdapter extends ArrayAdapter<Transaction> {

        public CustomListViewAdapter(@NonNull Context context, ArrayList<Transaction> infos) {
            super(context, 0, infos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_transaction, parent,false);
            TextView date = convertView.findViewById(R.id.transactionDate);
            date.setText(getItem(position).getDate());
            TextView name = convertView.findViewById(R.id.transactionName);
            date.setText(getItem(position).getTransactionName());
            TextView amount = convertView.findViewById(R.id.transactionAmount);
            date.setText((int) getItem(position).getAmount());

            return convertView;

        }


    }


}


















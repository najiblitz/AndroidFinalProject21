package com.example.androidfinal.Views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfinal.Database;
import com.example.androidfinal.Fragments.CreateSavingFragment;
import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<Saving> savings;
    private Context context;

    public CustomRecyclerViewAdapter(ArrayList<Saving> savings, Context context) {
        this.savings = savings;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.savings_item_view,parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Saving saving = savings.get(position);
        holder.title.setText(saving.getTitle());
        holder.savingsAmount.setText("$" + (int)  saving.getHaveAmount() + " / $" + saving.getGoalAmount());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extra = new Bundle();
                extra.putInt(CreateSavingFragment.ACTION_TYPE, CreateSavingFragment.UPDATE);
                extra.putParcelable(CreateSavingFragment.SAVING, savings.get(position));
                Navigation.findNavController(view).navigate(R.id.editSavingFragment, extra);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (savings != null) {
            return savings.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

        protected TextView title;
        protected TextView savingsAmount;
        //this
        protected TextView goalAmount;
        protected ImageView edit;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.savingsTitle);
            // and this
            this.savingsAmount = itemView.findViewById(R.id.savingsAmount);
            this.goalAmount = itemView.findViewById(R.id.transAmount);
            this.edit = itemView.findViewById(R.id.editAmount);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            new AlertDialog.Builder(context)
                    .setTitle("Delete")
                    .setMessage("Are you sure you want to delete " + savings.get(getLayoutPosition()).getTitle() + "?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Database db = new Database(context);
                            db.deleteSaving(savings.get(getLayoutPosition()).getId());
                            savings.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            db.close();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return false;
        }
    }
}

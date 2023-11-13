package com.example.bankingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {


    Context context;

    ArrayList<User> list;

    public MyAdaptor(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( context ).inflate( R.layout.item, parent, false );
        return new MyViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get( position );
        holder.firstName.setText( user.getName() );
        holder.lastName.setText( user.getAccountNo() );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView firstName, lastName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tvfirstName);
            lastName = itemView.findViewById(R.id.tvlastName);

        }
    }
}

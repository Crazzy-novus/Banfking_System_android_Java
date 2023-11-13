package com.example.bankingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User_List extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdaptor myAdaptor;
    ArrayList<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("ABC Banking");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<User>();
        myAdaptor = new MyAdaptor(this,list);
        recyclerView.setAdapter(myAdaptor);

        try {
            database.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Toast.makeText(User_List.this, "Something went wrong**", Toast.LENGTH_SHORT).show();


                    try {


                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            User user = dataSnapshot.getValue(User.class);
                            list.add(user);
                        }
                        myAdaptor.notifyDataSetChanged();
                    }catch (Exception e) {
                        Toast.makeText(User_List.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {


                    // leave a toast message here
                    Toast.makeText(User_List.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                }

            });
        }catch (Exception e){
            Toast.makeText(this, "Something went wrong!!!!", Toast.LENGTH_SHORT).show();
        }

        finally {
            Toast.makeText(User_List.this, "***Something went wrong***", Toast.LENGTH_SHORT).show();
        }




    }
}
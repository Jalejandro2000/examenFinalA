package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;


import com.example.examenfinal.viewholder.IssueRowViewHolder;
import com.example.examenfinal.viewholder.JournalViewHolder;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    PlaceHolderView placeHolderView;

    UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        placeHolderView = findViewById(R.id.placeholderview);

        placeHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this));






        getALLJournals();


    }



    public void getALLJournals(){

        Call<List<JournalsResponse>> userlist = ApiClient.getUserService().getAllJournals();

        userlist.enqueue(new Callback<List<JournalsResponse>>() {
            @Override
            public void onResponse(Call<List<JournalsResponse>> call, Response<List<JournalsResponse>> response) {
                if (response.isSuccessful()) {

                    List<JournalsResponse> journals = response.body();
                    placeHolderView.removeAllViews();
                    for(JournalsResponse value: journals) {
                        placeHolderView.addView(new JournalViewHolder(MainActivity.this, value));
                    }

                }

            }

            @Override
            public void onFailure(Call<List<JournalsResponse>> call, Throwable t) {

            }
        });



    }


}



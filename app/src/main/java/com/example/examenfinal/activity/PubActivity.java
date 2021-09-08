package com.example.examenfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.examenfinal.ApiClient;
import com.example.examenfinal.IssueResponse;
import com.example.examenfinal.PubResponse;
import com.example.examenfinal.R;
import com.example.examenfinal.viewholder.IssueRowViewHolder;
import com.example.examenfinal.viewholder.PubViewHolder;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PubActivity extends AppCompatActivity {
    private String issueId;
    PlaceHolderView placeHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub);

        placeHolderView = findViewById(R.id.placeholderview);

        placeHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this));

        Bundle b = getIntent().getExtras();
        issueId = b.getString("i_id");
        getAllPubs();
    }

    public void getAllPubs() {
        Call<List<PubResponse>> userlist = ApiClient.getUserService().getAllPub(issueId);

        userlist.enqueue(new Callback<List<PubResponse>>() {
            @Override
            public void onResponse(Call<List<PubResponse>> call, Response<List<PubResponse>> response) {
                if (response.isSuccessful()) {

                    List<PubResponse> issueRespons = response.body();

                    for(PubResponse value: issueRespons) {
                        placeHolderView.addView(new PubViewHolder(PubActivity.this, value));
                    }

                }

            }

            @Override
            public void onFailure(Call<List<PubResponse>> call, Throwable t) {
                Log.e("faliure", t.getLocalizedMessage());
            }
        });

    }
}
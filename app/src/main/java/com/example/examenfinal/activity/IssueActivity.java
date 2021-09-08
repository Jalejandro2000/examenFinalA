package com.example.examenfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.examenfinal.ApiClient;
import com.example.examenfinal.IssueResponse;
import com.example.examenfinal.MainActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.viewholder.IssueRowViewHolder;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueActivity extends AppCompatActivity {
    private String journalId;
    PlaceHolderView placeHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        placeHolderView = findViewById(R.id.placeholderview);

        placeHolderView.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(this));

        Bundle b = getIntent().getExtras();
            journalId = b.getString("j_id");
            getAllIssues();
    }

    public void getAllIssues() {
        Call<List<IssueResponse>> userlist = ApiClient.getUserService().getaAllIssues(journalId);

        userlist.enqueue(new Callback<List<IssueResponse>>() {
            @Override
            public void onResponse(Call<List<IssueResponse>> call, Response<List<IssueResponse>> response) {
                if (response.isSuccessful()) {

                    List<IssueResponse> issueRespons = response.body();

                    for(IssueResponse value: issueRespons) {
                        placeHolderView.addView(new IssueRowViewHolder(IssueActivity.this, value));
                    }

                }

            }

            @Override
            public void onFailure(Call<List<IssueResponse>> call, Throwable t) {
                Log.e("faliure", t.getLocalizedMessage());
            }
        });

    }
}
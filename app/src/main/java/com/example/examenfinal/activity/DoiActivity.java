package com.example.examenfinal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.examenfinal.R;

public class DoiActivity extends AppCompatActivity {

    private WebView wvDoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi);
        wvDoi = findViewById(R.id.wvDoi);

        Bundle b = getIntent().getExtras();
        this.setTitle(b.getString("title"));
        wvDoi.loadUrl(b.getString("doi"));
    }
}
package com.example.examenfinal.viewholder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.JournalsResponse;
import com.example.examenfinal.PubResponse;
import com.example.examenfinal.R;
import com.example.examenfinal.activity.DoiActivity;
import com.example.examenfinal.activity.PubActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Recycle;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.row_pub)
public class PubViewHolder {

    @View(R.id.tvTitle)
    TextView tvTitle;

    @View(R.id.tvDatePublished)
    TextView tvDatePublished;

    @View(R.id.tvSection)
    TextView tvSection;

    @View(R.id.tvDoi)
    TextView tvDoi;

    @Position
    int position;
    private Context context;
    private PubResponse data;

    public PubViewHolder(Context context, PubResponse data) {
        this.data = data;
        this.context = context;
    }


    @Resolve
    public void onResolved() {

        tvTitle.setText(data.getTitle());
        tvDatePublished.setText(data.getDate_published());
        tvSection.setText(data.getSection());
        tvDoi.setText(data.getDoi());
    }

    @Recycle
    public void onRecycled() {
    }

    @Click(R.id.btnDoi)
    public void onBtnDoiClick()
    {
        Intent intent = new Intent(context, DoiActivity.class);
        Bundle b = new Bundle();
        b.putString("doi", data.getDoi());
        b.putString("title", data.getTitle());
        intent.putExtras(b);
        context.startActivity(intent);
    }
}

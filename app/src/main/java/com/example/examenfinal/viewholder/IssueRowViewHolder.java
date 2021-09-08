package com.example.examenfinal.viewholder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.example.examenfinal.IssueResponse;
import com.example.examenfinal.activity.IssueActivity;
import com.example.examenfinal.activity.PubActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Recycle;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.row_issue)
public class IssueRowViewHolder {

    @View(R.id.layoutMain)
    LinearLayout layoutMain;

    @View(R.id.tvTittle)
    TextView username;

    @View(R.id.txtDescripcion)
    TextView prefix;

    @View(R.id.txtnumber)
    TextView number;

    @View(R.id.txtYear)
    TextView year;

    @View(R.id.txtDatePublished)
    TextView dateP;

    @View(R.id.txtTitle)
    TextView title;

    @View(R.id.txtDoi)
    TextView doi;

    @View(R.id.imgPortada)
    ImageView imageMore;

    @Position
    int position;
    private Context context;
    private IssueResponse data;

    public IssueRowViewHolder(Context context, IssueResponse data) {
        this.data = data;
        this.context = context;
    }


    @Resolve
    public void onResolved() {

        prefix.setText(data.getVolume());
        username.setText(data.getIssue_id());
        Glide.with(context)
                .load(data.getCover())
                .into(imageMore);

        number.setText(data.getNumber());
        year.setText(data.getYear());
        dateP.setText(data.getDate_published());
        title.setText(data.getTitle());
        doi.setText(data.getDoi());


    }

    @Recycle
    public void onRecycled() {

    }


    @Click(R.id.layoutMain)
    public void onItemClick(){
        Intent intent = new Intent(context, PubActivity.class);
        Bundle b = new Bundle();
        b.putString("i_id", data.getIssue_id());
        intent.putExtras(b);
        context.startActivity(intent);

    }


}

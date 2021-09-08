package com.example.examenfinal.viewholder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.JournalsResponse;
import com.example.examenfinal.R;
import com.example.examenfinal.activity.IssueActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Recycle;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.row_journal)
public class JournalViewHolder {

    @View(R.id.layoutMain)
    LinearLayout layoutMain;

    @View(R.id.tvNombre)
    TextView tvNombre;

    @View(R.id.tvDescripcion)
    TextView tvDescripcion;

    @View(R.id.imgPortada)
    ImageView imgPortada;

    @Position
    int position;
    private Context context;
    private JournalsResponse data;

    public JournalViewHolder(Context context, JournalsResponse data) {
        this.data = data;
        this.context = context;
    }


    @Resolve
    public void onResolved() {

        tvNombre.setText(data.getName());
        tvDescripcion.setText(data.getDescription());
        Glide.with(context)
                .load(data.getPortada())
                .into(imgPortada);
    }

    @Recycle
    public void onRecycled() {
    }

    @Click(R.id.layoutMain)
    public void onItemClick(){
        Intent intent = new Intent(context, IssueActivity.class);
        Bundle b = new Bundle();
        b.putString("j_id", data.getJournal_id());
        intent.putExtras(b);
        context.startActivity(intent);




    }

}

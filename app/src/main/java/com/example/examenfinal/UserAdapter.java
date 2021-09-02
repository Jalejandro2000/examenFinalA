package com.example.examenfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> {

    private List<UserResponse> userResponseList;
    private Context context;

    public UserAdapter() {

    }
    public void setData(List<UserResponse> useResponseList) {
        this.userResponseList = useResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new com.example.examenfinal.UserAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        UserResponse userResponse = userResponseList.get(position);

        String username = userResponse.getIssue_id();
        String prefix = userResponse.getVolume();
        String number = userResponse.getNumber();
        String year = userResponse.getYear();
        String dateP = userResponse.getDate_published();
        String title = userResponse.getTitle();
        String doi = userResponse.getDoi();


        holder.prefix.setText(prefix);
        holder.username.setText(username);
        Glide.with(context)
                .load(userResponse.getCover())
                .into(holder.imageMore);

        holder.number.setText(number);
        holder.year.setText(year);
        holder.dateP.setText(dateP);
        holder.title.setText(title);
        holder.doi.setText(doi);


    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {

        TextView username;
        TextView prefix;
        TextView number;
        TextView year;
        TextView dateP;
        TextView title;
        TextView doi;
        ImageView imageMore;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            prefix = itemView.findViewById(R.id.txtVolume);
            number = itemView.findViewById(R.id.txtnumber);
            year = itemView.findViewById(R.id.txtYear);
            dateP = itemView.findViewById(R.id.txtDatePublished);
            title = itemView.findViewById(R.id.txtTitle);
            doi = itemView.findViewById(R.id.txtDoi);

            imageMore = itemView.findViewById(R.id.imageMore);
        }
    }
}

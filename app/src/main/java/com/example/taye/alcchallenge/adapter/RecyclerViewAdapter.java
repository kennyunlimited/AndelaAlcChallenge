package com.example.taye.alcchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taye.alcchallenge.R;
import com.example.taye.alcchallenge.controller.DetailUserActivity;
import com.example.taye.alcchallenge.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TAYE on 21/04/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Item> items;
    private Context context;



    public RecyclerViewAdapter(Context context, List<Item> items) {
        this.items = items;
        this.context = context;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_item, parent, false);
         return new RecyclerViewHolder(view);

    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.username.setText(items.get(position).getLogin());
        holder.githublink.setText(items.get(position).getHtm_url());

        Picasso.with(context)
                .load(items.get(position).getAvatar_url())
                .placeholder(R.drawable.loading)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }



    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView username, githublink;
        private ImageView imageView;
//        private List<Item> items;
//        private Context context;

        public RecyclerViewHolder(View userView) {
            super(userView);
            username = (TextView) userView.findViewById(R.id.username);
            githublink = (TextView) userView.findViewById(R.id.githubLink);
            imageView = (ImageView) userView.findViewById(R.id.photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Item itemClicked = items.get(position);
                        Intent intent = new Intent(context, DetailUserActivity.class);
                        intent.putExtra("login", items.get(position).getLogin());
                        intent.putExtra("htmlUrl", items.get(position).getHtm_url());
                        intent.putExtra("avatarUrl", items.get(position).getAvatar_url());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + itemClicked.getLogin(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

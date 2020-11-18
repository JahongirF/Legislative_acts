package com.example.legislative_acts.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legislative_acts.Fragment.Other;
import com.example.legislative_acts.R;

import java.util.ArrayList;
import java.util.List;

public class Other_Adapter extends RecyclerView.Adapter<Other_Adapter.Other_ViewHolder> {

    private List<Other> otherList;

    public Other_Adapter() {
        otherList = new ArrayList<>();
    }

    public List<Other> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<Other> otherList) {
        this.otherList = otherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Other_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Other_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.other_app_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull Other_ViewHolder holder, int position) {
        holder.imageView_other.setImageResource(otherList.get(position).getImageView_other());
        holder.textView_other_title.setText(otherList.get(position).getTextView_other_title());
        holder.textView_other_subject.setText(otherList.get(position).getTextView_other_subject());
        holder.textView_other_download.setText(otherList.get(position).getTextView_other_download());
        holder.imageView_other_download.setImageResource(otherList.get(position).getImageView_download());
    }

    @Override
    public int getItemCount() {
        return otherList.size();
    }

    public class Other_ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView_other;
        private TextView textView_other_title;
        private TextView textView_other_subject;
        private TextView textView_other_download;
        private ImageView imageView_other_download;

        public Other_ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_other = itemView.findViewById(R.id.imageView_other);
            textView_other_title = itemView.findViewById(R.id.textView_other_Title);
            textView_other_subject = itemView.findViewById(R.id.textView_other_Subject);
            textView_other_download = itemView.findViewById(R.id.textView_other_download);
            imageView_other_download = itemView.findViewById(R.id.imageView_other_download);

            imageView_other_download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(otherList.get(getAdapterPosition()).getUrl());
                    itemView.getContext().startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Выберите нужное вам приложение"));

                }
            });

        }
    }

}

package com.example.legislative_acts.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legislative_acts.Data.Acts_Subtitle;
import com.example.legislative_acts.R;

import java.util.List;

public class Acts_Subtitle_Adapter extends RecyclerView.Adapter<Acts_Subtitle_Adapter.Acts_Subtitle_ViewHolder> {

    private List<Acts_Subtitle> acts_subtitleList;
    private OnSubtitleClickListener onSubtitleClickListener;

    public Acts_Subtitle_Adapter(List<Acts_Subtitle> acts_subtitleList) {
        this.acts_subtitleList = acts_subtitleList;
    }

    public List<Acts_Subtitle> getActs_subtitleList() {
        return acts_subtitleList;
    }

    public void setActs_subtitleList(List<Acts_Subtitle> acts_subtitleList) {
        this.acts_subtitleList = acts_subtitleList;
        notifyDataSetChanged();
    }

    public interface OnSubtitleClickListener
    {
        void onSubtitleClick(int position, Acts_Subtitle acts_subtitle);
    }

    public void setOnSubtitleClickListener(OnSubtitleClickListener onSubtitleClickListener) {
        this.onSubtitleClickListener = onSubtitleClickListener;
    }

    @NonNull
    @Override
    public Acts_Subtitle_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Acts_Subtitle_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.acts_sub_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Acts_Subtitle_ViewHolder holder, int position) {
        holder.textView_sub_title.setText(acts_subtitleList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return acts_subtitleList.size() ;
    }

    public class Acts_Subtitle_ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_sub_id;
        private TextView textView_sub_title;


        public Acts_Subtitle_ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_sub_title = itemView.findViewById(R.id.textView_sub_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSubtitleClickListener != null)
                    {
                        onSubtitleClickListener.onSubtitleClick(getAdapterPosition(),acts_subtitleList.get(getAdapterPosition()));
                    }
                }
            });

        }
    }


}

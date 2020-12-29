package com.example.legislative_acts.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legislative_acts.Data.Acts;
import com.example.legislative_acts.Data.Acts_Subtitle;
import com.example.legislative_acts.Detail_Activity;
import com.example.legislative_acts.MainActivity;
import com.example.legislative_acts.R;
import com.example.legislative_acts.Title_Activity;

import java.util.ArrayList;
import java.util.List;

public class Acts_Adapter extends RecyclerView.Adapter<Acts_Adapter.Acts_ViewHolder> {

    private List<Acts> actsList;
    private OnActsClickListener onActsClickListener;
    private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

    public Acts_Adapter(List<Acts> actsList) {
        this.actsList = actsList;
    }

    public List<Acts> getActsList() {
        return actsList;
    }

    public void setActsList(List<Acts> actsList) {
        this.actsList = actsList;
        notifyDataSetChanged();
    }

    public void setOnActsClickListener(OnActsClickListener onActsClickListener) {
        this.onActsClickListener = onActsClickListener;
    }

    public interface OnActsClickListener {
        void onActsClick(int position, Acts acts);
    }

    public void clear()
    {
        actsList.clear();
    }

    @NonNull
    @Override
    public Acts_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Acts_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.acts_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Acts_ViewHolder holder, int position) {

        holder.imageView_acts.setImageResource(actsList.get(position).getImage());
        holder.textView_acts.setText(actsList.get(position).getTitle());
        holder.imageView_arrow.setImageResource(actsList.get(position).getArrow_image());
        int positionTitle = position;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.recyclerView_acts_subtitle.getContext(), RecyclerView.VERTICAL, false);
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(holder.itemView.getContext(), R.anim.layout_animation_fall_down);
        linearLayoutManager.setInitialPrefetchItemCount(actsList.get(position).getActs_subtitles().size());
        Acts_Subtitle_Adapter acts_subtitle_adapter = new Acts_Subtitle_Adapter(actsList.get(position).getActs_subtitles());
        acts_subtitle_adapter.setOnSubtitleClickListener(new Acts_Subtitle_Adapter.OnSubtitleClickListener() {
            @Override
            public void onSubtitleClick(int position, Acts_Subtitle acts_subtitle) {
             //  Toast.makeText(holder.itemView.getContext(), ""+acts_subtitle.getTitle() + " " + actsList.get(positionTitle).getTitle() , Toast.LENGTH_SHORT).show();

                if (actsList.get(positionTitle).getTitle().equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЕР КОДЕКСИ") || actsList.get(positionTitle).getTitle().equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МЕҲНАТ КОДЕКСИ") || actsList.get(positionTitle).getTitle().equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ МАСЪУЛИЯТИ ЧЕКЛАНГАН ҲАМДА ҚЎШИМЧА МАСЪУЛИЯТЛИ ЖАМИЯТЛАР ТЎҒРИСИДА") || actsList.get(positionTitle).getTitle().equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ ХУСУСИЙ КОРХОНА ТЎҒРИСИДА") || actsList.get(positionTitle).getTitle().equals("O‘ZBEKISTON RESPUBLIKASINING YER KODEKSI") || actsList.get(positionTitle).getTitle().equals("O‘ZBEKISTON RESPUBLIKASINING QONUNI MAS’ULIYATI CHEKLANGAN HAMDA QO‘SHIMCHA MAS’ULIYATLI JAMIYATLAR TO‘G‘RISIDA") || actsList.get(positionTitle).getTitle().equals("O‘ZBEKISTON RESPUBLIKASINING MEHNAT KODEKSI") || actsList.get(positionTitle).getTitle().equals("O‘ZBEKISTON RESPUBLIKASINING QONUNI XUSUSIY KORXONA TO‘G‘RISIDA") || actsList.get(positionTitle).getTitle().equals("Общественный кодекс") || actsList.get(positionTitle).getTitle().equals("Трудовой кодекс") || actsList.get(positionTitle).getTitle().equals("Частное предприятие") || actsList.get(positionTitle).getTitle().equals("Земельный кодекс")) {
                    Intent intent = new Intent(holder.itemView.getContext(), Detail_Activity.class);
                    intent.putExtra("title", actsList.get(positionTitle).getTitle());
                    intent.putExtra("position", positionTitle);
                    intent.putExtra("positionSubject", position);
                    intent.putExtra("titleSubject", acts_subtitle.getTitle());
                    holder.itemView.getContext().startActivity(intent);
                } else {
                    Intent intent = new Intent(holder.itemView.getContext(), Title_Activity.class);
                    intent.putExtra("title", actsList.get(positionTitle).getTitle());
                    intent.putExtra("position", positionTitle);
                    intent.putExtra("positionSubject", position);
                    intent.putExtra("titleSubject", acts_subtitle.getTitle());
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
        holder.recyclerView_acts_subtitle.setLayoutManager(linearLayoutManager);
        holder.recyclerView_acts_subtitle.setAdapter(acts_subtitle_adapter);
        holder.recyclerView_acts_subtitle.setRecycledViewPool(recycledViewPool);
        holder.recyclerView_acts_subtitle.setLayoutAnimation(layoutAnimationController);


        boolean isExpanded = actsList.get(position).isExpended();
        holder.recyclerView_acts_subtitle.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        if (isExpanded) {
            holder.linearLayout.setBackgroundColor(holder.itemView.getResources().getColor(R.color.color_item_stroke));
            holder.imageView_arrow.setImageResource(R.drawable.ic_arrow_up);
            holder.imageView_acts.setImageResource(R.drawable.ic_pattern_example_white);
            holder.textView_acts.setTextColor(holder.itemView.getResources().getColor(R.color.white));

        }


    }

    @Override
    public int getItemCount() {
        return actsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class Acts_ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView_acts;
        private TextView textView_acts;
        private RecyclerView recyclerView_acts_subtitle;
        private LinearLayout linearLayout;
        private ImageView imageView_arrow;

        public Acts_ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_acts = itemView.findViewById(R.id.imageView_item);
            imageView_arrow = itemView.findViewById(R.id.imageView2);
            textView_acts = itemView.findViewById(R.id.textView_item);
            recyclerView_acts_subtitle = itemView.findViewById(R.id.recyclerView_item);
            linearLayout = itemView.findViewById(R.id.linear_id);


            itemView.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    Acts acts = actsList.get(getAdapterPosition());
                    acts.setExpended(!acts.isExpended());
                    notifyItemChanged(getAdapterPosition());

                    if (onActsClickListener != null) {
                        onActsClickListener.onActsClick(getAdapterPosition(), actsList.get(getAdapterPosition()));
                    }
                }
            });


        }
    }

}

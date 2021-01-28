package com.example.legislative_acts.Adapter;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;


import com.example.legislative_acts.Data.ActsData;
import com.example.legislative_acts.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Favourite_Adapter extends RecyclerView.Adapter<Favourite_Adapter.Favourite_ViewHolder> {

    private List<ActsData> actsData;
    private OnClickBXMSListener onClickBXMSListener;
    private OnLongClickListener onLongClickListener;

    public Favourite_Adapter() {
        actsData = new ArrayList<>();
    }

    public List<ActsData> getGetBXMS() {
        return actsData;
    }

    public void setGetBXMS(List<ActsData> actsData) {
        this.actsData = actsData;
        notifyDataSetChanged();
    }

    public interface OnClickBXMSListener{
        void OnClickListener(int position, ActsData saveDate);
    }

    public interface  OnLongClickListener{
        void OnLongClick(int position, ActsData saveDate);
    }


    public void setOnClickBXMSListener(OnClickBXMSListener onClickBXMSListener) {
        this.onClickBXMSListener = onClickBXMSListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Favourite_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Favourite_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Favourite_ViewHolder holder, int position) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(holder.itemView.getContext());
        String lang = sharedPreferences.getString("lang","kir");
        if (lang.equals("kir"))
        {
            Locale locale = new Locale("uk");
            Resources resources = holder.itemView.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration,displayMetrics);
            android.content.res.Configuration configuration1 = resources.getConfiguration();
            configuration1.setLocale(locale);


        }
        else if (lang.equals("uz"))
        {
            Locale locale = new Locale("uz");
            Resources resources = holder.itemView.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration,displayMetrics);
            android.content.res.Configuration configuration1 = resources.getConfiguration();
            configuration1.setLocale(locale);



        }
        else if (lang.equals("rus"))
        {
            Locale locale = new Locale("ru");
            Resources resources = holder.itemView.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration,displayMetrics);
            android.content.res.Configuration configuration1 = resources.getConfiguration();
            configuration1.setLocale(locale);



        }


        String title = holder.itemView.getResources().getString(R.string.named_title)  + " " + actsData.get(position).getTitle();
        String section = holder.itemView.getResources().getString(R.string.named_section) + " " + actsData.get(position).getTitleSection();
        String chapter = holder.itemView.getResources().getString(R.string.named_chapter) + " " + actsData.get(position).getTitleChapter();

        SpannableStringBuilder spannableStringBuilderTitle = new SpannableStringBuilder(title);
        SpannableStringBuilder spannableStringBuilderSection = new SpannableStringBuilder(section);
        SpannableStringBuilder spannableStringBuilderChapter = new SpannableStringBuilder(chapter);

        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan1 = new StyleSpan(Typeface.ITALIC);

        int idBXMS, idSubject, idTitle;
        idBXMS = title.indexOf(":");
        idSubject = section.indexOf(":");
        idTitle = chapter.indexOf(":");

        spannableStringBuilderTitle.setSpan(styleSpan,0,idBXMS,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilderTitle.setSpan(styleSpan1,idBXMS,title.length()-1,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilderSection.setSpan(styleSpan,0,idSubject,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilderSection.setSpan(styleSpan1,idSubject,section.length(),SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilderChapter.setSpan(styleSpan,0,idTitle,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilderChapter.setSpan(styleSpan1,idTitle,chapter.length()-1,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);




       // Toast.makeText(holder.itemView.getContext(), "" + holder.linearLayout.getLayoutParams().height, Toast.LENGTH_SHORT).show();

        holder.textViewTitle.setText(spannableStringBuilderTitle);

        holder.textViewSection.setText(spannableStringBuilderSection);

        holder.textViewChapter.setText(spannableStringBuilderChapter);



        if (actsData.get(position).getTitleChapter() == null)
        {
            holder.textViewChapter.setVisibility(View.GONE);
        }
        else {
            holder.textViewSection.setVisibility(View.VISIBLE);
            if (holder.textViewSection.length() > 120)
            {
                holder.linearLayout.getLayoutParams().height = 540;
                holder.linearLayout.requestLayout();
            }
            else if (holder.textViewChapter.length() > 90)
            {
                holder.linearLayout.getLayoutParams().height = 450;
                holder.linearLayout.requestLayout();
            }
        }


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            holder.imageView.setImageResource(R.drawable.icon_app_3_dark);

        }



    }

    @Override
    public int getItemCount() {
        return actsData.size();
    }

    class Favourite_ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle;
        private TextView textViewChapter;
        private TextView textViewSection;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public Favourite_ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textView_Title_ID);
            textViewSection = itemView.findViewById(R.id.textView_Section_ID);
            textViewChapter = itemView.findViewById(R.id.textView_Chapter_ID);
            imageView = itemView.findViewById(R.id.logo_saved);
            linearLayout = itemView.findViewById(R.id.linearLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickBXMSListener != null)
                    {
                        onClickBXMSListener.OnClickListener(getAdapterPosition(),actsData.get(getAdapterPosition()));
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    if (onLongClickListener != null)
                    {
                        onLongClickListener.OnLongClick(getAdapterPosition(),actsData.get(getAdapterPosition()));
                    }

                    return true;
                }
            });

        }
    }
}

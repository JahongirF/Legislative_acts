package com.example.legislative_acts.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legislative_acts.Adapter.Acts_Adapter;
import com.example.legislative_acts.Data.Acts;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Administrativniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Byudjetniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Chastnoe_Predpriyatie;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Grajdanskiy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Nalogoviy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Obshestvenniy_lodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Semeyniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Tamojenniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Trudovoy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Ugolovniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Ugolovniy_protssesualniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Zemelniy_kodeks_kir;
import com.example.legislative_acts.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Main_Activity extends Fragment {

    private RecyclerView recyclerView;
    private Acts_Adapter adapter;
    private LayoutAnimationController layoutAnimationController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmant_main_activity, container,false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            adapter = new Acts_Adapter(Acts_Dark());
        }
        else
            {
                adapter = new Acts_Adapter(Acts());
            }

//        adapter = new Acts_Adapter(Acts());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutAnimation(layoutAnimationController);

        return view;
    }

    public static List<Acts> Acts() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example, "Административный кодекс", Administrativniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Бюджетный кодекс", Byudjetniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Гражданский кодекс", Grajdanskiy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный процессуальный кодекс", Ugolovniy_protssesualniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Земельный кодекс", Zemelniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Налоговый кодекс", Nalogoviy_kodeks_kir.getActs_Subtitles(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Общественный кодекс", Obshestvenniy_lodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Семейный кодекс", Semeyniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Таможенный кодекс", Tamojenniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Трудовой кодекс", Trudovoy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный кодекс", Ugolovniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Частное предприятие", Chastnoe_Predpriyatie.getActs_Subtitle(),R.drawable.ic_arrow_down));

        return acts;

    }

    public static List<Acts> Acts_Dark() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Административный кодекс", Administrativniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Бюджетный кодекс", Byudjetniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Гражданский кодекс", Grajdanskiy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Уголовный процессуальный кодекс", Ugolovniy_protssesualniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Земельный кодекс", Zemelniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Налоговый кодекс", Nalogoviy_kodeks_kir.getActs_Subtitles(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Общественный кодекс", Obshestvenniy_lodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Семейный кодекс", Semeyniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Таможенный кодекс", Tamojenniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Трудовой кодекс", Trudovoy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Уголовный кодекс", Ugolovniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Частное предприятие", Chastnoe_Predpriyatie.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));

        return acts;

    }
}

package com.example.legislative_acts.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Administrativniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Byudjetniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Chastnoe_Predpriyatie_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Grajdanskiy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Nalogoviy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Obshestvenniy_lodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Semeyniy_kodeks_lat;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Tamojenniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Trudovoy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Ugolovniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Ugolovniy_protssesualniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Zemelniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Administrativniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Byudjetniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Chastnoe_Predpriyatie_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Grajdanskiy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Nalogoviy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Obshestvenniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Semeyniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Tamojenniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Trudovoy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Ugolovniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Ugolovniy_protssesualniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Zemelniy_kodeks_ru;
import com.example.legislative_acts.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Main_Activity extends Fragment {

    private RecyclerView recyclerView;
    private Acts_Adapter adapter;
    private LayoutAnimationController layoutAnimationController;
    String text;
    private String lang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmant_main_activity, container,false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        Bundle bundle = this.getArguments();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        lang = sharedPreferences.getString("lang", "kir");


        if (lang.equals("uz"))
        {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            {
                adapter = new Acts_Adapter(Acts_lat_Dark());
            }
            else
            {
                adapter = new Acts_Adapter(Acts_lat());
            }
        }
        if (lang.equals("kir"))
        {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            {
                adapter = new Acts_Adapter(Acts_Dark());
            }
            else
            {
                adapter = new Acts_Adapter(Acts());
            }
        }

        if (lang.equals("rus"))
        {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            {
                adapter = new Acts_Adapter(Acts_Dark_Rus());
            }
            else
            {
                adapter = new Acts_Adapter(Acts_Rus());
            }
        }

        if (bundle != null) {
            text = bundle.getString("hello");

            if (text.equals("kir")) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                {
                    sharedPreferences.edit().putString("lang", "kir").apply();
                    adapter = new Acts_Adapter(Acts_Dark());
                }
                else
                {
                    sharedPreferences.edit().putString("lang", "kir").apply();
                    adapter = new Acts_Adapter(Acts());
                }
            }

            if (text.equals("uz")) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                {
                    sharedPreferences.edit().putString("lang", "uz").apply();
                    adapter = new Acts_Adapter(Acts_lat_Dark());
                }
                else
                {
                    sharedPreferences.edit().putString("lang", "uz").apply();
                    adapter = new Acts_Adapter(Acts_lat());
                }
            }

            if (text.equals("rus")) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                {
                    sharedPreferences.edit().putString("lang", "rus").apply();
                    adapter = new Acts_Adapter(Acts_Dark_Rus());
                }
                else
                {
                    sharedPreferences.edit().putString("lang", "rus").apply();
                    adapter = new Acts_Adapter(Acts_Rus());
                }
            }
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutAnimation(layoutAnimationController);

        return view;
    }

    public static List<Acts> Acts() {
        List<Acts> acts = new ArrayList<>();

//        acts.add(new Acts(R.drawable.ic_pattern_example, "Административный кодекс", Administrativniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Бюджетный кодекс", Byudjetniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Гражданский кодекс", Grajdanskiy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный процессуальный кодекс", Ugolovniy_protssesualniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Земельный кодекс", Zemelniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Налоговый кодекс", Nalogoviy_kodeks_kir.getActs_Subtitles(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Общественный кодекс", Obshestvenniy_lodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Семейный кодекс", Semeyniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Таможенный кодекс", Tamojenniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Трудовой кодекс", Trudovoy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный кодекс", Ugolovniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
//        acts.add(new Acts(R.drawable.ic_pattern_example, "Частное предприятие", Chastnoe_Predpriyatie.getActs_Subtitle(),R.drawable.ic_arrow_down));


        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ", Administrativniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ", Byudjetniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ФУҚАРОЛИК КОДЕКСИ", Grajdanskiy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ", Ugolovniy_protssesualniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЕР КОДЕКСИ", Zemelniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ", Nalogoviy_kodeks_kir.getActs_Subtitles(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ МАСЪУЛИЯТИ ЧЕКЛАНГАН ҲАМДА ҚЎШИМЧА МАСЪУЛИЯТЛИ ЖАМИЯТЛАР ТЎҒРИСИДА", Obshestvenniy_lodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ", Semeyniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ", Tamojenniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МЕҲНАТ КОДЕКСИ", Trudovoy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ", Ugolovniy_kodeks_kir.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ ХУСУСИЙ КОРХОНА ТЎҒРИСИДА", Chastnoe_Predpriyatie.getActs_Subtitle(),R.drawable.ic_arrow_down));

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


    public static List<Acts> Acts_lat() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI", Administrativniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI", Byudjetniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI", Grajdanskiy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI", Ugolovniy_protssesualniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING YER KODEKSI", Zemelniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING SOLIQ KODEKSI", Nalogoviy_kodeks_uz.getActs_Subtitles(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING QONUNI MAS’ULIYATI CHEKLANGAN HAMDA QO‘SHIMCHA MAS’ULIYATLI JAMIYATLAR TO‘G‘RISIDA", Obshestvenniy_lodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI", Semeyniy_kodeks_lat.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI", Tamojenniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING MEHNAT KODEKSI", Trudovoy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI", Ugolovniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "O‘ZBEKISTON RESPUBLIKASINING QONUNI XUSUSIY KORXONA TO‘G‘RISIDA", Chastnoe_Predpriyatie_uz.getActs_Subtitle(),R.drawable.ic_arrow_down));

        return acts;

    }

    public static List<Acts> Acts_lat_Dark() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI", Administrativniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI", Byudjetniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI", Grajdanskiy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI", Ugolovniy_protssesualniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING YER KODEKSI", Zemelniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING SOLIQ KODEKSI", Nalogoviy_kodeks_uz.getActs_Subtitles(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING QONUNI MAS’ULIYATI CHEKLANGAN HAMDA QO‘SHIMCHA MAS’ULIYATLI JAMIYATLAR TO‘G‘RISIDA", Obshestvenniy_lodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI", Semeyniy_kodeks_lat.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI", Tamojenniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING MEHNAT KODEKSI", Trudovoy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI", Ugolovniy_kodeks_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "O‘ZBEKISTON RESPUBLIKASINING QONUNI XUSUSIY KORXONA TO‘G‘RISIDA", Chastnoe_Predpriyatie_uz.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));

        return acts;

    }

    //Rus start

    public static List<Acts> Acts_Rus() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example, "Административный кодекс", Administrativniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Бюджетный кодекс", Byudjetniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Гражданский кодекс", Grajdanskiy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный процессуальный кодекс", Ugolovniy_protssesualniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Земельный кодекс", Zemelniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Налоговый кодекс", Nalogoviy_kodeks_ru.getActs_Subtitles(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Общественный кодекс", Obshestvenniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Семейный кодекс", Semeyniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Таможенный кодекс", Tamojenniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Трудовой кодекс", Trudovoy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Уголовный кодекс", Ugolovniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example, "Частное предприятие", Chastnoe_Predpriyatie_ru.getActs_Subtitle(),R.drawable.ic_arrow_down));


        return acts;

    }

    public static List<Acts> Acts_Dark_Rus() {
        List<Acts> acts = new ArrayList<>();

        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Административный кодекс", Administrativniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Бюджетный кодекс", Byudjetniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Гражданский кодекс", Grajdanskiy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Уголовный процессуальный кодекс", Ugolovniy_protssesualniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Земельный кодекс", Zemelniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Налоговый кодекс", Nalogoviy_kodeks_ru.getActs_Subtitles(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Общественный кодекс", Obshestvenniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Семейный кодекс", Semeyniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Таможенный кодекс", Tamojenniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Трудовой кодекс", Trudovoy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Уголовный кодекс", Ugolovniy_kodeks_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));
        acts.add(new Acts(R.drawable.ic_pattern_example_dark, "Частное предприятие", Chastnoe_Predpriyatie_ru.getActs_Subtitle(),R.drawable.ic_dark_arrow_down));

        return acts;

    }

    //Rus finish


}

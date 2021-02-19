package com.example.legislative_acts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.legislative_acts.Adapter.Acts_Subtitle_Adapter;
import com.example.legislative_acts.Data.Acts_Subtitle;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Administrativniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Byudjetniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Grajdanskiy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Nalogoviy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Semeyniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Tamojenniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Ugolovniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_kir.Ugolovniy_protssesualniy_kodeks_kir;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Administrativniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Byudjetniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Grajdanskiy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Nalogoviy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Semeyniy_kodeks_lat;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Tamojenniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Ugolovniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_lat.Ugolovniy_protssesualniy_kodeks_uz;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Administrativniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Byudjetniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Grajdanskiy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Nalogoviy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Semeyniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Tamojenniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Ugolovniy_kodeks_ru;
import com.example.legislative_acts.Documentation_Class.Data_for_ru.Ugolovniy_protssesualniy_kodeks_ru;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class Title_Activity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Acts_Subtitle_Adapter adapter;
    private LayoutAnimationController layoutAnimationController;

    private String titleActs;
    private int positionActs;
    private String titleSubject;
    private int positionSubject;
    private MaterialToolbar materialToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_);

        materialToolbar = findViewById(R.id.toolBarTitle);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.hide();
        }

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();


        if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("positionSubject") && intent.hasExtra("titleSubject"))

        {
            titleActs = intent.getStringExtra("title");
            positionActs = intent.getIntExtra("position", 1);
            titleSubject = intent.getStringExtra("titleSubject");
            positionSubject = intent.getIntExtra("positionSubject", 2);
        }

        recyclerView = findViewById(R.id.recyclerView_title);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_fall_down);
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        adapter = new Acts_Subtitle_Adapter(acts_subtitles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutAnimation(layoutAnimationController);

        if (titleActs.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && positionActs == 0)
        {
            if (titleSubject.equals("I.Биринчи бўлим. Умумий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.Иккинчи бўлим. Маъмурий ҳуқуқбузарлик ва маъмурий жавобгарлик") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.Учинчи бўлим. Маъмурий ҳуқуқбузарликлар тўғрисидаги ишларни кўриб чиқишга ваколати бўлган органлар (мансабдор шахслар)") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.Тўртинчи бўлим. Маъмурий ҳуқуқбузарлик тўғрисидаги ишларни юритиш") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Бешинчи бўлим. Маъмурий жа3о қўлланиш тўғрисидаги қарорларни ижро этиш") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_5());
            }
        }

        if (titleActs.equals("Бюджет кодекси") && positionActs == 1)
        {
            if (titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II бўлим. Бюджет тизими бюджетлари") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III бўлим. Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV бўлим. Бюджет тизими бюджетларининг даромадлари") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V бўлим. Бюджет тизими бюджетларининг харажатлари") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI бўлим. Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII бўлим. Бюджет тизими бюджетларининг ижроси") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII бўлим. Бюджет ҳисоби ва ҳисоботи") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_8());
            }


        }

        if (titleActs.equals("Фуқоролик кодекси") && positionActs == 2)
        {
            if (titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II бўлим. Мулк ҳуқуқи ва бошқа ашёвий ҳуқуқлар") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III бўлим. Мажбурият ҳуқуқи") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_3());
            }
        }

        if (titleActs.equals("Жиноят-процессуал кодекси") && positionActs == 3)
        {
            if (titleSubject.equals("I.Биринчи бўлим \n" + "Асосий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.Иккинчи бўлим \n" + "Жиноят процесси иштирокчилари") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.Учинчи бўлим \n" + "Далиллар ва исбот қилиниши лозим бўлган ҳолатлар") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.Тўртинчи бўлим \n" + "Процессуал мажбурлов") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Бешинчи бўлим \n" + "Жиноят натижасида етказилган мулкий зиённи қоплаш") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI.Олтинчи бўлим \n" + "Жиноятларнинг олдини олиш чоралари") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.Еттинчи бўлим \n" + "Реабилитация") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII.Саккизинчи бўлим \n" + "Процессуал муддатлар ва чиқимлар") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX.Тўққизинчи бўлим \n" + "Ишни судга қадар юритиш") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_9());
            }

            if (titleSubject.equals("X.Ўнинчи бўлим \n" + "Биринчи инстанция судида иш юритиш") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI.Ўн биринчи бўлим \n" + "Ҳукм, ажрим ва қарорларнинг қонунийлиги, асослилиги ва адолатлилигини текшириш") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII.Ўн иккинчи бўлим \n" + "Ҳукм, ажрим, қарорларни ижро этиш") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII.Ўн учинчи бўлим \n" + "Алоҳида тоифадаги жиноят ишларини юритиш") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV.Ўн тўртинчи бўлим \n" + "Жиноий суд ишларини юритиш соҳасидаги халқаро ҳамкорлик") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_14());
            }
        }

        if (titleActs.equals("Солиқ кодекси") && positionActs == 5)
        {
            if (titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II бўлим. Солиқ ҳисоби ва солиқ ҳисоботлари") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III бўлим. Солиқ мажбуриятини бажариш") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV бўлим. Солиқ тўловчиларни ва солиқ солиш объектларини ҳисобга олиш") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V бўлим. Солиқ назорати") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI бўлим. Трансферт нархни белгилашда солиқ назорати") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII бўлим. Назорат қилинадиган чет эл компанияларининг фойдасига солиқ солиш шартлари ва умумий қоидалари") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII бўлим. Солиққа оид ҳуқуқбузарликлар ва уларни содир этганлик учун жавобгарлик") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX бўлим. Солиқ органларининг ҳужжатлари ва улар мансабдор шахсларининг ҳаракатлари (ҳаракатсизлиги) устидан шикоят бериш") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_9());
            }

            if (titleSubject.equals("X бўлим. Қўшилган қиймат солиғи") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_10());
            }

            if (titleSubject.equals("ХI бўлим. Акциз солиғи") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII бўлим. Фойда солиғи") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII бўлим. Жисмоний шахслардан олинадиган даромад солиғи") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV бўлим. Ижтимоий солиқ") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_14());
            }

            if (titleSubject.equals("XV бўлим. Мол-мулк солиғи") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_15());
            }

            if (titleSubject.equals("XVI бўлим. Ер солиғи") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_16());
            }

            if (titleSubject.equals("XVII бўлим. Сув ресурсларидан фойдаланганлик учун солиқ") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_17());
            }

            if (titleSubject.equals("XVIII бўлим. Ер қаъридан фойдаланганлик учун солиқ") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_18());
            }

            if (titleSubject.equals("XIX бўлим. Йиғимлар") && positionSubject == 18)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_19());
            }

            if (titleSubject.equals("XX бўлим. Айланмадан олинадиган солиқ") && positionSubject == 19)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_20());
            }

            if (titleSubject.equals("ХХI бўлим. Солиқ тўловчиларнинг айрим тоифаларига солиқ солишнинг ўзига хос хусусиятлари") && positionSubject == 20)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_21());
            }
        }

        if (titleActs.equals("Оила кодекси") && positionActs == 7) {
            if (titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II бўлим. Никоҳ") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III бўлим. Қон-қариндошлик ва болаларнинг насл-насабини белгилаш") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV бўлим. Ота-она ҳамда вояга етмаган болаларнинг ҳуқуқ ва мажбуриятлари") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V бўлим. Оила аъзоларининг ва бошқа шахсларнинг алимент мажбуриятлари") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI бўлим. Ота-она қарамоғидан маҳрум бўлган болаларни жойлаштириш шакллари") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII бўлим. Фуқаролик ҳолати далолатномаларини қайд этиш") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII бўлим. Чет эл фуқаролари ва фуқаролиги бўлмаган шахслар иштирокидаги оилавий муносабатларни тартибга солиш") && positionSubject == 7) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("Божхона кодекси") && positionActs == 8) {
            if (titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_1());
            }
            if (titleSubject.equals("II бўлим. Божхона режимлари") && positionSubject == 1) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_2());
            }
            if (titleSubject.equals("III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши") && positionSubject == 2) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_3());
            }
            if (titleSubject.equals("IV бўлим. Божхона назорати") && positionSubject == 3) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_4());
            }
            if (titleSubject.equals("V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги") && positionSubject == 4) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI бўлим. Божхона расмийлаштируви") && positionSubject == 5) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_6());
            }
            if (titleSubject.equals("VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис") && positionSubject == 6) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_7());
            }
            if (titleSubject.equals("VIII бўлим. Божхона тўловлари") && positionSubject == 7) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_8());
            }
            if (titleSubject.equals("IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш") && positionSubject == 8) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_9());
            }
            if (titleSubject.equals("X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари") && positionSubject == 9) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_10());
            }
            if (titleSubject.equals("XI бўлим. Назорат остида етказиб бериш") && positionSubject == 10) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_11());
            }
            if (titleSubject.equals("XII бўлим. Якунловчи қоидалар") && positionSubject == 11) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_kir.getActs_Chapter_12());
            }
        }

        if (titleActs.equals("Жиноят кодекси") && positionActs == 10) {
            if (titleSubject.equals("I.Биринчи бўлим. Умумий қоидалар") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_1());
            }



            if (titleSubject.equals("II.Иккинчи бўлим. Жавобгарлик асослари") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_2());
            }


            if (titleSubject.equals("III.Учинчи бўлим. Қилмишнинг жиноийлигини истисно қиладиган ҳолатлар") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.Тўртинчи бўлим. Жазо ва уни тайинлаш") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Бешинчи бўлим. Жавобгарликдан ва жазодан озод қилиш") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_5());
            }


            if (titleSubject.equals("VI.Олтинчи бўлим. Вояга етмаганлар жавобгарлигининг хусусиятлари, бошқарув ва жамоат бирлашмалари органларининг фаолият тартибига қарши жиноятлар") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.Елтинчи бўлим. Тиббий йўсиндаги мажбурлов чоралари") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_7());
            }


            if (titleSubject.equals("VIII.Саккизинчи бўлим. Атамаларнинг ҳуқуқий маъноси") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_8());
            }
        }


        //lat start
        if (titleActs.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && positionActs == 0)
        {
            if (titleSubject.equals("I.Birinchi bo‘lim. Umumiy qoidalar") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.Ikkinchi bo‘lim. Ma’muriy huquqbuzarlik va ma’muriy javobgarlik") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.Uchinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni ko‘rib chiqishga vakolati bo‘lgan organlar (mansabdor shaxslar)") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.To‘rtinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni yuritish") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Beshinchi bo‘lim. Ma’muriy jazo qo‘llanish to‘g‘risidagi qarorlarni ijro etish") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_5());
            }
        }

        if (titleActs.equals("Byudjet kodeksi") && positionActs == 1)
        {
            if (titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II bo‘lim. Byudjet tizimi byudjetlari") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III bo‘lim. O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti. O‘zbekiston Respublikasining tiklanish va taraqqiyot jamg‘armasi") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV bo‘lim. Byudjet tizimi byudjetlarining daromadlari") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V bo‘lim. Byudjet tizimi byudjetlarining xarajatlari") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI bo‘lim. Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII bo‘lim. Byudjet tizimi byudjetlarining ijrosi") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII bo‘lim. Byudjet hisobi va hisoboti") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_uz.getActs_Chapter_8());
            }



        }

        if (titleActs.equals("Fuqorolik kodeksi") && positionActs == 2)
        {
            if (titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II bo‘lim. Mulk huquqi va boshqa ashyoviy huquqlar") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III bo‘lim. Majburiyat huquqi") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_3());
            }
        }


        if (titleActs.equals("Jinoyat kodeksi") && positionActs == 10) {
            if (titleSubject.equals("I.Birinchi bo‘lim. Umumiy qoidalar") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_1());
            }



            if (titleSubject.equals("II.Ikkinchi bo‘lim. Javobgarlik asoslari") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_2());
            }


            if (titleSubject.equals("III.Uchinchi bo‘lim. Qilmishning jinoiyligini istisno qiladigan holatlar") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.To‘rtinchi bo‘lim. Jazo va uni tayinlash") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Beshinchi bo‘lim. Javobgarlikdan va jazodan ozod qilish") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_5());
            }


            if (titleSubject.equals("VI.Oltinchi bo‘lim. Voyaga yetmaganlar javobgarligining xususiyatlari") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.Yettinchi bo‘lim. Tibbiy yo‘sindagi majburlov choralari") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_7());
            }


            if (titleSubject.equals("VIII.Sakkizinchi bo‘lim. Atamalarning huquqiy ma’nosi") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("Jinoyat-prosessual kodeksi") && positionActs == 3)
        {
            if (titleSubject.equals("I.Birinchi bo‘lim \n" + "Asosiy qoidalar") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.Ikkinchi bo‘lim \n" + "Jinoyat prosessi ishtirokchilari") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.Uchinchi bo‘lim \n" + "Dalillar va isbot qilinishi lozim bo‘lgan holatlar") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.To‘rtinchi bo‘lim \n" + "Prosessual majburlov") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Beshinchi bo‘lim \n" + "Jinoyat natijasida yetkazilgan mulkiy ziyonni qoplash") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI.Oltinchi bo‘lim \n" + "Jinoyatlarning oldini olish choralari") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.Yettinchi bo‘lim \n" + "Reabilitasiya") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII.Sakkizinchi bo‘lim \n" + "Prosessual muddatlar va chiqimlar") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX.To‘qqizinchi bo‘lim \n" + "Ishni sudga qadar yuritish") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_9());
            }

            if (titleSubject.equals("X.O‘ninchi bo‘lim \n" + "Birinchi instansiya sudida ish yuritish") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI.O‘n birinchi bo‘lim \n" + "Hukm, ajrim va qarorlarning qonuniyligi, asosliligi va adolatliligini tekshirish") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII.O‘n ikkinchi bo‘lim \n" + "Hukm, ajrim, qarorlarni ijro etish") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII.O‘n uchinchi bo‘lim \n" + "Alohida toifadagi jinoyat ishlarini yuritish") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV.O‘n to‘rtinchi bo‘lim \n" + "Jinoiy sud ishlarini yuritish sohasidagi xalqaro hamkorlik") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_14());
            }

        }

        if (titleActs.equals("Soliq kodeksi") && positionActs == 5)
        {
            if (titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II bo‘lim. Soliq hisobi va soliq hisobotlari") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III bo‘lim. Soliq majburiyatini bajarish") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV bo‘lim. Soliq to‘lovchilarni va soliq solish ob’yektlarini hisobga olish") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V bo‘lim. Soliq nazorati") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI bo‘lim. Transfert narxni belgilashda soliq nazorati") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII bo‘lim. Nazorat qilinadigan chet el kompaniyalarining foydasiga soliq solish shartlari va umumiy qoidalari") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII bo‘lim. Soliqqa oid huquqbuzarliklar va ularni sodir etganlik uchun javobgarlik") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX bo‘lim. Soliq organlarining hujjatlari va ular mansabdor shaxslarining harakatlari (harakatsizligi) ustidan shikoyat berish") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_9());
            }

            if (titleSubject.equals("X bo‘lim. Qo‘shilgan qiymat soligʻi") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI bo‘lim. Aksiz soligʻi") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII bo‘lim. Foyda soligʻi") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII bo‘lim. Jismoniy shaxslardan olinadigan daromad soligʻi") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV bo‘lim. Ijtimoiy soliq") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_14());
            }

            if (titleSubject.equals("XV bo‘lim. Mol-mulk soligʻi") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_15());
            }

            if (titleSubject.equals("XVI bo‘lim. Yer soligʻi") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_16());
            }

            if (titleSubject.equals("XVII bo‘lim. Suv resurslaridan foydalanganlik uchun soliq") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_17());
            }

            if (titleSubject.equals("XVIII bo‘lim. Yer qa’ridan foydalanganlik uchun soliq") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_18());
            }

            if (titleSubject.equals("XIX bo‘lim. Yigʻimlar") && positionSubject == 18)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_19());
            }

            if (titleSubject.equals("XX bo‘lim. Aylanmadan olinadigan soliq") && positionSubject == 19)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_20());
            }

            if (titleSubject.equals("XXI bo‘lim. Soliq to‘lovchilarning ayrim toifalariga soliq solishning o‘ziga xos xususiyatlari") && positionSubject == 20)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_21());
            }


        }

        if (titleActs.equals("Oila kodeksi") && positionActs == 7) {
            if (titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_1());
            }

            if (titleSubject.equals("II bo‘lim. Nikoh") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_2());
            }

            if (titleSubject.equals("III bo‘lim. Qon-qarindoshlik va bolalarning nasl-nasabini belgilash") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV bo‘lim. Ota-ona hamda voyaga yetmagan bolalarning huquq va majburiyatlari") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_4());
            }

            if (titleSubject.equals("V bo‘lim. Oila a’zolarining va boshqa shaxslarning aliment majburiyatlari") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI bo‘lim. Ota-ona qaramog‘idan mahrum bo‘lgan bolalarni joylashtirish shakllari") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII bo‘lim. Fuqarolik holati dalolatnomalarini qayd etish") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII bo‘lim. Chet el fuqarolari va fuqaroligi bo‘lmagan shaxslar ishtirokidagi oilaviy munosabatlarni tartibga solish") && positionSubject == 7) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("Bojxona kodeksi") && positionActs == 8) {
            if (titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_1());
            }
            if (titleSubject.equals("II bo‘lim. Bojxona rejimlari") && positionSubject == 1) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_2());
            }
            if (titleSubject.equals("III bo‘lim. Transport vositalariga va tovarlarning ayrim toifalariga nisbatan bojxona rejimlarining qo‘llanilishi") && positionSubject == 2) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_3());
            }
            if (titleSubject.equals("IV bo‘lim. Bojxona nazorati") && positionSubject == 3) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_4());
            }
            if (titleSubject.equals("V bo‘lim. Bojxona ishida valyuta nazorati va tashqi savdo operatsiyalarining monitoringi") && positionSubject == 4) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI bo‘lim. Bojxona rasmiylashtiruvi") && positionSubject == 5) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_6());
            }
            if (titleSubject.equals("VII bo‘lim. Deklarant, bojxona brokeri va bojxona rasmiylashtiruvi bo‘yicha mutaxassis") && positionSubject == 6) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_7());
            }
            if (titleSubject.equals("VIII bo‘lim. Bojxona to‘lovlari") && positionSubject == 7) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_8());
            }
            if (titleSubject.equals("IX bo‘lim. Bojxona statistikasi. Bojxona ishida axborot-kommunikatsiya texnologiyalari") && positionSubject == 8) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_9());
            }
            if (titleSubject.equals("X bo‘lim. Chet ellik shaxslarning ayrim toifalari uchun bojxona imtiyozlari") && positionSubject == 9) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_10());
            }
            if (titleSubject.equals("XI bo‘lim. Nazorat ostida yetkazib berish") && positionSubject == 10) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_11());
            }
            if (titleSubject.equals("XII bo‘lim. Yakunlovchi qoidalar") && positionSubject == 11) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_uz.getActs_Chapter_12());
            }
        }



        //lat finish

        //rus start

        if (titleActs.equals("Административный кодекс") && positionActs == 0)
        {
            if (titleSubject.equals("I.Раздел первый. общие положения") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.Раздел второй. административное правонарушение и административная ответственность") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.Раздел третий. органы (должностные лица), уполномоченные рассматривать дела об административных правонарушениях") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.Раздел четвертый. производство по делам об административных правонарушениях") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.Раздел пятый. исполнение постановлений о применении административных взысканий") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_5());
            }
        }

        if (titleActs.equals("Бюджетный кодекс") && positionActs == 1)
        {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("Раздел II. Бюджеты бюджетной системы") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("Раздел III. Консолидированный бюджет Республики Узбекистан. Фонд реконструкции и развития Республики Узбекистан") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("Раздел IV. Доходы бюджетов бюджетной системы") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("Раздел V. Расходы бюджетов бюджетной системы") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_5());
            }

            if (titleSubject.equals("Раздел VI. Составление, рассмотрение, принятие и утверждение Государственного бюджета и бюджетов государственных целевых фондов") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("Раздел VII. Исполнение бюджетов бюджетной системы") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("Раздел VIII. Бюджетный учет и отчетность") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_8());
            }

            if (titleSubject.equals("Раздел IX. Контроль за исполнением бюджетов бюджетной системы") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_ru.getActs_Chapter_9());
            }


        }

        if (titleActs.equals("Гражданский кодекс") && positionActs == 2)
        {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("Раздел II. Право собственности и другие вещные права") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("Раздел III. Обязательственное право") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_3());
            }
        }

        if (titleActs.equals("Налоговый кодекс") && positionActs == 5)
        {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("Раздел II. Исполнение налогового обязательства") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("Раздел III. Налоговый контроль") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("Раздел IV. Ответственность за налоговое правонарушение") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("Раздел V. Налог на прибыль юридических лиц") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_5());
            }

            if (titleSubject.equals("Раздел VI. Налог на доходы физических лиц") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("Раздел VII. Налог на добавленную стоимость") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("Раздел VIII. Акцизный налог") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_8());
            }

            if (titleSubject.equals("Раздел IX. Налоги и специальные платежи для недропользователей") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_9());
            }

            if (titleSubject.equals("Раздел X. Налог за пользование водными ресурсами") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_10());
            }

            if (titleSubject.equals("Раздел XI. Налог на имущество") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_11());
            }

            if (titleSubject.equals("Раздел XII. Земельный налог") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_12());
            }

            if (titleSubject.equals("Раздел XV. Обязательные платежи в государственные целевые фонды") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_15());
            }

            if (titleSubject.equals("Раздел XVII. Государственная пошлина") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_17());
            }

            if (titleSubject.equals("Раздел XVIII. Таможенные платежи") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_18());
            }

            if (titleSubject.equals("Раздел XIX. Сбор за право розничной торговли отдельными видами товаров и оказание отдельных видов услуг") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_19());
            }

            if (titleSubject.equals("Раздел XX. Упрощенный порядок налогообложения") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_20());
            }

            if (titleSubject.equals("Раздел XXI. Особенности налогообложения отдельных категорий налогоплательщиков") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_21());
            }



        }

        if (titleActs.equals("Семейный кодекс") && positionActs == 7) {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("Раздел II. Брак") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("Раздел III. Кровное родство и установление происхождения детей") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("Раздел IV. Права и обязанности родителей и несовершеннолетних детей") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("Раздел V. Алиментные обязательства членов семьи и других лиц") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_5());
            }
            if (titleSubject.equals("Раздел VI. Формы устройства детей, оставшихся без попечения родителей") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("Раздел VII. Регистрация актов гражданского состояния") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("Раздел VIII. Регулирование семейных отношений с участием иностранных граждан и лиц без гражданства") && positionSubject == 7) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_8());
            }
        }


        if (titleActs.equals("Таможенный кодекс") && positionActs == 8) {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_1());
            }
            if (titleSubject.equals("Раздел II. Таможенные режимы") && positionSubject == 1) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_2());
            }
            if (titleSubject.equals("Раздел III. Применение таможенных режимов к транспортным средствам и отдельным категориям товаров") && positionSubject == 2) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_3());
            }
            if (titleSubject.equals("Раздел IV. Таможенный контроль") && positionSubject == 3) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_4());
            }
            if (titleSubject.equals("Раздел V. Валютный контроль и мониторинг внешнеторговых операций в таможенном деле") && positionSubject == 4) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_5());
            }
            if (titleSubject.equals("Раздел VI. Таможенное оформление") && positionSubject == 5) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_6());
            }
            if (titleSubject.equals("Раздел VII. Декларант, таможенный брокер и специалист по таможенному оформлению") && positionSubject == 6) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_7());
            }
            if (titleSubject.equals("Раздел VIII. Таможенные платежи") && positionSubject == 7) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_8());
            }
            if (titleSubject.equals("Раздел IX. Таможенная статистика. Информационно-коммуникационные технологии в таможенном деле. Защита прав на объекты интеллектуальной собственности") && positionSubject == 8) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_9());
            }
            if (titleSubject.equals("Раздел X. Таможенные льготы отдельным категориям иностранных лиц") && positionSubject == 9) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_10());
            }
            if (titleSubject.equals("Раздел XI. Контролируемые поставки") && positionSubject == 10) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_11());
            }
            if (titleSubject.equals("Раздел XII. Заключительные положения") && positionSubject == 11) {
                adapter.setActs_subtitleList(Tamojenniy_kodeks_ru.getActs_Chapter_12());
            }
        }


        if (titleActs.equals("Уголовный кодекс") && positionActs == 10) {
            if (titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_1());
            }



            if (titleSubject.equals("Раздел II. Основания ответственности") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_2());
            }


            if (titleSubject.equals("Раздел III. Обстоятельства, исключающие преступность деяния") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("Раздел IV. Наказание и его назначение") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("Раздел V. Освобождение от ответственности и наказания") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_5());
            }


            if (titleSubject.equals("Раздел VI. Особенности ответственности несовершеннолетних") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("Раздел VII. Принудительные меры медицинского характера") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_7());
            }


            if (titleSubject.equals("Раздел VIII. Правовое значение терминов") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_8());
            }
        }


        if (titleActs.equals("Уголовный процессуальный кодекс") && positionActs == 3)
        {
            if (titleSubject.equals("Раздел первый \n" + "Основные положения") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("Раздел второй \n" + "Участники уголовного процесса") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("Раздел третий \n" + "Доказательства и обстоятельства, подлежащие доказыванию") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("Раздел четвертый \n" + "Процессуальное принуждение") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("Раздел пятый \n" + "Возмещение имущественного вреда, причиненного преступлением") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_5());
            }

            if (titleSubject.equals("Раздел шестой \n" + "Меры предупреждения преступлений") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("Раздел седьмой \n" + "Реабилитация") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("Раздел восьмой\n" + "Процессуальные сроки и издержки") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_8());
            }

            if (titleSubject.equals("Раздел девятый\n" + "Досудебное производство") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_9());
            }

            if (titleSubject.equals("Раздел десятый \n" + "Производство в суде первой инстанции") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_10());
            }

            if (titleSubject.equals("Раздел одиннадцатый \n" + "Проверка законности, обоснованности и справедливости приговоров, определений и постановлений") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_11());
            }

            if (titleSubject.equals("Раздел двенадцатый \n" + "Исполнение приговоров, определений, постановлений") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_12());
            }

            if (titleSubject.equals("Раздел тринадцатый\n" + "Производство по отдельным категориям уголовных дел") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_13());
            }

            if (titleSubject.equals("Раздел четырнадцатый \n" + "Международное сотрудничество в сфере уголовного судопроизводства") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_14());
            }
        }



        //rus finish


        adapter.setOnSubtitleClickListener(new Acts_Subtitle_Adapter.OnSubtitleClickListener() {
            @Override
            public void onSubtitleClick(int position, Acts_Subtitle acts_subtitle) {
                Intent intent1 = new Intent(getApplicationContext(),Detail_Activity.class);
                intent1.putExtra("title", titleActs);
                intent1.putExtra("position",positionActs);
                intent1.putExtra("titleSubject",titleSubject);
                intent1.putExtra("positionSubject",positionSubject);
                intent1.putExtra("titleChapter", acts_subtitle.getTitle());
                intent1.putExtra("positionChapter", position);
                intent1.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent1);

            }
        });

    }
}
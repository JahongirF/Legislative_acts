package com.example.legislative_acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_);

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

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && positionActs == 0)
        {
            if (titleSubject.equals("I.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_kir.getActs_Chapter_5());
            }
        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && positionActs == 1)
        {
            if (titleSubject.equals("I бўлим Умумий қоидалар") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II бўлим Бюджет тизими бюджетлари") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV бўлим Бюджет тизими бюджетларининг даромадлари") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V бўлим Бюджет тизими бюджетларининг харажатлари") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI бўлим Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII бўлим Бюджет тизими бюджетларининг ижроси") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII бўлим Бюджет ҳисоби ва ҳисоботи") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Byudjetniy_kodeks_kir.getActs_Chapter_8());
            }


        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ФУҚАРОЛИК КОДЕКСИ") && positionActs == 2)
        {
            if (titleSubject.equals("I.БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_kir.getActs_Chapter_3());
            }
        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && positionActs == 3)
        {
            if (titleSubject.equals("I.БИРИНЧИ БЎЛИМ \n" + "АСОСИЙ ҚОИДАЛАР") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.ИККИНЧИ БЎЛИМ \n" + "ЖИНОЯТ ПРОЦЕССИ ИШТИРОКЧИЛАРИ") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "ДАЛИЛЛАР ВА ИСБОТ ҚИЛИНИШИ ЛОЗИМ БЎЛГАН ҲОЛАТЛАР") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МАЖБУРЛОВ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.БЕШИНЧИ БЎЛИМ \n" + "ЖИНОЯТ НАТИЖАСИДА ЕТКАЗИЛГАН МУЛКИЙ ЗИЁННИ ҚОПЛАШ") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ \n" + "ЖИНОЯТЛАРНИНГ ОЛДИНИ ОЛИШ ЧОРАЛАРИ") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ \n" + "РЕАБИЛИТАЦИЯ") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МУДДАТЛАР ВА ЧИҚИМЛАР") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX.ТЎҚҚИЗИНЧИ БЎЛИМ \n" + "ИШНИ СУДГА ҚАДАР ЮРИТИШ") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_9());
            }

            if (titleSubject.equals("X.ЎНИНЧИ БЎЛИМ \n" + "БИРИНЧИ ИНСТАНЦИЯ СУДИДА ИШ ЮРИТИШ") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI.ЎН БИРИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ ВА ҚАРОРЛАРНИНГ ҚОНУНИЙЛИГИ, АСОСЛИЛИГИ ВА АДОЛАТЛИЛИГИНИ ТЕКШИРИШ") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII.ЎН ИККИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ, ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII.ЎН УЧИНЧИ БЎЛИМ \n" + "АЛОҲИДА ТОИФАДАГИ ЖИНОЯТ ИШЛАРИНИ ЮРИТИШ") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV.ЎН ТЎРТИНЧИ БЎЛИМ \n" + "ЖИНОИЙ СУД ИШЛАРИНИ ЮРИТИШ СОҲАСИДАГИ ХАЛҚАРО ҲАМКОРЛИК") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_14());
            }
        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && positionActs == 5)
        {
            if (titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II БЎЛИМ СОЛИҚ ҲИСОБИ ВА СОЛИҚ ҲИСОБОТЛАРИ") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III БЎЛИМ СОЛИҚ МАЖБУРИЯТИНИ БАЖАРИШ") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИ ВА СОЛИҚ СОЛИШ ОБЪЕКТЛАРИНИ ҲИСОБГА ОЛИШ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V БЎЛИМ СОЛИҚ НАЗОРАТИ") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI БЎЛИМ ТРАНСФЕРТ НАРХНИ БЕЛГИЛАШДА СОЛИҚ НАЗОРАТИ") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII БЎЛИМ НАЗОРАТ ҚИЛИНАДИГАН ЧЕТ ЭЛ КОМПАНИЯЛАРИНИНГ ФОЙДАСИГА СОЛИҚ СОЛИШ ШАРТЛАРИ ВА УМУМИЙ ҚОИДАЛАРИ") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII БЎЛИМ СОЛИҚҚА ОИД ҲУҚУҚБУЗАРЛИКЛАР ВА УЛАРНИ СОДИР ЭТГАНЛИК УЧУН ЖАВОБГАРЛИК") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX БЎЛИМ СОЛИҚ ОРГАНЛАРИНИНГ ҲУЖЖАТЛАРИ ВА УЛАР МАНСАБДОР ШАХСЛАРИНИНГ ҲАРАКАТЛАРИ (ҲАРАКАТСИЗЛИГИ) УСТИДАН ШИКОЯТ БЕРИШ") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_9());
            }

            if (titleSubject.equals("X БЎЛИМ ҚЎШИЛГАН ҚИЙМАТ СОЛИҒИ") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_10());
            }

            if (titleSubject.equals("ХI БЎЛИМ АКЦИЗ СОЛИҒИ") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII БЎЛИМ ФОЙДА СОЛИҒИ") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII БЎЛИМ ЖИСМОНИЙ ШАХСЛАРДАН ОЛИНАДИГАН ДАРОМАД СОЛИҒИ") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV БЎЛИМ ИЖТИМОИЙ СОЛИҚ") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_14());
            }

            if (titleSubject.equals("XV БЎЛИМ МОЛ-МУЛК СОЛИҒИ") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_15());
            }

            if (titleSubject.equals("XVI БЎЛИМ ЕР СОЛИҒИ") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_16());
            }

            if (titleSubject.equals("XVII БЎЛИМ СУВ РЕСУРСЛАРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_17());
            }

            if (titleSubject.equals("XVIII БЎЛИМ ЕР ҚАЪРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_18());
            }

            if (titleSubject.equals("XIX БЎЛИМ ЙИҒИМЛАР") && positionSubject == 18)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_19());
            }

            if (titleSubject.equals("XX БЎЛИМ АЙЛАНМАДАН ОЛИНАДИГАН СОЛИҚ") && positionSubject == 19)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_20());
            }

            if (titleSubject.equals("ХХI БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИНГ АЙРИМ ТОИФАЛАРИГА СОЛИҚ СОЛИШНИНГ ЎЗИГА ХОС ХУСУСИЯТЛАРИ") && positionSubject == 20)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_kir.getActs_Chapter_21());
            }
        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && positionActs == 7) {
            if (titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_1());
            }

            if (titleSubject.equals("II БЎЛИМ НИКОҲ") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_2());
            }

            if (titleSubject.equals("III БЎЛИМ ҚОН-ҚАРИНДОШЛИК ВА БОЛАЛАРНИНГ НАСЛ-НАСАБИНИ БЕЛГИЛАШ") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV БЎЛИМ ОТА-ОНА ҲАМДА ВОЯГА ЕТМАГАН БОЛАЛАРНИНГ ҲУҚУҚ ВА МАЖБУРИЯТЛАРИ") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V БЎЛИМ ОИЛА АЪЗОЛАРИНИНГ ВА БОШҚА ШАХСЛАРНИНГ АЛИМЕНТ МАЖБУРИЯТЛАРИ") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI БЎЛИМ ОТА-ОНА ҚАРАМОҒИДАН МАҲРУМ БЎЛГАН БОЛАЛАРНИ ЖОЙЛАШТИРИШ ШАКЛЛАРИ") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII БЎЛИМ ЧЕТ ЭЛ ФУҚАРОЛАРИ ВА ФУҚАРОЛИГИ БЎЛМАГАН ШАХСЛАР ИШТИРОКИДАГИ ОИЛАВИЙ МУНОСАБАТЛАРНИ ТАРТИБГА СОЛИШ") && positionSubject == 7) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_kir.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && positionActs == 8) {
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

        if (titleActs.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && positionActs == 10) {
            if (titleSubject.equals("I.БИРИНЧИ БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_1());
            }



            if (titleSubject.equals("II.ИККИНЧИ БЎЛИМ ЖАВОБГАРЛИК АСОСЛАРИ") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_2());
            }


            if (titleSubject.equals("III.УЧИНЧИ БЎЛИМ ҚИЛМИШНИНГ ЖИНОИЙЛИГИНИ ИСТИСНО ҚИЛАДИГАН ҲОЛАТЛАР") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ ЖАЗО ВА УНИ ТАЙИНЛАШ") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.БЕШИНЧИ БЎЛИМ ЖАВОБГАРЛИКДАН ВА ЖАЗОДАН ОЗОД ҚИЛИШ") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_5());
            }


            if (titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ, БОШҚАРУВ ВА ЖАМОАТ БИРЛАШМАЛАРИ ОРГАНЛАРИНИНГ ФАОЛИЯТ ТАРТИБИГА ҚАРШИ ЖИНОЯТЛАР") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ ТИББИЙ ЙЎСИНДАГИ МАЖБУРЛОВ ЧОРАЛАРИ") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_7());
            }


            if (titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ АТАМАЛАРНИНГ ҲУҚУҚИЙ МАЪНОСИ") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_kir.getActs_Chapter_8());
            }
        }


        //lat start
        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI") && positionActs == 0)
        {
            if (titleSubject.equals("I.BIRINChI BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.IKKINChI BO‘LIM. MA’MURIY HUQUQBUZARLIK VA MA’MURIY JAVOBGARLIK") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.UChINChI BO‘LIM. MA’MURIY HUQUQBUZARLIKLAR TO‘G‘RISIDAGI IShLARNI KO‘RIB ChIQIShGA VAKOLATI BO‘LGAN ORGANLAR (MANSABDOR ShAXSLAR)") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.TO‘RTINChI BO‘LIM. MA’MURIY HUQUQBUZARLIK TO‘G‘RISIDAGI IShLARNI YURITISh") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.BEShINChI BO‘LIM. MA’MURIY JAZO QO‘LLANISh TO‘G‘RISIDAGI QARORLARNI IJRO ETISh") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_uz.getActs_Chapter_5());
            }
        }

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && positionActs == 1)
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

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI") && positionActs == 2)
        {
            if (titleSubject.equals("I BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III BO‘LIM. MAJBURIYAT HUQUQI") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_uz.getActs_Chapter_3());
            }
        }


        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && positionActs == 10) {
            if (titleSubject.equals("I.BIRINChI BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_1());
            }



            if (titleSubject.equals("II.IKKINChI BO‘LIM. JAVOBGARLIK ASOSLARI") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_2());
            }


            if (titleSubject.equals("III.UChINChI BO‘LIM. QILMIShNING JINOIYLIGINI ISTISNO QILADIGAN HOLATLAR") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.TO‘RTINChI BO‘LIM. JAZO VA UNI TAYINLASh") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.BEShINChI BO‘LIM. JAVOBGARLIKDAN VA JAZODAN OZOD QILISh") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_5());
            }


            if (titleSubject.equals("VI.OLTINChI BO‘LIM. VOYAGA YETMAGANLAR JAVOBGARLIGINING XUSUSIYATLARI") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.YETTINChI BO'LIM. TIBBIY YO‘SINDAGI MAJBURLOV ChORALARI") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_7());
            }


            if (titleSubject.equals("VIII.SAKKIZINChI BO‘LIM. ATAMALARNING HUQUQIY MA’NOSI") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_uz.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && positionActs == 3)
        {
            if (titleSubject.equals("I.BIRINChI BO‘LIM \n" + "ASOSIY QOIDALAR") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.IKKINChI BO‘LIM \n" + "JINOYAT PROSESSI ISHTIROKChILARI") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.UChINChI BO‘LIM \n" + "DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.TO‘RTINChI BO‘LIM \n" + "PROSESSUAL MAJBURLOV") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.BESHINChI BO‘LIM \n" + "JINOYAT NATIJASIDA YETKAZILGAN MULKIY ZIYONNI QOPLASH") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI.OLTINChI BO‘LIM \n" + "JINOYATLARNING OLDINI OLISH ChORALARI") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII.YETTINChI BO‘LIM \n" + "REABILITASIYA") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII.SAKKIZINChI BO‘LIM \n" + "PROSESSUAL MUDDATLAR VA ChIQIMLAR") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX.TO‘QQIZINChI BO‘LIM \n" + "ISHNI SUDGA QADAR YuRITISH") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_9());
            }

            if (titleSubject.equals("X.O‘NINChI BO‘LIM \n" + "BIRINChI INSTANSIYA SUDIDA ISH YURITISH") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI.O‘N BIRINChI BO‘LIM \n" + "HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII.O‘N IKKINChI BO‘LIM \n" + "HUKM, AJRIM, QARORLARNI IJRO ETISH") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII.O‘N UChINChI BO‘LIM \n" + "ALOHIDA TOIFADAGI JINOYAT ISHLARINI YURITISH") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV.O‘N TO‘RTINChI BO‘LIM \n" + "JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_14());
            }
        }

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING SOLIQ KODEKSI") && positionActs == 5)
        {
            if (titleSubject.equals("I BO‘LIM-UMUMIY QOIDALAR") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_1());
            }

            if (titleSubject.equals("II BO‘LIM-SOLIQ HISOBI VA SOLIQ HISOBOTLARI") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_2());
            }

            if (titleSubject.equals("III BO‘LIM-SOLIQ MAJBURIYATINI BAJARISH") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV BO‘LIM-SOLIQ TO‘LOVChILARNI VA SOLIQ SOLISH OB’YEKTLARINI HISOBGA OLISH") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_4());
            }

            if (titleSubject.equals("V BO‘LIM-SOLIQ NAZORATI") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_5());
            }

            if (titleSubject.equals("VI BO‘LIM-TRANSFERT NARXNI BELGILASHDA SOLIQ NAZORATI") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII BO‘LIM-NAZORAT QILINADIGAN CHET EL KOMPANIYALARINING FOYDASIGA SOLIQ SOLISH SHARTLARI VA UMUMIY QOIDALARI") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII BO‘LIM-SOLIQQA OID HUQUQBUZARLIKLAR VA ULARNI SODIR ETGANLIK UChUN JAVOBGARLIK") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_8());
            }

            if (titleSubject.equals("IX BO‘LIM-SOLIQ ORGANLARINING HUJJATLARI VA ULAR MANSABDOR SHAXSLARINING HARAKATLARI (HARAKATSIZLIGI) USTIDAN SHIKOYAT BERISH") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_9());
            }

            if (titleSubject.equals("X BO‘LIM-QO‘SHILGAN QIYMAT SOLIGʻI") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_10());
            }

            if (titleSubject.equals("XI BO‘LIM-AKSIZ SOLIGʻI") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_11());
            }

            if (titleSubject.equals("XII BO‘LIM-FOYDA SOLIGʻI") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_12());
            }

            if (titleSubject.equals("XIII BO‘LIM-JISMONIY SHAXSLARDAN OLINADIGAN DAROMAD SOLIGʻI") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_13());
            }

            if (titleSubject.equals("XIV BO‘LIM-IJTIMOIY SOLIQ") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_14());
            }

            if (titleSubject.equals("XV BO‘LIM-MOL-MULK SOLIGʻI") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_15());
            }

            if (titleSubject.equals("XVI BO‘LIM-YER SOLIGʻI") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_16());
            }

            if (titleSubject.equals("XVII BO‘LIM-SUV RESURSLARIDAN FOYDALANGANLIK UChUN SOLIQ") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_17());
            }

            if (titleSubject.equals("XVIII BO‘LIM-YER QA’RIDAN FOYDALANGANLIK UChUN SOLIQ") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_18());
            }

            if (titleSubject.equals("XIX BO‘LIM-YIGʻIMLAR") && positionSubject == 18)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_19());
            }

            if (titleSubject.equals("XX BO‘LIM-AYLANMADAN OLINADIGAN SOLIQ") && positionSubject == 19)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_20());
            }

            if (titleSubject.equals("XXI BO‘LIM-SOLIQ TO‘LOVChILARNING AYRIM TOIFALARIGA SOLIQ SOLISHNING O‘ZIGA XOS XUSUSIYATLARI") && positionSubject == 20)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_uz.getActs_Chapter_21());
            }


        }

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && positionActs == 7) {
            if (titleSubject.equals("I BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_1());
            }

            if (titleSubject.equals("II BO‘LIM. NIKOH") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_2());
            }

            if (titleSubject.equals("III BO‘LIM. QON-QARINDOShLIK VA BOLALARNING NASL-NASABINI BELGILASh") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV BO‘LIM. OTA-ONA HAMDA VOYAGA YETMAGAN BOLALARNING HUQUQ VA MAJBURIYATLARI") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_4());
            }

            if (titleSubject.equals("V BO‘LIM. OILA A’ZOLARINING VA BOShQA ShAXSLARNING ALIMENT MAJBURIYATLARI") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_5());
            }
            if (titleSubject.equals("VI BO‘LIM. OTA-ONA QARAMOG‘IDAN MAHRUM BO‘LGAN BOLALARNI JOYLAShTIRISh ShAKLLARI") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_6());
            }

            if (titleSubject.equals("VII BO‘LIM. FUQAROLIK HOLATI DALOLATNOMALARINI QAYD ETISh") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_7());
            }

            if (titleSubject.equals("VIII BO‘LIM. ChET EL FUQAROLARI VA FUQAROLIGI BO‘LMAGAN ShAXSLAR IShTIROKIDAGI OILAVIY MUNOSABATLARNI TARTIBGA SOLISh") && positionSubject == 7) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_lat.getActs_Chapter_8());
            }
        }

        if (titleActs.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && positionActs == 8) {
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
            if (titleSubject.equals("I.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("II.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("III.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("IV.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Administrativniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("V.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ") && positionSubject == 4)
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
            if (titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Grajdanskiy_kodeks_ru.getActs_Chapter_3());
            }
        }

        if (titleActs.equals("Налоговый кодекс") && positionActs == 5)
        {
            if (titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("РАЗДЕЛ II. ИСПОЛНЕНИЕ НАЛОГОВОГО ОБЯЗАТЕЛЬСТВА") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("РАЗДЕЛ III. НАЛОГОВЫЙ КОНТРОЛЬ") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("РАЗДЕЛ IV. ОТВЕТСТВЕННОСТЬ ЗА НАЛОГОВОЕ ПРАВОНАРУШЕНИЕ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("РАЗДЕЛ V. НАЛОГ НА ПРИБЫЛЬ ЮРИДИЧЕСКИХ ЛИЦ") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_5());
            }

            if (titleSubject.equals("РАЗДЕЛ VI. НАЛОГ НА ДОХОДЫ ФИЗИЧЕСКИХ ЛИЦ") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("РАЗДЕЛ VII. НАЛОГ НА ДОБАВЛЕННУЮ СТОИМОСТЬ") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("РАЗДЕЛ VIII. АКЦИЗНЫЙ НАЛОГ") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_8());
            }

            if (titleSubject.equals("РАЗДЕЛ IX. НАЛОГИ И СПЕЦИАЛЬНЫЕ ПЛАТЕЖИ ДЛЯ НЕДРОПОЛЬЗОВАТЕЛЕЙ") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_9());
            }

            if (titleSubject.equals("РАЗДЕЛ X. НАЛОГ ЗА ПОЛЬЗОВАНИЕ ВОДНЫМИ РЕСУРСАМИ") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_10());
            }

            if (titleSubject.equals("РАЗДЕЛ XI. НАЛОГ НА ИМУЩЕСТВО") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_11());
            }

            if (titleSubject.equals("РАЗДЕЛ XII. ЗЕМЕЛЬНЫЙ НАЛОГ") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_12());
            }

            if (titleSubject.equals("РАЗДЕЛ XV. ОБЯЗАТЕЛЬНЫЕ ПЛАТЕЖИ В ГОСУДАРСТВЕННЫЕ ЦЕЛЕВЫЕ ФОНДЫ") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_15());
            }

            if (titleSubject.equals("РАЗДЕЛ XVII. ГОСУДАРСТВЕННАЯ ПОШЛИНА") && positionSubject == 13)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_17());
            }

            if (titleSubject.equals("РАЗДЕЛ XVIII. ТАМОЖЕННЫЕ ПЛАТЕЖИ") && positionSubject == 14)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_18());
            }

            if (titleSubject.equals("РАЗДЕЛ XIX. СБОР ЗА ПРАВО РОЗНИЧНОЙ ТОРГОВЛИ ОТДЕЛЬНЫМИ ВИДАМИ ТОВАРОВ И ОКАЗАНИЕ ОТДЕЛЬНЫХ ВИДОВ УСЛУГ") && positionSubject == 15)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_19());
            }

            if (titleSubject.equals("РАЗДЕЛ XX. УПРОЩЕННЫЙ ПОРЯДОК НАЛОГООБЛОЖЕНИЯ") && positionSubject == 16)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_20());
            }

            if (titleSubject.equals("РАЗДЕЛ XXI. ОСОБЕННОСТИ НАЛОГООБЛОЖЕНИЯ ОТДЕЛЬНЫХ КАТЕГОРИЙ НАЛОГОПЛАТЕЛЬЩИКОВ") && positionSubject == 17)
            {
                adapter.setActs_subtitleList(Nalogoviy_kodeks_ru.getActs_Chapter_21());
            }



        }

        if (titleActs.equals("Семейный кодекс") && positionActs == 7) {
            if (titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("РАЗДЕЛ II. БРАК") && positionSubject == 1) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("РАЗДЕЛ III. КРОВНОЕ РОДСТВО И УСТАНОВЛЕНИЕ ПРОИСХОЖДЕНИЯ ДЕТЕЙ") && positionSubject == 2) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("РАЗДЕЛ IV. ПРАВА И ОБЯЗАННОСТИ РОДИТЕЛЕЙ И НЕСОВЕРШЕННОЛЕТНИХ ДЕТЕЙ") && positionSubject == 3) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("РАЗДЕЛ V. АЛИМЕНТНЫЕ ОБЯЗАТЕЛЬСТВА ЧЛЕНОВ СЕМЬИ И ДРУГИХ ЛИЦ") && positionSubject == 4) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_5());
            }
            if (titleSubject.equals("РАЗДЕЛ VI. ФОРМЫ УСТРОЙСТВА ДЕТЕЙ, ОСТАВШИХСЯ БЕЗ ПОПЕЧЕНИЯ РОДИТЕЛЕЙ") && positionSubject == 5) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("РАЗДЕЛ VII. РЕГИСТРАЦИЯ АКТОВ ГРАЖДАНСКОГО СОСТОЯНИЯ") && positionSubject == 6) {
                adapter.setActs_subtitleList(Semeyniy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА") && positionSubject == 7) {
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
            if (titleSubject.equals("РАЗДЕЛ 1. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_1());
            }



            if (titleSubject.equals("РАЗДЕЛ 2. ОСНОВАНИЯ ОТВЕТСТВЕННОСТИ") && positionSubject == 1) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_2());
            }


            if (titleSubject.equals("РАЗДЕЛ 3. ОБСТОЯТЕЛЬСТВА, ИСКЛЮЧАЮЩИЕ ПРЕСТУПНОСТЬ ДЕЯНИЯ") && positionSubject == 2) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("РАЗДЕЛ 4. НАКАЗАНИЕ И ЕГО НАЗНАЧЕНИЕ") && positionSubject == 3) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("РАЗДЕЛ 5. ОСВОБОЖДЕНИЕ ОТ ОТВЕТСТВЕННОСТИ И НАКАЗАНИЯ") && positionSubject == 4) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_5());
            }


            if (titleSubject.equals("РАЗДЕЛ 6. ОСОБЕННОСТИ ОТВЕТСТВЕННОСТИ НЕСОВЕРШЕННОЛЕТНИХ") && positionSubject == 5) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("РАЗДЕЛ 7. ПРИНУДИТЕЛЬНЫЕ МЕРЫ МЕДИЦИНСКОГО ХАРАКТЕРА") && positionSubject == 6) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_7());
            }


            if (titleSubject.equals("VIII.SAKKIZINChI BO‘LIM. ATAMALARNING HUQUQIY MA’NOSI") && positionSubject == 7) {
                adapter.setActs_subtitleList(Ugolovniy_kodeks_ru.getActs_Chapter_8());
            }
        }


        if (titleActs.equals("Уголовный процессуальный кодекс") && positionActs == 3)
        {
            if (titleSubject.equals("РАЗДЕЛ ПЕРВЫЙ \n" + "ОСНОВНЫЕ ПОЛОЖЕНИЯ") && positionSubject == 0)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_1());
            }

            if (titleSubject.equals("РАЗДЕЛ ВТОРОЙ \n" + "УЧАСТНИКИ УГОЛОВНОГО ПРОЦЕССА") && positionSubject == 1)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_2());
            }

            if (titleSubject.equals("РАЗДЕЛ ТРЕТИЙ \n" + "ДОКАЗАТЕЛЬСТВА И ОБСТОЯТЕЛЬСТВА, ПОДЛЕЖАЩИЕ ДОКАЗЫВАНИЮ") && positionSubject == 2)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_3());
            }

            if (titleSubject.equals("РАЗДЕЛ ЧЕТВЕРТЫЙ \n" + "ПРОЦЕССУАЛЬНОЕ ПРИНУЖДЕНИЕ") && positionSubject == 3)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_4());
            }

            if (titleSubject.equals("РАЗДЕЛ ПЯТЫЙ \n" + "ВОЗМЕЩЕНИЕ ИМУЩЕСТВЕННОГО ВРЕДА, ПРИЧИНЕННОГО ПРЕСТУПЛЕНИЕМ") && positionSubject == 4)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_5());
            }

            if (titleSubject.equals("РАЗДЕЛ ШЕСТОЙ \n" + "МЕРЫ ПРЕДУПРЕЖДЕНИЯ ПРЕСТУПЛЕНИЙ") && positionSubject == 5)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_6());
            }

            if (titleSubject.equals("РАЗДЕЛ СЕДЬМОЙ \n" + "РЕАБИЛИТАЦИЯ") && positionSubject == 6)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_7());
            }

            if (titleSubject.equals("РАЗДЕЛ ВОСЬМОЙ\n" + "ПРОЦЕССУАЛЬНЫЕ СРОКИ И ИЗДЕРЖКИ") && positionSubject == 7)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_8());
            }

            if (titleSubject.equals("РАЗДЕЛ ДЕВЯТЫЙ\n" + "ДОСУДЕБНОЕ ПРОИЗВОДСТВО") && positionSubject == 8)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_9());
            }

            if (titleSubject.equals("РАЗДЕЛ ДЕСЯТЫЙ \n" + "ПРОИЗВОДСТВО В СУДЕ ПЕРВОЙ ИНСТАНЦИИ") && positionSubject == 9)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_10());
            }

            if (titleSubject.equals("РАЗДЕЛ ОДИННАДЦАТЫЙ \n" + "ПРОВЕРКА ЗАКОННОСТИ, ОБОСНОВАННОСТИ И СПРАВЕДЛИВОСТИ ПРИГОВОРОВ, ОПРЕДЕЛЕНИЙ И ПОСТАНОВЛЕНИЙ") && positionSubject == 10)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_11());
            }

            if (titleSubject.equals("РАЗДЕЛ ДВЕНАДЦАТЫЙ \n" + "ИСПОЛНЕНИЕ ПРИГОВОРОВ, ОПРЕДЕЛЕНИЙ, ПОСТАНОВЛЕНИЙ") && positionSubject == 11)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_12());
            }

            if (titleSubject.equals("РАЗДЕЛ ТРИНАДЦАТЫЙ\n" + "ПРОИЗВОДСТВО ПО ОТДЕЛЬНЫМ КАТЕГОРИЯМ УГОЛОВНЫХ ДЕЛ") && positionSubject == 12)
            {
                adapter.setActs_subtitleList(Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_13());
            }

            if (titleSubject.equals("РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ \n" + "МЕЖДУНАРОДНОЕ СОТРУДНИЧЕСТВО В СФЕРЕ УГОЛОВНОГО СУДОПРОИЗВОДСТВА") && positionSubject == 13)
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
                startActivity(intent1);

            }
        });

    }
}
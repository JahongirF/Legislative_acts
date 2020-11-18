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

        if (titleActs.equals("Административный кодекс") && positionActs == 0)
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

        if (titleActs.equals("Бюджетный кодекс") && positionActs == 1)
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

        if (titleActs.equals("Гражданский кодекс") && positionActs == 2)
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

        if (titleActs.equals("Уголовный процессуальный кодекс") && positionActs == 3)
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

        if (titleActs.equals("Налоговый кодекс") && positionActs == 5)
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

        if (titleActs.equals("Семейный кодекс") && positionActs == 7) {
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

        if (titleActs.equals("Таможенный кодекс") && positionActs == 8) {
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

        if (titleActs.equals("Уголовный кодекс") && positionActs == 10) {
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
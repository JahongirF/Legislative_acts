package com.example.legislative_acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.legislative_acts.Data.Acts_Subtitle;
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
import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

public class Detail_Activity extends AppCompatActivity {

    private String title;
    private int position;
    private String titleSubject;
    private int positionSubject;
    private String titleChapter;
    private int positionChapter;
    private PDFView pdfView;
    private String dark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        pdfView = findViewById(R.id.pdfView);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            dark = "no";
        } else {
            dark = "yes";
        }

        Intent intent = getIntent();

        if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("positionSubject") && intent.hasExtra("titleSubject")) {
            title = intent.getStringExtra("title");
            position = intent.getIntExtra("position", 1);
            titleSubject = intent.getStringExtra("titleSubject");
            positionSubject = intent.getIntExtra("positionSubject", 2);
        }
        if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("titleSubject") && intent.hasExtra("positionSubject") && intent.hasExtra("titleChapter") && intent.hasExtra("positionChapter")) {
            title = intent.getStringExtra("title");
            position = intent.getIntExtra("position", 1);
            titleSubject = intent.getStringExtra("titleSubject");
            positionSubject = intent.getIntExtra("positionSubject", 2);
            titleChapter = intent.getStringExtra("titleChapter");
            positionChapter = intent.getIntExtra("positionChapter", 3);

        }

       // Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject, Toast.LENGTH_LONG).show();


        //Административный кодекс начало

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && position == 0 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/1.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР/" + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/1.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР/" + acts_subtitles.get(i).getTitle() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && position == 0 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/2.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/2.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && position == 0 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/3.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/3.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && position == 0 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/4.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/4.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МАЪМУРИЙ ЖАВОБГАРЛИК ТЎҒРИСИДАГИ КОДЕКСИ") && position == 0 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/5.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/5.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Административный кодекс начало


        //Бюджетный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("I бўлим Умумий қоидалар") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/1.I бўлим Умумий қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/1.I бўлим Умумий қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("II бўлим Бюджет тизими бюджетлари") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/2.II бўлим Бюджет тизими бюджетлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/2.II бўлим Бюджет тизими бюджетлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/3.III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/3.III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("IV бўлим Бюджет тизими бюджетларининг даромадлари") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/4.IV бўлим Бюджет тизими бюджетларининг даромадлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/4.IV бўлим Бюджет тизими бюджетларининг даромадлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("V бўлим Бюджет тизими бюджетларининг харажатлари") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/5.V бўлим Бюджет тизими бюджетларининг харажатлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/5.V бўлим Бюджет тизими бюджетларининг харажатлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("VI бўлим Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/6.VI бўлим Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/6.VI бўлим Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("VII бўлим Бюджет тизими бюджетларининг ижроси") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/7.VII бўлим Бюджет тизими бюджетларининг ижроси/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/7.VII бўлим Бюджет тизими бюджетларининг ижроси/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БЮДЖЕТ КОДЕКСИ") && position == 1 && titleSubject.equals("VIII бўлим Бюджет ҳисоби ва ҳисоботи") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Бюджетный кодекс/8.VIII бўлим Бюджет ҳисоби ва ҳисоботи/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Бюджетный кодекс/8.VIII бўлим Бюджет ҳисоби ва ҳисоботи/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Бюджетный кодекс канец


        //Гражданский кодекс начано
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ФУҚАРОЛИК КОДЕКСИ") && position == 2 && titleSubject.equals("I.БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ФУҚАРОЛИК КОДЕКСИ") && position == 2 && titleSubject.equals("II.БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/2.II БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/2.II БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ФУҚАРОЛИК КОДЕКСИ") && position == 2 && titleSubject.equals("III.БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/3.III БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/3.III БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Гражданский кодекс конец

        //Уголовный процессуальный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ \n" + "АСОСИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/1.БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/1.БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ \n" + "ЖИНОЯТ ПРОЦЕССИ ИШТИРОКЧИЛАРИ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/2.ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/2.ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "ДАЛИЛЛАР ВА ИСБОТ ҚИЛИНИШИ ЛОЗИМ БЎЛГАН ҲОЛАТЛАР") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "ДАЛИЛЛАР ВА ИСБОТ ҚИЛИНИШИ ЛОЗИМ БЎЛГАН ҲОЛАТЛАР") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МАЖБУРЛОВ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/4.ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/4.ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ \n" + "ЖИНОЯТ НАТИЖАСИДА ЕТКАЗИЛГАН МУЛКИЙ ЗИЁННИ ҚОПЛАШ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/5.БЕШИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/5.БЕШИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ \n" + "ЖИНОЯТЛАРНИНГ ОЛДИНИ ОЛИШ ЧОРАЛАРИ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/6.ОЛТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/6.ОЛТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ \n" + "РЕАБИЛИТАЦИЯ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/7.ЕТТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/7.ЕТТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МУДДАТЛАР ВА ЧИҚИМЛАР") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/8.САККИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/8.САККИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("IX.ТЎҚҚИЗИНЧИ БЎЛИМ \n" + "ИШНИ СУДГА ҚАДАР ЮРИТИШ") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/9.ТЎҚҚИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/9.ТЎҚҚИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("X.ЎНИНЧИ БЎЛИМ \n" + "БИРИНЧИ ИНСТАНЦИЯ СУДИДА ИШ ЮРИТИШ") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/10.ЎНИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/10.ЎНИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("XI.ЎН БИРИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ ВА ҚАРОРЛАРНИНГ ҚОНУНИЙЛИГИ, АСОСЛИЛИГИ ВА АДОЛАТЛИЛИГИНИ ТЕКШИРИШ") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/11.ЎН БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/11.ЎН БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("XII.ЎН ИККИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ, ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/12.ЎН ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/12.ЎН ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("XIII.ЎН УЧИНЧИ БЎЛИМ \n" + "АЛОҲИДА ТОИФАДАГИ ЖИНОЯТ ИШЛАРИНИ ЮРИТИШ") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/13.ЎН УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/13.ЎН УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ-ПРОЦЕССУАЛ КОДЕКСИ") && position == 3 && titleSubject.equals("XIV.ЎН ТЎРТИНЧИ БЎЛИМ \n" + "ЖИНОИЙ СУД ИШЛАРИНИ ЮРИТИШ СОҲАСИДАГИ ХАЛҚАРО ҲАМКОРЛИК") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/14.ЎН ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/14.ЎН ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный процессуальный кодекс конец

        //Налоговый кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("II БЎЛИМ СОЛИҚ ҲИСОБИ ВА СОЛИҚ ҲИСОБОТЛАРИ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/2.II БЎЛИМ СОЛИҚ ҲИСОБИ ВА СОЛИҚ ҲИСОБОТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/2.II БЎЛИМ СОЛИҚ ҲИСОБИ ВА СОЛИҚ ҲИСОБОТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("III БЎЛИМ СОЛИҚ МАЖБУРИЯТИНИ БАЖАРИШ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/3.III БЎЛИМ СОЛИҚ МАЖБУРИЯТИНИ БАЖАРИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/3.III БЎЛИМ СОЛИҚ МАЖБУРИЯТИНИ БАЖАРИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("IV БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИ ВА СОЛИҚ СОЛИШ ОБЪЕКТЛАРИНИ ҲИСОБГА ОЛИШ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/4.IV БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИ ВА СОЛИҚ СОЛИШ ОБЪЕКТЛАРИНИ ҲИСОБГА ОЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/4.IV БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИ ВА СОЛИҚ СОЛИШ ОБЪЕКТЛАРИНИ ҲИСОБГА ОЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("V БЎЛИМ СОЛИҚ НАЗОРАТИ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/5.V БЎЛИМ СОЛИҚ НАЗОРАТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/5.V БЎЛИМ СОЛИҚ НАЗОРАТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("VI БЎЛИМ ТРАНСФЕРТ НАРХНИ БЕЛГИЛАШДА СОЛИҚ НАЗОРАТИ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/6.VI БЎЛИМ ТРАНСФЕРТ НАРХНИ БЕЛГИЛАШДА СОЛИҚ НАЗОРАТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/6.VI БЎЛИМ ТРАНСФЕРТ НАРХНИ БЕЛГИЛАШДА СОЛИҚ НАЗОРАТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("VII БЎЛИМ НАЗОРАТ ҚИЛИНАДИГАН ЧЕТ ЭЛ КОМПАНИЯЛАРИНИНГ ФОЙДАСИГА СОЛИҚ СОЛИШ ШАРТЛАРИ ВА УМУМИЙ ҚОИДАЛАРИ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/7.VII БЎЛИМ НАЗОРАТ ҚИЛИНАДИГАН ЧЕТ ЭЛ КОМПАНИЯЛАРИНИНГ ФОЙДАСИГА СОЛИҚ СОЛИШ ШАРТЛАРИ ВА УМУМИЙ ҚОИДАЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/7.VII БЎЛИМ НАЗОРАТ ҚИЛИНАДИГАН ЧЕТ ЭЛ КОМПАНИЯЛАРИНИНГ ФОЙДАСИГА СОЛИҚ СОЛИШ ШАРТЛАРИ ВА УМУМИЙ ҚОИДАЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("VIII БЎЛИМ СОЛИҚҚА ОИД ҲУҚУҚБУЗАРЛИКЛАР ВА УЛАРНИ СОДИР ЭТГАНЛИК УЧУН ЖАВОБГАРЛИК") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/8.VIII БЎЛИМ СОЛИҚҚА ОИД ҲУҚУҚБУЗАРЛИКЛАР ВА УЛАРНИ СОДИР ЭТГАНЛИК УЧУН ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/8.VIII БЎЛИМ СОЛИҚҚА ОИД ҲУҚУҚБУЗАРЛИКЛАР ВА УЛАРНИ СОДИР ЭТГАНЛИК УЧУН ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("IX БЎЛИМ СОЛИҚ ОРГАНЛАРИНИНГ ҲУЖЖАТЛАРИ ВА УЛАР МАНСАБДОР ШАХСЛАРИНИНГ ҲАРАКАТЛАРИ (ҲАРАКАТСИЗЛИГИ) УСТИДАН ШИКОЯТ БЕРИШ") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/9.IX БЎЛИМ СОЛИҚ ОРГАНЛАРИНИНГ ҲУЖЖАТЛАРИ ВА УЛАР МАНСАБДОР ШАХСЛАРИНИНГ ҲАРАКАТЛАРИ (ҲАРАКАТСИЗЛИГИ) УСТИДАН ШИКОЯТ БЕРИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/9.IX БЎЛИМ СОЛИҚ ОРГАНЛАРИНИНГ ҲУЖЖАТЛАРИ ВА УЛАР МАНСАБДОР ШАХСЛАРИНИНГ ҲАРАКАТЛАРИ (ҲАРАКАТСИЗЛИГИ) УСТИДАН ШИКОЯТ БЕРИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("X БЎЛИМ ҚЎШИЛГАН ҚИЙМАТ СОЛИҒИ") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/10.X БЎЛИМ ҚЎШИЛГАН ҚИЙМАТ СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/10.X БЎЛИМ ҚЎШИЛГАН ҚИЙМАТ СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("ХI БЎЛИМ АКЦИЗ СОЛИҒИ") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/11.ХI БЎЛИМ АКЦИЗ СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/11.ХI БЎЛИМ АКЦИЗ СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XII БЎЛИМ ФОЙДА СОЛИҒИ") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/12.XII БЎЛИМ ФОЙДА СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/12.XII БЎЛИМ ФОЙДА СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XIII БЎЛИМ ЖИСМОНИЙ ШАХСЛАРДАН ОЛИНАДИГАН ДАРОМАД СОЛИҒИ") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/13.XIII БЎЛИМ ЖИСМОНИЙ ШАХСЛАРДАН ОЛИНАДИГАН ДАРОМАД СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/13.XIII БЎЛИМ ЖИСМОНИЙ ШАХСЛАРДАН ОЛИНАДИГАН ДАРОМАД СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XIV БЎЛИМ ИЖТИМОИЙ СОЛИҚ") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/14.XIV БЎЛИМ ИЖТИМОИЙ СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/14.XIV БЎЛИМ ИЖТИМОИЙ СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XV БЎЛИМ МОЛ-МУЛК СОЛИҒИ") && positionSubject == 14) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_15();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/15.XV БЎЛИМ МОЛ-МУЛК СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/15.XV БЎЛИМ МОЛ-МУЛК СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XVI БЎЛИМ ЕР СОЛИҒИ") && positionSubject == 15) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_16();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/16.XVI БЎЛИМ ЕР СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/16.XVI БЎЛИМ ЕР СОЛИҒИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XVII БЎЛИМ СУВ РЕСУРСЛАРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 16) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_17();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/17.XVII БЎЛИМ СУВ РЕСУРСЛАРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/17.XVII БЎЛИМ СУВ РЕСУРСЛАРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XVIII БЎЛИМ ЕР ҚАЪРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 17) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_18();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/18.XVIII БЎЛИМ ЕР ҚАЪРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/18.XVIII БЎЛИМ ЕР ҚАЪРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XIX БЎЛИМ ЙИҒИМЛАР") && positionSubject == 18) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_19();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/19.XIX БЎЛИМ ЙИҒИМЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/19.XIX БЎЛИМ ЙИҒИМЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("XX БЎЛИМ АЙЛАНМАДАН ОЛИНАДИГАН СОЛИҚ") && positionSubject == 19) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_20();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/20.XX БЎЛИМ АЙЛАНМАДАН ОЛИНАДИГАН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/20.XX БЎЛИМ АЙЛАНМАДАН ОЛИНАДИГАН СОЛИҚ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ СОЛИҚ КОДЕКСИ") && position == 5 && titleSubject.equals("ХХI БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИНГ АЙРИМ ТОИФАЛАРИГА СОЛИҚ СОЛИШНИНГ ЎЗИГА ХОС ХУСУСИЯТЛАРИ") && positionSubject == 20) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_kir.getActs_Chapter_21();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Налоговый кодекс/21.ХХI БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИНГ АЙРИМ ТОИФАЛАРИГА СОЛИҚ СОЛИШНИНГ ЎЗИГА ХОС ХУСУСИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Налоговый кодекс/21.ХХI БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИНГ АЙРИМ ТОИФАЛАРИГА СОЛИҚ СОЛИШНИНГ ЎЗИГА ХОС ХУСУСИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Налоговый кодекс конец

        //Общественный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ МАСЪУЛИЯТИ ЧЕКЛАНГАН ҲАМДА ҚЎШИМЧА МАСЪУЛИЯТЛИ ЖАМИЯТЛАР ТЎҒРИСИДА") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_lodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Общественный кодекс конец

        //Семейный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("II БЎЛИМ НИКОҲ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/2.II БЎЛИМ НИКОҲ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/2.II БЎЛИМ НИКОҲ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("III БЎЛИМ ҚОН-ҚАРИНДОШЛИК ВА БОЛАЛАРНИНГ НАСЛ-НАСАБИНИ БЕЛГИЛАШ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/3.III БЎЛИМ ҚОН-ҚАРИНДОШЛИК ВА БОЛАЛАРНИНГ НАСЛ-НАСАБИНИ БЕЛГИЛАШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/3.III БЎЛИМ ҚОН-ҚАРИНДОШЛИК ВА БОЛАЛАРНИНГ НАСЛ-НАСАБИНИ БЕЛГИЛАШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("IV БЎЛИМ ОТА-ОНА ҲАМДА ВОЯГА ЕТМАГАН БОЛАЛАРНИНГ ҲУҚУҚ ВА МАЖБУРИЯТЛАРИ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/4.IV БЎЛИМ ОТА-ОНА ҲАМДА ВОЯГА ЕТМАГАН БОЛАЛАРНИНГ ҲУҚУҚ ВА МАЖБУРИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/4.IV БЎЛИМ ОТА-ОНА ҲАМДА ВОЯГА ЕТМАГАН БОЛАЛАРНИНГ ҲУҚУҚ ВА МАЖБУРИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("V БЎЛИМ ОИЛА АЪЗОЛАРИНИНГ ВА БОШҚА ШАХСЛАРНИНГ АЛИМЕНТ МАЖБУРИЯТЛАРИ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/5.V БЎЛИМ ОИЛА АЪЗОЛАРИНИНГ ВА БОШҚА ШАХСЛАРНИНГ АЛИМЕНТ МАЖБУРИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/5.V БЎЛИМ ОИЛА АЪЗОЛАРИНИНГ ВА БОШҚА ШАХСЛАРНИНГ АЛИМЕНТ МАЖБУРИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("VI БЎЛИМ ОТА-ОНА ҚАРАМОҒИДАН МАҲРУМ БЎЛГАН БОЛАЛАРНИ ЖОЙЛАШТИРИШ ШАКЛЛАРИ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/6.VI БЎЛИМ ОТА-ОНА ҚАРАМОҒИДАН МАҲРУМ БЎЛГАН БОЛАЛАРНИ ЖОЙЛАШТИРИШ ШАКЛЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/6.VI БЎЛИМ ОТА-ОНА ҚАРАМОҒИДАН МАҲРУМ БЎЛГАН БОЛАЛАРНИ ЖОЙЛАШТИРИШ ШАКЛЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/7.VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/7.VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/7.VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/7.VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ОИЛА КОДЕКСИ") && position == 7 && titleSubject.equals("VIII БЎЛИМ ЧЕТ ЭЛ ФУҚАРОЛАРИ ВА ФУҚАРОЛИГИ БЎЛМАГАН ШАХСЛАР ИШТИРОКИДАГИ ОИЛАВИЙ МУНОСАБАТЛАРНИ ТАРТИБГА СОЛИШ") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Семейный кодекс/8.VIII БЎЛИМ ЧЕТ ЭЛ ФУҚАРОЛАРИ ВА ФУҚАРОЛИГИ БЎЛМАГАН ШАХСЛАР ИШТИРОКИДАГИ ОИЛАВИЙ МУНОСАБАТЛАРНИ ТАРТИБГА СОЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Семейный кодекс/8.VIII БЎЛИМ ЧЕТ ЭЛ ФУҚАРОЛАРИ ВА ФУҚАРОЛИГИ БЎЛМАГАН ШАХСЛАР ИШТИРОКИДАГИ ОИЛАВИЙ МУНОСАБАТЛАРНИ ТАРТИБГА СОЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Семейный кодекс конец

        //Таможенный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/1.I бўлим. Умумий қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/1.I бўлим. Умумий қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("II бўлим. Божхона режимлари") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/2.II бўлим. Божхона режимлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/2.II бўлим. Божхона режимлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/3.III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/3.III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("IV бўлим. Божхона назорати") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/4.IV бўлим. Божхона назорати/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/4.IV бўлим. Божхона назорати/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/5.V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/5.V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("VI бўлим. Божхона расмийлаштируви") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/6.VI бўлим. Божхона расмийлаштируви/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/6.VI бўлим. Божхона расмийлаштируви/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/7.VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/7.VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("VIII бўлим. Божхона тўловлари") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/8.VIII бўлим. Божхона тўловлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/8.VIII бўлим. Божхона тўловлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/9.IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/9.IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/10.X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/10.X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("XI бўлим. Назорат остида етказиб бериш") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/11.XI бўлим. Назорат остида етказиб бериш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/11.XI бўлим. Назорат остида етказиб бериш/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ БОЖХОНА КОДЕКСИ") && position == 8 && titleSubject.equals("XII бўлим. Якунловчи қоидалар") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_kir.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Таможенный кодекс/12.XII бўлим. Якунловчи қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Таможенный кодекс/12.XII бўлим. Якунловчи қоидалар/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Таможенный кодекс конец

        //Уголовный кодекс начало

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/1.I.БИРИНЧИ БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/1.I.БИРИНЧИ БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ ЖАВОБГАРЛИК АСОСЛАРИ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/2.II.ИККИНЧИ БЎЛИМ ЖАВОБГАРЛИК АСОСЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/2.II.ИККИНЧИ БЎЛИМ ЖАВОБГАРЛИК АСОСЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ ҚИЛМИШНИНГ ЖИНОИЙЛИГИНИ ИСТИСНО ҚИЛАДИГАН ҲОЛАТЛАР") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/3.III.УЧИНЧИ БЎЛИМ ҚИЛМИШНИНГ ЖИНОИЙЛИГИНИ ИСТИСНО ҚИЛАДИГАН ҲОЛАТЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/3.III.УЧИНЧИ БЎЛИМ ҚИЛМИШНИНГ ЖИНОИЙЛИГИНИ ИСТИСНО ҚИЛАДИГАН ҲОЛАТЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ ЖАЗО ВА УНИ ТАЙИНЛАШ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/4.IV.ТЎРТИНЧИ БЎЛИМ ЖАЗО ВА УНИ ТАЙИНЛАШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/4.IV.ТЎРТИНЧИ БЎЛИМ ЖАЗО ВА УНИ ТАЙИНЛАШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ ЖАВОБГАРЛИКДАН ВА ЖАЗОДАН ОЗОД ҚИЛИШ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/5.V.БЕШИНЧИ БЎЛИМ ЖАВОБГАРЛИКДАН ВА ЖАЗОДАН ОЗОД ҚИЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/5.V.БЕШИНЧИ БЎЛИМ ЖАВОБГАРЛИКДАН ВА ЖАЗОДАН ОЗОД ҚИЛИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ, БОШҚАРУВ ВА ЖАМОАТ БИРЛАШМАЛАРИ ОРГАНЛАРИНИНГ ФАОЛИЯТ ТАРТИБИГА ҚАРШИ ЖИНОЯТЛАР") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/6.VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ, БОШҚАРУВ ВА ЖАМОАТ БИРЛАШМАЛАРИ ОРГАНЛАРИНИНГ ФАОЛИЯТ ТАРТИБИГА ҚАРШИ ЖИНОЯТЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/6.VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ, БОШҚАРУВ ВА ЖАМОАТ БИРЛАШМАЛАРИ ОРГАНЛАРИНИНГ ФАОЛИЯТ ТАРТИБИГА ҚАРШИ ЖИНОЯТЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ ТИББИЙ ЙЎСИНДАГИ МАЖБУРЛОВ ЧОРАЛАРИ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/7.VII.ЕТТИНЧИ БЎЛИМ ТИББИЙ ЙЎСИНДАГИ МАЖБУРЛОВ ЧОРАЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/7.VII.ЕТТИНЧИ БЎЛИМ ТИББИЙ ЙЎСИНДАГИ МАЖБУРЛОВ ЧОРАЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЖИНОЯТ КОДЕКСИ") && position == 10 && titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ АТАМАЛАРНИНГ ҲУҚУҚИЙ МАЪНОСИ") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/8.VIII.САККИЗИНЧИ БЎЛИМ АТАМАЛАРНИНГ ҲУҚУҚИЙ МАЪНОСИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/8.VIII.САККИЗИНЧИ БЎЛИМ АТАМАЛАРНИНГ ҲУҚУҚИЙ МАЪНОСИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный кодекс финал

        //Земельный кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ЕР КОДЕКСИ") && position == 4) {
            List<Acts_Subtitle> actsList = Zemelniy_kodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Земельный кодекс конец

        //Трудовой кодекс начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ МЕҲНАТ КОДЕКСИ") && position == 9) {
            List<Acts_Subtitle> actsList = Trudovoy_kodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Трудовой кодекс конец

        //Частное предприятие начало
        if (title.equals("ЎЗБЕКИСТОН РЕСПУБЛИКАСИНИНГ ҚОНУНИ ХУСУСИЙ КОРХОНА ТЎҒРИСИДА") && position == 11) {
            List<Acts_Subtitle> actsList = Chastnoe_Predpriyatie.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Частное предприятие конец


        //lat start

        //Административный кодекс начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI") && position == 0 && titleSubject.equals("I.BIRINChI BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/1.I.BIRINChI BO‘LIM.UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/1.I.BIRINChI BO‘LIM.UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI") && position == 0 && titleSubject.equals("II.IKKINChI BO‘LIM. MA’MURIY HUQUQBUZARLIK VA MA’MURIY JAVOBGARLIK") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/2.II.IKKINChI BO‘LIM.MA’MURIY HUQUQBUZARLIK VA MA’MURIY JAVOBGARLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/2.II.IKKINChI BO‘LIM.MA’MURIY HUQUQBUZARLIK VA MA’MURIY JAVOBGARLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI") && position == 0 && titleSubject.equals("III.UChINChI BO‘LIM. MA’MURIY HUQUQBUZARLIKLAR TO‘G‘RISIDAGI IShLARNI KO‘RIB ChIQIShGA VAKOLATI BO‘LGAN ORGANLAR (MANSABDOR ShAXSLAR)") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/3.III.UChINChI BO‘LIM.MA’MURIY HUQUQBUZARLIKLAR TO‘G‘RISIDAGI IShLARNI KO‘RIB ChIQIShGA VAKOLATI BO‘LGAN ORGANLAR (MANSABDOR ShAXSLAR)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/3.III.UChINChI BO‘LIM.MA’MURIY HUQUQBUZARLIKLAR TO‘G‘RISIDAGI IShLARNI KO‘RIB ChIQIShGA VAKOLATI BO‘LGAN ORGANLAR (MANSABDOR ShAXSLAR)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING MA’MURIY JAVOBGARLIK TO‘G‘RISIDAGI KODEKSI") && position == 0 && titleSubject.equals("IV.TO‘RTINChI BO‘LIM. MA’MURIY HUQUQBUZARLIK TO‘G‘RISIDAGI IShLARNI YURITISh") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/4.IV.TO‘RTINChI BO‘LIM.MA’MURIY HUQUQBUZARLIK TO‘G‘RISIDAGI IShLARNI YURITISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/4.IV.TO‘RTINChI BO‘LIM.MA’MURIY HUQUQBUZARLIK TO‘G‘RISIDAGI IShLARNI YURITISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }



        //Административный кодекс конец


        //Бюджетный кодекс начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/1.I bo‘lim.Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/1.I bo‘lim.Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("II bo‘lim. Byudjet tizimi byudjetlari") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/2.II bo‘lim.Byudjet tizimi byudjetlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/2.II bo‘lim.Byudjet tizimi byudjetlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/3.III bo‘lim.O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti. O‘zbekiston Respublikasining tiklanish va taraqqiyot jamg‘armasi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/3.III bo‘lim.O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti. O‘zbekiston Respublikasining tiklanish va taraqqiyot jamg‘armasi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("IV bo‘lim. Byudjet tizimi byudjetlarining daromadlari") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/4.IV bo‘lim.Byudjet tizimi byudjetlarining daromadlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/4.IV bo‘lim.Byudjet tizimi byudjetlarining daromadlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("V bo‘lim. Byudjet tizimi byudjetlarining xarajatlari") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/5.V bo‘lim.Byudjet tizimi byudjetlarining xarajatlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/5.V bo‘lim.Byudjet tizimi byudjetlarining xarajatlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("VI bo‘lim. Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/6.VI bo‘lim.Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/6.VI bo‘lim.Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("VII bo‘lim. Byudjet tizimi byudjetlarining ijrosi") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/7.VII bo‘lim.Byudjet tizimi byudjetlarining ijrosi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/7.VII bo‘lim.Byudjet tizimi byudjetlarining ijrosi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BYUDJET KODEKSI") && position == 1 && titleSubject.equals("VIII bo‘lim. Byudjet hisobi va hisoboti") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Бюджетный кодекс/8.VIII bo‘lim.Byudjet hisobi va hisoboti/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Бюджетный кодекс/8.VIII bo‘lim.Byudjet hisobi va hisoboti/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Бюджетный кодекс конец

        //Гражданский кодекс начало лат

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI") && position == 2 && titleSubject.equals("I BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI") && position == 2 && titleSubject.equals("II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/2.II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/2.II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING FUQAROLIK KODEKSI") && position == 2 && titleSubject.equals("III BO‘LIM. MAJBURIYAT HUQUQI") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/3.III BO‘LIM. MAJBURIYAT HUQUQI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/3.III BO‘LIM. MAJBURIYAT HUQUQI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Гражданский кодекс конец лат


        //Уголовный процес-кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("I.BIRINChI BO‘LIM \n" + "ASOSIY QOIDALAR") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/1.BIRINChI BO‘LIM-ASOSIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/1.BIRINChI BO‘LIM-ASOSIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("II.IKKINChI BO‘LIM \n" + "JINOYAT PROSESSI ISHTIROKChILARI") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/2.IKKINChI BO‘LIM-JINOYAT PROSESSI ISHTIROKChILARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/2.IKKINChI BO‘LIM-JINOYAT PROSESSI ISHTIROKChILARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("III.UChINChI BO‘LIM \n" + "DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/3.UChINChI BO‘LIM-DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/3.UChINChI BO‘LIM-DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }



        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("IV.TO‘RTINChI BO‘LIM \n" + "PROSESSUAL MAJBURLOV") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/4.TO‘RTINChI BO‘LIM-PROSESSUAL MAJBURLOV/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/4.TO‘RTINChI BO‘LIM-PROSESSUAL MAJBURLOV/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("V.BESHINChI BO‘LIM \n" + "JINOYAT NATIJASIDA YETKAZILGAN MULKIY ZIYONNI QOPLASH") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/5.BESHINChI BO‘LIM-JINOYAT NATIJASIDA YeTKAZILGAN MULKIY ZIYoNNI QOPLASH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/5.BESHINChI BO‘LIM-JINOYAT NATIJASIDA YeTKAZILGAN MULKIY ZIYoNNI QOPLASH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("VI.OLTINChI BO‘LIM \n" + "JINOYATLARNING OLDINI OLISH ChORALARI") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/6.OLTINChI BO‘LIM-JINOYATLARNING OLDINI OLISH ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/6.OLTINChI BO‘LIM-JINOYATLARNING OLDINI OLISH ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("VII.YETTINChI BO‘LIM \n" + "REABILITASIYA") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/7.YeTTINChI BO‘LIM-REABILITASIYa/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/7.YeTTINChI BO‘LIM-REABILITASIYa/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("VIII.SAKKIZINChI BO‘LIM \n" + "PROSESSUAL MUDDATLAR VA ChIQIMLAR") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/8.SAKKIZINChI BO‘LIM -PROSESSUAL MUDDATLAR VA ChIQIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/8.SAKKIZINChI BO‘LIM -PROSESSUAL MUDDATLAR VA ChIQIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("IX.TO‘QQIZINChI BO‘LIM \n" + "ISHNI SUDGA QADAR YuRITISH") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/9.TO‘QQIZINChI BO‘LIM -ISHNI SUDGA QADAR YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/9.TO‘QQIZINChI BO‘LIM -ISHNI SUDGA QADAR YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("X.O‘NINChI BO‘LIM \n" + "BIRINChI INSTANSIYA SUDIDA ISH YURITISH") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/10.O‘NINChI BO‘LIM-BIRINChI INSTANSIYa SUDIDA ISH YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/10.O‘NINChI BO‘LIM-BIRINChI INSTANSIYa SUDIDA ISH YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("XI.O‘N BIRINChI BO‘LIM \n" + "HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/11.O‘N BIRINChI BO‘LIM-HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/11.O‘N BIRINChI BO‘LIM-HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("XII.O‘N IKKINChI BO‘LIM \n" + "HUKM, AJRIM, QARORLARNI IJRO ETISH") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/12.O‘N IKKINChI BO‘LIM-HUKM, AJRIM, QARORLARNI IJRO ETISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/12.O‘N IKKINChI BO‘LIM-HUKM, AJRIM, QARORLARNI IJRO ETISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("XIII.O‘N UChINChI BO‘LIM \n" + "ALOHIDA TOIFADAGI JINOYAT ISHLARINI YURITISH") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/13.O‘N UChINChI BO‘LIM-ALOHIDA TOIFADAGI JINOYAT ISHLARINI YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/13.O‘N UChINChI BO‘LIM-ALOHIDA TOIFADAGI JINOYAT ISHLARINI YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT-PROSESSUAL KODEKSI") && position == 3 && titleSubject.equals("XIV.O‘N TO‘RTINChI BO‘LIM \n" + "JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/14.O‘N TO‘RTINChI BO‘LIM -JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/14.O‘N TO‘RTINChI BO‘LIM -JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный прцес-кодекс лат конец

        //Земельный кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING YER KODEKSI") && position == 4) {
            List<Acts_Subtitle> actsList = Zemelniy_kodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Земельный кодекс лат конец

        //Общественный кодекс лат начало
        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING QONUNI MAS’ULIYATI CHEKLANGAN HAMDA QO‘SHIMCHA MAS’ULIYATLI JAMIYATLAR TO‘G‘RISIDA") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_lodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Общественный кодекс лат конец


        //Семейный кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("I BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("II BO‘LIM. NIKOH") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/2.II BO‘LIM. NIKOH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/2.II BO‘LIM. NIKOH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("III BO‘LIM. QON-QARINDOShLIK VA BOLALARNING NASL-NASABINI BELGILASh") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/3.III BO‘LIM. QON-QARINDOShLIK VA BOLALARNING NASL-NASABINI BELGILASh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/3.III BO‘LIM. QON-QARINDOShLIK VA BOLALARNING NASL-NASABINI BELGILASh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("IV BO‘LIM. OTA-ONA HAMDA VOYAGA YETMAGAN BOLALARNING HUQUQ VA MAJBURIYATLARI") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/4.IV BO‘LIM. OTA-ONA HAMDA VOYAGA YETMAGAN BOLALARNING HUQUQ VA MAJBURIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/4.IV BO‘LIM. OTA-ONA HAMDA VOYAGA YETMAGAN BOLALARNING HUQUQ VA MAJBURIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("V BO‘LIM. OILA A’ZOLARINING VA BOShQA ShAXSLARNING ALIMENT MAJBURIYATLARI") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/5.V BO‘LIM. OILA A’ZOLARINING VA BOShQA ShAXSLARNING ALIMENT MAJBURIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/5.V BO‘LIM. OILA A’ZOLARINING VA BOShQA ShAXSLARNING ALIMENT MAJBURIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("VI BO‘LIM. OTA-ONA QARAMOG‘IDAN MAHRUM BO‘LGAN BOLALARNI JOYLAShTIRISh ShAKLLARI") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/6.VI BO‘LIM. OTA-ONA QARAMOG‘IDAN MAHRUM BO‘LGAN BOLALARNI JOYLAShTIRISh ShAKLLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/6.VI BO‘LIM. OTA-ONA QARAMOG‘IDAN MAHRUM BO‘LGAN BOLALARNI JOYLAShTIRISh ShAKLLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("VII BO‘LIM. FUQAROLIK HOLATI DALOLATNOMALARINI QAYD ETISh") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/7.VII BO‘LIM. FUQAROLIK HOLATI DALOLATNOMALARINI QAYD ETISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/7.VII BO‘LIM. FUQAROLIK HOLATI DALOLATNOMALARINI QAYD ETISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }



        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING OILA KODEKSI") && position == 7 && titleSubject.equals("VIII BO‘LIM. ChET EL FUQAROLARI VA FUQAROLIGI BO‘LMAGAN ShAXSLAR IShTIROKIDAGI OILAVIY MUNOSABATLARNI TARTIBGA SOLISh") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_lat.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Семейный кодекс/8.VIII BO‘LIM. ChET EL FUQAROLARI VA FUQAROLIGI BO‘LMAGAN ShAXSLAR IShTIROKIDAGI OILAVIY MUNOSABATLARNI TARTIBGA SOLISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Семейный кодекс/8.VIII BO‘LIM. ChET EL FUQAROLARI VA FUQAROLIGI BO‘LMAGAN ShAXSLAR IShTIROKIDAGI OILAVIY MUNOSABATLARNI TARTIBGA SOLISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Семейный кодекс лат конец


        //Таможенный кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/1.I bo‘lim. Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/1.I bo‘lim. Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("II bo‘lim. Bojxona rejimlari") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/2.II bo‘lim. Bojxona rejimlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/2.II bo‘lim. Bojxona rejimlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("III bo‘lim. Transport vositalariga va tovarlarning ayrim toifalariga nisbatan bojxona rejimlarining qo‘llanilishi") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/3.III bo‘lim. Transport vositalariga va tovarlarning ayrim toifalariga nisbatan bojxona rejimlarining qo‘llanilishi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/3.III bo‘lim. Transport vositalariga va tovarlarning ayrim toifalariga nisbatan bojxona rejimlarining qo‘llanilishi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("IV bo‘lim. Bojxona nazorati") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/4.IV bo‘lim. Bojxona nazorati/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/4.IV bo‘lim. Bojxona nazorati/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("V bo‘lim. Bojxona ishida valyuta nazorati va tashqi savdo operatsiyalarining monitoringi") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/5.V bo‘lim. Bojxona ishida valyuta nazorati va tashqi savdo operatsiyalarining monitoringi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/5.V bo‘lim. Bojxona ishida valyuta nazorati va tashqi savdo operatsiyalarining monitoringi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("VI bo‘lim. Bojxona rasmiylashtiruvi") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/6.VI bo‘lim. Bojxona rasmiylashtiruvi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/6.VI bo‘lim. Bojxona rasmiylashtiruvi/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("VII bo‘lim. Deklarant, bojxona brokeri va bojxona rasmiylashtiruvi bo‘yicha mutaxassis") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/7.VII bo‘lim. Deklarant, bojxona brokeri va bojxona rasmiylashtiruvi bo‘yicha mutaxassis/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/7.VII bo‘lim. Deklarant, bojxona brokeri va bojxona rasmiylashtiruvi bo‘yicha mutaxassis/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("VIII bo‘lim. Bojxona to‘lovlari") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/8.VIII bo‘lim. Bojxona to‘lovlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/8.VIII bo‘lim. Bojxona to‘lovlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("IX bo‘lim. Bojxona statistikasi. Bojxona ishida axborot-kommunikatsiya texnologiyalari") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/9.IX bo‘lim. Bojxona statistikasi. Bojxona ishida axborot-kommunikatsiya texnologiyalari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/9.IX bo‘lim. Bojxona statistikasi. Bojxona ishida axborot-kommunikatsiya texnologiyalari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("X bo‘lim. Chet ellik shaxslarning ayrim toifalari uchun bojxona imtiyozlari") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/10.X bo‘lim. Chet ellik shaxslarning ayrim toifalari uchun bojxona imtiyozlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/10.X bo‘lim. Chet ellik shaxslarning ayrim toifalari uchun bojxona imtiyozlari/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("XI bo‘lim. Nazorat ostida yetkazib berish") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/11.XI bo‘lim. Nazorat ostida yetkazib berish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/11.XI bo‘lim. Nazorat ostida yetkazib berish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING BOJXONA KODEKSI") && position == 8 && titleSubject.equals("XII bo‘lim. Yakunlovchi qoidalar") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_uz.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Таможенный кодекс/12.XII bo‘lim. Yakunlovchi qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Таможенный кодекс/12.XII bo‘lim. Yakunlovchi qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Таможенный кодекс лат начало

        //Трудовой кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING MEHNAT KODEKSI") && position == 9) {
            List<Acts_Subtitle> actsList = Trudovoy_kodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Трудовой кодекс лат конец

        //Уголовный кодекс лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("I.BIRINChI BO‘LIM. UMUMIY QOIDALAR") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/1.BIRINChI BO‘LIM-UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/1.BIRINChI BO‘LIM-UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("II.IKKINChI BO‘LIM. JAVOBGARLIK ASOSLARI") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/2.IKKINChI BO‘LIM-JAVOBGARLIK ASOSLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/2.IKKINChI BO‘LIM-JAVOBGARLIK ASOSLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("III.UChINChI BO‘LIM. QILMIShNING JINOIYLIGINI ISTISNO QILADIGAN HOLATLAR") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/3.UChINChI BO‘LIM-QILMIShNING JINOIYLIGINI ISTISNO QILADIGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/3.UChINChI BO‘LIM-QILMIShNING JINOIYLIGINI ISTISNO QILADIGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("IV.TO‘RTINChI BO‘LIM. JAZO VA UNI TAYINLASh") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/4.TO‘RTINChI BO‘LIM-JAZO VA UNI TAYINLASh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/4.TO‘RTINChI BO‘LIM-JAZO VA UNI TAYINLASh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("V.BEShINChI BO‘LIM. JAVOBGARLIKDAN VA JAZODAN OZOD QILISh") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/5.BEShINChI BO‘LIM-JAVOBGARLIKDAN VA JAZODAN OZOD QILISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/5.BEShINChI BO‘LIM-JAVOBGARLIKDAN VA JAZODAN OZOD QILISh/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("VI.OLTINChI BO‘LIM. VOYAGA YETMAGANLAR JAVOBGARLIGINING XUSUSIYATLARI") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/6.OLTINChI BO‘LIM-VOYAGA YETMAGANLAR JAVOBGARLIGINING XUSUSIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/6.OLTINChI BO‘LIM-VOYAGA YETMAGANLAR JAVOBGARLIGINING XUSUSIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("VII.YETTINChI BO'LIM. TIBBIY YO‘SINDAGI MAJBURLOV ChORALARI") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/7.ETTINChI BO-TIBBIY YO‘SINDAGI MAJBURLOV ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/7.ETTINChI BO-TIBBIY YO‘SINDAGI MAJBURLOV ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING JINOYAT KODEKSI") && position == 10 && titleSubject.equals("VIII.SAKKIZINChI BO‘LIM. ATAMALARNING HUQUQIY MA’NOSI") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный кодекс/8.SAKKIZINChI BO‘LIM-ATAMALARNING HUQUQIY MA’NOSI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный кодекс/8.SAKKIZINChI BO‘LIM-ATAMALARNING HUQUQIY MA’NOSI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        //Уголовный кодекс лат конец

        //Частное придриятие лат начало

        if (title.equals("O‘ZBEKISTON RESPUBLIKASINING QONUNI XUSUSIY KORXONA TO‘G‘RISIDA") && position == 11) {
            List<Acts_Subtitle> actsList = Chastnoe_Predpriyatie_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Частное придриятие лат конец

        //lat finish


        //Rus start

        //Администратиный кодекс рус начало

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("I.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/1.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ/" + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/1.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ/" + acts_subtitles.get(i).getTitle() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("II.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/2.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/2.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("III.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/3.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/3.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("IV.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("V.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/5.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/5.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Администратиный кодекс рус конец

        //Бюджетный кодекс рус начало

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/1.Раздел I. Общие положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/1.Раздел I. Общие положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел II. Бюджеты бюджетной системы") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/2.Раздел II. Бюджеты бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/2.Раздел II. Бюджеты бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел III. Консолидированный бюджет Республики Узбекистан. Фонд реконструкции и развития Республики Узбекистан") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/3.Раздел III. Консолидированный бюджет Республики Узбекистан. Фонд реконструкции и развития Республики Узбекистан/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/3.Раздел III. Консолидированный бюджет Республики Узбекистан. Фонд реконструкции и развития Республики Узбекистан/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел IV. Доходы бюджетов бюджетной системы") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/4.Раздел IV. Доходы бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/4.Раздел IV. Доходы бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел V. Расходы бюджетов бюджетной системы") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/5.Раздел V. Расходы бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/5.Раздел V. Расходы бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел VI. Составление, рассмотрение, принятие и утверждение Государственного бюджета и бюджетов государственных целевых фондов") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/6.Раздел VI. Составление, рассмотрение, принятие и утверждение Государственного бюджета и бюджетов государственных целевых фондов/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/6.Раздел VI. Составление, рассмотрение, принятие и утверждение Государственного бюджета и бюджетов государственных целевых фондов/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел VII. Исполнение бюджетов бюджетной системы") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/7.Раздел VII. Исполнение бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/7.Раздел VII. Исполнение бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел VIII. Бюджетный учет и отчетность") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/8.Раздел VIII. Бюджетный учет и отчетность/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/8.Раздел VIII. Бюджетный учет и отчетность/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("Раздел IX. Контроль за исполнением бюджетов бюджетной системы") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Byudjetniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Бюджетный кодекс/9.Раздел IX. Контроль за исполнением бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Бюджетный кодекс/9.Раздел IX. Контроль за исполнением бюджетов бюджетной системы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Бюджетный кодекс рус конец


        //Гражданский кодекс рус начало

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/2.РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/2.РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/3.РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/3.РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Гражданский кодекс рус конец

        //Земельный кодекс рус начало

        if (title.equals("Земельный кодекс") && position == 4) {
            List<Acts_Subtitle> actsList = Zemelniy_kodeks_ru.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Земельный кодекс рус конец


        //Налоговый кодекс рус начало

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ II. ИСПОЛНЕНИЕ НАЛОГОВОГО ОБЯЗАТЕЛЬСТВА") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/2.РАЗДЕЛ II. ИСПОЛНЕНИЕ НАЛОГОВОГО ОБЯЗАТЕЛЬСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/2.РАЗДЕЛ II. ИСПОЛНЕНИЕ НАЛОГОВОГО ОБЯЗАТЕЛЬСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ III. НАЛОГОВЫЙ КОНТРОЛЬ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/3.РАЗДЕЛ III. НАЛОГОВЫЙ КОНТРОЛЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/3.РАЗДЕЛ III. НАЛОГОВЫЙ КОНТРОЛЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ IV. ОТВЕТСТВЕННОСТЬ ЗА НАЛОГОВОЕ ПРАВОНАРУШЕНИЕ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/4.РАЗДЕЛ IV. ОТВЕТСТВЕННОСТЬ ЗА НАЛОГОВОЕ ПРАВОНАРУШЕНИЕ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/4.РАЗДЕЛ IV. ОТВЕТСТВЕННОСТЬ ЗА НАЛОГОВОЕ ПРАВОНАРУШЕНИЕ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ V. НАЛОГ НА ПРИБЫЛЬ ЮРИДИЧЕСКИХ ЛИЦ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/5.РАЗДЕЛ V. НАЛОГ НА ПРИБЫЛЬ ЮРИДИЧЕСКИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/5.РАЗДЕЛ V. НАЛОГ НА ПРИБЫЛЬ ЮРИДИЧЕСКИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ VI. НАЛОГ НА ДОХОДЫ ФИЗИЧЕСКИХ ЛИЦ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/6.РАЗДЕЛ VI. НАЛОГ НА ДОХОДЫ ФИЗИЧЕСКИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/6.РАЗДЕЛ VI. НАЛОГ НА ДОХОДЫ ФИЗИЧЕСКИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ VII. НАЛОГ НА ДОБАВЛЕННУЮ СТОИМОСТЬ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/7.РАЗДЕЛ VII. НАЛОГ НА ДОБАВЛЕННУЮ СТОИМОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/7.РАЗДЕЛ VII. НАЛОГ НА ДОБАВЛЕННУЮ СТОИМОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ VIII. АКЦИЗНЫЙ НАЛОГ") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/8.РАЗДЕЛ VIII. АКЦИЗНЫЙ НАЛОГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/8.РАЗДЕЛ VIII. АКЦИЗНЫЙ НАЛОГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ IX. НАЛОГИ И СПЕЦИАЛЬНЫЕ ПЛАТЕЖИ ДЛЯ НЕДРОПОЛЬЗОВАТЕЛЕЙ") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/9.РАЗДЕЛ IX. НАЛОГИ И СПЕЦИАЛЬНЫЕ ПЛАТЕЖИ ДЛЯ НЕДРОПОЛЬЗОВАТЕЛЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/9.РАЗДЕЛ IX. НАЛОГИ И СПЕЦИАЛЬНЫЕ ПЛАТЕЖИ ДЛЯ НЕДРОПОЛЬЗОВАТЕЛЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ X. НАЛОГ ЗА ПОЛЬЗОВАНИЕ ВОДНЫМИ РЕСУРСАМИ") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/10.РАЗДЕЛ X. НАЛОГ ЗА ПОЛЬЗОВАНИЕ ВОДНЫМИ РЕСУРСАМИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/10.РАЗДЕЛ X. НАЛОГ ЗА ПОЛЬЗОВАНИЕ ВОДНЫМИ РЕСУРСАМИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XI. НАЛОГ НА ИМУЩЕСТВО") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/11.РАЗДЕЛ XI. НАЛОГ НА ИМУЩЕСТВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/11.РАЗДЕЛ XI. НАЛОГ НА ИМУЩЕСТВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XII. ЗЕМЕЛЬНЫЙ НАЛОГ") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/12.РАЗДЕЛ XII. ЗЕМЕЛЬНЫЙ НАЛОГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/12.РАЗДЕЛ XII. ЗЕМЕЛЬНЫЙ НАЛОГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XV. ОБЯЗАТЕЛЬНЫЕ ПЛАТЕЖИ В ГОСУДАРСТВЕННЫЕ ЦЕЛЕВЫЕ ФОНДЫ") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_15();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/13.РАЗДЕЛ XV. ОБЯЗАТЕЛЬНЫЕ ПЛАТЕЖИ В ГОСУДАРСТВЕННЫЕ ЦЕЛЕВЫЕ ФОНДЫ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/13.РАЗДЕЛ XV. ОБЯЗАТЕЛЬНЫЕ ПЛАТЕЖИ В ГОСУДАРСТВЕННЫЕ ЦЕЛЕВЫЕ ФОНДЫ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XVII. ГОСУДАРСТВЕННАЯ ПОШЛИНА") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_17();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/14.РАЗДЕЛ XVII. ГОСУДАРСТВЕННАЯ ПОШЛИНА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/14.РАЗДЕЛ XVII. ГОСУДАРСТВЕННАЯ ПОШЛИНА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XVIII. ТАМОЖЕННЫЕ ПЛАТЕЖИ") && positionSubject == 14) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_18();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/15.РАЗДЕЛ XVIII. ТАМОЖЕННЫЕ ПЛАТЕЖИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/15.РАЗДЕЛ XVIII. ТАМОЖЕННЫЕ ПЛАТЕЖИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XIX. СБОР ЗА ПРАВО РОЗНИЧНОЙ ТОРГОВЛИ ОТДЕЛЬНЫМИ ВИДАМИ ТОВАРОВ И ОКАЗАНИЕ ОТДЕЛЬНЫХ ВИДОВ УСЛУГ") && positionSubject == 15) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_19();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/16.РАЗДЕЛ XIX. СБОР ЗА ПРАВО РОЗНИЧНОЙ ТОРГОВЛИ ОТДЕЛЬНЫМИ ВИДАМИ ТОВАРОВ И ОКАЗАНИЕ ОТДЕЛЬНЫХ ВИДОВ УСЛУГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/16.РАЗДЕЛ XIX. СБОР ЗА ПРАВО РОЗНИЧНОЙ ТОРГОВЛИ ОТДЕЛЬНЫМИ ВИДАМИ ТОВАРОВ И ОКАЗАНИЕ ОТДЕЛЬНЫХ ВИДОВ УСЛУГ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XX. УПРОЩЕННЫЙ ПОРЯДОК НАЛОГООБЛОЖЕНИЯ") && positionSubject == 16) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_20();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/17.РАЗДЕЛ XX. УПРОЩЕННЫЙ ПОРЯДОК НАЛОГООБЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/17.РАЗДЕЛ XX. УПРОЩЕННЫЙ ПОРЯДОК НАЛОГООБЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("РАЗДЕЛ XXI. ОСОБЕННОСТИ НАЛОГООБЛОЖЕНИЯ ОТДЕЛЬНЫХ КАТЕГОРИЙ НАЛОГОПЛАТЕЛЬЩИКОВ") && positionSubject == 17) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_ru.getActs_Chapter_21();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Налоговый кодекс/18.РАЗДЕЛ XXI. ОСОБЕННОСТИ НАЛОГООБЛОЖЕНИЯ ОТДЕЛЬНЫХ КАТЕГОРИЙ НАЛОГОПЛАТЕЛЬЩИКОВ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Налоговый кодекс/18.РАЗДЕЛ XXI. ОСОБЕННОСТИ НАЛОГООБЛОЖЕНИЯ ОТДЕЛЬНЫХ КАТЕГОРИЙ НАЛОГОПЛАТЕЛЬЩИКОВ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }



        //Налоговый кодекс рус конец

        //Общественный кодекс рус начало

        if (title.equals("Общественный кодекс") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_kodeks_ru.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Общественный кодекс рус конец

        //Семейный кодекс рус начало

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ II. БРАК") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/2.РАЗДЕЛ II. БРАК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/2.РАЗДЕЛ II. БРАК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ III. КРОВНОЕ РОДСТВО И УСТАНОВЛЕНИЕ ПРОИСХОЖДЕНИЯ ДЕТЕЙ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/3.РАЗДЕЛ III. КРОВНОЕ РОДСТВО И УСТАНОВЛЕНИЕ ПРОИСХОЖДЕНИЯ ДЕТЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/3.РАЗДЕЛ III. КРОВНОЕ РОДСТВО И УСТАНОВЛЕНИЕ ПРОИСХОЖДЕНИЯ ДЕТЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ IV. ПРАВА И ОБЯЗАННОСТИ РОДИТЕЛЕЙ И НЕСОВЕРШЕННОЛЕТНИХ ДЕТЕЙ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/4.РАЗДЕЛ IV. ПРАВА И ОБЯЗАННОСТИ РОДИТЕЛЕЙ И НЕСОВЕРШЕННОЛЕТНИХ ДЕТЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/4.РАЗДЕЛ IV. ПРАВА И ОБЯЗАННОСТИ РОДИТЕЛЕЙ И НЕСОВЕРШЕННОЛЕТНИХ ДЕТЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ V. АЛИМЕНТНЫЕ ОБЯЗАТЕЛЬСТВА ЧЛЕНОВ СЕМЬИ И ДРУГИХ ЛИЦ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/5.РАЗДЕЛ V. АЛИМЕНТНЫЕ ОБЯЗАТЕЛЬСТВА ЧЛЕНОВ СЕМЬИ И ДРУГИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/5.РАЗДЕЛ V. АЛИМЕНТНЫЕ ОБЯЗАТЕЛЬСТВА ЧЛЕНОВ СЕМЬИ И ДРУГИХ ЛИЦ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ VI. ФОРМЫ УСТРОЙСТВА ДЕТЕЙ, ОСТАВШИХСЯ БЕЗ ПОПЕЧЕНИЯ РОДИТЕЛЕЙ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/6.РАЗДЕЛ VI. ФОРМЫ УСТРОЙСТВА ДЕТЕЙ, ОСТАВШИХСЯ БЕЗ ПОПЕЧЕНИЯ РОДИТЕЛЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/6.РАЗДЕЛ VI. ФОРМЫ УСТРОЙСТВА ДЕТЕЙ, ОСТАВШИХСЯ БЕЗ ПОПЕЧЕНИЯ РОДИТЕЛЕЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ VII. РЕГИСТРАЦИЯ АКТОВ ГРАЖДАНСКОГО СОСТОЯНИЯ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/7.РАЗДЕЛ VII. РЕГИСТРАЦИЯ АКТОВ ГРАЖДАНСКОГО СОСТОЯНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/7.РАЗДЕЛ VII. РЕГИСТРАЦИЯ АКТОВ ГРАЖДАНСКОГО СОСТОЯНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }



        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/8.РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/8.РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Семейный кодекс рус конец

        //Таможенный кодекс рус начало

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/1.Раздел I. Общие положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/1.Раздел I. Общие положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел II. Таможенные режимы") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/2.Раздел II. Таможенные режимы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/2.Раздел II. Таможенные режимы/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел III. Применение таможенных режимов к транспортным средствам и отдельным категориям товаров") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/3.Раздел III. Применение таможенных режимов к транспортным средствам и отдельным категориям товаров/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/3.Раздел III. Применение таможенных режимов к транспортным средствам и отдельным категориям товаров/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел IV. Таможенный контроль") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/4.Раздел IV. Таможенный контроль/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/4.Раздел IV. Таможенный контроль/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел V. Валютный контроль и мониторинг внешнеторговых операций в таможенном деле") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/5.Раздел V. Валютный контроль и мониторинг внешнеторговых операций в таможенном деле/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/5.Раздел V. Валютный контроль и мониторинг внешнеторговых операций в таможенном деле/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел VI. Таможенное оформление") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/6.Раздел VI. Таможенное оформление/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/6.Раздел VI. Таможенное оформление/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел VII. Декларант, таможенный брокер и специалист по таможенному оформлению") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/7.Раздел VII. Декларант, таможенный брокер и специалист по таможенному оформлению/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/7.Раздел VII. Декларант, таможенный брокер и специалист по таможенному оформлению/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел VIII. Таможенные платежи") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/8.Раздел VIII. Таможенные платежи/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/8.Раздел VIII. Таможенные платежи/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел IX. Таможенная статистика. Информационно-коммуникационные технологии в таможенном деле. Защита прав на объекты интеллектуальной собственности") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/9.Раздел IX. Таможенная статистика/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/9.Раздел IX. Таможенная статистика/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел X. Таможенные льготы отдельным категориям иностранных лиц") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/10.Раздел X. Таможенные льготы отдельным категориям иностранных лиц/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/10.Раздел X. Таможенные льготы отдельным категориям иностранных лиц/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел XI. Контролируемые поставки") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/11.Раздел XI. Контролируемые поставки/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/11.Раздел XI. Контролируемые поставки/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("Раздел XII. Заключительные положения") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Tamojenniy_kodeks_ru.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Таможенный кодекс/12.Раздел XII. Заключительные положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Таможенный кодекс/12.Раздел XII. Заключительные положения/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Таможенный кодекс рус конец

        //Трудовой кодекс рус начало
        if (title.equals("Трудовой кодекс") && position == 9) {
            List<Acts_Subtitle> actsList = Trudovoy_kodeks_ru.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }
        //Трудовой кодекс рус конец

        //Частное предприятие рус начало

        if (title.equals("Частное предприятие") && position == 11) {
            List<Acts_Subtitle> actsList = Chastnoe_Predpriyatie_ru.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Частное предприятие рус конец


        //Уголовный кодекс рус начало

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 1. ОБЩИЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/1.РАЗДЕЛ 1. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/1.РАЗДЕЛ 1. ОБЩИЕ ПОЛОЖЕНИЯ" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 2. ОСНОВАНИЯ ОТВЕТСТВЕННОСТИ") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/2.РАЗДЕЛ 2. ОСНОВАНИЯ ОТВЕТСТВЕННОСТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/2.РАЗДЕЛ 2. ОСНОВАНИЯ ОТВЕТСТВЕННОСТИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 3. ОБСТОЯТЕЛЬСТВА, ИСКЛЮЧАЮЩИЕ ПРЕСТУПНОСТЬ ДЕЯНИЯ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/3.РАЗДЕЛ 3. ОБСТОЯТЕЛЬСТВА, ИСКЛЮЧАЮЩИЕ ПРЕСТУПНОСТЬ ДЕЯНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/3.UРАЗДЕЛ 3. ОБСТОЯТЕЛЬСТВА, ИСКЛЮЧАЮЩИЕ ПРЕСТУПНОСТЬ ДЕЯНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 4. НАКАЗАНИЕ И ЕГО НАЗНАЧЕНИЕ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/4.РАЗДЕЛ 4. НАКАЗАНИЕ И ЕГО НАЗНАЧЕНИЕ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/4.РАЗДЕЛ 4. НАКАЗАНИЕ И ЕГО НАЗНАЧЕНИЕ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 5. ОСВОБОЖДЕНИЕ ОТ ОТВЕТСТВЕННОСТИ И НАКАЗАНИЯ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/5.РАЗДЕЛ 5. ОСВОБОЖДЕНИЕ ОТ ОТВЕТСТВЕННОСТИ И НАКАЗАНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/5.РАЗДЕЛ 5. ОСВОБОЖДЕНИЕ ОТ ОТВЕТСТВЕННОСТИ И НАКАЗАНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 6. ОСОБЕННОСТИ ОТВЕТСТВЕННОСТИ НЕСОВЕРШЕННОЛЕТНИХ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/6.РАЗДЕЛ 6. ОСОБЕННОСТИ ОТВЕТСТВЕННОСТИ НЕСОВЕРШЕННОЛЕТНИХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/6.РАЗДЕЛ 6. ОСОБЕННОСТИ ОТВЕТСТВЕННОСТИ НЕСОВЕРШЕННОЛЕТНИХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("РАЗДЕЛ 7. ПРИНУДИТЕЛЬНЫЕ МЕРЫ МЕДИЦИНСКОГО ХАРАКТЕРА") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/7.РАЗДЕЛ 7. ПРИНУДИТЕЛЬНЫЕ МЕРЫ МЕДИЦИНСКОГО ХАРАКТЕРА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/7.РАЗДЕЛ 7. ПРИНУДИТЕЛЬНЫЕ МЕРЫ МЕДИЦИНСКОГО ХАРАКТЕРА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("VIII.SAKKIZINChI BO‘LIM. ATAMALARNING HUQUQIY MA’NOSI") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный кодекс/8.SAKKIZINChI BO‘LIM-ATAMALARNING HUQUQIY MA’NOSI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный кодекс/8.SAKKIZINChI BO‘LIM-ATAMALARNING HUQUQIY MA’NOSI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }


        //Уголовный кодекс рус конец

        //Уголовный процес-кодекс начало

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ПЕРВЫЙ \n" + "ОСНОВНЫЕ ПОЛОЖЕНИЯ") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/1.РАЗДЕЛ ПЕРВЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/1.РАЗДЕЛ ПЕРВЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ВТОРОЙ \n" + "УЧАСТНИКИ УГОЛОВНОГО ПРОЦЕССА") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/2.РАЗДЕЛ ВТОРОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/2.РАЗДЕЛ ВТОРОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ТРЕТИЙ \n" + "ДОКАЗАТЕЛЬСТВА И ОБСТОЯТЕЛЬСТВА, ПОДЛЕЖАЩИЕ ДОКАЗЫВАНИЮ") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/3.РАЗДЕЛ ТРЕТИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/3.РАЗДЕЛ ТРЕТИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }



        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ЧЕТВЕРТЫЙ \n" + "ПРОЦЕССУАЛЬНОЕ ПРИНУЖДЕНИЕ") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ПЯТЫЙ \n" + "ВОЗМЕЩЕНИЕ ИМУЩЕСТВЕННОГО ВРЕДА, ПРИЧИНЕННОГО ПРЕСТУПЛЕНИЕМ") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/5.РАЗДЕЛ ПЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/5.РАЗДЕЛ ПЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ШЕСТОЙ \n" + "МЕРЫ ПРЕДУПРЕЖДЕНИЯ ПРЕСТУПЛЕНИЙ") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/6.РАЗДЕЛ ШЕСТОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/6.РАЗДЕЛ ШЕСТОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ СЕДЬМОЙ \n" + "РЕАБИЛИТАЦИЯ") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/7.РАЗДЕЛ СЕДЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/7.РАЗДЕЛ СЕДЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ВОСЬМОЙ\n" + "ПРОЦЕССУАЛЬНЫЕ СРОКИ И ИЗДЕРЖКИ") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/8.РАЗДЕЛ ВОСЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/8.РАЗДЕЛ ВОСЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ДЕВЯТЫЙ\n" + "ДОСУДЕБНОЕ ПРОИЗВОДСТВО") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/9.РАЗДЕЛ ДЕВЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/9.РАЗДЕЛ ДЕВЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ДЕСЯТЫЙ \n" + "ПРОИЗВОДСТВО В СУДЕ ПЕРВОЙ ИНСТАНЦИИ") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/10.РАЗДЕЛ ДЕСЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/10.РАЗДЕЛ ДЕСЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ОДИННАДЦАТЫЙ \n" + "ПРОВЕРКА ЗАКОННОСТИ, ОБОСНОВАННОСТИ И СПРАВЕДЛИВОСТИ ПРИГОВОРОВ, ОПРЕДЕЛЕНИЙ И ПОСТАНОВЛЕНИЙ") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/11.РАЗДЕЛ ОДИННАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/11.РАЗДЕЛ ОДИННАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ДВЕНАДЦАТЫЙ \n" + "ИСПОЛНЕНИЕ ПРИГОВОРОВ, ОПРЕДЕЛЕНИЙ, ПОСТАНОВЛЕНИЙ") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/12.РАЗДЕЛ ДВЕНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/12.РАЗДЕЛ ДВЕНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ТРИНАДЦАТЫЙ\n" + "ПРОИЗВОДСТВО ПО ОТДЕЛЬНЫМ КАТЕГОРИЯМ УГОЛОВНЫХ ДЕЛ") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/13.РАЗДЕЛ ТРИНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/13.РАЗДЕЛ ТРИНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ \n" + "МЕЖДУНАРОДНОЕ СОТРУДНИЧЕСТВО В СФЕРЕ УГОЛОВНОГО СУДОПРОИЗВОДСТВА") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/14.РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/14.РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный процес-кодекс конец

        //Rus finish
    }
}
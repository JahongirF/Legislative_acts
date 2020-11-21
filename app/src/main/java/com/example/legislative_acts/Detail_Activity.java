package com.example.legislative_acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

        Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject, Toast.LENGTH_LONG).show();


        //Административный кодекс начало

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

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

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК") && positionSubject == 1) {

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

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)") && positionSubject == 2) {

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

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ") && positionSubject == 3) {

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

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 4) {

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
        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("I бўлим Умумий қоидалар") && positionSubject == 0) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("II бўлим Бюджет тизими бюджетлари") && positionSubject == 1) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("III бўлим Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("IV бўлим Бюджет тизими бюджетларининг даромадлари") && positionSubject == 3) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("V бўлим Бюджет тизими бюджетларининг харажатлари") && positionSubject == 4) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("VI бўлим Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш") && positionSubject == 5) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("VII бўлим Бюджет тизими бюджетларининг ижроси") && positionSubject == 6) {

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

        if (title.equals("Бюджетный кодекс") && position == 1 && titleSubject.equals("VIII бўлим Бюджет ҳисоби ва ҳисоботи") && positionSubject == 7) {

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
        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("I.БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

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

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("II.БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР") && positionSubject == 1) {

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

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("III.БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ") && positionSubject == 2) {

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
        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ \n" + "АСОСИЙ ҚОИДАЛАР") && positionSubject == 0) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ \n" + "ЖИНОЯТ ПРОЦЕССИ ИШТИРОКЧИЛАРИ") && positionSubject == 1) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "ДАЛИЛЛАР ВА ИСБОТ ҚИЛИНИШИ ЛОЗИМ БЎЛГАН ҲОЛАТЛАР") && positionSubject == 2) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "ДАЛИЛЛАР ВА ИСБОТ ҚИЛИНИШИ ЛОЗИМ БЎЛГАН ҲОЛАТЛАР") && positionSubject == 2) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МАЖБУРЛОВ") && positionSubject == 3) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ \n" + "ЖИНОЯТ НАТИЖАСИДА ЕТКАЗИЛГАН МУЛКИЙ ЗИЁННИ ҚОПЛАШ") && positionSubject == 4) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ \n" + "ЖИНОЯТЛАРНИНГ ОЛДИНИ ОЛИШ ЧОРАЛАРИ") && positionSubject == 5) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ \n" + "РЕАБИЛИТАЦИЯ") && positionSubject == 6) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ \n" + "ПРОЦЕССУАЛ МУДДАТЛАР ВА ЧИҚИМЛАР") && positionSubject == 7) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("IX.ТЎҚҚИЗИНЧИ БЎЛИМ \n" + "ИШНИ СУДГА ҚАДАР ЮРИТИШ") && positionSubject == 8) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("X.ЎНИНЧИ БЎЛИМ \n" + "БИРИНЧИ ИНСТАНЦИЯ СУДИДА ИШ ЮРИТИШ") && positionSubject == 9) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("XI.ЎН БИРИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ ВА ҚАРОРЛАРНИНГ ҚОНУНИЙЛИГИ, АСОСЛИЛИГИ ВА АДОЛАТЛИЛИГИНИ ТЕКШИРИШ") && positionSubject == 10) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("XII.ЎН ИККИНЧИ БЎЛИМ \n" + "ҲУКМ, АЖРИМ, ҚАРОРЛАРНИ ИЖРО ЭТИШ") && positionSubject == 11) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("XIII.ЎН УЧИНЧИ БЎЛИМ \n" + "АЛОҲИДА ТОИФАДАГИ ЖИНОЯТ ИШЛАРИНИ ЮРИТИШ") && positionSubject == 12) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("XIV.ЎН ТЎРТИНЧИ БЎЛИМ \n" + "ЖИНОИЙ СУД ИШЛАРИНИ ЮРИТИШ СОҲАСИДАГИ ХАЛҚАРО ҲАМКОРЛИК") && positionSubject == 13) {

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
        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("II БЎЛИМ СОЛИҚ ҲИСОБИ ВА СОЛИҚ ҲИСОБОТЛАРИ") && positionSubject == 1) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("III БЎЛИМ СОЛИҚ МАЖБУРИЯТИНИ БАЖАРИШ") && positionSubject == 2) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("IV БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИ ВА СОЛИҚ СОЛИШ ОБЪЕКТЛАРИНИ ҲИСОБГА ОЛИШ") && positionSubject == 3) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("V БЎЛИМ СОЛИҚ НАЗОРАТИ") && positionSubject == 4) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("VI БЎЛИМ ТРАНСФЕРТ НАРХНИ БЕЛГИЛАШДА СОЛИҚ НАЗОРАТИ") && positionSubject == 5) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("VII БЎЛИМ НАЗОРАТ ҚИЛИНАДИГАН ЧЕТ ЭЛ КОМПАНИЯЛАРИНИНГ ФОЙДАСИГА СОЛИҚ СОЛИШ ШАРТЛАРИ ВА УМУМИЙ ҚОИДАЛАРИ") && positionSubject == 6) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("VIII БЎЛИМ СОЛИҚҚА ОИД ҲУҚУҚБУЗАРЛИКЛАР ВА УЛАРНИ СОДИР ЭТГАНЛИК УЧУН ЖАВОБГАРЛИК") && positionSubject == 7) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("IX БЎЛИМ СОЛИҚ ОРГАНЛАРИНИНГ ҲУЖЖАТЛАРИ ВА УЛАР МАНСАБДОР ШАХСЛАРИНИНГ ҲАРАКАТЛАРИ (ҲАРАКАТСИЗЛИГИ) УСТИДАН ШИКОЯТ БЕРИШ") && positionSubject == 8) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("X БЎЛИМ ҚЎШИЛГАН ҚИЙМАТ СОЛИҒИ") && positionSubject == 9) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("ХI БЎЛИМ АКЦИЗ СОЛИҒИ") && positionSubject == 10) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XII БЎЛИМ ФОЙДА СОЛИҒИ") && positionSubject == 11) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XIII БЎЛИМ ЖИСМОНИЙ ШАХСЛАРДАН ОЛИНАДИГАН ДАРОМАД СОЛИҒИ") && positionSubject == 12) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XIV БЎЛИМ ИЖТИМОИЙ СОЛИҚ") && positionSubject == 13) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XV БЎЛИМ МОЛ-МУЛК СОЛИҒИ") && positionSubject == 14) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XVI БЎЛИМ ЕР СОЛИҒИ") && positionSubject == 15) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XVII БЎЛИМ СУВ РЕСУРСЛАРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 16) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XVIII БЎЛИМ ЕР ҚАЪРИДАН ФОЙДАЛАНГАНЛИК УЧУН СОЛИҚ") && positionSubject == 17) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XIX БЎЛИМ ЙИҒИМЛАР") && positionSubject == 18) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("XX БЎЛИМ АЙЛАНМАДАН ОЛИНАДИГАН СОЛИҚ") && positionSubject == 19) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("ХХI БЎЛИМ СОЛИҚ ТЎЛОВЧИЛАРНИНГ АЙРИМ ТОИФАЛАРИГА СОЛИҚ СОЛИШНИНГ ЎЗИГА ХОС ХУСУСИЯТЛАРИ") && positionSubject == 20) {

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
        if (title.equals("Общественный кодекс") && position == 6) {
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
        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("I БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

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
        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("II БЎЛИМ НИКОҲ") && positionSubject == 1) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("III БЎЛИМ ҚОН-ҚАРИНДОШЛИК ВА БОЛАЛАРНИНГ НАСЛ-НАСАБИНИ БЕЛГИЛАШ") && positionSubject == 2) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("IV БЎЛИМ ОТА-ОНА ҲАМДА ВОЯГА ЕТМАГАН БОЛАЛАРНИНГ ҲУҚУҚ ВА МАЖБУРИЯТЛАРИ") && positionSubject == 3) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("V БЎЛИМ ОИЛА АЪЗОЛАРИНИНГ ВА БОШҚА ШАХСЛАРНИНГ АЛИМЕНТ МАЖБУРИЯТЛАРИ") && positionSubject == 4) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("VI БЎЛИМ ОТА-ОНА ҚАРАМОҒИДАН МАҲРУМ БЎЛГАН БОЛАЛАРНИ ЖОЙЛАШТИРИШ ШАКЛЛАРИ") && positionSubject == 5) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ") && positionSubject == 6) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("VII БЎЛИМ ФУҚАРОЛИК ҲОЛАТИ ДАЛОЛАТНОМАЛАРИНИ ҚАЙД ЭТИШ") && positionSubject == 6) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("VIII БЎЛИМ ЧЕТ ЭЛ ФУҚАРОЛАРИ ВА ФУҚАРОЛИГИ БЎЛМАГАН ШАХСЛАР ИШТИРОКИДАГИ ОИЛАВИЙ МУНОСАБАТЛАРНИ ТАРТИБГА СОЛИШ") && positionSubject == 7) {

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
        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("II бўлим. Божхона режимлари") && positionSubject == 1) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши") && positionSubject == 2) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("IV бўлим. Божхона назорати") && positionSubject == 3) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги") && positionSubject == 4) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("VI бўлим. Божхона расмийлаштируви") && positionSubject == 5) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис") && positionSubject == 6) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("VIII бўлим. Божхона тўловлари") && positionSubject == 7) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш") && positionSubject == 8) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари") && positionSubject == 9) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("XI бўлим. Назорат остида етказиб бериш") && positionSubject == 10) {

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

        if (title.equals("Таможенный кодекс") && position == 8 && titleSubject.equals("XII бўлим. Якунловчи қоидалар") && positionSubject == 11) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("I.БИРИНЧИ БЎЛИМ УМУМИЙ ҚОИДАЛАР") && positionSubject == 0) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("II.ИККИНЧИ БЎЛИМ ЖАВОБГАРЛИК АСОСЛАРИ") && positionSubject == 1) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ ҚИЛМИШНИНГ ЖИНОИЙЛИГИНИ ИСТИСНО ҚИЛАДИГАН ҲОЛАТЛАР") && positionSubject == 2) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("IV.ТЎРТИНЧИ БЎЛИМ ЖАЗО ВА УНИ ТАЙИНЛАШ") && positionSubject == 3) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("V.БЕШИНЧИ БЎЛИМ ЖАВОБГАРЛИКДАН ВА ЖАЗОДАН ОЗОД ҚИЛИШ") && positionSubject == 4) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ, БОШҚАРУВ ВА ЖАМОАТ БИРЛАШМАЛАРИ ОРГАНЛАРИНИНГ ФАОЛИЯТ ТАРТИБИГА ҚАРШИ ЖИНОЯТЛАР") && positionSubject == 5) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("VII.ЕТТИНЧИ БЎЛИМ ТИББИЙ ЙЎСИНДАГИ МАЖБУРЛОВ ЧОРАЛАРИ") && positionSubject == 6) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("VIII.САККИЗИНЧИ БЎЛИМ АТАМАЛАРНИНГ ҲУҚУҚИЙ МАЪНОСИ") && positionSubject == 7) {

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
        if (title.equals("Земельный кодекс") && position == 4) {
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
        if (title.equals("Трудовой кодекс") && position == 9) {
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
        if (title.equals("Частное предприятие") && position == 11) {
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
    }
}
package com.example.legislative_acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.legislative_acts.Data.ActsData;
import com.example.legislative_acts.Data.ActsViewModal;
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
    private ActsViewModal viewModal;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item_save_date,menu);

        MenuItem item = menu.getItem(0);

        int id = item.getItemId();

        switch (id)
        {
            case R.id.save_date:

                Intent intent = getIntent();
                ActsData actsData;

                if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("titleSubject") && intent.hasExtra("positionSubject") && intent.hasExtra("titleChapter") && intent.hasExtra("positionChapter")) {

                    actsData = viewModal.getActByAllParameters(title,position,titleSubject,positionSubject,titleChapter,positionChapter);
                    if (actsData == null)
                    {

                        item.setIcon(R.drawable.ic_book_mark_add);
                    }
                    else {

                        item.setIcon(R.drawable.ic_book_mark_delete);
                    }
                   }
                else if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("positionSubject") && intent.hasExtra("titleSubject")) {

                    actsData = viewModal.getActByAllParameters(title,position,titleSubject,positionSubject,titleChapter,positionChapter);
                    if (actsData == null)
                    {

                        item.setIcon(R.drawable.ic_book_mark_add);
                    }
                    else {

                        item.setIcon(R.drawable.ic_book_mark_delete);
                    }
                     }


                break;


        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.save_date:

                Intent intent = getIntent();
                ActsData actsData;
                if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("titleSubject") && intent.hasExtra("positionSubject") && intent.hasExtra("titleChapter") && intent.hasExtra("positionChapter")) {

                    actsData = viewModal.getActByAllParameters(title,position,titleSubject,positionSubject,titleChapter,positionChapter);
                    if (actsData == null)
                    {
                        viewModal.insert(new ActsData(title,position,titleSubject,positionSubject,titleChapter,positionChapter));
                        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
                        item.setIcon(R.drawable.ic_book_mark_delete);
                    }
                    else {
                        viewModal.delete(actsData);
                        Toast.makeText(this, "Данные удалены", Toast.LENGTH_SHORT).show();
                        item.setIcon(R.drawable.ic_book_mark_add);
                    }
                     // Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject + "\ntitleChapter:" + titleChapter + "\npositionChapter:" + positionChapter, Toast.LENGTH_LONG).show();
                }
                else if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("positionSubject") && intent.hasExtra("titleSubject")) {

                    actsData = viewModal.getActByLessParameters(title,position,titleSubject,positionSubject);
                    if (actsData == null)
                    {
                        viewModal.insert(new ActsData(title,position,titleSubject,positionSubject));
                        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
                        item.setIcon(R.drawable.ic_book_mark_delete);
                    }
                    else {
                        viewModal.delete(actsData);
                        Toast.makeText(this, "Данные удалены", Toast.LENGTH_SHORT).show();
                        item.setIcon(R.drawable.ic_book_mark_add);
                    }
                    //  Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject, Toast.LENGTH_LONG).show();
                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pdfView = findViewById(R.id.pdfView);
        viewModal = ViewModelProviders.of(this).get(ActsViewModal.class);
       // viewModal.DeleteAllActs();
        LiveData<List<ActsData>> listLiveData = viewModal.getListLiveData();
        listLiveData.observe(this, new Observer<List<ActsData>>() {
            @Override
            public void onChanged(List<ActsData> actsData) {
                for (ActsData actsData1 : actsData)
                {
                    Log.d("Tax", "title:" + actsData1.getTitle() + "\nposition:" + actsData1.getPosition() + "\ntitleSubject:" + actsData1.getTitleSection() + "\npositionSubject:" + actsData1.getPositionSection() + "\ntitleChapter:" + actsData1.getTitleChapter() + "\npositionChapter:" + actsData1.getPositionChapter());
                }
            }
        });

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            dark = "no";
        } else {
            dark = "yes";
        }

        Intent intent = getIntent();

        if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("titleSubject") && intent.hasExtra("positionSubject") && intent.hasExtra("titleChapter") && intent.hasExtra("positionChapter")) {
            title = intent.getStringExtra("title");
            position = intent.getIntExtra("position", 1);
            titleSubject = intent.getStringExtra("titleSubject");
            positionSubject = intent.getIntExtra("positionSubject", 2);
            titleChapter = intent.getStringExtra("titleChapter");
            positionChapter = intent.getIntExtra("positionChapter", 3);
          //  Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject + "\ntitleChapter:" + titleChapter + "\npositionChapter:" + positionChapter, Toast.LENGTH_LONG).show();
        }
         if (intent.hasExtra("title") && intent.hasExtra("position") && intent.hasExtra("positionSubject") && intent.hasExtra("titleSubject")) {
            title = intent.getStringExtra("title");
            position = intent.getIntExtra("position", 1);
            titleSubject = intent.getStringExtra("titleSubject");
            positionSubject = intent.getIntExtra("positionSubject", 2);

          //  Toast.makeText(this, "title:" + title + "\nposition:" + position + "\ntitleSubject:" + titleSubject + "\npositionSubject:" + positionSubject, Toast.LENGTH_LONG).show();
        }





        //Административный кодекс начало

        if (title.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && position == 0 && titleSubject.equals("I.Биринчи бўлим. Умумий қоидалар") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/1.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР/" + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/1.БИРИНЧИ БЎЛИМ. УМУМИЙ ҚОИДАЛАР/" + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && position == 0 && titleSubject.equals("II.Иккинчи бўлим. Маъмурий ҳуқуқбузарлик ва маъмурий жавобгарлик") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/2.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/2.ИККИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ВА МАЪМУРИЙ ЖАВОБГАРЛИК/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && position == 0 && titleSubject.equals("III.Учинчи бўлим. Маъмурий ҳуқуқбузарликлар тўғрисидаги ишларни кўриб чиқишга ваколати бўлган органлар (мансабдор шахслар)") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/3.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/3.УЧИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИКЛАР ТЎҒРИСИДАГИ ИШЛАРНИ КЎРИБ ЧИҚИШГА ВАКОЛАТИ БЎЛГАН ОРГАНЛАР (МАНСАБДОР ШАХСЛАР)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && position == 0 && titleSubject.equals("IV.Тўртинчи бўлим. Маъмурий ҳуқуқбузарлик тўғрисидаги ишларни юритиш") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/4.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/4.ТЎРТИНЧИ БЎЛИМ. МАЪМУРИЙ ҲУҚУҚБУЗАРЛИК ТЎҒРИСИДАГИ ИШЛАРНИ ЮРИТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Маъмурий жавобгарлик тўғрисидаги кодекси") && position == 0 && titleSubject.equals("V.Бешинчи бўлим. Маъмурий жа3о қўлланиш тўғрисидаги қарорларни ижро этиш") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Административный кодекс/5.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Административный кодекс/5.БЕШИНЧИ БЎЛИМ. МАЪМУРИЙ ЖА3О ҚЎЛЛАНИШ ТЎҒРИСИДАГИ ҚАРОРЛАРНИ ИЖРО ЭТИШ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Административный кодекс начало


        //Бюджетный кодекс начало
        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("II бўлим. Бюджет тизими бюджетлари") && positionSubject == 1) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("III бўлим. Ўзбекистон Республикасининг консолидациялашган бюджети. Ўзбекистон Республикасининг тикланиш ва тараққиёт жамғармаси") && positionSubject == 2) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("IV бўлим. Бюджет тизими бюджетларининг даромадлари") && positionSubject == 3) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("V бўлим. Бюджет тизими бюджетларининг харажатлари") && positionSubject == 4) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("VI бўлим. Давлат бюджетини ва давлат мақсадли жамғармалари бюджетларини тузиш, кўриб чиқиш, қабул қилиш ҳамда тасдиқлаш") && positionSubject == 5) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("VII бўлим. Бюджет тизими бюджетларининг ижроси") && positionSubject == 6) {

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

        if (title.equals("Бюджет кодекси") && position == 1 && titleSubject.equals("VIII бўлим. Бюджет ҳисоби ва ҳисоботи") && positionSubject == 7) {

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
        if (title.equals("Фуқоролик кодекси") && position == 2 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/1.I БЎЛИМ УМУМИЙ ҚОИДАЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Фуқоролик кодекси") && position == 2 && titleSubject.equals("II бўлим. Мулк ҳуқуқи ва бошқа ашёвий ҳуқуқлар") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/2.II БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/2.II БЎЛИМ МУЛК ҲУҚУҚИ ВА БОШҚА АШЁВИЙ ҲУҚУҚЛАР/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Фуқоролик кодекси") && position == 2 && titleSubject.equals("III бўлим. Мажбурият ҳуқуқи") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Гражданский кодекс/3.III БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Гражданский кодекс/3.III БЎЛИМ МАЖБУРИЯТ ҲУҚУҚИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Гражданский кодекс конец

        //Уголовный процессуальный кодекс начало
        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("I.Биринчи бўлим \n" + "Асосий қоидалар") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/1.БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/1.БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("II.Иккинчи бўлим \n" + "Жиноят процесси иштирокчилари") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/2.ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/2.ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("III.УЧИНЧИ БЎЛИМ \n" + "Далиллар ва исбот қилиниши лозим бўлган ҳолатлар") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/3.УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("IV.Тўртинчи бўлим \n" + "Процессуал мажбурлов") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/4.ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/4.ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("V.Бешинчи бўлим \n" + "Жиноят натижасида етказилган мулкий зиённи қоплаш") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/5.БЕШИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/5.БЕШИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("VI.Олтинчи бўлим \n" + "Жиноятларнинг олдини олиш чоралари") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/6.ОЛТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/6.ОЛТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("VII.Еттинчи бўлим \n" + "Реабилитация") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/7.ЕТТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/7.ЕТТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("VIII.Саккизинчи бўлим \n" + "Процессуал муддатлар ва чиқимлар") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/8.САККИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/8.САККИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("IX.Тўққизинчи бўлим \n" + "Ишни судга қадар юритиш") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/9.ТЎҚҚИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/9.ТЎҚҚИЗИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("X.Ўнинчи бўлим \n" + "Биринчи инстанция судида иш юритиш") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/10.ЎНИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/10.ЎНИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("XI.Ўн биринчи бўлим \n" + "Ҳукм, ажрим ва қарорларнинг қонунийлиги, асослилиги ва адолатлилигини текшириш") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/11.ЎН БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/11.ЎН БИРИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("XII.Ўн иккинчи бўлим \n" + "Ҳукм, ажрим, қарорларни ижро этиш") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/12.ЎН ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/12.ЎН ИККИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("XIII.Ўн учинчи бўлим \n" + "Алоҳида тоифадаги жиноят ишларини юритиш") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/13.ЎН УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/13.ЎН УЧИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят-процессуал кодекси") && position == 3 && titleSubject.equals("XIV.Ўн тўртинчи бўлим \n" + "Жиноий суд ишларини юритиш соҳасидаги халқаро ҳамкорлик") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_kir.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/14.ЎН ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный процессуальный кодекс/14.ЎН ТЎРТИНЧИ БЎЛИМ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный процессуальный кодекс конец

        //Налоговый кодекс начало
        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("II бўлим. Солиқ ҳисоби ва солиқ ҳисоботлари") && positionSubject == 1) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("III бўлим. Солиқ мажбуриятини бажариш") && positionSubject == 2) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("IV бўлим. Солиқ тўловчиларни ва солиқ солиш объектларини ҳисобга олиш") && positionSubject == 3) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("V бўлим. Солиқ назорати") && positionSubject == 4) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("VI бўлим. Трансферт нархни белгилашда солиқ назорати") && positionSubject == 5) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("VII бўлим. Назорат қилинадиган чет эл компанияларининг фойдасига солиқ солиш шартлари ва умумий қоидалари") && positionSubject == 6) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("VIII бўлим. Солиққа оид ҳуқуқбузарликлар ва уларни содир этганлик учун жавобгарлик") && positionSubject == 7) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("IX бўлим. Солиқ органларининг ҳужжатлари ва улар мансабдор шахсларининг ҳаракатлари (ҳаракатсизлиги) устидан шикоят бериш") && positionSubject == 8) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("X бўлим. Қўшилган қиймат солиғи") && positionSubject == 9) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("ХI бўлим. Акциз солиғи") && positionSubject == 10) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XII бўлим. Фойда солиғи") && positionSubject == 11) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XIII бўлим. Жисмоний шахслардан олинадиган даромад солиғи") && positionSubject == 12) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XIV бўлим. Ижтимоий солиқ") && positionSubject == 13) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XV бўлим. Мол-мулк солиғи") && positionSubject == 14) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XVI бўлим. Ер солиғи") && positionSubject == 15) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XVII бўлим. Сув ресурсларидан фойдаланганлик учун солиқ") && positionSubject == 16) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XVIII бўлим. Ер қаъридан фойдаланганлик учун солиқ") && positionSubject == 17) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XIX бўлим. Йиғимлар") && positionSubject == 18) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("XX бўлим. Айланмадан олинадиган солиқ") && positionSubject == 19) {

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

        if (title.equals("Солиқ кодекси") && position == 5 && titleSubject.equals("ХХI бўлим. Солиқ тўловчиларнинг айрим тоифаларига солиқ солишнинг ўзига хос хусусиятлари") && positionSubject == 20) {

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
        if (title.equals("Масъулияти чекланган ҳамда қўшимча масъулиятли жамиятлар тўғрисидаги кодекси") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_lodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Общественный кодекс конец

        //Семейный кодекс начало
        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

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
        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("II бўлим. Никоҳ") && positionSubject == 1) {

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

        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("III бўлим. Қон-қариндошлик ва болаларнинг насл-насабини белгилаш") && positionSubject == 2) {

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

        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("IV бўлим. Ота-она ҳамда вояга етмаган болаларнинг ҳуқуқ ва мажбуриятлари") && positionSubject == 3) {

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

        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("V бўлим. Оила аъзоларининг ва бошқа шахсларнинг алимент мажбуриятлари") && positionSubject == 4) {

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

        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("VI бўлим. Ота-она қарамоғидан маҳрум бўлган болаларни жойлаштириш шакллари") && positionSubject == 5) {

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

        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("VII бўлим. Фуқаролик ҳолати далолатномаларини қайд этиш") && positionSubject == 6) {

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


        if (title.equals("Оила кодекси") && position == 7 && titleSubject.equals("VIII бўлим. Чет эл фуқаролари ва фуқаролиги бўлмаган шахслар иштирокидаги оилавий муносабатларни тартибга солиш") && positionSubject == 7) {

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
        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("I бўлим. Умумий қоидалар") && positionSubject == 0) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("II бўлим. Божхона режимлари") && positionSubject == 1) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("III бўлим. Транспорт воситаларига ва товарларнинг айрим тоифаларига нисбатан божхона режимларининг қўлланилиши") && positionSubject == 2) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("IV бўлим. Божхона назорати") && positionSubject == 3) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("V бўлим. Божхона ишида валюта назорати ва ташқи савдо операцияларининг мониторинги") && positionSubject == 4) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("VI бўлим. Божхона расмийлаштируви") && positionSubject == 5) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("VII бўлим. Декларант, божхона брокери ва божхона расмийлаштируви бўйича мутахассис") && positionSubject == 6) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("VIII бўлим. Божхона тўловлари") && positionSubject == 7) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("IX бўлим. Божхона статистикаси. Божхона ишида ахборот-коммуникация технологиялари. Интеллектуал мулк объектларига бўлган ҳуқуқларни ҳимоя қилиш") && positionSubject == 8) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("X бўлим. Чет эллик шахсларнинг айрим тоифалари учун божхона имтиёзлари") && positionSubject == 9) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("XI бўлим. Назорат остида етказиб бериш") && positionSubject == 10) {

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

        if (title.equals("Божхона кодекси") && position == 8 && titleSubject.equals("XII бўлим. Якунловчи қоидалар") && positionSubject == 11) {

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

        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("I.Биринчи бўлим. Умумий қоидалар") && positionSubject == 0) {

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


        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("II.Иккинчи бўлим. Жавобгарлик асослари") && positionSubject == 1) {

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


        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("III.Учинчи бўлим. Қилмишнинг жиноийлигини истисно қиладиган ҳолатлар") && positionSubject == 2) {

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

        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("IV.Тўртинчи бўлим. Жазо ва уни тайинлаш") && positionSubject == 3) {

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

        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("V.Бешинчи бўлим. Жавобгарликдан ва жазодан озод қилиш") && positionSubject == 4) {

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


        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("VI.Олтинчи бўлим. Вояга етмаганлар жавобгарлигининг хусусиятлари, бошқарув ва жамоат бирлашмалари органларининг фаолият тартибига қарши жиноятлар") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_kodeks_kir.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Уголовный кодекс/6.VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Уголовный кодекс/6.VI.ОЛТИНЧИ БЎЛИМ ВОЯГА ЕТМАГАНЛАР ЖАВОБГАРЛИГИНИНГ ХУСУСИЯТЛАРИ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("VII.Елтинчи бўлим. Тиббий йўсиндаги мажбурлов чоралари") && positionSubject == 6) {

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

        if (title.equals("Жиноят кодекси") && position == 10 && titleSubject.equals("VIII.Саккизинчи бўлим. Атамаларнинг ҳуқуқий маъноси") && positionSubject == 7) {

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
        if (title.equals("Ер кодекси") && position == 4) {
            List<Acts_Subtitle> actsList = Zemelniy_kodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Земельный кодекс конец

        //Трудовой кодекс начало
        if (title.equals("Меҳнат кодекси") && position == 9) {
            List<Acts_Subtitle> actsList = Trudovoy_kodeks_kir.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Трудовой кодекс конец

        //Частное предприятие начало
        if (title.equals("Хусусий корхона тоғрисидаги кодекси") && position == 11) {
            List<Acts_Subtitle> actsList = Chastnoe_Predpriyatie.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("kir/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("kir/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Частное предприятие конец


        //lat start

        //Административный кодекс начало

        if (title.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && position == 0 && titleSubject.equals("I.Birinchi bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/1.I.Birinchi bo‘lim. Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/1.I.Birinchi bo‘lim. Umumiy qoidalar/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && position == 0 && titleSubject.equals("II.Ikkinchi bo‘lim. Ma’muriy huquqbuzarlik va ma’muriy javobgarlik") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/2.II.Ikkinchi bo‘lim. Ma’muriy huquqbuzarlik va ma’muriy javobgarlik/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/2.II.Ikkinchi bo‘lim. Ma’muriy huquqbuzarlik va ma’muriy javobgarlik/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && position == 0 && titleSubject.equals("III.Uchinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni ko‘rib chiqishga vakolati bo‘lgan organlar (mansabdor shaxslar)") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/3.III.Uchinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni ko‘rib chiqishga vakolati bo‘lgan organlar (mansabdor shaxslar)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/3.III.Uchinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni ko‘rib chiqishga vakolati bo‘lgan organlar (mansabdor shaxslar)/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && position == 0 && titleSubject.equals("IV.To‘rtinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni yuritish") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/4.IV.To‘rtinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni yuritish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/4.IV.To‘rtinchi bo‘lim. Ma’muriy huquqbuzarlik to‘g‘risidagi ishlarni yuritish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Ma’muriy javobkarlik to‘g‘risidagi kodeksi") && position == 0 && titleSubject.equals("V.Beshinchi bo‘lim. Ma’muriy jazo qo‘llanish to‘g‘risidagi qarorlarni ijro etish") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Административный кодекс/5.V.Beshinchi bo‘lim. Ma’muriy jazo qo‘llanish to‘g‘risidagi qarorlarni ijro etish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Административный кодекс/5.V.Beshinchi bo‘lim. Ma’muriy jazo qo‘llanish to‘g‘risidagi qarorlarni ijro etish/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }


        }


        //Административный кодекс конец


        //Бюджетный кодекс начало

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("II bo‘lim. Byudjet tizimi byudjetlari") && positionSubject == 1) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("III bo‘lim. O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti. O‘zbekiston Respublikasining tiklanish va taraqqiyot jamg‘armasi") && positionSubject == 2) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("IV bo‘lim. Byudjet tizimi byudjetlarining daromadlari") && positionSubject == 3) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("V bo‘lim. Byudjet tizimi byudjetlarining xarajatlari") && positionSubject == 4) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("VI bo‘lim. Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash") && positionSubject == 5) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("VII bo‘lim. Byudjet tizimi byudjetlarining ijrosi") && positionSubject == 6) {

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

        if (title.equals("Byudjet kodeksi") && position == 1 && titleSubject.equals("VIII bo‘lim. Byudjet hisobi va hisoboti") && positionSubject == 7) {

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

        if (title.equals("Fuqorolik kodeksi") && position == 2 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/1.I BO‘LIM. UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Fuqorolik kodeksi") && position == 2 && titleSubject.equals("II bo‘lim. Mulk huquqi va boshqa ashyoviy huquqlar") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/2.II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/2.II BO‘LIM. MULK HUQUQI VA BOShQA AShYOVIY HUQUQLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Fuqorolik kodeksi") && position == 2 && titleSubject.equals("III bo‘lim. Majburiyat huquqi") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Гражданский кодекс/3.III BO‘LIM. MAJBURIYAT HUQUQI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Гражданский кодекс/3.III BO‘LIM. MAJBURIYAT HUQUQI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Гражданский кодекс конец лат


        //Уголовный процес-кодекс лат начало

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("I.Birinchi bo‘lim \n" + "Asosiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/1.BIRINChI BO‘LIM-ASOSIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/1.BIRINChI BO‘LIM-ASOSIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("II.Ikkinchi bo‘lim \n" + "Jinoyat prosessi ishtirokchilari") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/2.IKKINChI BO‘LIM-JINOYAT PROSESSI ISHTIROKChILARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/2.IKKINChI BO‘LIM-JINOYAT PROSESSI ISHTIROKChILARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("III.Uchinchi bo‘lim \n" + "Dalillar va isbot qilinishi lozim bo‘lgan holatlar") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/3.UChINChI BO‘LIM-DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/3.UChINChI BO‘LIM-DALILLAR VA ISBOT QILINISHI LOZIM BO‘LGAN HOLATLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("IV.To‘rtinchi bo‘lim \n" + "Prosessual majburlov") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/4.TO‘RTINChI BO‘LIM-PROSESSUAL MAJBURLOV/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/4.TO‘RTINChI BO‘LIM-PROSESSUAL MAJBURLOV/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("V.Beshinchi bo‘lim \n" + "Jinoyat natijasida yetkazilgan mulkiy ziyonni qoplash") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/5.BESHINChI BO‘LIM-JINOYAT NATIJASIDA YeTKAZILGAN MULKIY ZIYoNNI QOPLASH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/5.BESHINChI BO‘LIM-JINOYAT NATIJASIDA YeTKAZILGAN MULKIY ZIYoNNI QOPLASH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("VI.Oltinchi bo‘lim \n" + "Jinoyatlarning oldini olish choralari") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/6.OLTINChI BO‘LIM-JINOYATLARNING OLDINI OLISH ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/6.OLTINChI BO‘LIM-JINOYATLARNING OLDINI OLISH ChORALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("VII.Yettinchi bo‘lim \n" + "Reabilitasiya") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/7.YeTTINChI BO‘LIM-REABILITASIYa/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/7.YeTTINChI BO‘LIM-REABILITASIYa/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("VIII.Sakkizinchi bo‘lim \n" + "Prosessual muddatlar va chiqimlar") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/8.SAKKIZINChI BO‘LIM -PROSESSUAL MUDDATLAR VA ChIQIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/8.SAKKIZINChI BO‘LIM -PROSESSUAL MUDDATLAR VA ChIQIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("IX.To‘qqizinchi bo‘lim \n" + "Ishni sudga qadar yuritish") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/9.TO‘QQIZINChI BO‘LIM -ISHNI SUDGA QADAR YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/9.TO‘QQIZINChI BO‘LIM -ISHNI SUDGA QADAR YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("X.O‘ninchi bo‘lim \n" + "Birinchi instansiya sudida ish yuritish") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/10.O‘NINChI BO‘LIM-BIRINChI INSTANSIYa SUDIDA ISH YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/10.O‘NINChI BO‘LIM-BIRINChI INSTANSIYa SUDIDA ISH YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("XI.O‘n birinchi bo‘lim \n" + "Hukm, ajrim va qarorlarning qonuniyligi, asosliligi va adolatliligini tekshirish") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/11.O‘N BIRINChI BO‘LIM-HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/11.O‘N BIRINChI BO‘LIM-HUKM, AJRIM VA QARORLARNING QONUNIYLIGI, ASOSLILIGI VA ADOLATLILIGINI TEKSHIRISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("XII.O‘n ikkinchi bo‘lim \n" + "Hukm, ajrim, qarorlarni ijro etish") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/12.O‘N IKKINChI BO‘LIM-HUKM, AJRIM, QARORLARNI IJRO ETISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/12.O‘N IKKINChI BO‘LIM-HUKM, AJRIM, QARORLARNI IJRO ETISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("XIII.O‘n uchinchi bo‘lim \n" + "Alohida toifadagi jinoyat ishlarini yuritish") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/13.O‘N UChINChI BO‘LIM-ALOHIDA TOIFADAGI JINOYAT ISHLARINI YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/13.O‘N UChINChI BO‘LIM-ALOHIDA TOIFADAGI JINOYAT ISHLARINI YuRITISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Jinoyat-prosessual kodeksi") && position == 3 && titleSubject.equals("XIV.O‘n to‘rtinchi bo‘lim \n" + "Jinoiy sud ishlarini yuritish sohasidagi xalqaro hamkorlik") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_uz.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/14.O‘N TO‘RTINChI BO‘LIM -JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Уголовный процессуальный кодекс/14.O‘N TO‘RTINChI BO‘LIM -JINOIY SUD ISHLARINI YuRITISH SOHASIDAGI XALQARO HAMKORLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный прцес-кодекс лат конец

        //Налоговый кодекс лат начало

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/1.I BO‘LIM-UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/1.I BO‘LIM-UMUMIY QOIDALAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("II bo‘lim. Soliq hisobi va soliq hisobotlar") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/2.II BO‘LIM-SOLIQ HISOBI VA SOLIQ HISOBOTLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/2.II BO‘LIM-SOLIQ HISOBI VA SOLIQ HISOBOTLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("III bo‘lim. Soliq majburiyatini bajarish") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/3.III BO‘LIM-SOLIQ MAJBURIYATINI BAJARISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/3.III BO‘LIM-SOLIQ MAJBURIYATINI BAJARISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("IV bo‘lim. Soliq to‘lovchilarni va soliq solish ob’yektlarini hisobga olish") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/4.IV BO‘LIM-SOLIQ TO‘LOVChILARNI VA SOLIQ SOLISH OB’YeKTLARINI HISOBGA OLISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/4.IV BO‘LIM-SOLIQ TO‘LOVChILARNI VA SOLIQ SOLISH OB’YeKTLARINI HISOBGA OLISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("V bo‘lim. Soliq nazorati") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/5.V BO‘LIM-SOLIQ NAZORATI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/5.V BO‘LIM-SOLIQ NAZORATI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("VI bo‘lim. Transfert narxni belgilashda soliq nazorati") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/6.VI BO‘LIM-TRANSFERT NARXNI BELGILASHDA SOLIQ NAZORATI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/6.VI BO‘LIM-TRANSFERT NARXNI BELGILASHDA SOLIQ NAZORATI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("VII bo‘lim. Nazorat qilinadigan chet el kompaniyalarining foydasiga soliq solish shartlari va umumiy qoidalari") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/7.VII BO‘LIM-NAZORAT QILINADIGAN CHET EL KOMPANIYALARINING FOYDASIGA SOLIQ SOLISH SHARTLARI VA UMUMIY QOIDALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/7.VII BO‘LIM-NAZORAT QILINADIGAN CHET EL KOMPANIYALARINING FOYDASIGA SOLIQ SOLISH SHARTLARI VA UMUMIY QOIDALARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("VIII bo‘lim. Soliqqa oid huquqbuzarliklar va ularni sodir etganlik uchun javobgarlik") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/8.VIII BO‘LIM-SOLIQQA OID HUQUQBUZARLIKLAR VA ULARNI SODIR ETGANLIK UChUN JAVOBGARLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/8.VIII BO‘LIM-SOLIQQA OID HUQUQBUZARLIKLAR VA ULARNI SODIR ETGANLIK UChUN JAVOBGARLIK/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("IX bo‘lim. Soliq organlarining hujjatlari va ular mansabdor shaxslarining harakatlari (harakatsizligi) ustidan shikoyat berish") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/9.IX BO‘LIM-SOLIQ ORGANLARINING HUJJATLARI VA ULAR MANSABDOR SHAXSLARINING HARAKATLARI (HARAKATSIZLIGI) USTIDAN SHIKOYAT BERISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/9.IX BO‘LIM-SOLIQ ORGANLARINING HUJJATLARI VA ULAR MANSABDOR SHAXSLARINING HARAKATLARI (HARAKATSIZLIGI) USTIDAN SHIKOYAT BERISH/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("X bo‘lim. Qo‘shilgan qiymat soligʻi") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/10.X BO‘LIM-QO‘SHILGAN QIYMAT SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/10.X BO‘LIM-QO‘SHILGAN QIYMAT SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XI bo‘lim. Aksiz soligʻi") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/11.XI BO‘LIM-AKSIZ SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/11.XI BO‘LIM-AKSIZ SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XII bo‘lim. Foyda soligʻi") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/12.XII BO‘LIM-FOYDA SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/12.XII BO‘LIM-FOYDA SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XIII bo‘lim. Jismoniy shaxslardan olinadigan daromad soligʻi") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/13.XIII BO‘LIM-JISMONIY SHAXSLARDAN OLINADIGAN DAROMAD SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/13.XIII BO‘LIM-JISMONIY SHAXSLARDAN OLINADIGAN DAROMAD SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XIV bo‘lim. Ijtimoiy soliq") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/14.XIV BO‘LIM-IJTIMOIY SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/14.XIV BO‘LIM-IJTIMOIY SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XV bo‘lim. Mol-mulk soligʻi") && positionSubject == 14) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_15();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/15.XV BO‘LIM-MOL-MULK SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/15.XV BO‘LIM-MOL-MULK SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XVI bo‘lim. Yer soligʻi") && positionSubject == 15) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_16();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/16.XVI BO‘LIM-YeR SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/16.XVI BO‘LIM-YeR SOLIGʻI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XVII bo‘lim. Suv resurslaridan foydalanganlik uchun soliq") && positionSubject == 16) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_17();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/17.XVII BO‘LIM-SUV RESURSLARIDAN FOYDALANGANLIK UChUN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/17.XVII BO‘LIM-SUV RESURSLARIDAN FOYDALANGANLIK UChUN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XVIII bo‘lim. Yer qa’ridan foydalanganlik uchun soliq") && positionSubject == 17) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_18();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/18.XVIII BO‘LIM-YeR QA’RIDAN FOYDALANGANLIK UChUN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/18.XVIII BO‘LIM-YeR QA’RIDAN FOYDALANGANLIK UChUN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XIX bo‘lim. Yigʻimlar") && positionSubject == 18) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_19();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/19.XIX BO‘LIM-YIGʻIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/19.XIX BO‘LIM-YIGʻIMLAR/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XX bo‘lim. Aylanmadan olinadigan soliq") && positionSubject == 19) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_20();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/20.XX BO‘LIM-AYLANMADAN OLINADIGAN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/20.XX BO‘LIM-AYLANMADAN OLINADIGAN SOLIQ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Soliq kodeksi") && position == 5 && titleSubject.equals("XXI bo‘lim. Soliq to‘lovchilarning ayrim toifalariga soliq solishning o‘ziga xos xususiyatlari") && positionSubject == 20) {

            List<Acts_Subtitle> acts_subtitles = Nalogoviy_kodeks_uz.getActs_Chapter_21();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Налоговый кодекс/21.XXI BO‘LIM-SOLIQ TO‘LOVChILARNING AYRIM TOIFALARIGA SOLIQ SOLISHNING O‘ZIGA XOS XUSUSIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Налоговый кодекс/21.XXI BO‘LIM-SOLIQ TO‘LOVChILARNING AYRIM TOIFALARIGA SOLIQ SOLISHNING O‘ZIGA XOS XUSUSIYATLARI/" + (i + 1) + "." + acts_subtitles.get(i).getTitle() + ".pdf").load();

                    }
                }
            }
        }

        //Налоговый кодекс лат нконец

        //Земельный кодекс лат начало

        if (title.equals("Yer kodeksi") && position == 4) {
            List<Acts_Subtitle> actsList = Zemelniy_kodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Земельный кодекс лат конец

        //Общественный кодекс лат начало
        if (title.equals("Mas’suliyati cheklangan hamda qo‘shimcha mas’uliyatli jamiyatlar to‘g‘risidagi kodeksi") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_lodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }
        //Общественный кодекс лат конец


        //Семейный кодекс лат начало

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

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
        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("II bo‘lim. Nikoh") && positionSubject == 1) {

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

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("III bo‘lim. Qon-qarindoshlik va bolalarning nasl-nasabini belgilash") && positionSubject == 2) {

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

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("IV bo‘lim. Ota-ona hamda voyaga yetmagan bolalarning huquq va majburiyatlari") && positionSubject == 3) {

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

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("V bo‘lim. Oila a’zolarining va boshqa shaxslarning aliment majburiyatlari") && positionSubject == 4) {

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

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("VI bo‘lim. Ota-ona qaramog‘idan mahrum bo‘lgan bolalarni joylashtirish shakllari") && positionSubject == 5) {

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

        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("VII bo‘lim. Fuqarolik holati dalolatnomalarini qayd etish") && positionSubject == 6) {

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


        if (title.equals("Oila kodeksi") && position == 7 && titleSubject.equals("VIII bo‘lim. Chet el fuqarolari va fuqaroligi bo‘lmagan shaxslar ishtirokidagi oilaviy munosabatlarni tartibga solish") && positionSubject == 7) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("I bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("II bo‘lim. Bojxona rejimlari") && positionSubject == 1) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("III bo‘lim. Transport vositalariga va tovarlarning ayrim toifalariga nisbatan bojxona rejimlarining qo‘llanilishi") && positionSubject == 2) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("IV bo‘lim. Bojxona nazorati") && positionSubject == 3) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("V bo‘lim. Bojxona ishida valyuta nazorati va tashqi savdo operatsiyalarining monitoringi") && positionSubject == 4) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("VI bo‘lim. Bojxona rasmiylashtiruvi") && positionSubject == 5) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("VII bo‘lim. Deklarant, bojxona brokeri va bojxona rasmiylashtiruvi bo‘yicha mutaxassis") && positionSubject == 6) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("VIII bo‘lim. Bojxona to‘lovlari") && positionSubject == 7) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("IX bo‘lim. Bojxona statistikasi. Bojxona ishida axborot-kommunikatsiya texnologiyalari") && positionSubject == 8) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("X bo‘lim. Chet ellik shaxslarning ayrim toifalari uchun bojxona imtiyozlari") && positionSubject == 9) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("XI bo‘lim. Nazorat ostida yetkazib berish") && positionSubject == 10) {

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

        if (title.equals("Bojxona kodeksi") && position == 8 && titleSubject.equals("XII bo‘lim. Yakunlovchi qoidalar") && positionSubject == 11) {

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

        if (title.equals("Mehnat kodeksi") && position == 9) {
            List<Acts_Subtitle> actsList = Trudovoy_kodeks_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Трудовой кодекс лат конец

        //Уголовный кодекс лат начало

        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("I.Birinchi bo‘lim. Umumiy qoidalar") && positionSubject == 0) {

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


        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("II.Ikkinchi bo‘lim. Javobgarlik asoslari") && positionSubject == 1) {

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


        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("III.Uchinchi bo‘lim. Qilmishning jinoiyligini istisno qiladigan holatlar") && positionSubject == 2) {

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

        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("IV.To‘rtinchi bo‘lim. Jazo va uni tayinlash") && positionSubject == 3) {

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

        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("V.Beshinchi bo‘lim. Javobgarlikdan va jazodan ozod qilish") && positionSubject == 4) {

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


        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("VI.Oltinchi bo‘lim. Voyaga yetmaganlar javobgarligining xususiyatlari") && positionSubject == 5) {

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

        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("VII.Yettinchi bo‘lim. Tibbiy yo‘sindagi majburlov choralari") && positionSubject == 6) {

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

        if (title.equals("Jinoyat kodeksi") && position == 10 && titleSubject.equals("VIII.Sakkizinchi bo‘lim. Atamalarning huquqiy ma’nosi") && positionSubject == 7) {

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

        if (title.equals("Xususiy korxona to‘g‘risidagi kodeksi") && position == 11) {
            List<Acts_Subtitle> actsList = Chastnoe_Predpriyatie_uz.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                Log.i("title", actsList.get(i).getTitle());

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("lat/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("lat/Частное предприятие/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Частное придриятие лат конец

        //lat finish


        //Rus start

        //Администратиный кодекс рус начало

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("I.Раздел первый. общие положения") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {

                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/1.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ/" + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/1.РАЗДЕЛ ПЕРВЫЙ. ОБЩИЕ ПОЛОЖЕНИЯ/" + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();
                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("II.Раздел второй. административное правонарушение и административная ответственность") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/2.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/2.РАЗДЕЛ ВТОРОЙ. АДМИНИСТРАТИВНОЕ ПРАВОНАРУШЕНИЕ И АДМИНИСТРАТИВНАЯ ОТВЕТСТВЕННОСТЬ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("III.Раздел третий. органы (должностные лица), уполномоченные рассматривать дела об административных правонарушениях") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/3.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/3.РАЗДЕЛ ТРЕТИЙ. ОРГАНЫ (ДОЛЖНОСТНЫЕ ЛИЦА), УПОЛНОМОЧЕННЫЕ РАССМАТРИВАТЬ ДЕЛА ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }


        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("IV.Раздел четвертый. производство по делам об административных правонарушениях") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ. ПРОИЗВОДСТВО ПО ДЕЛАМ ОБ АДМИНИСТРАТИВНЫХ ПРАВОНАРУШЕНИЯХ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Административный кодекс") && position == 0 && titleSubject.equals("V.Раздел пятый. исполнение постановлений о применении административных взысканий") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Administrativniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Административный кодекс/5.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Административный кодекс/5.РАЗДЕЛ ПЯТЫЙ. ИСПОЛНЕНИЕ ПОСТАНОВЛЕНИЙ О ПРИМЕНЕНИИ АДМИНИСТРАТИВНЫХ ВЗЫСКАНИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

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

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/1.РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("Раздел II. Право собственности и другие вещные права") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/2.РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/2.РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Гражданский кодекс") && position == 2 && titleSubject.equals("Раздел III. Обязательственное право") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Grajdanskiy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Гражданский кодекс/3.РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Гражданский кодекс/3.РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

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
                        pdfView.fromAsset("rus/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Земельный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Земельный кодекс рус конец


        //Налоговый кодекс рус начало

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел II. Исполнение налогового обязательства") && positionSubject == 1) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел III. Налоговый контроль") && positionSubject == 2) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел IV. Ответственность за налоговое правонарушение") && positionSubject == 3) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел V. Налог на прибыль юридических лиц") && positionSubject == 4) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел VI. Налог на доходы физических лиц") && positionSubject == 5) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел VII. Налог на добавленную стоимость") && positionSubject == 6) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел VIII. Акцизный налогГ") && positionSubject == 7) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел IX. Налоги и специальные платежи для недропользователей") && positionSubject == 8) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел X. Налог за пользование водными ресурсамиИ") && positionSubject == 9) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XI. Налог на имущество") && positionSubject == 10) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XII. Земельный налог") && positionSubject == 11) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XV. Обязательные платежи в государственные целевые фонды") && positionSubject == 12) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XVII. Государственная пошлина") && positionSubject == 13) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XVIII. Таможенные платежи") && positionSubject == 14) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XIX. Сбор за право розничной торговли отдельными видами товаров и оказание отдельных видов услуг") && positionSubject == 15) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XX. Упрощенный порядок налогообложения") && positionSubject == 16) {

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

        if (title.equals("Налоговый кодекс") && position == 5 && titleSubject.equals("Раздел XXI. Особенности налогообложения отдельных категорий налогоплательщиков") && positionSubject == 17) {

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

        if (title.equals("Общество с  ограниченной и дополнительной ответсятвенностью") && position == 6) {
            List<Acts_Subtitle> actsList = Obshestvenniy_kodeks_ru.getActs_Subtitle();
            for (int i = 0; i < actsList.size(); i++) {

                if (positionSubject == i && actsList.get(i).getTitle().equals(titleSubject)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Общественный кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Общественный кодекс рус конец

        //Семейный кодекс рус начало

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

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
        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел II. Брак") && positionSubject == 1) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел III. Кровное родство и установление происхождения детей") && positionSubject == 2) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел IV. Права и обязанности родителей и несовершеннолетних детей") && positionSubject == 3) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел V. Алиментные обязательства членов семьи и других лиц") && positionSubject == 4) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел VI. Формы устройства детей, оставшихся без попечения родителей") && positionSubject == 5) {

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

        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел VII. Регистрация актов гражданского состояния") && positionSubject == 6) {

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


        if (title.equals("Семейный кодекс") && position == 7 && titleSubject.equals("Раздел VIII. Регулирование семейных отношений с участием иностранных граждан и лиц без гражданства") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Semeyniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Семейный кодекс/8.РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Семейный кодекс/8.РАЗДЕЛ VIII. РЕГУЛИРОВАНИЕ СЕМЕЙНЫХ ОТНОШЕНИЙ С УЧАСТИЕМ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

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
                        pdfView.fromAsset("rus/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Трудовой кодекс/" + (i + 1) + "." + actsList.get(i).getTitle().toUpperCase() + ".pdf").load();

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел I. Общие положения") && positionSubject == 0) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел II. Основания ответственности") && positionSubject == 1) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел III. Обстоятельства, исключающие преступность деяния") && positionSubject == 2) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел IV. Наказание и его назначение") && positionSubject == 3) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел V. Освобождение от ответственности и наказания") && positionSubject == 4) {

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


        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел VI. Особенности ответственности несовершеннолетних") && positionSubject == 5) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел VII. Принудительные меры медицинского характера") && positionSubject == 6) {

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

        if (title.equals("Уголовный кодекс") && position == 10 && titleSubject.equals("Раздел VIII. Правовое значение терминов") && positionSubject == 7) {

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

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел первый \n" + "Основные положения") && positionSubject == 0) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_1();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/1.РАЗДЕЛ ПЕРВЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/1.РАЗДЕЛ ПЕРВЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел второй \n" + "Участники уголовного процесса") && positionSubject == 1) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_2();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/2.РАЗДЕЛ ВТОРОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/2.РАЗДЕЛ ВТОРОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел третий \n" + "Доказательства и обстоятельства, подлежащие доказыванию") && positionSubject == 2) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_3();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/3.РАЗДЕЛ ТРЕТИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/3.РАЗДЕЛ ТРЕТИЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }


        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел четвертый \n" + "Процессуальное принуждение") && positionSubject == 3) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_4();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/4.РАЗДЕЛ ЧЕТВЕРТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел пятый \n" + "Возмещение имущественного вреда, причиненного преступлением") && positionSubject == 4) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_5();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/5.РАЗДЕЛ ПЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/5.РАЗДЕЛ ПЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел шестой \n" + "Меры предупреждения преступлений") && positionSubject == 5) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_6();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/6.РАЗДЕЛ ШЕСТОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/6.РАЗДЕЛ ШЕСТОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел седьмой \n" + "Реабилитация") && positionSubject == 6) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_7();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/7.РАЗДЕЛ СЕДЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/7.РАЗДЕЛ СЕДЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел восьмой\n" + "Процессуальные сроки и издержки") && positionSubject == 7) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_8();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/8.РАЗДЕЛ ВОСЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/8.РАЗДЕЛ ВОСЬМОЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел девятый\n" + "Досудебное производство") && positionSubject == 8) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_9();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/9.РАЗДЕЛ ДЕВЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/9.РАЗДЕЛ ДЕВЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел десятый \n" + "Производство в суде первой инстанции") && positionSubject == 9) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_10();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/10.РАЗДЕЛ ДЕСЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/10.РАЗДЕЛ ДЕСЯТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел одиннадцатый \n" + "Проверка законности, обоснованности и справедливости приговоров, определений и постановлений") && positionSubject == 10) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_11();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/11.РАЗДЕЛ ОДИННАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/11.РАЗДЕЛ ОДИННАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел двенадцатый \n" + "Исполнение приговоров, определений, постановлений") && positionSubject == 11) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_12();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/12.РАЗДЕЛ ДВЕНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/12.РАЗДЕЛ ДВЕНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел тринадцатый\n" + "Производство по отдельным категориям уголовных дел") && positionSubject == 12) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_13();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/13.РАЗДЕЛ ТРИНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/13.РАЗДЕЛ ТРИНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        if (title.equals("Уголовный процессуальный кодекс") && position == 3 && titleSubject.equals("Раздел четырнадцатый \n" + "Международное сотрудничество в сфере уголовного судопроизводства") && positionSubject == 13) {

            List<Acts_Subtitle> acts_subtitles = Ugolovniy_protssesualniy_kodeks_ru.getActs_Chapter_14();

            for (int i = 0; i < acts_subtitles.size(); i++) {
                if (positionChapter == i && acts_subtitles.get(i).getTitle().equals(titleChapter)) {
                    if (dark.equals("no")) {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/14.РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").nightMode(true).load();
                    } else {
                        pdfView.fromAsset("rus/Уголовный процессуальный кодекс/14.РАЗДЕЛ ЧЕТЫРНАДЦАТЫЙ/" + (i + 1) + "." + acts_subtitles.get(i).getTitle().toUpperCase() + ".pdf").load();

                    }
                }
            }
        }

        //Уголовный процес-кодекс конец

        //Rus finish
    }
}
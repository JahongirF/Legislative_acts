package com.example.legislative_acts.Documentation_Class.Data_for_lat;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Byudjetniy_kodeks_uz {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I bo‘lim. Umumiy qoidalar"));
        acts_subtitles.add(new Acts_Subtitle("II bo‘lim. Byudjet tizimi byudjetlari"));
        acts_subtitles.add(new Acts_Subtitle("III bo‘lim. O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti. O‘zbekiston Respublikasining tiklanish va taraqqiyot jamg‘armasi"));
        acts_subtitles.add(new Acts_Subtitle("IV bo‘lim. Byudjet tizimi byudjetlarining daromadlari"));
        acts_subtitles.add(new Acts_Subtitle("V bo‘lim. Byudjet tizimi byudjetlarining xarajatlari"));
        acts_subtitles.add(new Acts_Subtitle("VI bo‘lim. Davlat byudjetini va davlat maqsadli jamg‘armalari byudjetlarini tuzish, ko‘rib chiqish, qabul qilish hamda tasdiqlash"));
        acts_subtitles.add(new Acts_Subtitle("VII bo‘lim. Byudjet tizimi byudjetlarining ijrosi"));
        acts_subtitles.add(new Acts_Subtitle("VIII bo‘lim. Byudjet hisobi va hisoboti"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("1-bob. Asosiy qoidalar"));
        acts_subtitles.add(new Acts_Subtitle("2-bob. Byudjet tizimi tushunchasi va prinsiplari"));
        acts_subtitles.add(new Acts_Subtitle("3-bob. Byudjet tasnifi"));
        acts_subtitles.add(new Acts_Subtitle("4-bob. Byudjet sohasidagi vakolatlar"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_2(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("5-bob. Davlat byudjeti"));
        acts_subtitles.add(new Acts_Subtitle("6-bob. Davlat maqsadli jamg‘armalari va byudjet tashkilotlarining byudjetdan tashqari jamg‘armalari"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_3(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("7-bob. O‘zbekiston Respublikasining konsolidasiyalashgan byudjeti"));
        acts_subtitles.add(new Acts_Subtitle("8-bob. O‘zbekiston Respublikasining Tiklanish va taraqqiyot jamg'armasi"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_4(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("9-bob. Davlat byudjeti daromadlari"));
        acts_subtitles.add(new Acts_Subtitle("11-bob. Byudjet tashkilotlarining byudjetdan tashqari jamg‘armalari daromadlari"));
        acts_subtitles.add(new Acts_Subtitle("12-bob. Beg‘araz yordam"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_5(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("13-bob. Davlat byudjeti xarajatlari"));
        acts_subtitles.add(new Acts_Subtitle("15-bob. Byudjet tashkilotlarining byudjetdan tashqari jamg‘armalari xarajatlari"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_6(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("16-bob. Davlat byudjeti va davlat maqsadli jamg‘armalari byudjetlarining loyihasini tuzish tartibi"));
        acts_subtitles.add(new Acts_Subtitle("17-bob. Davlat byudjeti to‘g‘risidagi Qonunni qabul qilish tartibi"));
        acts_subtitles.add(new Acts_Subtitle("18-bob. Xarajatlar smetalarini va shtat jadvallarini tuzish hamda tasdiqlash, ularni ro‘yxatdan o‘tkazish tartibi"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_7(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("19-bob. Byudjet tizimi byudjetlarini ijro etish tartibi"));
        acts_subtitles.add(new Acts_Subtitle("20-bob. Byudjetlararo munosabatlar"));
        acts_subtitles.add(new Acts_Subtitle("21-bob. Byudjet tizimi byudjetlariga o‘zgartirishlar kiritish"));
        acts_subtitles.add(new Acts_Subtitle("22-bob. Davlat byudjeti taqchilligi va profisiti. Davlat tomonidan mablag‘ jalb qilish"));
        acts_subtitles.add(new Acts_Subtitle("23-bob. Byudjet ssudalari, kredit liniyalari va kreditlar"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_8(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("24-bob. Byudjet hisobi va hisobotini yuritish tartibi"));
        acts_subtitles.add(new Acts_Subtitle("25-bob. Davlat byudjetining va davlat maqsadli jamg‘armalari byudjetlarining ijrosi to‘g‘risidagi hisobotlarni tasdiqlash"));
        acts_subtitles.add(new Acts_Subtitle("26-bob. Davlat moliyaviy nazorati"));
        acts_subtitles.add(new Acts_Subtitle("27-bob. Davlat moliyaviy nazoratini tashkil etish"));
        acts_subtitles.add(new Acts_Subtitle("28-bob. Byudjet to‘g‘risidagi qonun hujjatlarini buzish"));
        return acts_subtitles;
    }

}

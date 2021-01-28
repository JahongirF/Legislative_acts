package com.example.legislative_acts.Documentation_Class.Data_for_lat;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Ugolovniy_kodeks_uz {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I.Birinchi bo‘lim. Umumiy qoidalar"));
        acts_subtitles.add(new Acts_Subtitle("II.Ikkinchi bo‘lim. Javobgarlik asoslari"));
        acts_subtitles.add(new Acts_Subtitle("III.Uchinchi bo‘lim. Qilmishning jinoiyligini istisno qiladigan holatlar"));
        acts_subtitles.add(new Acts_Subtitle("IV.To‘rtinchi bo‘lim. Jazo va uni tayinlash"));
        acts_subtitles.add(new Acts_Subtitle("V.Beshinchi bo‘lim. Javobgarlikdan va jazodan ozod qilish"));
        acts_subtitles.add(new Acts_Subtitle("VI.Oltinchi bo‘lim. Voyaga yetmaganlar javobgarligining xususiyatlari"));
        acts_subtitles.add(new Acts_Subtitle("VII.Yettinchi bo‘lim. Tibbiy yo‘sindagi majburlov choralari"));
        acts_subtitles.add(new Acts_Subtitle("VIII.Sakkizinchi bo‘lim. Atamalarning huquqiy ma’nosi"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("1-bob. Jinoyat kodeksining vazifalari va prinsiplari"));
        acts_subtitles.add(new Acts_Subtitle("2-bob. Kodeksning amal qilish doirasi"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_2()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("3-bob. Jinoyat"));
        acts_subtitles.add(new Acts_Subtitle("4-bob. Javobgarlikka tortilishi lozim bo‘lgan shaxslar"));
        acts_subtitles.add(new Acts_Subtitle("5-bob. Ayb"));
        acts_subtitles.add(new Acts_Subtitle("6-bob. Tamom bo‘lmagan jinoyat"));
        acts_subtitles.add(new Acts_Subtitle("7-bob. Jinoyatda ishtirokchilik"));
        acts_subtitles.add(new Acts_Subtitle("8-bob. Bir qancha jinoyat sodir etish"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_3()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("9-bob. Qilmishning jinoiyligini istisno qiladigan holatlar tushunchasi va turlari"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_4()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("10-bob. Jazo tushunchasi, maqsadlari va turlari"));
        acts_subtitles.add(new Acts_Subtitle("11-bob. Jazo tayinlash"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_5()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("12-bob. Javobgarlikdan ozod qilishning turlari"));
        acts_subtitles.add(new Acts_Subtitle("13-bob. Jazodan ozod qilishning turlari"));
        acts_subtitles.add(new Acts_Subtitle("14-bob. Sudlanganlik"));

        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_6()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("15-bob. Jazo va uni tayinlash"));
        acts_subtitles.add(new Acts_Subtitle("16-bob. Javobgarlikdan yoki jazodan ozod qilish"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_7()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("17-bob. Tibbiy yo‘sindagi majburlov choralarining asoslari va ularni tayinlash"));


        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_8()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Atamalarning huquqiy ma’nosi"));
        return acts_subtitles;
    }


}

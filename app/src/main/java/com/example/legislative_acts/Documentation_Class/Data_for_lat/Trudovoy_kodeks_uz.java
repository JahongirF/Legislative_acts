package com.example.legislative_acts.Documentation_Class.Data_for_lat;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Trudovoy_kodeks_uz {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I bob. Asosiy qoidalar"));
        acts_subtitles.add(new Acts_Subtitle("II bob. Mehnatga oid munosabatlarning subyektlari"));
        acts_subtitles.add(new Acts_Subtitle("III bob. Xodimlar va ish beruvchilarning vakilligi"));
        acts_subtitles.add(new Acts_Subtitle("IV bob. Jamoa shartnomalari va kelishuvlari"));
        acts_subtitles.add(new Acts_Subtitle("V bob. Ishga joylashtirish"));
        acts_subtitles.add(new Acts_Subtitle("VI bob. Mehnat shartnomasi"));
        acts_subtitles.add(new Acts_Subtitle("VII bob. Ish vaqti"));
        acts_subtitles.add(new Acts_Subtitle("VIII bob. Dam olish vaqti"));
        acts_subtitles.add(new Acts_Subtitle("IX bob. Mehnatga haq to‘lash"));
        acts_subtitles.add(new Acts_Subtitle("X bob. Kafolatli to‘lovlar va kompensatsiya to‘lovlari"));
        acts_subtitles.add(new Acts_Subtitle("XI bob. Mehnat intizomi"));
        acts_subtitles.add(new Acts_Subtitle("XII bob. Mehnat shartnomasi taraflarining moddiy javobgarligi"));
        acts_subtitles.add(new Acts_Subtitle("XIII bob. Mehnatni muhofaza qilish"));
        acts_subtitles.add(new Acts_Subtitle("XIV bob. Ayrim toifadagi xodimlarga beriladigan qo‘shimcha kafolat va imtiyozlar"));
        acts_subtitles.add(new Acts_Subtitle("XV bob. Mehnat nizolari"));
        acts_subtitles.add(new Acts_Subtitle("XVI bob. Davlat ijtimoiy sug‘urtasi"));

        return acts_subtitles;
    }

}

package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_lodeks_kir {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("1-БОБ. УМУМИЙ ҚОИДАЛАР"));
        acts_subtitles.add(new Acts_Subtitle("2-БОБ. ЖАМИЯТНИ ТАЪСИС ЭТИШ"));
        acts_subtitles.add(new Acts_Subtitle("3-БОБ. ЖАМИЯТНИНГ УСТАВ ФОНДИ (УСТАВ КАПИТАЛИ)"));
        acts_subtitles.add(new Acts_Subtitle("4-БОБ. ЖАМИЯТДА БОШҚАРУВ"));
        acts_subtitles.add(new Acts_Subtitle("5-БОБ. ЖАМИЯТНИНГ БИТИМ ТУЗИШДАН МАНФААТДОРЛИГИ. ЙИРИК БИТИМЛАР"));
        acts_subtitles.add(new Acts_Subtitle("6-БОБ. ЖАМИЯТНИНГ ФАОЛИЯТИ УСТИДАН НАЗОРАТ ҚИЛИШ"));
        acts_subtitles.add(new Acts_Subtitle("7-БОБ. ЖАМИЯТНИ ҚАЙТА ТАШКИЛ ЭТИШ ВА ТУГАТИШ"));

        return acts_subtitles;
    }

}

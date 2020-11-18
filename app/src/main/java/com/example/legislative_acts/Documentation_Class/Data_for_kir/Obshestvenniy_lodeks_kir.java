package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_lodeks_kir {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I БОБ. УМУМИЙ ҚОИДАЛАР"));
        acts_subtitles.add(new Acts_Subtitle("II БОБ. ЖАМИЯТНИ ТАЪСИС ЭТИШ"));
        acts_subtitles.add(new Acts_Subtitle("III БОБ. ЖАМИЯТНИНГ УСТАВ ФОНДИ (УСТАВ КАПИТАЛИ)"));
        acts_subtitles.add(new Acts_Subtitle("IV БОБ. ЖАМИЯТДА БОШҚАРУВ"));
        acts_subtitles.add(new Acts_Subtitle("V БОБ. ЖАМИЯТНИНГ БИТИМ ТУЗИШДАН МАНФААТДОРЛИГИ. ЙИРИК БИТИМЛАР"));
        acts_subtitles.add(new Acts_Subtitle("VI БОБ. ЖАМИЯТНИНГ ФАОЛИЯТИ УСТИДАН НАЗОРАТ ҚИЛИШ"));
        acts_subtitles.add(new Acts_Subtitle("VII БОБ. ЖАМИЯТНИ ҚАЙТА ТАШКИЛ ЭТИШ ВА ТУГАТИШ"));

        return acts_subtitles;
    }

}

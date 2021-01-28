package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_lodeks_kir {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I-боб. Умумий қоидалар"));
        acts_subtitles.add(new Acts_Subtitle("II-боб. Жамиятни таъсис этиш"));
        acts_subtitles.add(new Acts_Subtitle("III-боб. Жамиятнинг устав фонди (устав капитали)"));
        acts_subtitles.add(new Acts_Subtitle("IV-боб. Жамиятда бошқарув"));
        acts_subtitles.add(new Acts_Subtitle("V-боб. Жамиятнинг битим тузишдан манфаатдорлиги. йирик битимлар"));
        acts_subtitles.add(new Acts_Subtitle("VI-боб. Жамиятнинг фаолияти устидан назорат қилиш"));
        acts_subtitles.add(new Acts_Subtitle("VII-боб. Жамиятни қайта ташкил этиш ва тугатиш"));

        return acts_subtitles;
    }

}

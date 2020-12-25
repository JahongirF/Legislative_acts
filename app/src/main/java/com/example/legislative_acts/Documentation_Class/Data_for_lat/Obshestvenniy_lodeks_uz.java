package com.example.legislative_acts.Documentation_Class.Data_for_lat;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_lodeks_uz {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I BOB. UMUMIY QOIDALAR"));
        acts_subtitles.add(new Acts_Subtitle("II BOB. JAMIYATNI TA’SIS ETISH"));
        acts_subtitles.add(new Acts_Subtitle("III BOB. JAMIYATNING USTAV FONDI (USTAV KAPITALI)"));
        acts_subtitles.add(new Acts_Subtitle("IV BOB. JAMIYATDA BOSHQARUV"));
        acts_subtitles.add(new Acts_Subtitle("V BOB. JAMIYATNING BITIM TUZISHDAN MANFAATDORLIGI. YIRIK BITIMLAR"));
        acts_subtitles.add(new Acts_Subtitle("VI BOB. JAMIYATNING FAOLIYATI USTIDAN NAZORAT QILISH"));
        acts_subtitles.add(new Acts_Subtitle("VII BOB. JAMIYATNI QAYTA TASHKIL ETISH VA TUGATISH"));

        return acts_subtitles;
    }

}

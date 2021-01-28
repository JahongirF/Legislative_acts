package com.example.legislative_acts.Documentation_Class.Data_for_lat;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_lodeks_uz {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("I bob. Umumiy qoidalar"));
        acts_subtitles.add(new Acts_Subtitle("II bob. Jamiyatni ta’sis etish"));
        acts_subtitles.add(new Acts_Subtitle("III bob. Jamiyatning ustav fondi (ustav kapitali)"));
        acts_subtitles.add(new Acts_Subtitle("IV bob. Jamiyatda boshqaruv"));
        acts_subtitles.add(new Acts_Subtitle("V bob. Jamiyatning bitim tuzishdan manfaatdorligi. yirik bitimlar"));
        acts_subtitles.add(new Acts_Subtitle("VI bob. Jamiyatning faoliyati ustidan nazorat qilish"));
        acts_subtitles.add(new Acts_Subtitle("VII bob. Jamiyatni qayta tashkil etish va tugatish"));

        return acts_subtitles;
    }

}

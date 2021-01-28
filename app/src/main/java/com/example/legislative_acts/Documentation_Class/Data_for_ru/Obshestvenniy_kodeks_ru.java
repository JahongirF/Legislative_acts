package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава I. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава II. Учреждение общества"));
        acts_subtitles.add(new Acts_Subtitle("Глава III. Уставный фонд (уставный капитал) общества"));
        acts_subtitles.add(new Acts_Subtitle("Глава IV. Управление в обществе"));
        acts_subtitles.add(new Acts_Subtitle("Глава V. Заинтересованность в совершении обществом сделки. крупные сделки"));
        acts_subtitles.add(new Acts_Subtitle("Глава VI. Контроль за деятельностью общества"));
        acts_subtitles.add(new Acts_Subtitle("Глава VII. Реорганизация и ликвидация общества"));

        return acts_subtitles;
    }

}

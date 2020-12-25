package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Obshestvenniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава I. ОБЩИЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("Глава II. УЧРЕЖДЕНИЕ ОБЩЕСТВА"));
        acts_subtitles.add(new Acts_Subtitle("Глава III. УСТАВНЫЙ ФОНД (УСТАВНЫЙ КАПИТАЛ) ОБЩЕСТВА"));
        acts_subtitles.add(new Acts_Subtitle("Глава IV. УПРАВЛЕНИЕ В ОБЩЕСТВЕ"));
        acts_subtitles.add(new Acts_Subtitle("Глава V. ЗАИНТЕРЕСОВАННОСТЬ В СОВЕРШЕНИИ ОБЩЕСТВОМ СДЕЛКИ. КРУПНЫЕ СДЕЛКИ"));
        acts_subtitles.add(new Acts_Subtitle("Глава VI. КОНТРОЛЬ ЗА ДЕЯТЕЛЬНОСТЬЮ ОБЩЕСТВА"));
        acts_subtitles.add(new Acts_Subtitle("Глава VII. РЕОРГАНИЗАЦИЯ И ЛИКВИДАЦИЯ ОБЩЕСТВА"));

        return acts_subtitles;
    }

}

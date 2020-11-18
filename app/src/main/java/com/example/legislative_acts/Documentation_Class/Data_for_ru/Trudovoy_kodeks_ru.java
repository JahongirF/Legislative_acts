package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Trudovoy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА I. ОСНОВНЫЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА II. СУБЪЕКТЫ ТРУДОВЫХ ОТНОШЕНИЙ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА III. ПРЕДСТАВИТЕЛЬСТВО РАБОТНИКОВ И РАБОТОДАТЕЛЕЙ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА IV. КОЛЛЕКТИВНЫЕ ДОГОВОРЫ И СОГЛАШЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА V. ТРУДОУСТРОЙСТВО"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА VI. ТРУДОВОЙ ДОГОВОР"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА VII. РАБОЧЕЕ ВРЕМЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА VIII. ВРЕМЯ ОТДЫХА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА IX. ОПЛАТА ТРУДА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА X. ГАРАНТИЙНЫЕ И КОМПЕНСАЦИОННЫЕ ВЫПЛАТЫ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XI. ДИСЦИПЛИНА ТРУДА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XII. МАТЕРИАЛЬНАЯ ОТВЕТСТВЕННОСТЬ СТОРОН ТРУДОВОГО ДОГОВОРА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XIII. ОХРАНА ТРУДА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XIV. ДОПОЛНИТЕЛЬНЫЕ ГАРАНТИИ И ЛЬГОТЫ ОТДЕЛЬНЫМ КАТЕГОРИЯМ РАБОТНИКОВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XV. ТРУДОВЫЕ СПОРЫ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА XVI. ГОСУДАРСТВЕННОЕ СОЦИАЛЬНОЕ СТРАХОВАНИЕ"));

        return acts_subtitles;
    }

}

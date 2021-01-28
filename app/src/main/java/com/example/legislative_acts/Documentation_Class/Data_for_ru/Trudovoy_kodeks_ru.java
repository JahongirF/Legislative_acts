package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Trudovoy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава I. Основные положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава II. Субъекты трудовых отношений"));
        acts_subtitles.add(new Acts_Subtitle("Глава III. Представительство работников и работодателей"));
        acts_subtitles.add(new Acts_Subtitle("Глава IV. Коллективные договоры и соглашения"));
        acts_subtitles.add(new Acts_Subtitle("Глава V. Трудоустройство"));
        acts_subtitles.add(new Acts_Subtitle("Глава VI. Трудовой договор"));
        acts_subtitles.add(new Acts_Subtitle("Глава VII. Рабочее время"));
        acts_subtitles.add(new Acts_Subtitle("Глава VIII. Время отдыха"));
        acts_subtitles.add(new Acts_Subtitle("Глава IX. Оплата труда"));
        acts_subtitles.add(new Acts_Subtitle("Глава X. Гарантийные и компенсационные выплаты"));
        acts_subtitles.add(new Acts_Subtitle("Глава XI. Дисциплина труда"));
        acts_subtitles.add(new Acts_Subtitle("Глава XII. Материальная ответственность сторон трудового договора"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIII. Охрана труда"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIV. Дополнительные гарантии и льготы отдельным категориям работников"));
        acts_subtitles.add(new Acts_Subtitle("Глава XV. Трудовые споры"));
        acts_subtitles.add(new Acts_Subtitle("Глава XVI. Государственное социальное страхование"));

        return acts_subtitles;
    }

}

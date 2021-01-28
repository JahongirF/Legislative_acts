package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Ugolovniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Раздел I. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Раздел II. Основания ответственности"));
        acts_subtitles.add(new Acts_Subtitle("Раздел III. Обстоятельства, исключающие преступность деяния"));
        acts_subtitles.add(new Acts_Subtitle("Раздел IV. Наказание и его назначение"));
        acts_subtitles.add(new Acts_Subtitle("Раздел V. Освобождение от ответственности и наказания"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VI. Особенности ответственности несовершеннолетних"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VII. Принудительные меры медицинского характера"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VIII. Правовое значение терминов"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 1. Задачи и принципы Уголовного кодекса"));
        acts_subtitles.add(new Acts_Subtitle("Глава 2. Пределы действия Кодекса"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_2()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 3. Преступление"));
        acts_subtitles.add(new Acts_Subtitle("Глава 4. Лица, подлежащие ответственности"));
        acts_subtitles.add(new Acts_Subtitle("Глава 5. Вина"));
        acts_subtitles.add(new Acts_Subtitle("Глава 6. Неоконченное преступление"));
        acts_subtitles.add(new Acts_Subtitle("Глава 7. Соучастие в преступлении"));
        acts_subtitles.add(new Acts_Subtitle("Глава 8. Множественность преступлений"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_3()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 9. Понятие и виды обстоятельств, исключающих преступность деяния"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_4()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 10. Понятие, цели и виды наказаний"));
        acts_subtitles.add(new Acts_Subtitle("Глава 11. Назначение наказания"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_5()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 12. Виды освобождения от ответственности"));
        acts_subtitles.add(new Acts_Subtitle("Глава 13. Виды освобождения от наказания"));
        acts_subtitles.add(new Acts_Subtitle("Глава 14. Судимость"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_6()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 15. Наказание и его назначение"));
        acts_subtitles.add(new Acts_Subtitle("Глава 16. Освобождение от ответственности или наказания"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_7()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 17. Основания и назначение принудительных мер медицинского характера"));


        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_8()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Правовое значение терминов"));
        return acts_subtitles;
    }


}

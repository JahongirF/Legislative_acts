package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Ugolovniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 1. ОБЩИЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 2. ОСНОВАНИЯ ОТВЕТСТВЕННОСТИ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 3. ОБСТОЯТЕЛЬСТВА, ИСКЛЮЧАЮЩИЕ ПРЕСТУПНОСТЬ ДЕЯНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 4. НАКАЗАНИЕ И ЕГО НАЗНАЧЕНИЕ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 5. ОСВОБОЖДЕНИЕ ОТ ОТВЕТСТВЕННОСТИ И НАКАЗАНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 6. ОСОБЕННОСТИ ОТВЕТСТВЕННОСТИ НЕСОВЕРШЕННОЛЕТНИХ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 7. ПРИНУДИТЕЛЬНЫЕ МЕРЫ МЕДИЦИНСКОГО ХАРАКТЕРА"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ 8. ПРАВОВОЕ ЗНАЧЕНИЕ ТЕРМИНОВ"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава I. Задачи и принципы Уголовного кодекса"));
        acts_subtitles.add(new Acts_Subtitle("Глава II. Пределы действия Кодекса"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_2()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава III. Преступление"));
        acts_subtitles.add(new Acts_Subtitle("Глава IV. Лица, подлежащие ответственности"));
        acts_subtitles.add(new Acts_Subtitle("Глава V. Вина"));
        acts_subtitles.add(new Acts_Subtitle("Глава VI. Неоконченное преступление"));
        acts_subtitles.add(new Acts_Subtitle("Глава VII. Соучастие в преступлении"));
        acts_subtitles.add(new Acts_Subtitle("Глава VIII. Множественность преступлений"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_3()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава IX. Понятие и виды обстоятельств, исключающих преступность деяния"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_4()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава X. Понятие, цели и виды наказаний"));
        acts_subtitles.add(new Acts_Subtitle("Глава XI. Назначение наказания"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_5()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава XII. Виды освобождения от ответственностии"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIII. Виды освобождения от наказания"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIV. Судимость"));
        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_6()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава XV. Наказание и его назначение"));
        acts_subtitles.add(new Acts_Subtitle("Глава XVI. Освобождение от ответственности или наказания"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_7()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава XVII. Основания и назначение принудительных мер медицинского характера"));


        return acts_subtitles;
    }



    public static List<Acts_Subtitle> getActs_Chapter_8()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("ПРАВОВОЕ ЗНАЧЕНИЕ ТЕРМИНОВ"));
        return acts_subtitles;
    }


}

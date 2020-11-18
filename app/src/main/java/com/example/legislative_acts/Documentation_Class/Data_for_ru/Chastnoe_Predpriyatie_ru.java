package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Chastnoe_Predpriyatie_ru {

   public static List<Acts_Subtitle> getActs_Subtitle()
   {
       List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
       acts_subtitles.add(new Acts_Subtitle("I. ОБЩИЕ ПОЛОЖЕНИЯ"));
       acts_subtitles.add(new Acts_Subtitle("II. СОЗДАНИЕ ЧАСТНОГО ПРЕДПРИЯТИЯ И ЕГО ГОСУДАРСТВЕННАЯ РЕГИСТРАЦИЯ"));
       acts_subtitles.add(new Acts_Subtitle("III. УПРАВЛЕНИЕ ЧАСТНЫМ ПРЕДПРИЯТИЕМ"));
       acts_subtitles.add(new Acts_Subtitle("IV. ТРУДОВЫЕ ОТНОШЕНИЯ НА ЧАСТНОМ ПРЕДПРИЯТИИ"));
       acts_subtitles.add(new Acts_Subtitle("V. ГАРАНТИЯ СВОБОДЫ ДЕЯТЕЛЬНОСТИ ЧАСТНОГО ПРЕДПРИЯТИЯ"));
       acts_subtitles.add(new Acts_Subtitle("VI. ЗАКЛЮЧИТЕЛЬНЫЕ ПОЛОЖЕНИЯ"));

       return acts_subtitles;
   }



}

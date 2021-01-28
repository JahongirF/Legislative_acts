package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Chastnoe_Predpriyatie_ru {

   public static List<Acts_Subtitle> getActs_Subtitle()
   {
       List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
       acts_subtitles.add(new Acts_Subtitle("Глава I. Общие положения"));
       acts_subtitles.add(new Acts_Subtitle("Глава II. Создание частного предприятия и его государственная регистрация"));
       acts_subtitles.add(new Acts_Subtitle("Глава III. Управление частным предприятием"));
       acts_subtitles.add(new Acts_Subtitle("Глава IV. Трудовые отношения на частном предприятии"));
       acts_subtitles.add(new Acts_Subtitle("Глава V. Гарантия свободы деятельности частного предприятия"));
       acts_subtitles.add(new Acts_Subtitle("Глава VI. Заключительные положения"));

       return acts_subtitles;
   }



}

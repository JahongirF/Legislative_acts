package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Chastnoe_Predpriyatie {

   public static List<Acts_Subtitle> getActs_Subtitle()
   {
       List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
       acts_subtitles.add(new Acts_Subtitle("I.УМУМИЙ ҚОИДАЛАР"));
       acts_subtitles.add(new Acts_Subtitle("II.ХУСУСИЙ КОРХОНА ТУЗИШ ВА УНИ ДАВЛАТ РЎЙХАТИДАН ЎТКАЗИШ"));
       acts_subtitles.add(new Acts_Subtitle("III.ХУСУСИЙ КОРХОНАНИ БОШҚАРИШ"));
       acts_subtitles.add(new Acts_Subtitle("IV.ХУСУСИЙ КОРХОНАДА МЕҲНАТГА ОИД МУНОСАБАТЛАР"));
       acts_subtitles.add(new Acts_Subtitle("V.ХУСУСИЙ КОРХОНА ФАОЛИЯТИ ЭРКИНЛИГИНИНГ КАФОЛАТЛАРИ"));
       acts_subtitles.add(new Acts_Subtitle("VI.ЯКУНЛОВЧИ ҚОИДАЛАР"));

       return acts_subtitles;
   }



}

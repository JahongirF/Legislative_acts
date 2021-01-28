package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Chastnoe_Predpriyatie {

   public static List<Acts_Subtitle> getActs_Subtitle()
   {
       List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
       acts_subtitles.add(new Acts_Subtitle("I. Умумий қоидалар"));
       acts_subtitles.add(new Acts_Subtitle("II. Хусусий корхона тузиш ва уни давлат рўйхатидан ўтказиш"));
       acts_subtitles.add(new Acts_Subtitle("III. Хусусий корхонани бошқариш"));
       acts_subtitles.add(new Acts_Subtitle("IV. Хусусий корхонада меҳнатга оид муносабатлар"));
       acts_subtitles.add(new Acts_Subtitle("V. Хусусий корхона фаолияти эркинлигининг кафолатлари"));
       acts_subtitles.add(new Acts_Subtitle("VI. Якунловчи қоидалар"));

       return acts_subtitles;
   }



}

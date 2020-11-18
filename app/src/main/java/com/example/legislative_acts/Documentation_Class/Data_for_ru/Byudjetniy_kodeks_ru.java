package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Byudjetniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Раздел I. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Раздел II. Бюджеты бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Раздел III. Консолидированный бюджет Республики Узбекистан. Фонд реконструкции и развития Республики Узбекистан"));
        acts_subtitles.add(new Acts_Subtitle("Раздел IV. Доходы бюджетов бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Раздел V. Расходы бюджетов бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VI. Составление, рассмотрение, принятие и утверждение Государственного бюджета и бюджетов государственных целевых фондов"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VII. Исполнение бюджетов бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Раздел VIII. Бюджетный учет и отчетность"));
        acts_subtitles.add(new Acts_Subtitle("Раздел IX. Контроль за исполнением бюджетов бюджетной системы"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 1. Основные положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава 2. Понятие и принципы бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Глава 3. Бюджетная классификация"));
        acts_subtitles.add(new Acts_Subtitle("Глава 4. Бюджетные полномочия"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_2(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 5. Государственный бюджет"));
        acts_subtitles.add(new Acts_Subtitle("Глава 6. Государственные целевые фонды и внебюджетные фонды бюджетных организаций"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_3(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 7. Консолидированный бюджет Республики Узбекистан"));
        acts_subtitles.add(new Acts_Subtitle("Глава 8. Фонд реконструкции и развития Республики Узбекистан"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_4(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 9. Доходы Государственного бюджета"));
        acts_subtitles.add(new Acts_Subtitle("Глава 11. Доходы внебюджетных фондов бюджетных организаций"));
        acts_subtitles.add(new Acts_Subtitle("Глава 12. Безвозмездная помощь"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_5(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 13. Расходы Государственного бюджета"));
        acts_subtitles.add(new Acts_Subtitle("Глава 15. Расходы внебюджетных фондов бюджетных организаций"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_6(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 16. Порядок составления проекта Государственного бюджета и бюджетов государственных целевых фондов"));
        acts_subtitles.add(new Acts_Subtitle("Глава 17. Порядок принятия Закона о Государственном бюджете"));
        acts_subtitles.add(new Acts_Subtitle("Глава 18. Составление и утверждение смет расходов и штатных расписаний, порядок их регистрации"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_7(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 19. Порядок исполнения бюджетов бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Глава 20. Межбюджетные отношения"));
        acts_subtitles.add(new Acts_Subtitle("Глава 21. Внесение изменений в бюджеты бюджетной системы"));
        acts_subtitles.add(new Acts_Subtitle("Глава 22. Дефицит и профицит Государственного бюджета. Государственные заимствования"));
        acts_subtitles.add(new Acts_Subtitle("Глава 23. Бюджетные ссуды, кредитные линии и кредиты"));
        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_8(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 24. Порядок ведения бюджетного учета и отчетности"));
        acts_subtitles.add(new Acts_Subtitle("Глава 25. Утверждение отчетов об исполнении Государственного бюджета и бюджетов государственных целевых фондов"));
         return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_9(){
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 26. Государственный финансовый контроль"));
        acts_subtitles.add(new Acts_Subtitle("Глава 27. Организация государственного финансового контроля"));
        acts_subtitles.add(new Acts_Subtitle("Глава 28. Нарушения бюджетного законодательства"));
        return acts_subtitles;
    }

}

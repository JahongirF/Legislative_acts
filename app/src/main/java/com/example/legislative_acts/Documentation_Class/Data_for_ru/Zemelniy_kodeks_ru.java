package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Zemelniy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава I. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава II. Земельный фонд"));
        acts_subtitles.add(new Acts_Subtitle("Глава III. Землеустройство"));
        acts_subtitles.add(new Acts_Subtitle("Глава IV. Собственность на землю. права юридических и физических лиц на земельные участки"));
        acts_subtitles.add(new Acts_Subtitle("Глава V. Права и обязанности землевладельца, землепользователя, арендатора и собственника земельного участка"));
        acts_subtitles.add(new Acts_Subtitle("Глава VI. Земли сельскохозяйственного назначения"));
        acts_subtitles.add(new Acts_Subtitle("Глава VII. Земли населенных пунктов (городов, поселков и сельских населенных пунктов)"));
        acts_subtitles.add(new Acts_Subtitle("Глава VIII. Земли промышленности, транспорта, связи, обороны и иного назначения"));
        acts_subtitles.add(new Acts_Subtitle("Глава IX. Земли природоохранного, оздоровительного, рекреационного и историко-культурного назначения"));
        acts_subtitles.add(new Acts_Subtitle("Глава X. Земли лесного фонда, водного фонда и земли запаса"));
        acts_subtitles.add(new Acts_Subtitle("Глава XI. Охрана земель"));
        acts_subtitles.add(new Acts_Subtitle("Глава XII. Контроль за использованием и охраной земель"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIII. Возмещение убытков землевладельцам, землепользователям, арендаторам"));
        acts_subtitles.add(new Acts_Subtitle("Глава XIV. Разрешение земельных споров и ответственность за нарушение земельного законодательства"));

        return acts_subtitles;

    }

}

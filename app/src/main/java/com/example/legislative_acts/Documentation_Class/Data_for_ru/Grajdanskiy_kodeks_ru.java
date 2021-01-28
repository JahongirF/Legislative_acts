package com.example.legislative_acts.Documentation_Class.Data_for_ru;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;

public class Grajdanskiy_kodeks_ru {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Раздел I. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Раздел II. Право собственности и другие вещные права"));
        acts_subtitles.add(new Acts_Subtitle("Раздел III. Обязательственное право"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 1. Гражданское законодательство"));
        acts_subtitles.add(new Acts_Subtitle("Глава 2. Возникновение гражданских прав и обязанностей. осуществление и защита гражданских прав"));
        acts_subtitles.add(new Acts_Subtitle("Глава 3. Граждане (физические лица)"));
        acts_subtitles.add(new Acts_Subtitle("Глава 4. Юридические лица"));
        acts_subtitles.add(new Acts_Subtitle("Глава 5. Государство как участник гражданско-правовых отношений"));
        acts_subtitles.add(new Acts_Subtitle("Глава 6. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава 7. Материальные блага"));
        acts_subtitles.add(new Acts_Subtitle("Глава 8. Нематериальные блага"));
        acts_subtitles.add(new Acts_Subtitle("Глава 9. Сделки"));
        acts_subtitles.add(new Acts_Subtitle("Глава 10. Представительство и доверенность"));
        acts_subtitles.add(new Acts_Subtitle("Глава 11. Исчисление сроков"));
        acts_subtitles.add(new Acts_Subtitle("Глава 12. Исковая давность"));

        return acts_subtitles;

    }

    public static List<Acts_Subtitle> getActs_Chapter_2()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 13. Общие положения"));
        acts_subtitles.add(new Acts_Subtitle("Глава 14. Право хозяйственного ведения. право оперативного управления"));
        acts_subtitles.add(new Acts_Subtitle("Глава 15. Приобретение и прекращение права собственности"));
        acts_subtitles.add(new Acts_Subtitle("Глава 16. Частная собственность"));
        acts_subtitles.add(new Acts_Subtitle("Глава 17. Публичная собственность"));
        acts_subtitles.add(new Acts_Subtitle("Глава 18. Общая собственность"));
        acts_subtitles.add(new Acts_Subtitle("Глава 19. Защита права собственности и других вещных прав"));

        return acts_subtitles;

    }

    public static List<Acts_Subtitle> getActs_Chapter_3()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("Глава 20. Понятие и стороны обязательства"));
        acts_subtitles.add(new Acts_Subtitle("Глава 21. Исполнение обязательств"));
        acts_subtitles.add(new Acts_Subtitle("Глава 22. Обеспечение исполнения обязательств"));
        acts_subtitles.add(new Acts_Subtitle("Глава 23. Перемена лиц в обязательстве"));
        acts_subtitles.add(new Acts_Subtitle("Глава 24. Ответственность за нарушение обязательств"));
        acts_subtitles.add(new Acts_Subtitle("Глава 25. Прекращение обязательств"));
        acts_subtitles.add(new Acts_Subtitle("Глава 26. Понятие и условия договора"));
        acts_subtitles.add(new Acts_Subtitle("Глава 27. Заключение договора"));
        acts_subtitles.add(new Acts_Subtitle("Глава 28. Изменение и расторжение договора"));

        return acts_subtitles;

    }

}

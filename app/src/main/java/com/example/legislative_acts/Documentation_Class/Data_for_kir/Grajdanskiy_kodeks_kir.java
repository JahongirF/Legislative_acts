package com.example.legislative_acts.Documentation_Class.Data_for_kir;

import android.app.Activity;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.legislative_acts.Data.Acts_Subtitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Grajdanskiy_kodeks_kir {

    public static List<Acts_Subtitle> getActs_Subtitle()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ I. ОБЩИЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ II. ПРАВО СОБСТВЕННОСТИ И ДРУГИЕ ВЕЩНЫЕ ПРАВА "));
        acts_subtitles.add(new Acts_Subtitle("РАЗДЕЛ III. ОБЯЗАТЕЛЬСТВЕННОЕ ПРАВО"));

        return acts_subtitles;
    }

    public static List<Acts_Subtitle> getActs_Chapter_1()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 1. ГРАЖДАНСКОЕ ЗАКОНОДАТЕЛЬСТВО"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 2. ВОЗНИКНОВЕНИЕ ГРАЖДАНСКИХ ПРАВ И ОБЯЗАННОСТЕЙ. ОСУЩЕСТВЛЕНИЕ И ЗАЩИТА ГРАЖДАНСКИХ ПРАВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 3. ГРАЖДАНЕ (ФИЗИЧЕСКИЕ ЛИЦА)"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 4. ЮРИДИЧЕСКИЕ ЛИЦА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 5. ГОСУДАРСТВО КАК УЧАСТНИК ГРАЖДАНСКО-ПРАВОВЫХ ОТНОШЕНИЙ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 6. ОБЩИЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 7. МАТЕРИАЛЬНЫЕ БЛАГА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 8. НЕМАТЕРИАЛЬНЫЕ БЛАГА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 9. СДЕЛКИ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 10. ПРЕДСТАВИТЕЛЬСТВО И ДОВЕРЕННОСТЬ\n"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 11. ИСЧИСЛЕНИЕ СРОКОВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 12. ИСКОВАЯ ДАВНОСТЬ"));

        return acts_subtitles;

    }

    public static List<Acts_Subtitle> getActs_Chapter_2()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 13. ОБЩИЕ ПОЛОЖЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 14. ПРАВО ХОЗЯЙСТВЕННОГО ВЕДЕНИЯ. ПРАВО ОПЕРАТИВНОГО УПРАВЛЕНИЯ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 15. ПРИОБРЕТЕНИЕ И ПРЕКРАЩЕНИЕ ПРАВА СОБСТВЕННОСТИ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 16. ЧАСТНАЯ СОБСТВЕННОСТЬ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 17. ПУБЛИЧНАЯ СОБСТВЕННОСТЬ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 18. ОБЩАЯ СОБСТВЕННОСТЬ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 19. ЗАЩИТА ПРАВА СОБСТВЕННОСТИ И ДРУГИХ ВЕЩНЫХ ПРАВ"));

        return acts_subtitles;

    }

    public static List<Acts_Subtitle> getActs_Chapter_3()
    {
        List<Acts_Subtitle> acts_subtitles = new ArrayList<>();
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 20. ПОНЯТИЕ И СТОРОНЫ ОБЯЗАТЕЛЬСТВА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 21. ИСПОЛНЕНИЕ ОБЯЗАТЕЛЬСТВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 22. ОБЕСПЕЧЕНИЕ ИСПОЛНЕНИЯ ОБЯЗАТЕЛЬСТВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 23. ПЕРЕМЕНА ЛИЦ В ОБЯЗАТЕЛЬСТВЕ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 24. ОТВЕТСТВЕННОСТЬ ЗА НАРУШЕНИЕ ОБЯЗАТЕЛЬСТВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 25. ПРЕКРАЩЕНИЕ ОБЯЗАТЕЛЬСТВ"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 26. ПОНЯТИЕ И УСЛОВИЯ ДОГОВОРА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 27. ЗАКЛЮЧЕНИЕ ДОГОВОРА"));
        acts_subtitles.add(new Acts_Subtitle("ГЛАВА 28. ИЗМЕНЕНИЕ И РАСТОРЖЕНИЕ ДОГОВОРА"));

        return acts_subtitles;

    }

}

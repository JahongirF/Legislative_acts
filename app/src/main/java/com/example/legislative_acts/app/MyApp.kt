package uz.star.mardexworker.app

import android.app.Application
import android.content.res.Configuration
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.idrok.a3003.data.LanguageChanger
import com.idrok.a3003.model.local.LocalStorage



/**
 * Created by Botirali Kozimov on 11/30/20.
 */

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        LocalStorage.init(this)
//        MapKitFactory.setApiKey("baced099-319b-49d6-9d6b-e8e7d2e7df56")

//        ModeChanger.getStatusMode(this)
        LanguageChanger(this).setLanguage()
    }

    companion object {
        lateinit var instance: MyApp
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
//        setLocale()
        LanguageChanger(this).setLanguage()
        Log.d("TTTTT", "onConfigurationChanged")
    }

}

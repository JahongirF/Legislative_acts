package com.idrok.a3003.data

import android.content.Context
import android.util.Log
import com.idrok.a3003.model.local.LocalStorage
import java.util.*

const val LANGUAGE = "lang"
const val PREFERENCE_KEY = "preference_key"
class LanguageChanger(private val context: Context){

    fun setLanguage(){
        val locale = getLocale()
        val res = context.resources
        val conf = res.configuration
        if (conf.locale != locale){
            conf.setLocale(locale)
            res.updateConfiguration(conf,res.displayMetrics)
        }
    }

    private fun getLocale(): Locale {
        val language = LocalStorage.instance.language
//        val prefs = context.getSharedPreferences(PREFERENCE_KEY,Context.MODE_PRIVATE)
//        val lang = prefs.getString(LANGUAGE,"asd")
        Log.d("msg",language!!)
        return when(/*prefs.getString(LANGUAGE,"rus")*/language){
            "rus" -> {
                Locale("ru","RU")
            }
            "uz" -> {
                Locale("uz","UZ")
            }

            else -> {
                Locale("ru","KZ")
            }
        }
    }

}
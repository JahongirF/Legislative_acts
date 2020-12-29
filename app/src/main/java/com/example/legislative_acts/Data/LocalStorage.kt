package com.idrok.a3003.model.local

import android.content.Context
import com.example.tarifussdapkviewpager2.data.source.local.BooleanPreference
import com.example.tarifussdapkviewpager2.data.source.local.LongPreference
import com.example.tarifussdapkviewpager2.data.source.local.StringPreference

class LocalStorage private constructor(context: Context) {
    companion object {
        lateinit var instance: LocalStorage

        fun init(context: Context) {
            instance = LocalStorage(context)
        }
    }

    private val pref = context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)

    var theme: String by StringPreference(pref,"kz")


    var language by StringPreference(pref)
    fun clear() {
        pref.edit().clear().apply()
    }


}
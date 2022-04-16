package com.mayajam.sample.Utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson

object SharedUtil {

    private fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
    fun setObject(key: String?, `object`: Any?, context: Context) {
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        val gson = Gson()
        val json: String = gson.toJson(`object`)
        editor.putString(key, json)
        editor.apply()
    }

    fun setString(key: String?, value: String?, context: Context) {
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun setInteger(key: String?, value: Int, context: Context) {
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun setBoolean(key: String?, value: Boolean, context: Context) {
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun <T> getObject(key: String?, context: Context, classType: Class<T>?): T? {
        val json: String = getPreferences(context).getString(key, "") ?: ""
        val gson = Gson()
        return gson.fromJson(json, classType)
    }

    fun getString(key: String?, context: Context): String {
        return getPreferences(context).getString(key, "") ?: ""
    }

    fun getInteger(key: String?, context: Context): Int {
        return getPreferences(context).getInt(key, 0)
    }

    fun getBoolean(key: String?, context: Context): Boolean {
        return getPreferences(context).getBoolean(key, false)
    }

    fun clearDefaults(key: String?, context: Context) {
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.remove(key)
        editor.apply()
    }

}
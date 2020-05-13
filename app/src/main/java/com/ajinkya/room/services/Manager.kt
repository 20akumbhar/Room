package com.ajinkya.room.services

import android.content.Context
import android.content.SharedPreferences

object Manager {
    private const val SHARED_PREF_NAME = "Choices"
    fun saveSortChoice(mctx: Context,choice:Int) {
        val sharePref: SharedPreferences =
            mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePref.edit()
        editor.putInt("sort", choice)
        editor.apply()
    }

    fun saveShowChoice(mctx: Context,choice:Int) {
        val sharePref: SharedPreferences =
            mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePref.edit()
        editor.putInt("show", choice)
        editor.apply()
    }

    fun getSortChoice(mctx: Context):Int{
        val sharePref: SharedPreferences =
            mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharePref.getInt("sort", 0)
    }

    fun getShowChoice(mctx: Context):Int{
        val sharePref: SharedPreferences =
            mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharePref.getInt("show", 0)
    }
}
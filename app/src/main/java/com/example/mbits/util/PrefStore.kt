package com.example.mbits.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

@Suppress("UNCHECKED_CAST")
class PrefStore(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences("${context.packageName}.preferences", Context.MODE_PRIVATE)


    /**
     * Returns the value to which the specified key is mapped, or
     * null if this map contains no mapping for the key.
     */
    fun <T : Any?> get(key: String): T? {
        return pref.all.getOrDefault(key, null) as T
    }


    /**
     * Removes the specified key and its corresponding value from this map.
     */
    fun remove(key: String) {
        pref.edit { remove(key) }
    }

    operator fun <T : Any> set(key: String, value: T) {
        pref.edit {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                is Boolean -> putBoolean(key, value)
                else -> Unit
            }
        }
    }
}
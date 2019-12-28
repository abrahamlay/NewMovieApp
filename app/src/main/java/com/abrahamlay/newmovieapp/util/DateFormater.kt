package com.abrahamlay.newmovieapp.util

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateFormater {
    companion object {
        @JvmStatic
        @SuppressLint("SimpleDateFormat")
        fun changeDateFormat(
            dateFormatInput: String,
            dateInput: String?,
            dateFormatOutput: String
        ): String {

            try {
                dateInput.let {
                    val inputFormat = SimpleDateFormat(dateFormatInput)
                    val outputFormat = SimpleDateFormat(dateFormatOutput, Locale.ENGLISH)
                    val date: Date
                    date = inputFormat.parse(dateInput!!)!!

                    return outputFormat.format(date)
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return ""
        }
    }

}

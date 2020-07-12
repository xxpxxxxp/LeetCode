package com.ypwang.easy

class Solution1507 {
    fun reformatDate(date: String): String {
        val (d, m, y) = date.split(' ')
        return "$y-${ mapOf(
                "Jan" to "01",
                "Feb" to "02",
                "Mar" to "03",
                "Apr" to "04",
                "May" to "05",
                "Jun" to "06",
                "Jul" to "07",
                "Aug" to "08",
                "Sep" to "09",
                "Oct" to "10",
                "Nov" to "11",
                "Dec" to "12").get(m)
        }-${d.takeWhile { it.isDigit() }.padStart(2, '0')}"
    }
}
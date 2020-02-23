package com.ypwang.easy

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution1360 {
    fun daysBetweenDates(date1: String, date2: String): Int =
        Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)).toInt())
}
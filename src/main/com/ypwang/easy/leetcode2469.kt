package com.ypwang.easy

class Solution2469 {
    fun convertTemperature(celsius: Double): DoubleArray =
        doubleArrayOf(celsius + 273.15, celsius * 1.80 + 32.00)
}
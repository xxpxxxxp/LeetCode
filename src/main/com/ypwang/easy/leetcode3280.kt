package com.ypwang.easy

class Solution3280 {
    fun convertDateToBinary(date: String): String {
        val y = date.substring(0, 4).toInt()
        val m = date.substring(5, 7).toInt()
        val d = date.substring(8, 10).toInt()

        return "{${y.toString(2)}}-{${m.toString(2)}}-{${d.toString(2)}}"
    }
}

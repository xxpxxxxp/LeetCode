package com.ypwang.easy

class Solution1736 {
    fun maximumTime(time: String): String {
        val (first, second) = time.split(":")
        val f = when (first) {
            "0?" -> "09"
            "1?" -> "19"
            "??", "2?" -> "23"
            "?0","?1","?2","?3" -> "2" + first[1]
            "?4","?5","?6","?7","?8","?9" -> "1" + first[1]
            else -> first
        }

        val s = when (second) {
            "0?","1?","2?","3?","4?","5?" -> second[0] + "9"
            "??" -> "59"
            "?0","?1","?2","?3","?4","?5","?6","?7","?8","?9" -> "5" + second[1]
            else -> second
        }

        return "$f:$s"
    }
}
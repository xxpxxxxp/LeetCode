package com.ypwang.easy

class Solution3921 {
    fun scoreValidator(events: Array<String>): IntArray {
        var score = 0
        var counter = 0

        for (e in events) {
            when (e) {
                "W" -> counter++
                "WD", "NB" -> score++
                else -> score += e.toInt()
            }

            if (counter == 10)
                break
        }

        return intArrayOf(score, counter)
    }
}

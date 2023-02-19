package com.ypwang.easy

class Solution2566 {
    fun minMaxDifference(num: Int): Int {
        val s = num.toString()
        val largest = s.firstOrNull { it != '9' }
        var max = s
        if (largest != null) {
            max = max.replace(largest, '9')
        }
        val min = s.replace(s[0], '0')
        return max.toInt() - min.toInt()
    }
}
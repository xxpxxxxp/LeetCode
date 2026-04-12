package com.ypwang.easy

class Solution3894 {
    fun trafficSignal(timer: Int): String =
        when (timer) {
            0 -> "Green"
            30 -> "Orange"
            in 31..90 -> "Red"
            else -> "Invalid"
        }
}

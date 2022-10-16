package com.ypwang.easy

class Solution2437 {
    fun countTime(time: String): Int {
        if (time == "??:??")
            return 24 * 60

        var res = 1
        if (time[0] == '?' && time[1] == '?')
            res *= 24
        else if (time[0] == '?')
            res *= if (time[1] - '0' >= 4) 2 else 3
        else if (time[1] == '?')
            res *= if (time[0] - '0' >= 2) 4 else 10
        if (time[3] == '?')
            res *= 6
        if (time[4] == '?')
            res *= 10

        return res
    }
}
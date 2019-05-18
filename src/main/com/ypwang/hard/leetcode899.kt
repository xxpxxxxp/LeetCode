package com.ypwang.hard

class Solution899 {
    fun orderlyQueue(S: String, K: Int): String {
        if (K > 1) return S.toList().sorted().joinToString("")

        var min = S
        var cur = S
        for (i in 1 until S.length) {
            cur = cur.substring(1) + cur[0]
            if (cur < min)
                min = cur
        }

        return min
    }
}
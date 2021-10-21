package com.ypwang.easy

class Solution1629 {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var i = 0
        val rst = IntArray(26)

        for ((v, c) in releaseTimes.zip(keysPressed.toList())) {
            val t = c - 'a'
            rst[t] = maxOf(rst[t], v - i)
            i = v
        }

        val t = rst.maxOrNull()!!
        return 'a' + rst.lastIndexOf(t)
    }
}
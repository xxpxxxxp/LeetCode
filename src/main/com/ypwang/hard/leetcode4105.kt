package com.ypwang.hard

class Solution4105 {
    fun repeatedStringMatch(a: String, b: String, x: Int, y: Int): Boolean {
        val an = a.length.toLong() * x
        val bn = b.length.toLong() * y

        if (bn > an)
            return false

        val sb = StringBuilder()
        while (sb.length < a.length + b.length - 1)
            sb.append(a)

        val position = sb.indexOf(b)
        if (position == -1)
            return false

        val req = (position.toLong() + bn + a.length - 1) / a.length
        return req <= x
    }
}

package com.ypwang.medium

class Solution2156 {
    fun subStrHash(s: String, power: Int, modulo: Int, k: Int, hashValue: Int): String {
        var cur = 0L
        var pk = 1L
        var res = 0
        for (i in s.lastIndex downTo 0) {
            cur = (cur * power + (s[i] - 'a') + 1) % modulo
            if (i + k >= s.length)
                pk = pk * power % modulo
            else
                cur = (cur - (s[i + k] - 'a' + 1) * pk % modulo + modulo) % modulo

            if (cur == hashValue.toLong())
                res = i
        }
        return s.substring(res, res + k)
    }
}
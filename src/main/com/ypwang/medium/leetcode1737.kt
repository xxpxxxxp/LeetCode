package com.ypwang.medium

class Solution1737 {
    fun minCharacters(a: String, b: String): Int {
        val ca = IntArray(26)
        val cb = IntArray(26)

        for (c in a)
            ca[c - 'a']++

        for (c in b)
            cb[c - 'a']++

        var way1 = Int.MAX_VALUE
        var way2 = Int.MAX_VALUE
        var suma = ca[0]
        var sumb = cb[0]
        for (i in 1 until 26) {
            way1 = minOf(way1, a.length - suma + sumb)
            way2 = minOf(way2, b.length - sumb + suma)
            suma += ca[i]
            sumb += cb[i]
        }

        val way3 = ca.zip(cb).map { it.first + it.second }.maxOrNull()!!
        return minOf(way1, way2, a.length + b.length - way3)
    }
}
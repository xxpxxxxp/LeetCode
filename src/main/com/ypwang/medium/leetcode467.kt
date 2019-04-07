package com.ypwang.medium

class Solution467 {
    fun findSubstringInWraproundString(p: String): Int {
        if (p.isEmpty())
            return 0

        var pre = p.first()
        var cont = 1
        val map = mutableMapOf(pre to cont)

        for (c in p.drop(1)) {
            if (pre == c-1 || (pre == 'z' && c == 'a')) {
                cont++
            } else {
                cont = 1
            }
            pre = c
            if (pre !in map || map[pre]!! < cont) {
                map[pre] = cont
            }
        }

        return map.map { it.value }.sum()
    }
}

fun main() {
    println(Solution467().findSubstringInWraproundString("zaba"))
}
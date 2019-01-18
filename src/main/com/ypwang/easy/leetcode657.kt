package com.ypwang.easy

class Solution657 {
    fun judgeCircle(moves: String): Boolean {
        var a = 0
        var b = 0
        for (m in moves) {
            when (m) {
                'U'-> a++
                'D'-> a--
                'L'-> b++
                'R'-> b--
            }
        }
        return a + b*0xffff == 0
    }
}

fun main(args: Array<String>) {
    println(Solution657().judgeCircle("LL"))
}
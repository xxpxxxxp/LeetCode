package com.ypwang.easy

class Solution3360 {
    fun canAliceWin(n: Int): Boolean {
        var i = 10
        var j = false
        var n = n

        while (true) {
            if (n < i)
                return j

            n -= i
            i--
            j = !j
        }
    }
}

fun main() {
    println(Solution3360().canAliceWin(12))
}
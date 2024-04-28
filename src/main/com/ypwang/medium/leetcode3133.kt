package com.ypwang.medium

class Solution3133 {
    fun minEnd(n: Int, x: Int): Long {
        val inject = (n-1).toString(2)
        var i = inject.lastIndex
        val c = x.toString(2).toCharArray()
        for (j in c.indices.reversed()) {
            if (c[j] == '0') {
                c[j] = inject[i]
                if (i-- == 0)
                    break
            }
        }

        return if (i >= 0) (inject.substring(0, i+1) + String(c)).toLong(2)
        else String(c).toLong(2)
    }
}

fun main() {
    println(Solution3133().minEnd(3,4))
    println(Solution3133().minEnd(2,7))
}

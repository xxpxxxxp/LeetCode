package com.ypwang.hard

class Solution2147 {
    fun numberOfWays(corridor: String): Int {
        val count = corridor.count { it == 'S' }
        if (count == 0 || count % 2 != 0)
            return 0

        var rst = 1L
        var plants = 1
        var idx = 0
        for (i in 0 until 2) {
            while (corridor[idx++] != 'S')
                continue
        }

        while (idx < corridor.length) {
            val c = corridor[idx++]
            if (c == 'P')
                plants++
            else {
                rst = rst * plants % 1000000007
                plants = 1

                while (corridor[idx++] != 'S')
                    continue
            }
        }

        return rst.toInt()
    }
}

fun main() {
    println(Solution2147().numberOfWays("PPSPSP"))
}
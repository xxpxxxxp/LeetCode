package com.ypwang.hard

class Solution483 {
    private fun canBuild(n: Long, len: Int): Long {
        fun check(base: Long): Long {
            var b = 1L
            var rst = 1L
            for (i in 1 until len) {
                val t = b * base
                if (t / base != b)
                    // overflow! base too big
                    return -1
                b = t

                rst += b
            }

            return when {
                rst == n -> 0
                rst < n -> -2L  // base small
                else -> -1L     // base big
            }
        }

        var min = 2L
        var max = n - 1

        while (min <= max) {
            val mid = min + (max - min) / 2
            when (check(mid)) {
                -1L ->
                    // base big
                    max = mid - 1
                -2L ->
                    // base small
                    min = mid + 1
                else -> return mid
            }
        }

        return -1
    }

    fun smallestGoodBase(n: String): String {
        val bench = n.toLong()
        var len = 0
        for (i in 0 until 64) {
            if (bench and (1L shl i) > 0) {
                len = i+1
            }
        }

        for (i in len downTo 3) {
            val t = canBuild(bench, i)
            if (t > 0) return t.toString()
        }

        return (bench - 1).toString()
    }
}

fun main() {
    println(Solution483().smallestGoodBase("470988884881403701"))
    println(Solution483().smallestGoodBase("13"))
    println(Solution483().smallestGoodBase("4681"))
    println(Solution483().smallestGoodBase("1000000000000000000"))
}
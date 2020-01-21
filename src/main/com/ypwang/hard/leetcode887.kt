package com.ypwang.hard

class Solution887 {
    fun superEggDrop(K: Int, N: Int): Int {
        fun f(x: Int): Int {
            var ans = 0
            var r = 1
            for (i in 1..K) {
                r *= (x - i + 1)
                r /= i
                ans += r
                if (ans >= N) break
            }

            return ans
        }

        var lo = 1
        var hi = N
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (f(mid) < N) lo = mid + 1
            else hi = mid
        }

        return lo
    }
}

fun main() {
    println(Solution887().superEggDrop(1,2))
    println(Solution887().superEggDrop(2,6))
    println(Solution887().superEggDrop(3,14))
}
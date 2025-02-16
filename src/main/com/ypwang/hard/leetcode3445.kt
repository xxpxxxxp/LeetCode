package com.ypwang.hard

class Solution3445 {
    fun maxDifference(s: String, k: Int): Int {
        var ans = Int.MIN_VALUE
        for (a in "01234") {
            for (b in "01234") {
                if (a != b) {
                    val seen = mutableMapOf<Pair<Int, Int>, Int>()
                    val pa = mutableListOf(0)
                    val pb = mutableListOf(0)
                    var ii = 0
                    for ((i, ch) in s.withIndex()) {
                        pa.add(pa.last() + if (ch == a) 1 else 0)
                        pb.add(pb.last() + if (ch == b) 1 else 0)
                        while (ii <= i - k + 1 && pa[ii] < pa.last() && pb[ii] < pb.last()) {
                            val key = Pair(pa[ii] % 2, pb[ii] % 2)
                            seen[key] = minOf(seen.getOrDefault(key, Int.MAX_VALUE), pa[ii] - pb[ii])
                            ii++
                        }
                        val key = Pair(1 - pa.last() % 2, pb.last() % 2)
                        val diff = pa.last() - pb.last()
                        if (key in seen)
                            ans = maxOf(ans, diff - seen[key]!!)
                    }
                }
            }
        }
        return ans
    }
}

fun main() {
    println(Solution3445().maxDifference("12233", 4))
}

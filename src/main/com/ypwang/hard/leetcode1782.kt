package com.ypwang.hard

class Solution1782 {
    fun countPairs(n: Int, edges: Array<IntArray>, qs: IntArray): IntArray? {
        val cnt = IntArray(n + 1)
        val shared: Array<MutableMap<Int, Int>?> = arrayOfNulls(n + 1)
        for ((a, b) in edges) {
            cnt[a]++
            cnt[b]++

            if (shared[minOf(a, b)] == null)
                shared[minOf(a, b)] = mutableMapOf()

            shared[minOf(a, b)]!![maxOf(a, b)] = shared[minOf(a, b)]!!.getOrDefault(maxOf(a, b), 0) + 1
        }

        val sortedCnt = cnt.sorted()
        return qs.withIndex().map { (idx, v) ->
            var t = 0

            var i = 1
            var j = n
            while (i < j) {
                if (v < sortedCnt[i] + sortedCnt[j])
                    t += j-- - i
                else
                    ++i
            }
            for (i in 1..n) {
                if (shared[i] != null) {
                    for ((j, sh_cnt) in shared[i]!!) {
                        if (v < cnt[i] + cnt[j] && v + sh_cnt >= cnt[i] + cnt[j])
                            t--
                    }
                }
            }

            t
        }.toIntArray()
    }
}
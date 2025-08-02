package com.ypwang.medium

class Solution3598 {
    private fun prefix(a: String, b: String): Int {
        val len = minOf(a.length, b.length)
        var cnt = 0
        while (cnt < len && a[cnt] == b[cnt])
            cnt++
        return cnt
    }

    fun longestCommonPrefix(words: Array<String>): IntArray {
        val n = words.size
        val ans = IntArray(n)
        if (n <= 1)
            return ans

        val lcp = IntArray(n - 1)
        var i = 0
        while (i + 1 < n) {
            lcp[i] = prefix(words[i], words[i + 1])
            i++
        }

        val prefmax = IntArray(n - 1)
        val sufmax = IntArray(n - 1)

        prefmax[0] = lcp[0]
        for (i in 1 until n - 1)
            prefmax[i] = maxOf(prefmax[i - 1], lcp[i])

        sufmax[n - 2] = lcp[n - 2]
        for (i in n - 3 downTo 0)
            sufmax[i] = maxOf(sufmax[i + 1], lcp[i])

        for (i in 0..<n) {
            var best = 0
            if (i >= 2)
                best = maxOf(best, prefmax[i - 2])
            if (i + 1 <= n - 2)
                best = maxOf(best, sufmax[i + 1])
            if (i > 0 && i < n - 1)
                best = maxOf(best, prefix(words[i - 1], words[i + 1]))
            ans[i] = best
        }

        return ans
    }
}

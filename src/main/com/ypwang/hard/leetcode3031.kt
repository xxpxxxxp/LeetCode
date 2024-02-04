package com.ypwang.hard

class Solution3031 {
    fun minimumTimeToInitialState(word: String, k: Int): Int {
        var rst = 1
        val n = word.length
        val z = zFunction(word)
        while (k * rst < n) {
            if (z[k * rst] >= n - k * rst)
                break
            ++rst
        }
        return rst
    }

    fun zFunction(s: String): IntArray {
        val n = s.length
        var l = 0
        var r = 0
        val z = IntArray(n)
        for (i in 1 until n) {
            if (i < r)
                z[i] = minOf(r - i, z[i - l])
            while (i + z[i] < n && s[z[i]] == s[i + z[i]])
                z[i] = z[i] + 1
            if (i + z[i] > r) {
                l = i
                r = i + z[i]
            }
        }
        return z
    }
}

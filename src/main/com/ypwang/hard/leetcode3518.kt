package com.ypwang.hard

class Solution3518 {
    fun smallestPalindrome(s: String, k: Int): String {
        val frequency = IntArray(26)
        for (ch in s)
            frequency[ch - 'a']++

        var mid = frequency.withIndex().firstOrNull { it.value % 2 == 1 }?.let { 'a' + it.index }
        val halfFreq = IntArray(26)
        var halfLength = s.length / 2
        for (i in frequency.indices)
            halfFreq[i] = frequency[i] / 2

        val totalPerms = multinomial(halfFreq)
        if (k > totalPerms)
            return ""
        val firstHalfBuilder = StringBuilder()
        var k = k
        for (pos in 0 until halfLength) {
            for (c in halfFreq.indices) {
                if (halfFreq[c] > 0) {
                    halfFreq[c]--
                    val perms = multinomial(halfFreq)
                    if (perms >= k) {
                        firstHalfBuilder.append('a' + c)
                        break
                    } else {
                        k -= perms.toInt()
                        halfFreq[c]++
                    }
                }
            }
        }
        val firstHalf = firstHalfBuilder.toString()
        val revHalf = firstHalf.reversed()
        return if (mid == null) {
            firstHalf + revHalf
        } else {
            firstHalf + mid + revHalf
        }
    }

    companion object {
        const val maxK = 1000001L
    }

    private fun multinomial(counts: IntArray): Long {
        var tot = counts.sum()
        var res = 1L
        for (i in counts.indices) {
            val cnt = counts[i]
            res *= binom(tot, cnt)
            if (res >= maxK)
                return maxK
            tot -= cnt
        }
        return res
    }

    private fun binom(n: Int, k: Int): Long {
        if (k > n)
            return 0
        var k = minOf(k, n-k)
        var result = 1L
        for (i in 1..k) {
            result = result * (n - i + 1) / i
            if (result >= maxK)
                return maxK
        }
        return result
    }
}

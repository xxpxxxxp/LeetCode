package com.ypwang.hard

class Solution3999 {
    fun minimumGroups(words: Array<String>): Int {
        val set = HashSet<String>()

        for (w in words) {
            val even = StringBuilder()
            val odd = StringBuilder()

            for ((i, v) in w.withIndex()) {
                if ((i and 1) == 0)
                    even.append(v)
                else
                    odd.append(v)
            }

            val key = canonical(even.toString()) + "|" + canonical(odd.toString())
            set.add(key)
        }

        return set.size
    }

    private fun canonical(s: String): String {
        val n = s.length
        if (n <= 1)
            return s

        val start = duval(s)
        val t = s + s
        return t.substring(start, start + n)
    }

    private fun duval(s: String): Int {
        val t = s + s
        val n = s.length

        var i = 0
        var ans = 0

        while (i < n) {
            ans = i
            var j = i + 1
            var k = i

            while (j < 2 * n && t[k] <= t[j]) {
                if (t[k] < t[j])
                    k = i
                else
                    k++

                j++
            }

            while (i <= k)
                i += j - k
        }

        return ans
    }
}

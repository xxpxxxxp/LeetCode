package com.ypwang.hard

class Solution3666 {
    fun minOperations(s: String, k: Int): Int {
        val z = s.count { it == '0' }

        val n = s.length
        val o = n - z
        if (z == 0)
            return 0

        for (i in 1..n) {
            val p = i * k.toLong()
            if (((p - z) and 1L) == 1L)
                continue
            if ((i and 1) == 1) {
                if (p >= z && p <= z * i + o * (i - 1))
                    return i
            } else {
                if (p >= z && p <= z * (i - 1) + o * i)
                    return i
            }
        }

        return -1
    }
}

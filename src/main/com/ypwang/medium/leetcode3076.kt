package com.ypwang.medium

class Solution3076 {
    fun shortestSubstrings(arr: Array<String>): Array<String> {
        val hm = mutableMapOf<String, Int>()
        for (s in arr) {
            val hs = mutableSetOf<String>()
            for (j in s.indices) {
                for (k in j + 1..s.length)
                    hs.add(s.substring(j, k))
            }
            for (e in hs)
                hm[e] = hm.getOrDefault(e, 0) + 1
        }

        val rst = mutableListOf<String>()
        for (s in arr) {
            val subs = mutableListOf<String>()
            for (j in s.indices) {
                for (k in j + 1..s.length)
                    if (hm[s.substring(j, k)] == 1)
                        subs.add(s.substring(j, k))
            }
            rst.add(subs.minWithOrNull(compareBy<String> { it.length }.thenBy { it }) ?: "")
        }
        return rst.toTypedArray()
    }
}

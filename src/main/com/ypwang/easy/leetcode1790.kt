package com.ypwang.easy

class Solution1790 {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val idxs = s1.indices.filter { s1[it] != s2[it] }

        if (idxs.isEmpty())
            return true

        if (idxs.size != 2)
            return false

        val (a, b) = idxs
        return s1[a] == s2[b] && s1[b] == s2[a]
    }
}
package com.ypwang.easy

class Solution3146 {
    fun findPermutationDifference(s: String, t: String): Int {
        val c = IntArray(26)
        s.withIndex().forEach { (i, v) -> c[v-'a'] = i }
        return t.withIndex().map { (i, v) -> Math.abs(i - c[v-'a']) }.sum()!!
    }
}

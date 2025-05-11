package com.ypwang.easy

class Solution3545 {
    fun minDeletion(s: String, k: Int): Int =
        s.groupBy { it }.map { it.value.size }.sortedDescending().drop(k).sum()
}

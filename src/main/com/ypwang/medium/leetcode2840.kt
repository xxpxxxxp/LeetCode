package com.ypwang.medium

class Solution2840 {
    fun checkStrings(s1: String, s2: String): Boolean =
        s1.withIndex().partition { it.index % 2 == 0 }.let { it.first.map { kv -> kv.value }.sorted() to it.second.map { kv -> kv.value }.sorted() } ==
                s2.withIndex().partition { it.index % 2 == 0 }.let { it.first.map { kv -> kv.value }.sorted() to it.second.map { kv -> kv.value }.sorted() }
}
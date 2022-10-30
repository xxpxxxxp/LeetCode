package com.ypwang.medium

class Solution2452 {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> =
        queries.filter { q ->
            dictionary.any { d ->
                q.zip(d).count { it.first != it.second } <= 2
            }
        }
}
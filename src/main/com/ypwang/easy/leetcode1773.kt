package com.ypwang.easy

class Solution1773 {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val idx = when (ruleKey) {
            "type" -> 0
            "color" -> 1
            "name" -> 2
            else -> throw Exception("impossible")
        }

        return items.count { it[idx] == ruleValue }
    }
}
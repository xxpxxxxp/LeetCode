package com.ypwang.easy

class Solution3606 {
    fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> =
        code.zip(businessLine).zip(isActive.toTypedArray())
            .filter { it.second }
            .filter { it.first.second in setOf("electronics", "grocery", "pharmacy", "restaurant") }
            .filter { it.first.first.isNotEmpty() && it.first.first.all { c -> c.isLetter() || c.isDigit() || c == '_' } }
            .sortedWith(compareBy<Pair<Pair<String, String>, Boolean>> { it.first.second }.thenBy { it.first.first })
            .map { it.first.first }
}

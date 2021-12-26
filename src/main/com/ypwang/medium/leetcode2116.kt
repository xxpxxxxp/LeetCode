package com.ypwang.medium

class Solution2116 {
    private fun validate(s: String, locked: String, op: Char): Boolean {
        var credit = 0
        var stack = 0
        for ((i, c) in locked.withIndex()) {
            when (c) {
                '0' ->
                    credit++
                '1' -> {
                    stack += if (s[i] == op) 1 else -1
                }
            }

            if (credit + stack < 0)
                return false
        }

        return stack <= credit
    }

    fun canBeValid(s: String, locked: String): Boolean =
        s.length % 2 == 0 && validate(s, locked, '(') && validate(s.reversed(), locked.reversed(), ')')
}
package com.ypwang.medium

class Solution2337 {
    fun canChange(start: String, target: String): Boolean {
        val s = start.withIndex().filter { it.value == 'L' || it.value == 'R' }
        val t = target.withIndex().filter { it.value == 'L' || it.value == 'R' }
        if (s.size != t.size)
            return false

        return s.zip(t).all { (m, n) ->
            m.value == n.value && (
                    if (m.value == 'L')
                        m.index >= n.index
                    else
                        m.index <= n.index
            )
        }
    }
}
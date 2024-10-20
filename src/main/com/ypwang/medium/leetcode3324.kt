package com.ypwang.medium

class Solution3324 {
    fun stringSequence(target: String): List<String> {
        val rst = mutableListOf<String>()
        var base = StringBuffer()
        for (c in target) {
            for (i in 0..(c-'a')) {
                base.append('a' + i)
                rst.add(base.toString())
                base.deleteCharAt(base.lastIndex)
            }
            base.append(c)
        }

        return rst
    }
}

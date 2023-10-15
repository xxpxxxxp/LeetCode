package com.ypwang.easy

class Solution2899 {
    fun lastVisitedIntegers(words: List<String>): List<Int> {
        val ov = mutableListOf<Int>()
        val rst = mutableListOf<Int>()
        var ci = -1
        for (s in words) {
            if (s == "prev") {
                rst.add(
                    if (ci == -1) -1
                    else ov[ci--]
                )
            } else {
                ci = ov.size
                ov.add(s.toInt())
            }
        }
        return rst
    }
}
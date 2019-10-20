package com.ypwang.easy

class Solution1221 {
    fun balancedStringSplit(s: String): Int {
        var rst = 0
        var count = 0

        for (c in s) {
            if (c == 'R') count++ else count--
            if (count == 0) rst++
        }

        return rst
    }
}
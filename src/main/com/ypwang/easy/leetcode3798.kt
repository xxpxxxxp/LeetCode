package com.ypwang.easy

class Solution3798 {
    fun largestEven(s: String): String {
        var j = s.lastIndex
        while (j >= 0 && s[j] == '1')
            j--

        return s.substring(0, j+1)
    }
}

package com.ypwang.easy

class Solution3090 {
    fun maximumLengthSubstring(s: String): Int {
        var rst = 0
        var i = 0
        var j = 0
        val count = IntArray(26)

        while (j < s.length) {
            val c = s[j++]
            count[c-'a']++
            while (count[c-'a'] > 2)
                count[s[i++]-'a']--

            rst = maxOf(j-i, rst)
        }

        return rst
    }
}

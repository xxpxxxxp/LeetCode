package com.ypwang.easy

class Solution3083 {
    fun isSubstringPresent(s: String): Boolean {
        val r = s.reversed()
        for (i in 0 until s.length-1) {
            if (r.contains(s.substring(i, i+2)))
                return true
        }

        return false
    }
}

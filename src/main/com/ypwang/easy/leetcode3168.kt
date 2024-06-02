package com.ypwang.easy

class Solution3168 {
    fun minimumChairs(s: String): Int =
        s.fold(0 to 0) { (cur, max), c ->
            if (c == 'E') {
                cur+1 to maxOf(max, cur+1)
            } else {
                cur-1 to max
            }
        }.second
}

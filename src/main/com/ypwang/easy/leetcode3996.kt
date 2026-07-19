package com.ypwang.easy

class Solution3996 {
    fun canReach(start: IntArray, target: IntArray): Boolean =
        ((start[0] + start[1]) and 1) == ((target[0] + target[1]) and 1)
}

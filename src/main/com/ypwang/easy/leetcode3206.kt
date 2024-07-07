package com.ypwang.easy

class Solution3206 {
    fun numberOfAlternatingGroups(colors: IntArray): Int =
        colors.withIndex().count { (i, v) ->
            v != colors[(i - 1 + colors.size) % colors.size] &&
                    v != colors[(i + 1 + colors.size) % colors.size]
        }
}

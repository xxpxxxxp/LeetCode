package com.ypwang.easy

class Solution3340 {
    fun isBalanced(num: String): Boolean =
        num.withIndex().partition { it.index % 2 == 0 }.let { (a, b) ->
            a.map { it.value - '0' }.sum()!! == b.map { it.value - '0' }.sum()!!
        }
}

package com.ypwang.easy

class Solution3959 {
    fun checkGoodInteger(n: Int): Boolean =
        n.toString().map { it - '0' }.let { s ->
            s.map { it * it }.sum() - s.sum() >= 50
        }
}

package com.ypwang.easy

class Solution3536 {
    fun maxProduct(n: Int): Int =
        n.toString().toCharArray().sortedDescending().let {
            (it[0] - '0') * (it[1] - '0')
    }
}

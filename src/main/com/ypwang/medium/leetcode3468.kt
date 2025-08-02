package com.ypwang.medium

class Solution3468 {
    fun countArrays(original: IntArray, bounds: Array<IntArray>): Int =
        original.zip(bounds).fold(Int.MIN_VALUE to Int.MAX_VALUE) { (pl, pu), (o, b) ->
            val (l, u) = b
            val nl = l - o
            val nu = u - o

            if (nl > pu || pl > nu)
                return 0

            maxOf(pl, nl) to minOf(pu, nu)
        }.let { it.second - it.first + 1 }
}

fun main() {
    println(
        Solution3468().countArrays(
            intArrayOf(1, 2, 3, 4),
            arrayOf(
                intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5)
            )
        )
    )
}

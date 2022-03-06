package com.ypwang.medium

class Solution2191 {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray =
        nums.sortedBy {
            if (it == 0)
                return@sortedBy mapping[0]

            var i = it
            var j = 0
            var p = 1
            while (i != 0) {
                j += p * mapping[i % 10]
                p *= 10
                i /= 10
            }
            j
        }.toIntArray()
}

fun main() {
    println(Solution2191().sortJumbled(intArrayOf(9,8,7,6,5,4,3,2,1,0), intArrayOf(0,1,2,3,4,5,6,7,8,9)))
}
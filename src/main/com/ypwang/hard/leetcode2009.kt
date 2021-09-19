package com.ypwang.hard

class Solution2009 {
    fun minOperations(nums: IntArray): Int {
        val unique = nums.toSet().sorted().toTypedArray()
        return unique.withIndex().fold(Int.MAX_VALUE to 0) { (min, searchIdx), (idx, v) ->
            if (min == 0)
                return 0

            val end = unique.binarySearch(v + nums.size - 1, searchIdx).let {
                if (it < 0) -it-2
                else it
            }

            minOf(min, nums.size - (end - idx + 1)) to end
        }.first
    }
}

fun main() {
    println(Solution2009().minOperations(intArrayOf(8,5,9,9,8,4)))
    println(Solution2009().minOperations(intArrayOf(4,2,5,3)))
    println(Solution2009().minOperations(intArrayOf(1,2,3,5,6)))
    println(Solution2009().minOperations(intArrayOf(1,10,100,1000)))
}
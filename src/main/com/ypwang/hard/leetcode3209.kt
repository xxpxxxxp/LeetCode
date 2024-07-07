package com.ypwang.hard

class Solution3209 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var cnt = mutableMapOf<Int, Int>()
        var rst = 0L
        for (n in nums) {
            val newCnt = mutableMapOf<Int, Int>()
            if ((n and k) == k) {
                newCnt[n] = 1
                for ((v, count) in cnt.entries)
                    newCnt[v and n] = newCnt.getOrDefault(v and n, 0) + count

                rst += newCnt[k]?.toLong() ?: 0L
            }
            cnt = newCnt
        }
        return rst
    }
}

fun main() {
    println(Solution3209().countSubarrays(intArrayOf(1,1,1), 1))
    println(Solution3209().countSubarrays(intArrayOf(1,1,2), 1))
    println(Solution3209().countSubarrays(intArrayOf(1,2,3), 2))
}

package com.ypwang.hard

class Solution3098 {
    data class Tuple4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4)

    fun sumOfPowers(nums: IntArray, k: Int): Int {
        nums.sort()

        // current idx, minDiff, last chosen value
        val memo = mutableMapOf<Tuple4<Int, Int, Int, Int>, Int>()
        fun dp(idx: Int, minDiff: Int, lastChooseIdx: Int, leftK: Int): Int {
            if (leftK == 0)
                return minDiff
            if (idx == nums.size)
                return 0

            return memo.getOrPut(Tuple4(idx, minDiff, lastChooseIdx, leftK)) {
                val choose = dp(idx + 1,
                    if (lastChooseIdx == -1)
                        Int.MAX_VALUE
                    else
                        minOf(minDiff, nums[idx] - nums[lastChooseIdx]), idx, leftK - 1)
                val notChoose = dp(idx + 1, minDiff, lastChooseIdx, leftK)
                (choose + notChoose) % 1000000007
            }
        }

        return dp(0, Int.MAX_VALUE, -1, k)
    }
}

fun main() {
    println(Solution3098().sumOfPowers(intArrayOf(-8,-5,-2,4), 4))
    println(Solution3098().sumOfPowers(intArrayOf(4,3,-1), 2))
}

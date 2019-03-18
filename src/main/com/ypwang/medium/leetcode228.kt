package com.ypwang.medium

class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        fun helper(start: Int, end: Int): List<Pair<Int, Int>> {
            if (nums[end] - nums[start] == end - start) {
                return listOf(Pair(start, end - start))
            }

            val mid = (end - start) / 2 + start
            val left = helper(start, mid)
            val right = helper(mid + 1, end)

            return if (nums[left.last().first] + left.last().second + 1 == nums[right.first().first]) {
                val t = left.last()
                left.dropLast(1) + Pair(t.first, t.second + 1 + right.first().second) + right.drop(1)
            } else {
                left + right
            }
        }

        return if (nums.isEmpty()) listOf()
        else helper(0, nums.lastIndex).map { if (it.second == 0) nums[it.first].toString() else "${nums[it.first]}->${nums[it.first] + it.second}" }
    }
}

fun main() {
    println(Solution228().summaryRanges(intArrayOf(0,2,3,4,6,8,9)))
}
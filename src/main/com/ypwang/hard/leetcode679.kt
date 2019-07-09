package com.ypwang.hard

class Solution679 {
    private fun solve(nums: ArrayList<Double>): Boolean {
        if (nums.size == 0) return false
        if (nums.size == 1) return Math.abs(nums[0] - 24) < 1e-6

        for (i in 0 until nums.size) {
            for (j in 0 until nums.size) {
                if (i == j) continue

                val left = ArrayList<Double>()

                for (k in 0 until nums.size) {
                    if (k != i && k != j)
                        left.add(nums[k])
                }

                label@ for (k in 0 until 4) {
                    if (k < 2 && j > i) continue
                    when (k) {
                        0 -> left.add(nums[i] + nums[j])
                        1 -> left.add(nums[i] * nums[j])
                        2 -> left.add(nums[i] - nums[j])
                        3 -> {
                            if (nums[j] == 0.0) continue@label
                            left.add(nums[i] / nums[j])
                        }
                    }

                    if (solve(left)) return true
                    left.removeAt(left.lastIndex)
                }
            }
        }

        return false
    }

    fun judgePoint24(nums: IntArray): Boolean {
        return solve(ArrayList(nums.map { it.toDouble() }))
    }
}

fun main() {
    println(Solution679().judgePoint24(intArrayOf(1,2,1,2)))
}
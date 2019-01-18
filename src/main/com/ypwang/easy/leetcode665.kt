package com.ypwang.easy

class Solution665 {
    fun helper(nums: List<Int>): Int {
        for (i in 0 until nums.size-1) {
            if (nums[i] > nums[i+1]) {
                return i
            }
        }
        return nums.size
    }

    fun checkPossibility(nums: IntArray): Boolean {
        val n = nums.toMutableList()
        val b = helper(n)
        if (b == n.size) {
            return true
        }

        val np = n.toMutableList()
        np.removeAt(b)
        if (helper(np) == np.size) {
            return true
        }

        val nq = n.toMutableList()
        nq.removeAt(b+1)
        if (helper(nq) == nq.size) {
            return true
        }

        return false
    }
}

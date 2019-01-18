package com.ypwang.medium

class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()

        fun helper(l: MutableList<Int>, remain: MutableSet<Int>) {
            if (remain.isEmpty()) {
                rst.add(l.toList())
                return
            }

            val t = remain.toList()
            for (r in t) {
                l.add(r)
                remain.remove(r)
                helper(l, remain)
                remain.add(r)
                l.removeAt(l.lastIndex)
            }
        }

        helper(mutableListOf(), nums.toMutableSet())
        return rst
    }
}
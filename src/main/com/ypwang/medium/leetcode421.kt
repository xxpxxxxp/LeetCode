package com.ypwang.medium

class Solution421 {
    class TreeNode(val bit: Int) {
        var left0: TreeNode? = null
        var right1: TreeNode? = null
    }

    fun findMaximumXOR(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        var root = TreeNode(32)

        fun build(num: Int) {
            var r = root
            var bit = 31
            while (bit >= 0) {
                if ((1 shl bit) and num == 0) {
                    if (r.left0 == null) {
                        r.left0 = TreeNode(bit)
                    }
                    r = r.left0!!
                } else {
                    if (r.right1 == null) {
                        r.right1 = TreeNode(bit)
                    }
                    r = r.right1!!
                }
                bit --
            }
        }

        nums.forEach { build(it) }

        while (root.right1 == null) {
            root = root.left0!!
        }

        fun find(num: Int): Int {
            var r: TreeNode? = root
            var final = 0

            while (r != null) {
                if (r!!.left0 == null && r!!.right1 == null) {
                    return final
                }

                val bit = r!!.bit - 1
                val bitmask = num and (1 shl bit) == 0

                if (r!!.left0 == null || (r!!.right1 != null && bitmask)) {
                    r = r!!.right1
                    final = final or (1 shl bit)
                } else {
                    r = r!!.left0
                }
            }

            return final
        }

        return nums.filter { it and (1 shl (root.bit - 1)) != 0 }.map { find(it) xor it }.max()!!
    }
}

fun main() {
    println(Solution421().findMaximumXOR(intArrayOf(0)))
}
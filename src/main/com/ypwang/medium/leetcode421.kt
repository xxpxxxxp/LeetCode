package com.ypwang.medium

import com.ypwang.TreeNode

class Solution421 {
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
                    if (r.left == null) {
                        r.left = TreeNode(bit)
                    }
                    r = r.left!!
                } else {
                    if (r.right == null) {
                        r.right = TreeNode(bit)
                    }
                    r = r.right!!
                }
                bit --
            }
        }

        nums.forEach { build(it) }

        while (root.right == null) {
            root = root.left!!
        }

        fun find(num: Int): Int {
            var r: TreeNode? = root
            var final = 0

            while (r != null) {
                if (r!!.left == null && r!!.right == null) {
                    return final
                }

                val bit = r!!.`val` - 1
                val bitmask = num and (1 shl bit) == 0

                if (r!!.left == null || (r!!.right != null && bitmask)) {
                    r = r!!.right
                    final = final or (1 shl bit)
                } else {
                    r = r!!.left
                }
            }

            return final
        }

        return nums.filter { it and (1 shl (root.`val` - 1)) != 0 }.map { find(it) xor it }.max()!!
    }
}

fun main() {
    println(Solution421().findMaximumXOR(intArrayOf(0)))
}
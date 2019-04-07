package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1008 {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        // [start, end)
        fun helper(array: IntArray, start: Int, end: Int): TreeNode? {
            if (start == end) {
                return null
            }

            val t = TreeNode(array[start])
            var l = start + 1
            var r = end

            while (l < r) {
                val mid = (r - l) / 2 + l
                if (array[mid] < t.`val`) {
                    l = mid + 1
                } else {
                    r = mid
                }
            }

            t.left = helper(array, start + 1, l)
            t.right = helper(array, l, end)

            return t
        }

        return helper(preorder, 0, preorder.size)
    }
}

fun main() {
    println(Solution1008().bstFromPreorder(intArrayOf(8,5,1,7,10,12)))
}
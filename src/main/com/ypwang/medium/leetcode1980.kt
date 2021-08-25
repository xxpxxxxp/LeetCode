package com.ypwang.medium

class Solution1980 {
    class Node {
        var left: Node? = null
        var right: Node? = null
    }

    fun findDifferentBinaryString(nums: Array<String>): String {
        val root = Node()

        for (num in nums) {
            var cur = root
            for (c in num) {
                cur = when (c) {
                    '0' -> {
                        if (cur.left == null)
                            cur.left = Node()

                        cur.left!!
                    }
                    else -> {
                        if (cur.right == null)
                            cur.right = Node()

                        cur.right!!
                    }
                }
            }
        }

        val sb = mutableListOf<Char>()

        fun helper(cur: Node, depth: Int, total: Int): Boolean {
            if (depth == total)
                return false

            for ((node, c) in listOf(cur.left to '0', cur.right to '1')){
                sb.add(c)

                if (node == null) {
                    return true
                }

                val next = helper(cur.left!!, depth+1, total)
                if (next)
                    return true

                sb.removeAt(sb.lastIndex)
            }

            return false
        }

        val total = nums.first().length
        helper(root, 0, total)

        return sb.joinToString("") + (0 until total - sb.size).map { '1' }.joinToString("")
    }
}

fun main() {
    println(Solution1980().findDifferentBinaryString(arrayOf(
        "01","10"
    )))
    println(Solution1980().findDifferentBinaryString(arrayOf(
        "00","01"
    )))
    println(Solution1980().findDifferentBinaryString(arrayOf(
        "111","011","001"
    )))
}
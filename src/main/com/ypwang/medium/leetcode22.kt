package com.ypwang.medium

class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val rst = mutableListOf<String>()

        fun helper(s: MutableList<Char>, left: Int, right: Int, stack: Int) {
            if (left == 0 && stack == 0) {
                rst.add(s.joinToString(""))
            }

            if (left > 0) {
                s.add('(')
                helper(s, left - 1, right, stack + 1)
                s.removeAt(s.lastIndex)
            }

            if (right > 0 && stack > 0) {
                s.add(')')
                helper(s, left, right - 1, stack - 1)
                s.removeAt(s.lastIndex)
            }
        }

        helper(mutableListOf('('), n - 1, n, 1)
        return rst
    }
}

fun main() {
    println(Solution22().generateParenthesis(3))
}
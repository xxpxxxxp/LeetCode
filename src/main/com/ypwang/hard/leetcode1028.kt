package com.ypwang.hard

import com.ypwang.TreeNode
import java.util.*

class Solution1028 {
    fun recoverFromPreorder(S: String): TreeNode? {
        val stack = Stack<Pair<TreeNode, Int>>()
        val dummy = TreeNode(0)
        stack.push(dummy to -1)

        var i = 0
        while (i < S.length) {
            var depth = 0
            while (i < S.length && S[i] == '-') {
                depth++
                i++
            }

            var number = 0
            while (i < S.length && S[i].isDigit()) {
                number = number * 10 + (S[i] - '0')
                i++
            }

            while (stack.peek().second >= depth)
                stack.pop()

            val t = stack.peek()
            val n = TreeNode(number)
            if (t.first.left == null) t.first.left = n
            else t.first.right = n

            stack.push(n to depth)
        }

        return dummy.left
    }
}

fun main() {
    println(Solution1028().recoverFromPreorder("1-2--3--4-5--6--7"))
}
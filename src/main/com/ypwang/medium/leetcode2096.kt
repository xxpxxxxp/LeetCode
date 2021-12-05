package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution2096 {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val startChain = mutableListOf<Pair<TreeNode, Char>>()
        val destChain = mutableListOf<Pair<TreeNode, Char>>()

        val chain = Stack<Pair<TreeNode, Char>>()
        chain.add(root!! to 'Z')
        fun helper(r: TreeNode?) {
            if (r == null)
                return

            if (r.`val` == startValue) {
                startChain.addAll(chain)
            }

            if (r.`val` == destValue) {
                destChain.addAll(chain)
            }

            if (startChain.isNotEmpty() && destChain.isNotEmpty())
                return

            chain.push(r.left to 'L')
            helper(r.left)
            chain.pop()

            chain.push(r.right to 'R')
            helper(r.right)
            chain.pop()
        }

        helper(root)

        val skip = startChain.zip(destChain).filter { it.first.first.`val` == it.second.first.`val` }.size
        return (skip until startChain.size).map { 'U' }.joinToString("") + destChain.drop(skip).map { it.second }.joinToString("")
    }
}
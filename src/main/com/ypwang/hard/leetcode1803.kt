package com.ypwang.hard

class Solution1803 {
    fun countPairs(nums: IntArray, low: Int, high: Int): Int {
        val root = TrieNode()
        var cntPairs = 0
        for (n in nums) {
            cntPairs += cntSmaller(root, n, high + 1) - cntSmaller(root, n, low)
            insertTrie(root, n)
        }
        return cntPairs
    }

    private fun cntSmaller(root: TrieNode, N: Int, K: Int): Int {
        var current: TrieNode? = root
        var cntPairs = 0
        var i = 31
        while (i >= 0 && current != null) {
            val x = (N shr i) and 1
            val y = (K shr i) and 1
            if (y == 1) {
                if (current.child[x] != null) cntPairs += current.child[x]!!.cnt
                current = current.child[1 - x]
            } else
                current = current.child[x]
            i--
        }
        return cntPairs
    }

    inner class TrieNode {
        var child = arrayOfNulls<TrieNode>(2)
        var cnt = 0
    }

    private fun insertTrie(root: TrieNode, N: Int) {
        var current: TrieNode? = root
        for (i in 31 downTo 0) {
            val x = (N shr i) and 1
            if (current!!.child[x] == null) {
                current.child[x] = TrieNode()
            }
            current.child[x]!!.cnt += 1
            current = current.child[x]
        }
    }
}
package com.ypwang.medium

class Solution3670 {
    class TrieNode {
        val child = arrayOfNulls<TrieNode>(2)
        var maxVal: Int = -1
    }

    class Trie {
        private val root = TrieNode()

        fun insert(num: Int) {
            var cur = root
            cur.maxVal = maxOf(cur.maxVal, num)
            for (bit in 20 downTo 0) {
                val b = (num shr bit) and 1
                if (cur.child[b] == null)
                    cur.child[b] = TrieNode()
                cur = cur.child[b]!!
                cur.maxVal = maxOf(cur.maxVal, num)
            }
        }

        private fun search(node: TrieNode?, num: Int, bit: Int): Int {
            if (node == null)
                return -1
            if (bit < 0)
                return node.maxVal

            val b = (num shr bit) and 1
            return if (b == 1)
                search(node.child[0], num, bit - 1)
            else
                maxOf(search(node.child[0], num, bit - 1), search(node.child[1], num, bit - 1))
        }

        fun findPartner(num: Int): Int = search(root, num, 20)
    }

    fun maxProduct(nums: IntArray): Long {
        val trie = Trie()
        var ans = 0L
        for (num in nums) {
            val partner = trie.findPartner(num)
            if (partner != -1 && (num and partner) == 0)
                ans = maxOf(ans, 1L * num * partner)

            trie.insert(num)
        }
        return ans
    }
}

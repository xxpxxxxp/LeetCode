package com.ypwang.hard

class Solution2935 {
    class Trie {
        val sub = Array<Trie?>(2) { null }

        fun add(num: Int, idx: Int) {
            if (idx == -1)
                return

            val v = (num shr idx) and 0x1
            if (sub[v] == null)
                sub[v] = Trie()
            sub[v]!!.add(num, idx-1)
        }

        fun erase(num: Int, idx: Int): Boolean {
            if (idx == -1)
                return true

            val v = (num shr idx) and 0x1
            if (sub[v] != null && sub[v]!!.erase(num, idx-1))
                sub[v] = null
            return sub.all { it == null }
        }

        fun maxXor(num: Int, idx: Int): Int {
            if (idx == -1)
                return 0

            val v = (num shr idx) and 0x1
            return if (sub[v xor 0x1] != null)
                sub[v xor 0x1]!!.maxXor(num, idx-1) + (1 shl idx)
            else
                sub[v]!!.maxXor(num, idx-1)
        }
    }

    fun maximumStrongPairXor(nums: IntArray): Int {
        nums.sort()
        val maxIdx = 19
        val trie = Trie()
        var rst = 0
        var idx = 0
        for (x in nums) {
            trie.add(x, maxIdx)
            while (idx < nums.size && 2 * nums[idx] < x) {
                trie.erase(nums[idx], maxIdx)
                ++idx
            }
            rst = maxOf(rst, trie.maxXor(x, maxIdx))
        }
        return rst
    }
}

fun main() {
    println(Solution2935().maximumStrongPairXor(intArrayOf(1,1,3)))
}
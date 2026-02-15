package com.ypwang.hard

import kotlin.collections.ArrayDeque

class Solution3845 {
    companion object {
        const val mb = 20
    }

    class Node {
        var children: Array<Node?> = arrayOfNulls<Node>(2)
        var count = 0
    }

    var root = Node()

    fun add(v: Int) {
        var current = root
        var i = mb

        while (i >= 0) {
            val bit = (v shr i) and 1

            if (current.children[bit] == null)
                current.children[bit] = Node()

            current = current.children[bit]!!
            current.count++
            i--
        }
    }
    
    fun del(v: Int) {
        var cu = root
        var i = mb
        while (i >= 0) {
            val bit = (v shr i) and 1
            cu = cu.children[bit]!!
            cu.count--
            i--
        }
    }

    fun query(v: Int): Int {
        var cu: Node? = root
        var an = 0
        var i = mb

        while (i >= 0) {
            val bit = (v shr i) and 1
            val wt = 1 - bit

            if (cu?.children[wt] != null && cu.children[wt]!!.count > 0) {
                an = an or (1 shl i)
                cu = cu.children[wt]
            } else {
                cu = cu?.children[bit]
            }
            
            if (cu == null)
                return an

            i--
        }
        return an
    }

    fun maxXor(nums: IntArray, k: Int): Int {
        val n = nums.size
        val prefix = IntArray(n + 1)
        var i = 0
        while (i < n) {
            prefix[i + 1] = prefix[i] xor nums[i]
            i++
        }
        val min = ArrayDeque<Int>()
        val max = ArrayDeque<Int>()
        var rst = 0
        var l = 0
        var r = 0
        while (r < n) {
            while (min.isNotEmpty() && nums[min.last()] >= nums[r])
                min.removeLast()

            min.addLast(r)

            while (max.isNotEmpty() && nums[max.last()] <= nums[r])
                max.removeLast()

            max.addLast(r)

            add(prefix[r])
            while (min.isNotEmpty() && max.isNotEmpty() && nums[max.first()] - nums[min.first()] > k) {
                del(prefix[l])
                l++
                if (min.isNotEmpty() && min.first() < l)
                    min.removeFirst()
                if (max.isNotEmpty() && max.first() < l)
                    max.removeFirst()
            }

            rst = maxOf(rst, query(prefix[r + 1]))
            r++
        }

        return rst
    }
}

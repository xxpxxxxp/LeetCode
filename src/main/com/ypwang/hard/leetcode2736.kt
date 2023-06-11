package com.ypwang.hard

import java.util.*

class Solution2736 {
    fun maximumSumQueries(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
        val sumToNum1 = TreeMap<Int, TreeSet<Int>>()
        for (i in nums1.indices) {
            val num1 = nums1[i]
            val num2 = nums2[i]
            sumToNum1.getOrPut(num1 + num2) { TreeSet() }.add(num1)
        }
        return IntArray(queries.size) { getMax(sumToNum1, queries[it]) }
    }

    private fun getMax(treeMap: TreeMap<Int, TreeSet<Int>>, q: IntArray): Int {
        val (x, y) = q
        var sum = treeMap.lastKey()
        while (sum != null) {
            val num1Set = treeMap[sum]!!
            var num1 = num1Set.last()
            while (num1 != null && num1 >= x) {
                val num2 = sum - num1
                if (num2 >= y) {
                    return sum
                }
                num1 = num1Set.lower(num1)
            }
            sum = treeMap.lowerKey(sum)
        }
        return -1
    }
}
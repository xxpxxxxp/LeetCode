package com.ypwang.hard

import java.util.*

class Solution2926 {
    fun maxBalancedSubsequenceSum(nums: IntArray): Long {
        val arr = IntArray(nums.size) { nums[it] - it }
        val map = TreeMap<Int, Long>()
        var rst = Long.MIN_VALUE
        for ((i, v) in nums.withIndex()) {
            if (v <= 0)
                rst = maxOf(rst, v.toLong())
            else {
                var tmp = v.toLong()
                if (map.floorKey(arr[i]) != null)
                    tmp += map[map.floorKey(arr[i])]!!
                while (map.ceilingKey(arr[i]) != null && map[map.ceilingKey(arr[i])]!! < tmp)
                    map.remove(map.ceilingKey(arr[i]))
                if (map.floorKey(arr[i]) == null || map[map.floorKey(arr[i])]!! < tmp)
                    map[arr[i]] = tmp
                rst = maxOf(rst, tmp)
            }
        }
        return rst
    }
}
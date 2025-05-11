package com.ypwang.hard

class Solution3544 {
    fun subtreeInversionSum(edges: Array<IntArray>, nums: IntArray, k: Int): Long {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges) {
            map.getOrPut(a, { mutableListOf() }).add(b)
            map.getOrPut(b, { mutableListOf() }).add(a)
        }

        return rec(
            map,
            nums,
            0,
            -1,
            0,
            0,
            k,
            Array(nums.size) { Array(2) { LongArray(k) { Long.MIN_VALUE } } })
    }

    private fun rec(
        map: MutableMap<Int, MutableList<Int>>,
        nums: IntArray,
        node: Int,
        parent: Int,
        numInversions: Int,
        depth: Int,
        k: Int,
        dp: Array<Array<LongArray>>
    ): Long {
        if (dp[node][numInversions][depth] != Long.MIN_VALUE)
            return dp[node][numInversions][depth]

        var flip = Int.MIN_VALUE.toLong()
        if (depth == 0) {
            flip = ((if (numInversions % 2 == 1) 1 else -1) * nums[node]).toLong()
            for (child in map.getOrDefault(node, listOf()))
                if (child != parent)
                    flip += rec(map, nums, child, node, (numInversions + 1) % 2, k - 1, k, dp)
        }
        var skip = ((if (numInversions % 2 == 0) 1 else -1) * nums[node]).toLong()
        for (child in map.getOrDefault(node, listOf()))
            if (child != parent)
                skip += rec(map, nums, child, node, numInversions, maxOf(0, depth - 1), k, dp)

        return maxOf(flip, skip).also { dp[node][numInversions][depth] = it }
    }
}

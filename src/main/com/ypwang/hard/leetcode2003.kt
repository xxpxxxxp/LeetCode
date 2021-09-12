package com.ypwang.hard

class Solution2003 {
    fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
        val n = parents.size
        val rst = IntArray(n) {1}
        if (!nums.contains(1))
            return rst

        val seen = BooleanArray(100010)
        val children = Array(n) { mutableListOf<Int>() }
        for ((i, v) in parents.withIndex())
            if (v != -1)
                children[v].add(i)

        fun dfs(i: Int) {
            if (!seen[nums[i]]) {
                for (j in children[i])
                    dfs(j)

                seen[nums[i]] = true
            }
        }

        var idx = nums.indexOf(1)
        var miss = 1
        while (idx >= 0) {
            dfs(idx)
            while (seen[miss])
                miss++

            rst[idx] = miss
            idx = parents[idx]
        }

        return rst
    }
}
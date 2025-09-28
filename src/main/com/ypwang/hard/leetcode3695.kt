package com.ypwang.hard

class Solution3695 {
    fun maxAlternatingSum(nums: IntArray, swaps: Array<IntArray>): Long {
        val dsu = IntArray(nums.size) { it }

        fun root(i: Int): Int {
            if (i != dsu[i]) dsu[i] = root(dsu[i])
            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        // Union the indices in each swap
        for ((a, b) in swaps)
            union(a, b)

        val parents = mutableSetOf<Int>()
        val oddCount = mutableMapOf<Int, Int>()
        val grp = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until nums.size) {
            val p = root(i)
            parents.add(p)
            grp.getOrPut(p) { mutableListOf() }.add(nums[i])
            if (i % 2 == 1)
                oddCount[p] = oddCount.getOrDefault(p, 0) + 1
        }

        var ans = 0L
        for (x in parents) {
            val odd = oddCount.getOrDefault(x, 0)
            val group = grp[x]!!.sorted()

            var evenSum = 0L
            var oddSum = 0L

            for (i in 0 until odd)
                oddSum += group[i]

            // remaining are for even indices
            for (i in odd until group.size)
                evenSum += group[i]

            ans += (evenSum - oddSum)
        }

        return ans
    }
}

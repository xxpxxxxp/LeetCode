package com.ypwang.hard

class Solution3378 {
    private class UnionFind(n: Int) {
        private val parent: IntArray = IntArray(n) { it }
        private val rank: IntArray = IntArray(n)
        var totalComponents: Int = n

        fun find(u: Int): Int {
            if (parent[u] == u)
                return u

            parent[u] = find(parent[u])
            return parent[u]
        }

        fun union(u: Int, v: Int) {
            val parentU = find(u)
            val parentV = find(v)

            if (parentU != parentV) {
                totalComponents--
                when {
                    rank[parentU] == rank[parentV] -> {
                        parent[parentV] = parentU
                        rank[parentU]++
                    }
                    rank[parentU] > rank[parentV] -> {
                        parent[parentV] = parentU
                    }
                    else -> {
                        parent[parentU] = parentV
                    }
                }
            }
        }
    }

    fun countComponents(nums: IntArray, threshold: Int): Int {
        val goodNums = nums.filter { it <= threshold }
        if (goodNums.isEmpty())
            return nums.size

        val uf = UnionFind(goodNums.size)

        val presentElements = IntArray(threshold + 1) { -1 }

        for (i in goodNums.indices)
            presentElements[goodNums[i]] = i

        for (d in goodNums) {
            for (i in d..threshold step d) {
                if (presentElements[i] == -1)
                    presentElements[i] = presentElements[d]
                else if (presentElements[i] != presentElements[d])
                    uf.union(presentElements[i], presentElements[d])
            }
        }

        return uf.totalComponents + nums.size - goodNums.size
    }
}

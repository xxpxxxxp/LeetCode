package com.ypwang.hard

class Solution1697 {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val dsu = IntArray(n){it}

        fun root(i: Int): Int {
            if (i != dsu[i])
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        edgeList.sortBy{ it[2] }
        val rst = BooleanArray(queries.size)

        var idx = 0
        for ((i, arr) in queries.withIndex().sortedBy{ it.value[2] }) {
            while (idx < edgeList.size && edgeList[idx][2] < arr[2]) {
                union(edgeList[idx][0], edgeList[idx][1])
                idx++
            }

            rst[i] = root(arr[0]) == root(arr[1])
        }

        return rst
    }
}
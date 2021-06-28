package com.ypwang.medium

class Solution1901 {
    fun findPeakGrid(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        var l = 0
        var r = n-1
        while (l <= r) {
            val mid = (l + r) / 2
            var maxRow = 0

            for(i in 0 until m)
                if (mat[maxRow][mid] < mat[i][mid])
                    maxRow = i

            val curr = mat[maxRow][mid]
            var left = -1
            var right = -1
            if(mid > 0)
                left = mat[maxRow][mid-1]
            if(mid < n-1)
                right = mat[maxRow][mid+1]

            if (curr > left && curr > right)
                return intArrayOf(maxRow, mid)
            else if (curr < right)
                l = mid + 1
            else
                r = mid - 1
        }
        return intArrayOf(-1, -1)
    }
}
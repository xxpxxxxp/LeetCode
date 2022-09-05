package com.ypwang.medium

class Solution2397 {
    fun maximumRows(mat: Array<IntArray>, cols: Int): Int {
        var max = 0
        for (mask in 0 until (1 shl mat[0].size)) {
            if (Integer.bitCount(mask) != cols)
                continue  // restricted to select only cols columns

            var c = 0
            for (element in mat) {
                var take = true
                for (j in 0 until mat[0].size) {
                    if (mask shr j and 1 == 0 && element[j] == 1) {
                        take = false
                        break
                    }
                }
                if (take)
                    c++
            }
            max = maxOf(max, c)
        }
        return max
    }
}
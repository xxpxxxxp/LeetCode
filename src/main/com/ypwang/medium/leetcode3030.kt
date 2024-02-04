package com.ypwang.medium

class Solution3030 {
    fun resultGrid(image: Array<IntArray>, threshold: Int): Array<IntArray> {
        val n = image.size
        val m = image[0].size
        val rs = Array(n) {Array(m) { mutableListOf<Int>() } }
        for (i in 0 until n - 2) {
            for (j in 0 until m - 2) {
                var sum = 0
                var isRegion = true
                for (k in i until i + 3) {
                    for (l in j until j + 3) {
                        sum += image[k][l]
                        isRegion = isRegion and
                                (k == i || Math.abs(image[k][l] - image[k - 1][l]) <= threshold) and
                                (l == j || Math.abs(image[k][l] - image[k][l - 1]) <= threshold)
                    }
                }
                if (isRegion)
                    for (k in i until i + 3)
                        for (l in j until j + 3)
                            rs[k][l].add(sum / 9)
            }
        }
        for (i in 0 until n)
            for (j in 0 until m)
                if (rs[i][j].isNotEmpty())
                    image[i][j] = rs[i][j].sum() / rs[i][j].size
        return image
    }
}

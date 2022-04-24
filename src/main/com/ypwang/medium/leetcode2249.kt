package com.ypwang.medium

class Solution2249 {
    fun countLatticePoints(circles: Array<IntArray>): Int {
        val res = HashSet<String>()
        for (arr in circles) {
            val (x, y, r) = arr
            for (i in x - r..x + r)
                for (j in y - r..y + r)
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= r * r)
                        res.add("$i,$j")
        }
        return res.size
    }
}
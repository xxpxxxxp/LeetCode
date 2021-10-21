package com.ypwang.hard

class Solution1998 {
    fun gcdSort(nums: IntArray): Boolean {
        val max = nums.maxOrNull()!!
        val dsu = IntArray(max+1){ it }

        fun root(i: Int): Int {
            if (i != dsu[i])
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        val spf = IntArray(max+1){ it }
        var i = 2
        while (i * i < max + 1) {
            if (spf[i] == i) {
                for (j in i * i .. max step i) {
                    if (spf[j] > i)
                        spf[j] = i
                }
            }
            i++
        }

        fun getPrimeFactors(i: Int): Set<Int> {
            val rst = mutableSetOf<Int>()
            var n = i
            while (n > 1) {
                rst.add(spf[n])
                n /= spf[n]
            }
            return rst
        }

        for (x in nums) {
            for (f in getPrimeFactors(x))
                union(x, f)
        }

        val copy = nums.clone()
        copy.sort()
        return copy.zip(nums).all { (x, y) -> root(x) == root(y) }
    }
}

fun main() {
    println(Solution1998().gcdSort(intArrayOf(7,21,3)))
    println(Solution1998().gcdSort(intArrayOf(5,2,6,2)))
    println(Solution1998().gcdSort(intArrayOf(10,5,9,3,15)))
}
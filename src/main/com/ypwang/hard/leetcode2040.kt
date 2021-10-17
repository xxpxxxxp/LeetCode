package com.ypwang.hard

class Solution2040 {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        val an = nums1.takeWhile { it < 0 }.map { -it }.reversed()
        val ap = nums1.takeLast(nums1.size - an.size)
        var bn = nums2.takeWhile { it < 0 }.map { -it }.reversed()
        var bp = nums2.takeLast(nums2.size - bn.size)

        val neg = an.size * bp.size + ap.size * bn.size
        var kk = k
        var positive = 1
        if (kk > neg)
            kk -= neg
        else {
            kk = neg - k + 1
            val t = bp
            bp = bn
            bn = t
            positive = -1
        }

        fun count(A: List<Int>, B: List<Int>, x: Long): Long {
            var rst = 0L
            var j = B.lastIndex
            for (i in A) {
                while (j >= 0 && i.toLong() * B[j] > x)
                    j--

                rst += j+1
            }

            return rst
        }

        var left = 0L
        var right = 10000000000L
        while (left < right) {
            val mid = (left + right) / 2
            if (count(an, bn, mid) + count(ap, bp, mid) >= kk)
                right = mid
            else
                left = mid + 1
        }

        return left * positive
    }
}

fun main() {
    println(Solution2040().kthSmallestProduct(intArrayOf(-100000,100000), intArrayOf(-100000,100000), 1))
    println(Solution2040().kthSmallestProduct(intArrayOf(-2,-1,0,1,2), intArrayOf(-3,-1,2,4,5), 3))
}
package com.ypwang.medium

class Solution986 {
    fun intervalIntersection(A: Array<Interval>, B: Array<Interval>): Array<Interval> {
        var i = 0
        var j = 0

        val rst = mutableListOf<Interval>()

        while (i < A.size && j < B.size) {
            val a = A[i]
            val b = B[j]

            if (a.end <= b.end) {
                if (b.start <= a.end) {
                    rst.add(Interval(maxOf(a.start, b.start), a.end))
                }
                i++
            } else {
                if (a.start <= b.end) {
                    rst.add(Interval(maxOf(a.start, b.start), b.end))
                }

                j++
            }
        }

        return rst.toTypedArray()
    }
}
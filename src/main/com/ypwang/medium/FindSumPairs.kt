package com.ypwang.medium

class FindSumPairs(nums1: IntArray, private val nums2: IntArray) {
    private val group1: List<Pair<Int, Int>> = nums1.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }
    private val sorted: MutableList<Int> = nums2.sorted().toMutableList()

    fun add(index: Int, `val`: Int) {
        sorted.remove(nums2[index])
        val newVal = nums2[index]  + `val`
        nums2[index] = newVal
        val newIdx = sorted.binarySearch(newVal).let { if (it >= 0) it else -it-1 }
        sorted.add(newIdx, newVal)
    }

    fun count(tot: Int): Int {
        var rst = 0
        var i = 0
        var j = sorted.lastIndex

        while (i < group1.size && j >= 0) {
            val (v1, c1) = group1[i++]

            while (j >= 0 && v1 + sorted[j] > tot)
                j--

            var c2 = 0
            while (j >= 0 && v1 + sorted[j] == tot) {
                j--
                c2++
            }

            rst += c1 * c2
        }

        return rst
    }
}

fun main() {
    val f = FindSumPairs(intArrayOf(9,70,14,9,76), intArrayOf(26,26,58,23,74,68,68,78,58,26))
    f.add(6,10)
    f.add(5,6)
    f.add(3,55)
    f.add(9,32)
    f.add(9,16)
    f.add(1,48)
    f.add(1,4)
    f.add(0,52)
    f.add(8,20)
    f.add(9,4)
    println(f.count(154))
}
package com.ypwang.hard

class Solution315 {
    fun countSmaller(nums: IntArray): List<Int> {
        val array = nums.withIndex().toList().toTypedArray()
        val rst = IntArray(nums.size)

        fun mergeSort(sp: Int, ep: Int) {
            if (ep - sp < 2) return
            val mid = (sp + ep) / 2
            mergeSort(sp, mid)
            mergeSort(mid, ep)

            val replace = Array<IndexedValue<Int>?>(ep - sp){null}

            var l = sp
            var r = mid
            var p = 0

            var switch = 0
            while (l < mid && r < ep) {
                val lv = array[l]
                val rv = array[r]

                replace[p] = if (lv.value > rv.value) {
                    switch++
                    r++
                    rv
                } else {
                    l++
                    rst[lv.index] += switch
                    lv
                }

                p++
            }

            while (l < mid) {
                rst[array[l].index] += switch
                replace[p] = array[l]
                l++
                p++
            }

            while (r < ep) {
                replace[p] = array[r]
                r++
                p++
            }

            for (i in sp until ep) {
                array[i] = replace[i-sp]!!
            }
        }

        mergeSort(0, nums.size)
        return rst.toList()
    }
}

fun main() {
    println(Solution315().countSmaller(intArrayOf(5,2,6,1)))
}
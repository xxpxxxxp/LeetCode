package com.ypwang.easy

class Solution1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val set = arr2.toSet()
        val map = mutableMapOf<Int, Int>()
        val list = mutableListOf<Int>()

        for (i in arr1) {
            if (i in set) map[i] = map.getOrDefault(i, 0) + 1
            else list.add(i)
        }

        val rst = mutableListOf<Int>()
        for (i in arr2) {
            if (i in map) {
                for (c in 0 until map[i]!!)
                    rst.add(i)
            }
        }

        rst.addAll(list.sorted())

        return rst.toIntArray()
    }
}
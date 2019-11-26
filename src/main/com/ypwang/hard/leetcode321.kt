package com.ypwang.hard

import java.lang.StringBuilder

class Solution321 {
    fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray =
        (maxOf(0, k - nums2.size)..minOf(nums1.size, k)).map {
            mergeNumber(makeNumber(nums1, it), makeNumber(nums2, k-it))
        }.filter { it.length == k }.max()!!.map { it - '0' }.toIntArray()

    private fun makeNumber(nums: IntArray, k: Int): String {
        val ans = IntArray(k)
        var j = 0
        for ((i, num) in nums.withIndex()) {
            while (nums.size - i + j > k && j > 0 && ans[j-1] < num) j--
            if (j < k) ans[j++] = num
        }
        return ans.joinToString("")
    }

    private fun mergeNumber(nums1: String, nums2: String): String {
        val rst = StringBuilder()
        var sb1 = nums1
        var sb2 = nums2
        while (sb1.isNotEmpty() && sb2.isNotEmpty()) {
            if (sb1 > sb2) {
                rst.append(sb1[0])
                sb1 = sb1.substring(1)
            } else {
                rst.append(sb2[0])
                sb2 = sb2.substring(1)
            }
        }
        rst.append(sb1)
        rst.append(sb2)
        return rst.toString()
    }
}

fun main() {
    println(Solution321().maxNumber(intArrayOf(8,0,4,4,1,7,3,6,5,9,3,6,6,0,2,5,1,7,7,7,8,7,1,4,4,5,4,8,7,6,2,2,9,4,7,5,6,2,2,8,4,6,0,4,7,8,9,1,7,0),
            intArrayOf(6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4),50).toList())
    println(Solution321().maxNumber(intArrayOf(8,5,9,5,1,6,9), intArrayOf(2,6,4,3,8,4,1,0,7,2,9,2,8),20).toList())
    println(Solution321().maxNumber(intArrayOf(2,5,6,4,4,0), intArrayOf(7,3,8,0,6,5,7,6,2),15).toList())
    println(Solution321().maxNumber(intArrayOf(1,2), intArrayOf(), 2).toList())
    println(Solution321().maxNumber(intArrayOf(3,4,6,5), intArrayOf(9,1,2,5,8,3), 5).toList())
    println(Solution321().maxNumber(intArrayOf(6,7), intArrayOf(6,0,4), 5).toList())
    println(Solution321().maxNumber(intArrayOf(3,9), intArrayOf(8,9), 3).toList())
}
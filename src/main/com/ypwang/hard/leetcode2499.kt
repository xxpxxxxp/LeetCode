package com.ypwang.hard

class Solution2499 {
    fun minimumTotalCost(nums1: IntArray, nums2: IntArray): Long {
        var rst = 0L
        val count = IntArray(100005)
        var dominantCnt = 0
        var dominantNum = -1
        var involvedCnt = 0
        for (i in nums1.indices) {
            if (nums1[i] == nums2[i]) {
                rst += i
                count[nums1[i]]++
                if (count[nums1[i]] > dominantCnt) {
                    dominantCnt = count[nums1[i]]
                    dominantNum = nums1[i]
                }
                involvedCnt++
            }
        }

        if (dominantCnt <= involvedCnt / 2)
            return rst

        for (i in nums1.indices) {
            if (nums1[i] != nums2[i] && nums1[i] != dominantNum && nums2[i] != dominantNum) {
                involvedCnt++
                rst += i
                if (dominantCnt <= involvedCnt / 2)
                    return rst
            }
        }
        return -1
    }
}
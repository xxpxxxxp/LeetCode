package com.ypwang.hard

class Solution689 {
    data class IdxSum(var idx: Int, var sum: Int)

    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val sumed = IntArray(nums.size)
        var sum = nums.take(k-1).sum()
        for (i in 0 .. nums.size - k) {
            sum += nums[i+k-1]
            sumed[i] = sum
            sum -= nums[i]
        }

        val left = Array(nums.size){ IdxSum(0, sumed[0]) }
        val right = Array(nums.size){ IdxSum(nums.size-k, sumed[nums.size-k]) }

        var a = 0
        var b = 0
        var c = 0

        for (i in 1 .. nums.size - 3 * k) {
            left[i] =
                if (sumed[i] > left[i-1].sum) IdxSum(i, sumed[i])
                else left[i-1]
        }

        for (i in nums.size-k-1 downTo 2 * k) {
            right[i] =
                if (sumed[i] >= right[i+1].sum) IdxSum(i, sumed[i])
                else right[i+1]
        }

        sum = 0

        for (i in k .. nums.size - 2*k) {
            if (sumed[i] + left[i-k].sum + right[i+k].sum > sum) {
                sum = sumed[i] + left[i-k].sum + right[i+k].sum
                a = left[i-k].idx
                b = i
                c = right[i+k].idx
            }
        }

        return intArrayOf(a, b, c)
    }
}

fun main() {
    println(Solution689().maxSumOfThreeSubarrays(intArrayOf(1,2,1,2,6,7,5,1), 2))
}
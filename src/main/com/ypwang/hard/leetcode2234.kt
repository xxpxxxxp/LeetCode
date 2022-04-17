package com.ypwang.hard

class Solution2234 {
    //BST
    private fun getMax(index: Int, rem: Long, target: Long, prefix_sum: LongArray, arr: LongArray): Long {
        var left = 0
        var right = index
        var `in` = -1
        while (right >= left) {
            val mid = left + (right - left) / 2
            //For calculating the value which we will add
            val `val` = arr[mid] * (mid + 1) - prefix_sum[mid]
            if (rem >= `val`) {
                //getting the index
                `in` = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        // edge case-1 in==-1 return 0;
        // edge case-2 in!=-1 return Math.min((rem+prefix_sum[in])/(in+1),target-1);
        // because we ultimately want a number which is less than target
        return if (`in` == -1) 0 else minOf((rem + prefix_sum[`in`]) / (`in` + 1), target - 1)
    }

    fun maximumBeauty(flowers: IntArray, newFlowers: Long, target: Int, full: Int, partial: Int): Long {
        //Edge case for fl having length 1
        if (flowers.size == 1) {
            if (flowers[0] >= target)
                return full.toLong()
            var result = minOf(target - 1L, flowers[0] + newFlowers) * partial
            if (flowers[0] + newFlowers >= target)
                result = maxOf(result, full.toLong())
            return result
        }

        //converting the array to long array
        val arr = flowers.map { it.toLong() }.sorted().toLongArray()

        //for removing the greatest or equal to elements than target
        var i = arr.size - 1
        while (i > -1 && arr[i] >= target)
            i--
        val mid_val = (arr.size - i - 1) * full.toLong()
        if (i == -1)
            return mid_val

        //for prefix sum
        val prefix_sum = LongArray(arr.size)
        prefix_sum[0] = arr[0]
        for (j in 1 until arr.size)
            prefix_sum[j] = prefix_sum[j - 1] + arr[j]

        // The present length after the reduction of the greatest or equal elements target
        val len = i + 1

        //Edge case 1
        var result = getMax(len - 1, newFlowers, target.toLong(), prefix_sum, arr) * partial

        //Edge case 2
        if (newFlowers - target * len + prefix_sum[len - 1] >= 0)
            result = maxOf(result, len * full.toLong())

        // initialize sum=0 for calculating the sum in whie loop
        var sum: Long = 0
        while (i > 0) {
            sum += arr[i]
            val v = newFlowers - target * (len - i) + sum
            if (v < 0)
                break
            result = maxOf(result, getMax(i - 1, v, target.toLong(), prefix_sum, arr) * partial + full * (len - i))
            i--
        }

        //Return the result as mid_val+result
        return result + mid_val
    }
}
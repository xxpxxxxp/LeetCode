package com.ypwang.medium

class Solution324 {
    fun wiggleSort(nums: IntArray) {
        fun partition(left: Int, right: Int, idx: Int) {
            var l = left
            var r = right

            while (l < r) {
                val key = nums[l]
                var i = l + 1
                var j = r

                // partition based on key
                // on end, we have i == j && [l,i) <= key && (i,r] > key
                while (i < j) {
                    while (i < j && nums[i] <= key) i++
                    while (i < j && nums[j] > key) j--
                    if (i != j) {
                        val t = nums[i]
                        nums[i] = nums[j]
                        nums[j] = t
                    }
                }

                // swap key to i position
                val p = if (nums[i] <= key) i else i-1
                val t = nums[p]
                nums[p] = key
                nums[l] = t

                // now we have [l,p) <= key and (p,r] > key
                when {
                    p == idx -> return
                    p < idx -> l = p + 1
                    else -> r = p - 1
                }
            }
        }

        partition(0, nums.lastIndex, nums.size / 2)

        var l = 0
        var r = nums.size / 2
        val mid = nums[r]
        while (l < r) {
            if (nums[l] == mid) {
                val t = nums[l]
                nums[l] = nums[r]
                nums[r] = t
                r--
            } else {
                l++
            }
        }

        val new = nums.copyOf()
        for (i in 0 until nums.size) {
            nums[i] = when (i % 2) {
                0 -> new[(nums.size - (i+1)) / 2]
                1 -> new[nums.size - (i+1)/2]
                else -> 0
            }
        }
    }
}

fun main() {
    val nums = intArrayOf(5,3,1,2,6,7,8,5,5)

    fun index(i: Int): Int = (1 + 2 * i) % (nums.size or 1)

    for (i in 0 until nums.size)
        println("$i\t${index(i)}")

    Solution324().wiggleSort(nums)
    println(nums.toList())
}
package com.ypwang.easy

class Solution2932 {
    fun maximumStrongPairXor(nums: IntArray): Int {
        var rst = 0
        for (x in nums)
            for (y in nums)
                if (Math.abs(x-y) <= minOf(x, y))
                    rst = maxOf(rst, x xor y)
        return rst
    }
}
package com.ypwang.hard

import java.util.Stack

class Solution4114 {
    fun countConsistent(nums: IntArray): Long {
        val n = nums.size
        val l = IntArray(n) { -1 }
        val st = Stack<Int>()
        for (i in 0 until n) {
            while (st.isNotEmpty() && (nums[st.peek()!!] and nums[i]) == nums[i] && nums[i] < nums[st.peek()!!])
                st.pop()

            if (st.isNotEmpty())
                l[i] = st.peek()!!

            st.push(i)
        }
        var res = 0L
        st.clear()
        for (i in n - 1 downTo 0) {
            while (st.isNotEmpty() && (nums[st.peek()!!] and nums[i]) == nums[i])
                st.pop()

            val r = (if (st.isEmpty()) n else st.peek())!!
            res += (i - l[i]).toLong() * (r - i)
            st.push(i)
        }
        return res
    }
}

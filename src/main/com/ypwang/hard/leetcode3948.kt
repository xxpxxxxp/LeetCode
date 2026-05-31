package com.ypwang.hard

class Solution3948 {
    fun maximumMEX(nums: IntArray): IntArray {
        val n = nums.size
        val sm = IntArray(n)

        // Suffix MEX precomputation
        val s = (0..n).toMutableSet()
        for (i in n - 1 downTo 0) {
            s.remove(nums[i])
            sm[i] = s.first()
        }

        val ans = mutableListOf<Int>()

        var v = sm[0]
        val st = (0..v).toMutableSet()

        for (i in 0 until n) {
            st.remove(nums[i])

            val p = (if (st.isEmpty()) v else st.first())

            if (p >= v) {
                ans.add(p)
                st.clear()

                if (i < n - 1) {
                    v = sm[i + 1]
                    st.addAll(0..v)
                }
            }
        }

        return ans.toIntArray()
    }
}

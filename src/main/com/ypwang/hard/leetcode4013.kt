package com.ypwang.hard

class Solution4013 {
    private fun solve(pref: LongArray, l: Int, r: Int): Long {
        if (l >= r)
            return 0L

        val mid = l + (r - l) / 2
        var cnt = solve(pref, l, mid) + solve(pref, mid + 1, r)

        var j = mid + 1
        for (i in l..mid) {
            while (j <= r && pref[j] <= pref[i])
                j++
            cnt += (j - (mid + 1)).toLong()
        }

        val temp = ArrayList<Long>(r - l + 1)
        var i = l
        j = mid + 1

        while (i <= mid && j <= r) {
            if (pref[i] <= pref[j]) {
                temp.add(pref[i])
                i++
            } else {
                temp.add(pref[j])
                j++
            }
        }

        while (i <= mid) {
            temp.add(pref[i])
            i++
        }

        while (j <= r) {
            temp.add(pref[j])
            j++
        }

        for (k in temp.indices)
            pref[l + k] = temp[k]

        return cnt
    }

    fun countRatioSubarrays(nums: IntArray, a: Int, b: Int): Long {
        val n = nums.size
        val pref = LongArray(n + 1)

        for (i in 0 until n)
            pref[i + 1] = if (nums[i] % 2 == 0)
                pref[i] + b.toLong()
            else
                pref[i] - a.toLong()

        return solve(pref, 0, n)
    }
}

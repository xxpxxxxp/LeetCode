package com.ypwang.hard

class Solution1505 {
    fun minInteger(num: String, k: Int): String {
        return String(helper(num.toCharArray(), k, 0))
    }

    fun helper(num: CharArray, k: Int, i: Int): CharArray {
        if (k == 0) return num
        if (i == num.size) return num

        var minReachable = num[i]
        var swapsRequired = 0

        var j = i + 1
        while (j < num.size && j - i <= k) {
            if (num[j] < minReachable) {
                minReachable = num[j]
                swapsRequired = j - i
            }
            j++
        }

        if (minReachable == num[i]) return helper(num, k, i + 1)
        for (j in i + swapsRequired downTo i + 1) {
            num[j] = num[j - 1]
        }
        num[i] = minReachable
        return helper(num, k - swapsRequired, i + 1)
    }
}
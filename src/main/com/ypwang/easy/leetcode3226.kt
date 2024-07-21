package com.ypwang.easy

class Solution3226 {
    fun minChanges(n: Int, k: Int): Int {
        if (n and k != k)
            return -1

        return Integer.bitCount(n and k.inv())
    }
}

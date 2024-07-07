package com.ypwang.easy

class Solution3210 {
    fun getEncryptedString(s: String, k: Int): String {
        val k = k % s.length
        return (s.take(k).reversed() + s.drop(k).reversed()).reversed()
    }
}

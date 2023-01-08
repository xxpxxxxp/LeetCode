package com.ypwang.medium

class Solution2531 {
    fun isItPossible(word1: String, word2: String): Boolean {
        val arr1 = IntArray(26)
        val arr2 = IntArray(26)
        for (c in word1)
            arr1[c - 'a']++
        for (c in word2)
            arr2[c - 'a']++

        for (i in 0..25) {
            if (arr1[i] == 0)
                continue
            arr1[i]--
            for (j in 0..25) {
                if (arr2[j] == 0)
                    continue

                arr2[i]++
                arr2[j]--
                arr1[j]++
                if (arr1.count { it > 0 } == arr2.count { it > 0 })
                    return true

                arr2[i]--
                arr2[j]++
                arr1[j]--
            }
            arr1[i]++
        }
        return false
    }
}
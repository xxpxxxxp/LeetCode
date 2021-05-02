package com.ypwang.medium

class Solution1850 {
    private fun nextPermutation(num: CharArray) {
        var i = num.lastIndex-1
        while (i >= 0) {
            if (num[i] < num[i+1])
                break

            i--
        }

        var x = i+1
        var y = num.lastIndex
        while (x < y) {
            val t = num[x]
            num[x++] = num[y]
            num[y--] = t
        }

        var idx = i+1
        while (num[idx] <= num[i])
            idx++

        val t = num[i]
        num[i] = num[idx]
        num[idx] = t
    }

    fun getMinSwaps(num: String, k: Int): Int {
        val arr = num.toCharArray()
        for (i in 0 until k) {
            nextPermutation(arr)
        }

        var ans = 0
        for (i in num.indices) {
            if (arr[i] != num[i]) {
                for (j in i+1 until num.length) {
                    if (arr[j] == num[i]) {
                        ans += j-i

                        for (q in j downTo i+1) {
                            arr[q] = arr[q-1]
                        }
                        arr[i] = num[i]
                        break
                    }
                }
            }
        }

        return ans
    }
}

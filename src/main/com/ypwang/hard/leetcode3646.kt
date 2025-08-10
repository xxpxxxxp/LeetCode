package com.ypwang.hard

class Solution3646 {
    private fun init(): List<Long> {
        val result = mutableListOf<Long>()

        for (mask in 1 until (1 shl 9)) {
            var sum = 0
            var oddCnt = 0
            for (d in 1..9) {
                if ((mask shr (d - 1)) and 1 == 1) {
                    sum += d
                    if (d % 2 == 1) oddCnt++
                }
            }
            if (sum > 18 || oddCnt > 1)
                continue

            val half = mutableListOf<Char>()
            var mid = ""

            for (d in 1..9) {
                if ((mask shr (d - 1)) and 1 == 1) {
                    if (d % 2 == 1)
                        mid = ('0' + d).toString()

                    repeat(d / 2) {
                        half.add('0' + d)
                    }
                }
            }

            half.sort()
            val used = BooleanArray(half.size)

            fun backtrack(path: MutableList<Char>) {
                if (path.size == half.size) {
                    val left = path.joinToString("")
                    val right = left.reversed()
                    val full = left + mid + right
                    if (full.isNotEmpty())
                        result.add(full.toLong())
                    return
                }

                for (i in half.indices) {
                    if (used[i] || (i > 0 && half[i] == half[i - 1] && !used[i - 1]))
                        continue
                    used[i] = true
                    path.add(half[i])
                    backtrack(path)
                    path.removeAt(path.size - 1)
                    used[i] = false
                }
            }

            backtrack(mutableListOf())
        }

        return result.distinct().sorted().toMutableList()
    }

    fun specialPalindrome(n: Long): Long {
        val specials = init()
        val idx = specials.binarySearch(n + 1)
        val insertionPoint = if (idx < 0) -idx - 1 else idx
        return specials[insertionPoint]
    }
}

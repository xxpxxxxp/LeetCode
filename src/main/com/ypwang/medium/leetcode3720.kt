package com.ypwang.medium

class Solution3720 {
    fun lexGreaterPermutation(s: String, target: String): String {
        val cnt = IntArray(26)
        for (c in s)
            cnt[c - 'a']++

        fun func(path: MutableList<Char>, cnt: IntArray, target: String, big: Boolean): String? {
            if (path.size == target.length)
                return if (big) path.joinToString("") else null

            val i = path.size
            for (c in 0 until 26) {
                if (cnt[c] == 0)
                    continue
                if (!big && ('a' + c < target[i]))
                    continue

                path.add('a' + c)
                cnt[c]--

                func(path, cnt, target, big || 'a' + c > target[i])?.let { return it }

                path.removeAt(path.size - 1)
                cnt[c]++
            }
            return null
        }

        val path = mutableListOf<Char>()
        return func(path, cnt, target, false) ?: ""
    }
}

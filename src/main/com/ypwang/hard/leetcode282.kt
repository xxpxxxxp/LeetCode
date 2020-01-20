package com.ypwang.hard

class Solution282 {
    fun addOperators(num: String, target: Int): List<String> {
        val rst = mutableListOf<String>()
        if (num.isEmpty()) return rst

        fun helper(path: String, pos: Int, eval: Long, mult: Long) {
            if (pos == num.length) {
                if (target.toLong() == eval) rst.add(path)
                return
            }

            for (i in pos until num.length) {
                if (i != pos && num[pos] == '0') break
                val cur = num.substring(pos, i + 1).toLong()
                if (pos == 0)
                    helper(cur.toString(), i + 1, cur, cur)
                else {
                    helper("$path+$cur", i + 1, eval + cur, cur)
                    helper("$path-$cur", i + 1, eval - cur, -cur)
                    helper("$path*$cur", i + 1, eval - mult + mult * cur, mult * cur)
                }
            }
        }

        helper("", 0, 0, 0)
        return rst
    }
}
package com.ypwang.medium

class Solution3006 {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        fun indices(sub: String): List<Int> {
            val rst = mutableListOf<Int>()
            var i = 0
            while (i < s.length) {
                i = s.indexOf(sub, i)
                if (i == -1)
                    return rst
                else {
                    rst.add(i)
                    i++
                }
            }

            return rst
        }

        val ai = indices(a)
        val bi = indices(b).toIntArray()
        return ai.filter { i ->
            val j = bi.binarySearch(i).let { if (it < 0) -it-1 else it }
            if (j > 0 && i - bi[j-1] <= k)
                true
            else if (j < bi.size && bi[j] - i <= k)
                true
            else if ((j+1) < bi.size && bi[j+1] - i <= k)
                true
            else
                false
        }
    }
}

fun main() {
    println(Solution3006().beautifulIndices("frkxslnnn", "rkxsl", "n", 2))
    println(Solution3006().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15))
}
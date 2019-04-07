package com.ypwang.medium

class Solution388 {
    fun lengthLongestPath(input: String): Int {
        val stack = mutableListOf<Pair<String, Int>>()

        var max = 0
        for (s in input.split("\\n")) {
            var c = 0
            while (s.length >= c * 2 + 2 && s.substring(c * 2, c * 2 + 2) == "\\t")
                c++

            val real = s.substring(c * 2)
            assert(c <= stack.size)

            for (j in c until stack.size)
                stack.removeAt(stack.lastIndex)
            val i = (if (stack.isEmpty()) 0 else stack.last().second + 1) + real.length
            stack.add(Pair(real, i))

            if (i > max)
                max = i
        }

        return max
    }
}

fun main() {
    println(Solution388().lengthLongestPath("""dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"""))
}
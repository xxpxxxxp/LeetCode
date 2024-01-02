package com.ypwang.hard

class Solution2983 {
    fun canMakePalindromeQueries(s: String, queries: Array<IntArray>): BooleanArray {
        val fq = IntArray(26)
        val m = queries.size
        val ret = BooleanArray(m)

        val n = s.length

        fun opp(i: Int): Int = n - 1 - i

        // check that both halves contain the same letters
        for (i in 0 until n / 2) {
            fq[s[i] - 'a']++
        }
        for (i in n / 2 until n) {
            fq[s[i] - 'a']--
        }

        if (fq.any { it != 0 })
            return ret

        // find the first and the last characters in the first half
        // that do not match with their associated character in
        // the second half
        var problemPoint = -1
        var lastProblem = -1
        for (i in 0 until n / 2) {
            if (s[i] != s[opp(i)]) {
                if (problemPoint == -1) {
                    problemPoint = i
                }
                lastProblem = i
            }
        }

        // if already a palindrome
        if (problemPoint == -1) {
            ret.fill(true)
            return ret
        }

        // the idea is that at least one of the intervals in the
        // query has to cover the first pair of different characters.
        // But depending on how far the other end of that interval
        // goes, the requirements for the other interval are lessened
        val dpFirst = IntArray(n / 2 + 1) { -1 }
        val dpSecond = IntArray(n + 1) { -1 }

        // assuming the first interval covers the first problem,
        // and then extends to the right
        var rptr = opp(problemPoint)
        val mp = mutableMapOf<Char, Int>()
        for (i in problemPoint until n / 2) {
            mp.compute(s[i]) { _: Char, v: Int? -> if (v == null) 1 else v + 1 }

            // the burden for the left end of the second interval does not change;
            // it needs to go at least until the last problematic match. But the
            // requirements for the right end do. If we can rearrange the characters
            // in the left half to match the right end of the right interval, this
            // means we do not need the right end of the right interval to go too far
            while (s[rptr] in mp) {
                mp.computeIfPresent(s[rptr]) { _: Char?, v: Int -> if (v == 1) null else v - 1 }
                rptr--
            }

            dpFirst[i] = rptr
        }

        // mirrored discussion assuming it is the right interval that takes
        // care of the first problematic pair
        var lptr = problemPoint
        mp.clear()
        for (i in opp(problemPoint) downTo n / 2) {
            mp.compute(s[i]) { _: Char, v: Int? -> if (v == null) 1 else v + 1 }

            while (s[lptr] in mp) {
                mp.computeIfPresent(s[lptr]) { _: Char?, v: Int -> if (v == 1) null else v - 1 }
                lptr++
            }

            dpSecond[i] = lptr
        }

        for (i in 0 until m) {
            val (a,b,c,d) = queries[i]

            // if the first or the last problematic pairs are not covered by either
            // interval, we cannot make a palindrome
            if ((a > problemPoint || b < problemPoint) && (d < opp(problemPoint) || c > opp(problemPoint))
                || (a > lastProblem || b < lastProblem) && (d < opp(lastProblem) || c > opp(lastProblem))
            )
                continue


            // if either interval the problematic interval on its side, it does not matter
            // what happens with the other interval
            if (a <= problemPoint && b >= lastProblem || c <= opp(lastProblem) && d >= opp(problemPoint)) {
                ret[i] = true
                continue
            }

            // if the left interval covers the first problem, we use
            // dp to figure out if the right one is large enough
            if (problemPoint in a..b) {
                if (d >= dpFirst[b] && c <= opp(lastProblem)) {
                    ret[i] = true
                }
            }

            // similarly for the case where the right interval covers
            // the first problem
            if (opp(problemPoint) in c..d) {
                if (a <= dpSecond[c] && b >= lastProblem) {
                    ret[i] = true
                }
            }
        }

        return ret
    }
}
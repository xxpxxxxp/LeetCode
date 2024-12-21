package com.ypwang.hard

class Solution3395 {
    val mod = 1000000007L
    lateinit var nCr: Array<IntArray>
    val inv2 = modInverse(2, mod)

    fun buildBinomialTable(nMax: Int) {
        nCr = Array(nMax + 1) { IntArray(nMax + 1) }
        for (i in 0..nMax) {
            nCr[i][0] = 1
            for (j in 1..i) {
                nCr[i][j] = ((nCr[i - 1][j - 1].toLong() + nCr[i - 1][j].toLong()) % mod).toInt()
            }
        }
    }

    fun modFix(x: Long): Int {
        var y = x % mod
        return ((y + mod) % mod).toInt()
    }

    fun subsequencesWithMiddleMode(nums: IntArray): Int {
        val n = nums.size
        buildBinomialTable(n)

        if (n < 5)
            return 0

        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            map.getOrPut(nums[i]) { mutableListOf() }.add(i)
        }

        map.forEach { (_, value) -> value.sort() }

        val leftCount = IntArray(n)
        val rightCount = IntArray(n)

        for (k in 0 until n) {
            val c = nums[k]
            val posList = map[c]!!
            val lc = countLess(posList, k)
            val rc = posList.size - lc - 1
            leftCount[k] = lc
            rightCount[k] = rc
        }

        var ans = 0L

        for (k in 2..n - 3) {
            val cVal = nums[k]
            val leftC = leftCount[k]
            val rightC = rightCount[k]
            val leftNonC = k - leftC
            val rightNonC = (n - 1 - k) - rightC

            if (leftNonC < 0 || rightNonC < 0) continue

            var waysT5: Long = 0
            if (leftC >= 2 && rightC >= 2) {
                waysT5 = (nCr[leftC][2].toLong() * nCr[rightC][2].toLong()) % mod
            }

            var waysT4: Long = 0
            if (leftC >= 2 && rightC >= 1) {
                if (rightNonC >= 1) {
                    waysT4 += (nCr[leftC][2].toLong() * nCr[rightC][1].toLong() % mod
                            * nCr[leftNonC][0].toLong() % mod
                            * nCr[rightNonC][1].toLong() % mod) % mod
                }
            }
            if (leftC >= 1 && rightC >= 2) {
                if (leftNonC >= 1) {
                    val tmp = (nCr[leftC][1].toLong() * nCr[rightC][2].toLong() % mod
                            * nCr[leftNonC][1].toLong() % mod
                            * nCr[rightNonC][0].toLong() % mod) % mod
                    waysT4 = (waysT4 + tmp) % mod
                }
            }
            waysT4 %= mod

            var waysT3: Long = 0
            if (rightC >= 2) {
                val tmp = (nCr[leftC][0].toLong() * nCr[rightC][2].toLong() % mod
                        * nCr[leftNonC][2].toLong() % mod
                        * nCr[rightNonC][0].toLong() % mod) % mod
                waysT3 = (waysT3 + tmp) % mod
            }
            if (leftC >= 1 && rightC >= 1) {
                val tmp = (nCr[leftC][1].toLong() * nCr[rightC][1].toLong() % mod
                        * nCr[leftNonC][1].toLong() % mod
                        * nCr[rightNonC][1].toLong() % mod) % mod
                waysT3 = (waysT3 + tmp) % mod
            }
            if (leftC >= 2) {
                val tmp = (nCr[leftC][2].toLong() * nCr[rightC][0].toLong() % mod
                        * nCr[leftNonC][0].toLong() % mod
                        * nCr[rightNonC][2].toLong() % mod) % mod
                waysT3 = (waysT3 + tmp) % mod
            }

            val leftFreqMap = mutableMapOf<Int, Int>()
            val rightFreqMap = mutableMapOf<Int, Int>()
            for ((v, posList) in map) {
                if (v == cVal) continue
                val fLeft = countLess(posList, k)
                if (fLeft > 0) leftFreqMap[v] = fLeft
                val fRight = countGreater(posList, k)
                if (fRight > 0) rightFreqMap[v] = fRight
            }

            var sumLeft: Long = 0
            var sumSqLeft: Long = 0
            for ((_, f) in leftFreqMap) {
                sumLeft += f
                sumSqLeft += f.toLong() * f
            }
            var sumRight: Long = 0
            var sumSqRight: Long = 0
            for ((_, f) in rightFreqMap) {
                sumRight += f
                sumSqRight += f.toLong() * f
            }

            sumLeft %= mod
            sumRight %= mod
            sumSqLeft %= mod
            sumSqRight %= mod

            val ways2DistinctExRight = mutableMapOf<Int, Long>()
            for ((v, fv) in rightFreqMap) {
                val sr = (sumRight - fv + mod) % mod
                val srSq = (sumSqRight - (fv.toLong() * fv % mod) + mod) % mod
                var t = (sr * sr - srSq) % mod
                t = (t * inv2) % mod
                ways2DistinctExRight[v] = modFix(t).toLong()
            }
            var temp = ((sumRight * sumRight) % mod - sumSqRight + mod) % mod
            temp = (temp * inv2) % mod

            val ways2DistinctExLeft = mutableMapOf<Int, Long>()
            for ((v, fv) in leftFreqMap) {
                val sl = (sumLeft - fv + mod) % mod
                val slSq = (sumSqLeft - (fv.toLong() * fv % mod) + mod) % mod
                var t = (sl * sl - slSq) % mod
                t = (t * inv2) % mod
                ways2DistinctExLeft[v] = modFix(t).toLong()
            }
            var tempp = ((sumLeft * sumLeft) % mod - sumSqLeft + mod) % mod
            tempp = (tempp * inv2) % mod

            var f2Left: Long = 0
            if (leftC >= 1 && rightNonC >= 2) {
                val chooseC = nCr[leftC][1].toLong()
                for ((v, freqV) in leftFreqMap) {
                    val val1 = ways2DistinctExRight[v] ?: temp
                    val addMe = (freqV.toLong() % mod) * val1 % mod
                    f2Left = (f2Left + addMe) % mod
                }
                f2Left = (f2Left * chooseC) % mod
            }

            var f2Right: Long = 0
            if (rightC >= 1 && leftNonC >= 2) {
                val chooseC = nCr[rightC][1].toLong()
                for ((w, freqW) in rightFreqMap) {
                    val val1 = ways2DistinctExLeft[w] ?: tempp
                    val addMe = (freqW.toLong() % mod) * val1 % mod
                    f2Right = (f2Right + addMe) % mod
                }
                f2Right = (f2Right * chooseC) % mod
            }

            val waysT2 = (f2Left + f2Right) % mod
            val totalForK = (waysT5 + waysT4 + waysT3 + waysT2) % mod
            ans = (ans + totalForK) % mod
        }

        return ans.toInt()
    }

    fun modInverse(a: Long, m: Long): Long {
        return modExp(a, m - 2, m)
    }

    fun modExp(base: Long, exp: Long, m: Long): Long {
        var result = 1L
        var cur = base % m
        var e = exp
        while (e > 0) {
            if (e and 1L == 1L) {
                result = (result * cur) % m
            }
            cur = (cur * cur) % m
            e = e shr 1
        }
        return result
    }

    fun countLess(posList: List<Int>, x: Int): Int {
        var lo = 0
        var hi = posList.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (posList[mid] < x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    fun countGreater(posList: List<Int>, x: Int): Int {
        var lo = 0
        var hi = posList.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (posList[mid] <= x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return posList.size - lo
    }
}

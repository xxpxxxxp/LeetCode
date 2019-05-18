package com.ypwang.hard

class Solution992 {
    fun subarraysWithKDistinct(A: IntArray, K: Int): Int {
        var minIdx = 0
        var maxIdx = 0

        var count = 0

        val minCache = IntArray(A.size+1)
        val maxCache = IntArray(A.size+1)

        for (i in minIdx until A.size) {
            minIdx = i
            if (minCache[A[i]]++ == 0) {
                count++
            }
            maxCache[A[i]]++
            if (count == K) break
        }

        maxIdx = minIdx
        for (i in minIdx+1 until A.size) {
            if (maxCache[A[i]] == 0) break
            maxIdx = i
            maxCache[A[i]]++
        }

        var rst = 0
        for (i in 0 until A.size) {
            if (count != K) break
            rst += maxIdx - minIdx + 1

            if (maxCache[A[i]] == 1) {
                maxCache[A[i]] = 0
                minCache[A[i]] = 0
                count--

                for (j in minIdx+1 until A.size) {
                    minIdx = j
                    if (minCache[A[j]]++ == 0) {
                        count++
                    }
                    if (j > maxIdx)
                        maxCache[A[j]]++
                    if (count == K) break
                }

                maxIdx = minIdx
                for (j in maxIdx+1 until A.size) {
                    if (maxCache[A[j]] == 0) break
                    maxIdx = j
                    maxCache[A[j]]++
                }
            } else if (minCache[A[i]] == 1) {
                minCache[A[i]] = 0
                maxCache[A[i]]--
                count--
                for (j in minIdx+1 until A.size) {
                    minIdx = j
                    if (minCache[A[j]]++ == 0) count++
                    if (count == K) break
                }
            } else {
                minCache[A[i]]--
                maxCache[A[i]]--
            }
        }

        return rst
    }
}

fun main() {
    println(Solution992().subarraysWithKDistinct(intArrayOf(2,1,2,1,1), 3))
}
package com.ypwang.hard

class Solution952 {
    class DSU(val idx: Int) {
        var father = this

        fun parent(): DSU {
            if (father != this) father = father.parent()
            return father
        }

        fun union(other: DSU) {
            parent().father = other.parent()
        }
    }

    fun largestComponentSize(A: IntArray): Int {
        val factors = Array(A.size){ mutableListOf<Int>() }
        val primes = mutableSetOf<Int>()

        for (i in 0 until A.size) {
            var x = A[i]
            var d = 2
            while (d * d <= x) {
                if (x % d == 0) {
                    primes.add(d)
                    factors[i].add(d)
                    while (x % d == 0) {
                        x /= d
                    }
                }
                d++
            }

            if (x > 1 || factors[i].isEmpty()) {
                primes.add(x)
                factors[i].add(x)
            }
        }

        val pArray = primes.toIntArray()
        val reverse = pArray.withIndex().map { it.value to it.index }.toMap()

        val dsus = Array(pArray.size){ DSU(it) }
        for (factor in factors) {
            val first = factor.first()
            for (p in factor) {
                dsus[reverse[first]!!].union(dsus[reverse[p]!!])
            }
        }

        val count = IntArray(dsus.size)
        for (factor in factors) {
            count[dsus[reverse[factor.first()]!!].parent().idx]++
        }

        return count.max()!!
    }
}

fun main() {
    println(Solution952().largestComponentSize(intArrayOf(2,3,6,7,4,12,21,39)))
}
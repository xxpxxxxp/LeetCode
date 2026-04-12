package com.ypwang.hard

class Solution {
    fun countGoodSubseq(nums: IntArray, p: Int, queries: Array<IntArray>): Int {
        val n = nums.size

        val gcdTree = IntArray(4 * n)
        val divisibleCount = IntArray(4 * n)

        fun gcd(a: Int, b: Int): Int =
            if (a == 0) b else gcd(b % a, a)

        fun build(node: Int, l: Int, r: Int) {
            if (l == r) {
                if (nums[l] % p == 0) {
                    divisibleCount[node] = 1
                    gcdTree[node] = nums[l]
                } else {
                    divisibleCount[node] = 0
                    gcdTree[node] = 0
                }
                return
            }

            val mid = (l + r) / 2
            build(node * 2, l, mid)
            build(node * 2 + 1, mid + 1, r)

            divisibleCount[node] = divisibleCount[node * 2] + divisibleCount[node * 2 + 1]
            gcdTree[node] = gcd(gcdTree[node * 2], gcdTree[node * 2 + 1])
        }

        if (n > 0)
            build(1, 0, n - 1)

        fun update(node: Int, l: Int, r: Int, idx: Int, value: Int) {
            if (l == r) {
                nums[l] = value
                if (value % p == 0) {
                    divisibleCount[node] = 1
                    gcdTree[node] = value
                } else {
                    divisibleCount[node] = 0
                    gcdTree[node] = 0
                }
                return
            }

            val mid = (l + r) / 2
            if (idx <= mid)
                update(node * 2, l, mid, idx, value)
            else
                update(node * 2 + 1, mid + 1, r, idx, value)

            divisibleCount[node] = divisibleCount[node * 2] + divisibleCount[node * 2 + 1]
            gcdTree[node] = gcd(gcdTree[node * 2], gcdTree[node * 2 + 1])
        }

        var answer = 0
        for ((index, value) in queries) {
            if (n > 0)
                update(1, 0, n - 1, index, value)

            if (n > 0 && gcdTree[1] == p) {
                if (divisibleCount[1] < n) {
                    answer++
                } else {
                    if (n > 20) {
                        answer++
                    } else {
                        var possible = false

                        for (i in 0 until n) {
                            var g = 0
                            for (j in 0 until n) {
                                if (i != j) {
                                    g = gcd(g, nums[j])
                                }
                            }
                            if (g == p) {
                                possible = true
                                break
                            }
                        }

                        if (possible)
                            answer++
                    }
                }
            }
        }

        return answer
    }
}

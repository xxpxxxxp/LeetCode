package com.ypwang.hard

class Solution943 {
    fun shortestSuperstring(A: Array<String>): String {
        val overlap = Array(A.size){IntArray(A.size)}

        for ((i, a) in A.withIndex()) {
            for ((j, b) in A.withIndex()) {
                if (i != j) {
                    for (k in minOf(a.length, b.length) downTo 1)
                        if (a.endsWith(b.substring(0, k))) {
                            overlap[i][j] = k
                            break
                        }
                }
            }
        }

        val dp = Array(1 shl A.size) { IntArray(A.size) }
        val parent = Array(1 shl A.size) { IntArray(A.size){-1} }
        for (mask in 0 until (1 shl A.size)) {
            for (bit in A.indices)
                if (mask and (1 shl bit) > 0) {
                    val pmask = mask xor (1 shl bit)        // unset
                    if (pmask == 0) continue
                    for (i in A.indices)
                        if (pmask and (1 shl i) > 0) {
                            // For each bit i in pmask, calculate the value
                            // if we ended with word i, then added word 'bit'.
                            val `val` = dp[pmask][i] + overlap[i][bit]
                            if (`val` > dp[mask][bit]) {
                                dp[mask][bit] = `val`
                                parent[mask][bit] = i
                            }
                        }
                }
        }

        // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
        // Reconstruct answer, first as a sequence 'perm' representing
        // the indices of each word from left to right.

        val perm = IntArray(A.size)
        val seen = BooleanArray(A.size)
        var t = 0
        var mask = (1 shl A.size) - 1

        // p: the last element of perm (last word written left to right)
        var p = dp[mask].withIndex().maxBy { it.value }!!.index

        // Follow parents down backwards path that retains maximum overlap
        while (p != -1) {
            perm[t++] = p
            seen[p] = true
            val p2 = parent[mask][p]
            mask = mask xor (1 shl p)
            p = p2
        }

        // Fill in remaining words not yet added
        for (i in A.indices)
            if (!seen[i])
                perm[t++] = i

        // Reverse perm
        perm.reverse()

        // Reconstruct final answer given perm
        val ans = StringBuilder(A[perm[0]])
        for (i in 1 until A.size) {
            ans.append(A[perm[i]].substring(overlap[perm[i - 1]][perm[i]]))
        }

        return ans.toString()
    }
}

fun main() {
    println(Solution943().shortestSuperstring(arrayOf("yeeiebcz","qbqhdytk","ygueikth","thqzyeei","gyygueikt","ikthqzyee")))
    println(Solution943().shortestSuperstring(arrayOf("alex","loves","leetcode")))
    println(Solution943().shortestSuperstring(arrayOf("catg","ctaagt","gcta","ttca","atgcatc")))
}
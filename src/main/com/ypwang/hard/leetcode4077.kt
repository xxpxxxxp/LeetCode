package com.ypwang.hard

import java.util.TreeMap

class Solution4077 {
    fun minInversions(words: Array<String>, target: IntArray): Int {
        val p = HashMap<Int, Int>()
        for (i in target.indices)
            p[target[i]] = i

        data class TrieNode(
            val ch: TreeMap<Char, Int> = TreeMap(),
            var wordIdx: Int = -1
        )

        val trie = mutableListOf(TrieNode())

        // Build trie
        for (idx in words.indices) {
            var cur = 0

            for (c in words[idx]) {
                if (!trie[cur].ch.containsKey(c)) {
                    trie[cur].ch[c] = trie.size
                    trie.add(TrieNode())
                }
                cur = trie[cur].ch[c]!!
            }

            trie[cur].wordIdx = idx
        }

        var total = 0L

        fun dfs(u: Int): MutableList<Int> {
            val lsts = mutableListOf<MutableList<Int>>()

            for ((_, v) in trie[u].ch) {
                lsts.add(dfs(v))
            }

            val d = lsts.size
            val cost = Array(d) { LongArray(d) }

            for (i in 0 until d) {
                for (j in 0 until d) {
                    if (i == j) continue

                    var q = 0
                    var s = 0L

                    for (x in lsts[i]) {
                        while (q < lsts[j].size && lsts[j][q] < x) {
                            q++
                        }
                        s += q.toLong()
                    }

                    cost[i][j] =
                        lsts[i].size.toLong() * lsts[j].size - s
                }
            }

            // Subset DP: find the minimum cost ordering of child subtrees
            val size = 1 shl d
            val inf = Long.MAX_VALUE / 2
            val dp = LongArray(size) { inf }
            dp[0] = 0L

            for (mask in 0 until size) {
                if (dp[mask] == inf) continue

                for (j in 0 until d) {
                    if ((mask and (1 shl j)) != 0) continue

                    var add = 0L
                    for (i in 0 until d) {
                        if ((mask and (1 shl i)) != 0) {
                            add += cost[i][j]
                        }
                    }

                    val nxt = mask or (1 shl j)
                    dp[nxt] = minOf(dp[nxt], dp[mask] + add)
                }
            }

            total += dp[size - 1]

            // Merge the sorted lists from all child subtrees
            val merged = mutableListOf<Int>()
            for (lst in lsts) {
                merged.addAll(lst)
            }
            merged.sort()

            // Insert the current word's target position
            if (trie[u].wordIdx != -1) {
                val x = p[trie[u].wordIdx]!!
                var pos = merged.binarySearch(x)

                // Match C++ lower_bound behavior
                if (pos < 0) {
                    pos = -pos - 1
                } else {
                    while (pos > 0 && merged[pos - 1] >= x) {
                        pos--
                    }
                }

                total += pos.toLong()
                merged.add(pos, x)
            }

            return merged
        }

        dfs(0)
        return total.toInt()
    }
}

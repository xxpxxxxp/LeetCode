package com.ypwang.easy

class Solution720 {
    class Trie(var cur: String = "", var isWord: Boolean = false) {
        val sub = Array<Trie?>(26) { null }
    }

    fun longestWord(words: Array<String>): String {
        val ac = 'a'.toInt()
        val root = Trie()
        for (w in words) {
            var head: Trie? = root
            for (c in w) {
                val cc = c.toInt() - ac
                if (head!!.sub[cc] == null) {
                    head.sub[cc] = Trie()
                }
                head = head.sub[cc]
            }
            head!!.isWord = true
            head.cur = w
        }

        val queue = mutableListOf(root)
        var ans = ""
        while (!queue.isEmpty()) {
            val head = queue.first()
            queue.removeAt(0)
            if (head.isWord && head.cur.length > ans.length || (head.cur.length == ans.length && head.cur < ans)) {
                ans = head.cur
            }
            queue.addAll(head.sub.filter{ it != null && it.isWord }.map{ it!! })
        }

        return ans
    }
}